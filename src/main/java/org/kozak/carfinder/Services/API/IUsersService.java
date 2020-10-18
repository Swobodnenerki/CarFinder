package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.UsersDto;
import java.util.ArrayList;
import java.util.List;

public interface IUsersService {
    int registerNewUser(UsersDto usersDto);
    void registerUserWithUserData(String email, String firstName, String lastName, String phone, AccountEntity accountEntity);
    void registerUserSetRole(AccountEntity accountEntity);
    int deleteUser(int id);
    void deleteAccount(AccountEntity account);
    int updateAccountDetails(String login, String password, AccountEntity account);
    int updateUserDetails(UsersDto usersDto);
    UsersDto getUserById(int id);
}