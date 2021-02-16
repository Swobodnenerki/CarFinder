package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.*;
import org.kozak.carfinder.Repositories.API.*;
import org.kozak.carfinder.Services.API.IAdvertService;
import org.kozak.carfinder.Services.API.IPhotoService;
import org.kozak.carfinder.Services.Const;
import org.kozak.carfinder.Services.Implementation.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    IPhotosDao photosDao;

    @Autowired
    PhotoService photoService;

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
    public ArrayList<AdvertDto> getAdvertsWithPhotos(String brand, String model, String type, String fuel_type, String engine, String gearbox, String trim, String colour) {
        ArrayList<AdvertEntity> adverts = advertDao.findAllByBrandAndModelAndTypeAndFuelTypeAndEngineAndGearboxAndTrimAndColour(brand, model, type, fuel_type, engine, gearbox, trim, colour);
        ArrayList<AdvertDto> advertDtos = new ArrayList<>();
        adverts.sort(new Comparator<AdvertEntity>() {
            @Override
            public int compare(AdvertEntity lhs, AdvertEntity rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.getPrice() > rhs.getPrice() ? 1 : (lhs.getPrice() < rhs.getPrice()) ? -1 : 0;
            }
        });
        for(AdvertEntity advert : adverts
        ){
            advertDtos.add(setUPAdvertDto(advert));
        }
        return advertDtos;
    }

    @Override
    public AdvertDto setUPAdvertDto(AdvertEntity advertEntity) {
        AdvertDto advertDto = new AdvertDto();
//        photoService = new PhotoService();

        advertDto.setAdvertId(advertEntity.getId());
        advertDto.setBrand(advertEntity.getBrand());
        advertDto.setModel(advertEntity.getModel());
        advertDto.setType(advertEntity.getType());
        advertDto.setFuelType(advertEntity.getFuelType());
        advertDto.setEngine(advertEntity.getEngine());
        advertDto.setGearbox(advertEntity.getGearbox());
        advertDto.setTrim(advertEntity.getTrim());
        advertDto.setColour(advertEntity.getColour());
        advertDto.setDealerId(advertEntity.getDealerByDealerid().getId());
        advertDto.setPrice(advertEntity.getPrice());
        advertDto.setUrl(photoService.getFirstPhoto(advertEntity.getId()).getUrl());
        advertDto.setPhotoId(photoService.getFirstPhoto(advertEntity.getId()).getId());
        return advertDto;
    }


    @Override
    public AdvertEntity getAdvertById(int id) {
//        return advertDao.getOne(id);
        return advertDao.findById(id).get();
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
    public ArrayList<AdvertDto> getAdvertByUserInterestWithPhotos(int userId) {
        ArrayList<Integer> ids = new ArrayList<>();
        Optional<UsersEntity> user = usersDao.findById(userId);
        if(user.isEmpty()) return null;
        ArrayList<InterestEntity> userInterest = interestDao.findAllByUsersByUserid(user.get());
        for (InterestEntity interestEntity: userInterest
        ) {
            ids.add(interestEntity.getAdvertByAdvertid().getId());
        }
        List<AdvertEntity> adverts = advertDao.findAllById(ids);
        ArrayList<AdvertDto> advertDtos = new ArrayList<>();
        for(AdvertEntity advert : adverts
        ){
            advertDtos.add(setUPAdvertDto(advert));
        }
        return advertDtos;

    }

    @Override
    public ArrayList<AdvertDto> getAdvertByDealerId(int dealerId) {
        Optional<DealerEntity> temp = dealerDao.findById(dealerId);
        if(temp.isEmpty()) return null;
        ArrayList<AdvertEntity> adverts = advertDao.findAllByDealerByDealerid(temp.get());
        ArrayList<AdvertDto> advertDtos = new ArrayList<>();
        for(AdvertEntity advert : adverts){
            advertDtos.add(setUPAdvertDto(advert));
        }
        return advertDtos;

    }

    @Override
    public int addAdvert(AdvertDto advertDto) {
        if(advertDto.getUrl().length()>500){
            return Const.urlToLang;
        }
        AdvertEntity advert = new AdvertEntity();
        DealerEntity dealer = dealerDao.getOne(advertDto.getDealerId());
        advert.setBrand(advertDto.getBrand());
        advert.setModel(advertDto.getModel());
        advert.setType(advertDto.getType());
        advert.setFuelType(advertDto.getFuelType());
        advert.setEngine(advertDto.getEngine());
        advert.setGearbox(advertDto.getGearbox());
        advert.setTrim(advertDto.getTrim());
        advert.setPrice(advertDto.getPrice());
        advert.setColour(advertDto.getColour());
        advert.setDealerByDealerid(dealer);
        AdvertEntity temp = advertDao.save(advert);
//        PhotoService photo = new PhotoService();
        PhotosEntity photo = new PhotosEntity();
        photo.setUrl(advertDto.getUrl());

        photo.setAdvertByAdvertid(advert);
        photosDao.save(photo);
//        photo.addPhoto(advertDto.getUrl(),advert);
        return temp.getId();
    }

    @Override
    public int deleteAdvert(int id) {
        Optional<AdvertEntity> advert = advertDao.findById(id);
        if(advert.isEmpty()) return Const.advertDoesNotExist;
        interestDao.deleteAllByAdvertByAdvertid(advert);
        photosDao.deleteAllByAdvertByAdvertid(advert);
        advertDao.deleteById(id);
        return Const.advertDeletionSuccess;
    }

    @Override
    public ArrayList<AdvertDto> getAdvertsByCity(String city) {
        List<Integer> ids = new ArrayList<>();
        ArrayList<AdvertEntity> adverts = new ArrayList<>();
        List<DealerEntity> dealers = dealerDao.findAllByCity(city);
        for(DealerEntity dealer : dealers){
            adverts = advertDao.findAllByDealerByDealerid(dealer);
            for(AdvertEntity advert: adverts){
                ids.add(advert.getId());
            }
        }
        List<AdvertEntity> allAdverts = advertDao.findAllById(ids);
        allAdverts.sort(new Comparator<AdvertEntity>() {
            @Override
            public int compare(AdvertEntity lhs, AdvertEntity rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.getPrice() > rhs.getPrice() ? 1 : (lhs.getPrice() < rhs.getPrice()) ? -1 : 0;
            }
        });
        ArrayList<AdvertDto> advertDtos = new ArrayList<>();
        for(AdvertEntity advert : allAdverts
        ){
            advertDtos.add(setUPAdvertDto(advert));
        }
        return advertDtos;
    }



}
