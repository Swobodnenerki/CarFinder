package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.CarSpecsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
@Transactional
public interface ICarSpecsDao extends JpaRepository<CarSpecsEntity, Integer> {
    ArrayList<CarSpecsEntity> findAllByBrand(String brand);
    ArrayList<CarSpecsEntity> findAllByBrandAndModel(String brand, String model);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndType(String brand, String model, String type);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelType(String brand, String model, String type, String fuel_type);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngine(String brand, String model, String type, String fuel_type, String engine);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearbox(String brand, String model, String type, String fuel_type, String engine, String gearbox);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrim(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);


}
