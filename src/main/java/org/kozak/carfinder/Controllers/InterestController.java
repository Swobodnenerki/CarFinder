package org.kozak.carfinder.Controllers;

import org.kozak.carfinder.Models.InterestEntity;
import org.kozak.carfinder.Models.InterestDto;
import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Services.Implementation.InterestService;
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
    @DeleteMapping("/{id}")
    public void deleteInterest(@PathVariable int id){
        interestService.deleteInterest(id);
    }
}
