package pedrocorreia.msscbrewery.service;

import pedrocorreia.msscbrewery.web.model.BeerDto;
import pedrocorreia.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
