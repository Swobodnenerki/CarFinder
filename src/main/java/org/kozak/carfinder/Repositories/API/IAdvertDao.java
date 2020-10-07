package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.CarSpecsEntity;
import org.kozak.carfinder.Models.DealerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
@Transactional
public interface IAdvertDao extends JpaRepository<AdvertEntity, Integer> {
    ArrayList<AdvertEntity> findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);
    ArrayList<AdvertEntity> findAllByDealerByDealerid(DealerEntity dealerEntity);


}
