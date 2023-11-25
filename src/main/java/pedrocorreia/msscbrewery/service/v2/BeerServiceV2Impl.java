package pedrocorreia.msscbrewery.service.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pedrocorreia.msscbrewery.service.BeerService;
import pedrocorreia.msscbrewery.web.model.BeerDto;
import pedrocorreia.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto){
        return beerDto;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        log.debug("Updating a beer...");

    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting a beer...");
    }
}