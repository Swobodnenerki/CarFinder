package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.CarSpecsEntity;

import java.util.ArrayList;

public interface ICarSpecsService {
    ArrayList<String> getBrand();
    ArrayList<CarSpecsEntity> getCarSpecs();
    ArrayList<CarSpecsEntity> getCarSpecsByBrand(String brand);
    ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModel(String brand, String model);
    ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndType(String brand, String model, String type);
    ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelType(String brand, String model, String type, String fuel_type);
    ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngine(String brand, String model, String type, String fuel_type, String engine);
    ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearbox(String brand, String model, String type, String fuel_type, String engine, String gearbox);
    ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrim(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim);
    ArrayList<CarSpecsEntity> getCarSpecsByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);
}
