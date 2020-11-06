package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.InterestEntity;
import org.kozak.carfinder.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@Transactional
public interface IInterestDao extends JpaRepository<InterestEntity, Integer> {
    ArrayList<InterestEntity> findAllByUsersByUserid(UsersEntity user);
    ArrayList<InterestEntity> findAllByAdvertByAdvertid(AdvertEntity advert);
    void deleteAllByAdvertByAdvertid(Optional<AdvertEntity> advertEntity);
}
