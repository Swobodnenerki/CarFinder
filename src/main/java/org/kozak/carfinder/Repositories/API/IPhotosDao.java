package org.kozak.carfinder.Repositories.API;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.PhotosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@Transactional
public interface IPhotosDao extends JpaRepository<PhotosEntity, Integer> {
    ArrayList<PhotosEntity> findAllByAdvertByAdvertid(AdvertEntity advert);
    void deleteAllByAdvertByAdvertid(Optional<AdvertEntity> advert);
}
