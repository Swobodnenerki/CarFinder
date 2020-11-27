package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.*;

import java.util.ArrayList;
import java.util.List;

public interface IDealerService {
    int registerNewDealer(DealerDto dealerDto);
    void registerDealerWithUserData(String email, String firstName, String lastName, String phone, AccountEntity accountEntity, DealerDto dealerDto);
    void registerDealerWithDealerData(String name, String city, String street, int streetNumber, UsersEntity usersEntity);
    void registerDealerSetRole(AccountEntity accountEntity);
    int getRoleByUserId(int id);
    DealerEntity getDealerById(int id);
    int getDealerIdByUserId(int id);
    DealerDto getDealerDtoByUserId(int id);
    int updateDealerByUserId(DealerDto dealerDto);
}
