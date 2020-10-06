package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.AccountEntity;
import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    int registerNewUser(/*UserDto userDto*/);
    void registerAccountWithLogin(String login, String password, UsersEntity user);
    int deleteUser(int id);
    void deleteAccount(AccountEntity account);
    int updateAccountDetails(String login, String password, AccountEntity account);
    int updateUserDetails(/*UserDto userDto*/);
}
