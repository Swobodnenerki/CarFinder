package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.PhotosEntity;
import java.util.ArrayList;
import java.util.List;

public interface IPhotoService {
    PhotosEntity getFirstPhoto(int id);
    PhotosEntity getPhotoById(int id);
    ArrayList<PhotosEntity> getPhotoByAdvertId(int id);
    void addPhoto(String url, AdvertEntity advert);
    int deletePhoto(int id);
}
