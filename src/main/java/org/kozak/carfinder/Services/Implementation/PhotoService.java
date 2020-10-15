package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.PhotosEntity;
import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Repositories.API.IAdvertDao;
import org.kozak.carfinder.Repositories.API.IPhotosDao;
import org.kozak.carfinder.Services.API.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PhotoService implements IPhotoService {

    @Autowired
    IPhotosDao photosDao;

    @Autowired
    IAdvertDao advertDao;


    @Override
    public PhotosEntity getFirstPhoto(int id) {
        Optional<AdvertEntity> advert = advertDao.findById(id);
        if(advert.isEmpty()) return null;
        ArrayList<PhotosEntity> photos = photosDao.findAllByAdvertByAdvertid(advert.get());
        return photos.get(0);
    }

    @Override
    public PhotosEntity getPhotoById(int id) {
        return photosDao.getOne(id);
    }

    @Override
    public ArrayList<PhotosEntity> getPhotoByAdvertId(int id) {
        Optional<AdvertEntity> advert = advertDao.findById(id);
        if(advert.isEmpty()) return null;
        return photosDao.findAllByAdvertByAdvertid(advert.get());
    }

    @Override
    public void addPhoto(String url, AdvertEntity advert) {
        PhotosEntity photo = new PhotosEntity();
        photo.setUrl(url);
        photo.setAdvertByAdvertid(advert);
        photosDao.save(photo);
    }

    @Override
    public int deletePhoto(int id) {
        return 0;
    }
}
