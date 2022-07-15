package com.example.demo.domain.place;

import com.example.demo.data.models.entities.Country;
import com.example.demo.data.models.entities.Town;
import com.example.demo.data.models.entities.Type;
import com.example.demo.data.repositories.CountryRepository;
import com.example.demo.data.repositories.TownRepository;
import com.example.demo.data.repositories.TypeRepository;
import com.example.demo.view.mappers.TownViewMapper;
import com.example.demo.view.placeData.PlaceCreateRequest;
import com.example.demo.view.placeData.PlaceResponse;
import com.example.demo.view.placeData.PlaceUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PlaceServiceSimple implements PlaceService {

    private final TownRepository townRepository;
    private final CountryRepository countryRepository;

    private final TypeRepository typeRepository;

    private final TownViewMapper townViewMapper;

    public PlaceServiceSimple(TownRepository townRepository, CountryRepository countryRepository, TypeRepository typeRepository, TownViewMapper townViewMapper) {
        this.townRepository = townRepository;
        this.countryRepository = countryRepository;
        this.typeRepository = typeRepository;
        this.townViewMapper = townViewMapper;
    }

    @Override
    public PlaceResponse getPlace(String id) {
        Long Id = Long.valueOf(id);

        Optional<Town> optTown = townRepository.findById(Id);

        if (optTown.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Town does not exist",
                    new Exception("Town does not exists"));
        }
        return townViewMapper.townToPlaceResponse(optTown.get());
    }

    @Override
    public String createPlace(PlaceCreateRequest placeRequest) {
        Optional<Town> town = townRepository
                .findByNameAndCountryName(placeRequest.getTownName(), placeRequest.getCountryName());

        if (town.isPresent()) {
            // place already exists
            return String.valueOf(town.get().getId());
        }

        Town newTown =
                Town.builder()
                        .name(placeRequest.getTownName())
                        .latitude(placeRequest.getLatitude())
                        .longitude(placeRequest.getLongitude())
                        .build();


        // dealing with the country
        Country country = findOrCreateCountry(placeRequest.getCountryName());
        newTown.setCountry(country);

        // dealing with type
        Type type = findOrCreateType(placeRequest.getType());
        newTown.setType(type);

        Town townEntity = townRepository.saveAndFlush(newTown);
        return String.valueOf(townEntity.getId());
    }

    @Override
    public int deletePlace(String id) {
        Optional<Town> town = townRepository.findById(Long.valueOf(id));

        if (town.isPresent()) {
            Town realTown = town.get();
            townRepository.deleteById(realTown.getId());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePlace(String id, PlaceUpdateRequest placeUpdateRequest) {
        Country country = findOrCreateCountry(placeUpdateRequest.getCountryName());
        Type type = findOrCreateType(placeUpdateRequest.getType());

        Optional<Town> optTown = townRepository.findById(Long.valueOf(id));
        if (optTown.isPresent()) {
            Town town = optTown.get();

            town.setType(type);
            town.setCountry(country);
            town.setLatitude(placeUpdateRequest.getLatitude());
            town.setLongitude(placeUpdateRequest.getLongitude());
            town.setName(placeUpdateRequest.getTownName());
            townRepository.saveAndFlush(town);
            return 1;
        }
        return 0;
    }

    private Country findOrCreateCountry(String countryName) {

        Optional<Country> country = countryRepository.findByName(countryName);
        if (country.isEmpty()) {
            Country newCountry =
                    Country.builder()
                            .name(countryName)
                            .build();

            countryRepository.saveAndFlush(newCountry);
            return newCountry;
        }
        return country.get();
    }

    private Type findOrCreateType(String typeLabel) {
        Optional<Type> type = typeRepository.findByLabel(typeLabel);
        if (type.isEmpty()) {
            Type newType = Type.builder()
                    .label(typeLabel)
                    .build();

            typeRepository.saveAndFlush(newType);
            return newType;
        }
        return type.get();
    }
}
