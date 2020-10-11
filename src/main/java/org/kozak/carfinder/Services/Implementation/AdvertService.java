package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.*;
import org.kozak.carfinder.Repositories.API.IAdvertDao;
import org.kozak.carfinder.Repositories.API.IInterestDao;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Repositories.API.IDealerDao;
import org.kozak.carfinder.Services.API.IAdvertService;
import org.kozak.carfinder.Services.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AdvertService implements IAdvertService{

    @Autowired
    IAdvertDao advertDao;

    @Autowired
    IInterestDao interestDao;

    @Autowired
    IUsersDao usersDao;

    @Autowired
    IDealerDao dealerDao;

    @Override
    public ArrayList<AdvertEntity> getAdverts(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour) {
        ArrayList<AdvertEntity> adverts = advertDao.findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(brand, model, type, fuel_type, engine, gearbox, trim, colour);
        adverts.sort(new Comparator<AdvertEntity>() {
            @Override
            public int compare(AdvertEntity lhs, AdvertEntity rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.getPrice() > rhs.getPrice() ? -1 : (lhs.getPrice() < rhs.getPrice()) ? 1 : 0;
            }
        });
        return adverts;
    }

    @Override
    public AdvertEntity getAdvertById(int id) {
        return advertDao.getOne(id);
    }

    @Override
    public List<AdvertEntity> getAdvertByUserInterest(int userId) {
        ArrayList<Integer> ids = new ArrayList<>();
        Optional<UsersEntity> user = usersDao.findById(userId);
        if(user.isEmpty()) return null;
        List<InterestEntity> userInterest = interestDao.findAllByUsersByUserid(user.get());
        for (InterestEntity interestEntity: userInterest
        ) {
            ids.add(interestEntity.getAdvertByAdvertid().getId());
        }
        return advertDao.findAllById(ids);
    }

    @Override
    public ArrayList<AdvertEntity> getAdvertByDealerId(int dealerId) {
        Optional<DealerEntity> temp = dealerDao.findById(dealerId);
        if(temp.isEmpty()) return null;
        return advertDao.findAllByDealerByDealerid(temp.get());

    }

    @Override
    public int addAdvert(AdvertDto advertDto) {
        AdvertEntity advert = new AdvertEntity();
        DealerEntity dealer = dealerDao.getOne(advertDto.getDealerId());
        advert.setBrand(advertDto.getBrand());
        advert.setBrand(advertDto.getModel());
        advert.setType(advertDto.getType());
        advert.setFuelType(advertDto.getFuelType());
        advert.setEngine(advertDto.getEngine());
        advert.setGearbox(advertDto.getGearBox());
        advert.setTrim(advertDto.getTrim());
        advert.setPrice(advertDto.getPrice());
        advert.setDealerByDealerid(dealer);
        AdvertEntity temp = advertDao.save(advert);
        PhotoService photo = new PhotoService();
        photo.addPhoto(advertDto.getUrl(),advert);
        return temp.getId();
    }

    @Override
    public List<AdvertEntity> getSortedByPrice(String price, String sortType) {
        return null;
    }
}
