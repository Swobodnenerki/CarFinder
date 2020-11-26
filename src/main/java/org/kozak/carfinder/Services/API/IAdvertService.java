package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.AdvertDto;
import java.util.ArrayList;
import java.util.List;

public interface IAdvertService {
    ArrayList<AdvertEntity> getAdverts(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);
    ArrayList<AdvertDto> getAdvertsWithPhotos(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);
    AdvertDto setUPAdvertDto(AdvertEntity advertEntity);
    AdvertEntity getAdvertById(int id);
    List<AdvertEntity> getAdvertByUserInterest(int userId);
    ArrayList<AdvertDto> getAdvertByUserInterestWithPhotos(int userId);
    ArrayList<AdvertDto> getAdvertByDealerId(int dealerId);
    int addAdvert(AdvertDto advert);
    int deleteAdvert(int id);
    ArrayList<AdvertDto> getAdvertsByCity(String city);
}
