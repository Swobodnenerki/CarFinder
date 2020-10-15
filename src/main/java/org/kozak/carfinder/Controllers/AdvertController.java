package org.kozak.carfinder.Controllers;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.AdvertDto;
import org.kozak.carfinder.Models.CarSpecsEntity;
import org.kozak.carfinder.Services.Exceptions.AdvertNotFoundException;
import org.kozak.carfinder.Services.Implementation.AdvertService;
import org.kozak.carfinder.Services.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/adverts")
public class AdvertController {

    @Autowired
    AdvertService advertService;

    @GetMapping("/byId/{id}")
    public AdvertEntity getById(@PathVariable int id) throws AdvertNotFoundException{
        AdvertEntity advert = advertService.getAdvertById(id);
        if(advert == null) throw new AdvertNotFoundException("There is no such advert");
        return advert;
//        return advertService.getAdvertById(id);
    }

    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/byTrim/byColour/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}/{trim}/{colour}")
    public ArrayList<AdvertEntity> getAdverts(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox, @PathVariable("trim") String trim, @PathVariable("colour") String colour){
        return advertService.getAdverts(brand, model, type, fuelType, engine, gearbox, trim, colour);
    }

    @GetMapping("/interested/{id}")
    public List<AdvertEntity> getAdvertByUserInterest(@PathVariable int id){
        return advertService.getAdvertByUserInterest(id);
    }

    @PostMapping("/dealer")
    public int addAdvert(@RequestBody AdvertDto advertDto){
        return advertService.addAdvert(advertDto);
    }

    @GetMapping("/dealer/{id}")
    public ArrayList<AdvertEntity> getAdvertByDealerId(@PathVariable int id){
        return advertService.getAdvertByDealerId(id);
    }



}
