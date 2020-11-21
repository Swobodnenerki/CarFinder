package org.kozak.carfinder.Controllers;

import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.InterestEntity;
import org.kozak.carfinder.Models.InterestDto;
import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Services.Implementation.InterestService;
import org.kozak.carfinder.Services.Implementation.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/interest")
public class InterestController {

    @Autowired
    InterestService interestService;

    @Autowired
    UsersService usersService;

    @Autowired
    IUsersDao usersDao;

    @GetMapping("/byAdvertId/{id}")
    public ArrayList<InterestEntity> getInterestByAdvertId(@PathVariable int id){
        return interestService.getInterestByAdvertId(id);
    }

    @GetMapping("/byUserId/{id}")
    public ArrayList<InterestEntity> getInterestByUserId(@PathVariable int id){
        return interestService.getInterestByUserId(id);
    }

    @PostMapping
    public int addInterest(@RequestBody InterestDto interest){
        return interestService.addInterest(interest);
    }

    @DeleteMapping("/{userId}/{advertId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInterestByUserInterested(@PathVariable ("userId") int userId, @PathVariable ("advertId") int advertId){
        UsersEntity user = usersDao.findById(userId).get();
        ArrayList<InterestEntity> interestByAdvert = interestService.getInterestByAdvertId(advertId);
        ArrayList<InterestEntity> interestByUser = interestService.getInterestByUserId(user.getId());
        for(InterestEntity interestA: interestByAdvert
        ){
            for(InterestEntity interestU: interestByUser){
                if(interestA.getId() == interestU.getId()) interestService.deleteInterest(interestA.getId());
            }
        }
    }

    @GetMapping("checkIfUserIsInterested/{userId}/{advertId}")
    public boolean checkIfUserIsInterested(@PathVariable("userId") int userId, @PathVariable("advertId") int advertId){
        boolean userInterested = false;
        UsersEntity user = usersDao.findById(userId).get();
        ArrayList<InterestEntity> interestByAdvert = interestService.getInterestByAdvertId(advertId);
        ArrayList<InterestEntity> interestByUser = interestService.getInterestByUserId(user.getId());
        for(InterestEntity interestA: interestByAdvert
        ){
            for(InterestEntity interestU: interestByUser){
                if(interestA.getId() == interestU.getId()) userInterested=true;
            }
        }
        return userInterested;
    }
}
