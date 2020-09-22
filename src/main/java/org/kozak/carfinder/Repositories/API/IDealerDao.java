package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.DealerEntity;
import org.kozak.carfinder.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
@Transactional
public interface IDealerDao extends JpaRepository<DealerEntity, Integer> {
    DealerEntity findDealerEntitiesByUsersByUserid(UsersEntity user);
}
