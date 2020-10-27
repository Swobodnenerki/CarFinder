package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.CarSpecsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
@Transactional
public interface ICarSpecsDao extends JpaRepository<CarSpecsEntity, Integer> {

    ArrayList<CarSpecsEntity> findAll();

    @Query(value = "SELECT DISTINCT brand FROM car_specs ORDER BY brand", nativeQuery = true)
    ArrayList<String> findDistinctBrand();

    @Query(value = "SELECT DISTINCT model FROM car_specs WHERE brand = ?1 ORDER BY model", nativeQuery = true)
    ArrayList<String> findDistinctModel(String brand);

    @Query(value = "SELECT DISTINCT type FROM car_specs WHERE brand = ?1 AND model = ?2 ORDER BY type", nativeQuery = true)
    ArrayList<String> findDistinctType(String brand, String model);

    @Query(value = "SELECT DISTINCT fuel_type FROM car_specs WHERE brand = ?1 AND model = ?2 AND type = ?3 ORDER BY fuel_type", nativeQuery = true)
    ArrayList<String> findDistinctFuelType(String brand, String model, String type);

    @Query(value = "SELECT DISTINCT engine FROM car_specs WHERE brand = ?1 AND model = ?2 AND type = ?3 AND fuel_type = ?4 ORDER BY engine", nativeQuery = true)
    ArrayList<String> findDistinctEngine(String brand, String model, String type, String fuel_type);

    @Query(value = "SELECT DISTINCT gearbox FROM car_specs WHERE brand = ?1 AND model = ?2 AND type = ?3 AND fuel_type = ?4 AND engine =?5 ORDER BY gearbox", nativeQuery = true)
    ArrayList<String> findDistinctGearbox(String brand, String model, String type, String fuel_type, String engine);

    @Query(value = "SELECT DISTINCT trim FROM car_specs WHERE brand = ?1 AND model = ?2 AND type = ?3 AND fuel_type = ?4 AND engine = ?5 AND gearbox = ?6 ORDER BY trim", nativeQuery = true)
    ArrayList<String> findDistinctTrim(String brand, String model, String type, String fuel_type, String engine, String gearbox);

    @Query(value = "SELECT DISTINCT colour FROM car_specs WHERE brand = ?1 AND model = ?2 AND type = ?3 AND fuel_type = ?4 AND engine = ?5 AND gearbox = ?6 AND trim = ?7 ORDER BY colour", nativeQuery = true)
    ArrayList<String> findDistinctColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim);

    @Query(value = "SELECT DISTINCT price FROM car_specs WHERE brand = ?1 AND model = ?2 AND type = ?3 AND fuel_type = ?4 AND engine = ?5 AND gearbox = ?6 AND trim = ?7 AND colour =?8 ORDER BY price", nativeQuery = true)
    Double findDistinctPrice(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);

    ArrayList<CarSpecsEntity> findAllByBrand(String brand);
    ArrayList<CarSpecsEntity> findAllByBrandAndModel(String brand, String model);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndType(String brand, String model, String type);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelType(String brand, String model, String type, String fuel_type);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngine(String brand, String model, String type, String fuel_type, String engine);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearbox(String brand, String model, String type, String fuel_type, String engine, String gearbox);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrim(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim);
    ArrayList<CarSpecsEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);


}
