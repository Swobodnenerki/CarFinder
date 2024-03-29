package org.kozak.carfinder.Services.Implementation;

import org.apache.catalina.User;
import org.kozak.carfinder.Models.*;
import org.kozak.carfinder.Repositories.API.IAccountDao;
import org.kozak.carfinder.Repositories.API.IAdvertDao;
import org.kozak.carfinder.Repositories.API.IInterestDao;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Services.API.IInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class InterestService implements IInterestService {

    @Autowired
    IUsersDao usersDao;

    @Autowired
    IInterestDao interestDao;

    @Autowired
    IAdvertDao advertDao;

    @Autowired
    IAccountDao accountDao;

    @Autowired
    UsersService usersService;

    @Override
    public ArrayList<InterestEntity> getInterestByAdvertId(int advertId) {
        AdvertEntity advert = advertDao.findById(advertId).get();
        return interestDao.findAllByAdvertByAdvertid(advert);
    }

    @Override
    public ArrayList<InterestEntity> getInterestByUserId(int userId) {
        UsersEntity user = usersDao.findById(userId).get();
        return interestDao.findAllByUsersByUserid(user);
    }

    @Override
    public int addInterest(InterestDto interestDto) {
        InterestEntity interest = new InterestEntity();
        AdvertEntity advert = advertDao.getOne(interestDto.getAdvertId());
        UsersEntity user = usersDao.getOne(interestDto.getUserId());
        interest.setAdvertByAdvertid(advert);
        interest.setUsersByUserid(user);
        InterestEntity temp = interestDao.save(interest);
        return temp.getId();
    }

    @Override
    public void deleteInterest(int id) {
        interestDao.deleteById(id);
    }
    @Override
    public boolean checkIfUserIsInterested(int userId, int advertId){
        boolean userInterested = false;
        UsersEntity user = usersDao.findById(userId).get();
        ArrayList<InterestEntity> interestByAdvert = this.getInterestByAdvertId(advertId);
        ArrayList<InterestEntity> interestByUser = this.getInterestByUserId(user.getId());
        for(InterestEntity interestA: interestByAdvert
        ){
            for(InterestEntity interestU: interestByUser){
                if(interestA.getId() == interestU.getId()) userInterested=true;
            }
        }
        return userInterested;
    }
    @Override
    public void deleteInterestByUserInterested(int userId, int advertId){
        UsersEntity user = usersDao.findById(userId).get();
        ArrayList<InterestEntity> interestByAdvert = this.getInterestByAdvertId(advertId);
        ArrayList<InterestEntity> interestByUser = this.getInterestByUserId(user.getId());
        for(InterestEntity interestA: interestByAdvert
        ){
            for(InterestEntity interestU: interestByUser){
                if(interestA.getId() == interestU.getId()) this.deleteInterest(interestA.getId());
            }
        }
    }

}
