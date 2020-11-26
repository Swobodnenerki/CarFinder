package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.InterestDto;
import org.kozak.carfinder.Models.InterestEntity;
import java.util.ArrayList;
import java.util.List;

public interface IInterestService {
    ArrayList<InterestEntity> getInterestByAdvertId(int advertId);
    ArrayList<InterestEntity> getInterestByUserId(int userId);
    int addInterest(InterestDto interestDto);
    void deleteInterest(int id);
    boolean checkIfUserIsInterested(int userId, int advertId);
    void deleteInterestByUserInterested(int userId, int advertId);
}
