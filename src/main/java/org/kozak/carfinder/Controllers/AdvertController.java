package org.kozak.carfinder.Controllers;

import org.kozak.carfinder.Models.*;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Services.Exceptions.AdvertNotFoundException;
import org.kozak.carfinder.Services.Implementation.AdvertService;
import org.kozak.carfinder.Services.Const;
import org.kozak.carfinder.Services.Implementation.PhotoService;
import org.kozak.carfinder.Services.Implementation.UsersService;
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

    @Autowired
    PhotoService photoService;

    @Autowired
    UsersService usersService;

    @Autowired
    IUsersDao usersDao;

    @GetMapping("/byId/{id}")
    public AdvertEntity getById(@PathVariable int id) throws AdvertNotFoundException{
        AdvertEntity advert = advertService.getAdvertById(id);
        if(advert == null) throw new AdvertNotFoundException("There is no such advert");
        return advert;
    }

    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/byTrim/byColour/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}/{trim}/{colour}")
    public ArrayList<AdvertDto> getAdvertsWithPhotos(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox, @PathVariable("trim") String trim, @PathVariable("colour") String colour){
        return advertService.getAdvertsWithPhotos(brand, model, type, fuelType, engine, gearbox, trim, colour);
    }


    @GetMapping("/interested/{userId}")
    public ArrayList<AdvertDto> getAdvertByUserInterestWithPhotos(@PathVariable int userId){
        UsersEntity user = usersDao.findById(userId).get();
        return advertService.getAdvertByUserInterestWithPhotos(user.getId());
    }

    @PostMapping("/dealer")
    public int addAdvert(@RequestBody AdvertDto advertDto){
        return advertService.addAdvert(advertDto);
    }

    @GetMapping("/dealer/{id}")
    public ArrayList<AdvertDto> getAdvertByDealerId(@PathVariable int id){
        return advertService.getAdvertByDealerId(id);
    }

    @GetMapping("/photo/byAdvertId/{id}")
    public PhotosEntity getFirstPhoto(@PathVariable int id){
        return photoService.getFirstPhoto(id);
    }

    @DeleteMapping("/dealer/{id}")
    public void deleteEvent(@PathVariable int id) throws AdvertNotFoundException{
        int result = advertService.deleteAdvert(id);
        if(result == Const.advertDoesNotExist)
            throw new AdvertNotFoundException("There is no such advert");
    }




}
