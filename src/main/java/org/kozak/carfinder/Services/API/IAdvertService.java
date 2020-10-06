package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.AdvertEntity;
import java.util.ArrayList;
import java.util.List;

public interface IAdvertService {
    ArrayList<AdvertEntity> getAdverts(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour);
    AdvertEntity getAdvertById(int id);
    ArrayList<AdvertEntity> getAdvertByUserId(int userId);
    ArrayList<AdvertEntity> getAdvertByDealerId(int dealerId);
    int addAdvert();
    int updateAdvert();
    int deleteAdvert(int id);

    List<AdvertEntity> getSortedByPrice(String price, String sortType);
}
