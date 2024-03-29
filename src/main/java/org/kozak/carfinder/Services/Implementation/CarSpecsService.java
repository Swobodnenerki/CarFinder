package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.CarSpecsEntity;
import org.kozak.carfinder.Repositories.API.ICarSpecsDao;
import org.kozak.carfinder.Services.API.ICarSpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarSpecsService implements ICarSpecsService {

    @Autowired
    ICarSpecsDao carSpecsDao;

    @Override
    public ArrayList<String> getBrand() {
        return carSpecsDao.findDistinctBrand();
    }

    @Override
    public ArrayList<String> getModel(String brand) {
        return carSpecsDao.findDistinctModel(brand);
    }

    @Override
    public ArrayList<String> getType(String brand, String model) {
        return carSpecsDao.findDistinctType(brand, model);
    }

    @Override
    public ArrayList<String> getFuelType(String brand, String model, String type) {
        return  carSpecsDao.findDistinctFuelType(brand, model, type);
    }

    @Override
    public ArrayList<String> getEngine(String brand, String model, String type, String fuel_type) {
        return  carSpecsDao.findDistinctEngine(brand, model, type, fuel_type);
    }

    @Override
    public ArrayList<String> getGearbox(String brand, String model, String type, String fuel_type, String engine) {
        return  carSpecsDao.findDistinctGearbox(brand, model, type, fuel_type, engine);
    }

    @Override
    public ArrayList<String> getTrim(String brand, String model, String type, String fuel_type, String engine, String gearbox) {
        return  carSpecsDao.findDistinctTrim(brand, model, type, fuel_type, engine, gearbox);
    }

    @Override
    public ArrayList<String> getColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim) {
        return  carSpecsDao.findDistinctColour(brand, model, type, fuel_type, engine, gearbox, trim);
    }

    @Override
    public Double getPrice(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour) {
        return  carSpecsDao.findDistinctPrice(brand, model, type, fuel_type, engine, gearbox, trim, colour);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecs() {
        return carSpecsDao.findAll();
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrand(String brand) {
        return carSpecsDao.findAllByBrand(brand);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModel(String brand, String model) {
        return carSpecsDao.findAllByBrandAndModel(brand, model);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndType(String brand, String model, String type) {
        return carSpecsDao.findAllByBrandAndModelAndType(brand, model, type);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelType(String brand, String model, String type, String fuel_type) {
        return carSpecsDao.findAllByBrandAndModelAndTypeAndFuelType(brand, model, type, fuel_type);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngine(String brand, String model, String type, String fuel_type, String engine) {
        return carSpecsDao.findAllByBrandAndModelAndTypeAndFuelTypeAndEngine(brand, model, type, fuel_type, engine);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearbox(String brand, String model, String type, String fuel_type, String engine, String gearbox) {
        return carSpecsDao.findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearbox(brand, model, type, fuel_type, engine, gearbox);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrim(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim) {
        return carSpecsDao.findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrim(brand, model, type, fuel_type, engine, gearbox, trim);
    }

    @Override
    public ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour) {
        return carSpecsDao.findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(brand, model, type, fuel_type, engine, gearbox, trim, colour);
    }
}
