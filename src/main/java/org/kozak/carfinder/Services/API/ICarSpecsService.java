package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.CarSpecsEntity;

import java.util.ArrayList;

public interface ICarSpecsService {
    ArrayList<String> getBrand();
    ArrayList<String> getModel(String brand);
    ArrayList<String> getType(String brand, String model);
    ArrayList<String> getFuelType(String brand, String model, String type);
    ArrayList<String> getEngine(String brand, String model, String type, String fuel_type);
    ArrayList<String> getGearbox(String brand, String model, String type, String fuel_type, String engine);
    ArrayList<String> getTrim(String brand, String model, String type, String fuel_type, String engine, String gearbox);
    ArrayList<String> getColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim);
    Double getPrice(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);
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
