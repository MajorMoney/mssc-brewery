package pedrocorreia.msscbrewery.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pedrocorreia.msscbrewery.web.model.BeerDto;
import pedrocorreia.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto){
        return beerDto;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Updating a beer...");

    }

    @Override
    public void deleteById(UUID beerId) {
      log.debug("Deleting a beer...");
    }
}
