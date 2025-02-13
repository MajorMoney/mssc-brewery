package pedrocorreia.msscbrewery.web.controller.v2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedrocorreia.msscbrewery.service.v2.BeerServiceV2;
import pedrocorreia.msscbrewery.web.model.BeerDto;
import pedrocorreia.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;




    @RequestMapping("/api/v1/beer")
    @RestController
    public class BeerControllerV2 {

        private final BeerServiceV2 beerService;

        public BeerControllerV2(BeerServiceV2 beerService){
            this.beerService = beerService;
        }
        @GetMapping({"/{beerId}"})
        public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
            return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity handlePost(@RequestBody BeerDtoV2 beerDto){

            BeerDtoV2 newDto = beerService.saveNewBeer(beerDto);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Location","/api/v1/beer" + newDto.getId().toString());

            return new ResponseEntity<>(headers,HttpStatus.CREATED);
        }

        @PutMapping({"/{beerId}"})
        public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,@RequestBody BeerDtoV2 beerDto){
            beerService.updateBeer(beerId,beerDto);

            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @DeleteMapping({"/{beerId}"})
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteBeer(@PathVariable("beerId") UUID beerId){
            beerService.deleteById(beerId);
        }

    }
