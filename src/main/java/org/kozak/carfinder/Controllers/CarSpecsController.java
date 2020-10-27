package org.kozak.carfinder.Controllers;

import org.kozak.carfinder.Models.CarSpecsEntity;
import org.kozak.carfinder.Services.Implementation.CarSpecsService;
import org.kozak.carfinder.Services.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/configure")
public class CarSpecsController {
    @Autowired
    CarSpecsService carSpecsService;

    @GetMapping
    public ArrayList<String> getBrand(){
        return carSpecsService.getBrand();
    }

//    @GetMapping
//    public ArrayList<CarSpecsEntity> getAll(){
//        return carSpecsService.getCarSpecs();
//    }

    @GetMapping("/byBrand/{brand}")
    public ArrayList<String> getModel(@PathVariable String brand){
        return carSpecsService.getModel(brand);
    }

//    @GetMapping("/byBrand/{brand}")
//    public ArrayList<CarSpecsEntity> getAllByBrand(@PathVariable String brand){
//        return carSpecsService.getCarSpecsByBrand(brand);
//    }

    @GetMapping("/byBrand/byModel/{brand}/{model}")
    public ArrayList<String> getType(@PathVariable("brand") String brand, @PathVariable("model") String model){
        return carSpecsService.getType(brand, model);
    }

//    @GetMapping("/byBrand/byModel/{brand}/{model}")
//    public ArrayList<CarSpecsEntity> getAllByBrandAndModel(@PathVariable("brand") String brand, @PathVariable("model") String model){
//        return carSpecsService.getCarSpecsByBrandAndModel(brand, model);
//    }

    @GetMapping("/byBrand/byModel/byType/{brand}/{model}/{type}")
    public ArrayList<String> getFuelType(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type){
        return carSpecsService.getFuelType(brand, model, type);
    }

//    @GetMapping("/byBrand/byModel/byType/{brand}/{model}/{type}")
//    public ArrayList<CarSpecsEntity> getAllByBrandAndModelAndType(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type){
//        return carSpecsService.getCarSpecsByBrandAndModelAndType(brand, model, type);
//    }

    @GetMapping("/byBrand/byModel/byType/byFuelType/{brand}/{model}/{type}/{fuelType}")
    public ArrayList<String> getEngine(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType){
        return carSpecsService.getEngine(brand, model, type, fuelType);
    }

//    @GetMapping("/byBrand/byModel/byType/byFuelType/{brand}/{model}/{type}/{fuelType}")
//    public ArrayList<CarSpecsEntity> getAllByBrandAndModelAndTypeAndFuelType(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType){
//        return carSpecsService.getCarSpecsByBrandAndModelAndTypeAndFuelType(brand, model, type, fuelType);
//    }

    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/{brand}/{model}/{type}/{fuelType}/{engine}")
    public ArrayList<String> getGearbox(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine){
        return carSpecsService.getGearbox(brand, model, type, fuelType, engine);
    }

//    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/{brand}/{model}/{type}/{fuelType}/{engine}")
//    public ArrayList<CarSpecsEntity> getAllByBrandAndModelAndTypeAndFuelTypeAndEngine(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine){
//        return carSpecsService.getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngine(brand, model, type, fuelType, engine);
//    }

    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}")
    public ArrayList<String> getTrim(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox){
        return carSpecsService.getTrim(brand, model, type, fuelType, engine, gearbox);
    }

//    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}")
//    public ArrayList<CarSpecsEntity> getAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearbox(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox){
//        return carSpecsService.getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearbox(brand, model, type, fuelType, engine, gearbox);
//    }

    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/byTrim/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}/{trim}")
    public ArrayList<String> getColour(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox, @PathVariable("trim") String trim){
        return carSpecsService.getColour(brand, model, type, fuelType, engine, gearbox, trim);
    }

//    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/byTrim/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}/{trim}")
//    public ArrayList<CarSpecsEntity> getAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrim(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox, @PathVariable("trim") String trim){
//        return carSpecsService.getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrim(brand, model, type, fuelType, engine, gearbox, trim);
//    }

    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/byTrim/byColour/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}/{trim}/{colour}")
    public Double getPrice(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox, @PathVariable("trim") String trim, @PathVariable("colour") String colour){
        return carSpecsService.getPrice(brand, model, type, fuelType, engine, gearbox, trim, colour);
    }

//    @GetMapping("/byBrand/byModel/byType/byFuelType/byEngine/byGearbox/byTrim/byColour/{brand}/{model}/{type}/{fuelType}/{engine}/{gearbox}/{trim}/{colour}")
//    public ArrayList<CarSpecsEntity> getAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(@PathVariable("brand") String brand, @PathVariable("model") String model, @PathVariable("type") String type, @PathVariable("fuelType") String fuelType, @PathVariable("engine") String engine, @PathVariable("gearbox") String gearbox, @PathVariable("trim") String trim, @PathVariable("colour") String colour){
//        return carSpecsService.getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(brand, model, type, fuelType, engine, gearbox, trim, colour);
//    }

}
