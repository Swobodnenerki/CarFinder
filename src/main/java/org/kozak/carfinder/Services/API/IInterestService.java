package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.InterestEntity;
import java.util.ArrayList;
import java.util.List;

public interface IInterestService {
    ArrayList<InterestEntity> getInterestByUserId(int userId);
    int addInterest();
    int deleteInterest(int id);
}
