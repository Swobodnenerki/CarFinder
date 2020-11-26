package org.kozak.carfinder.Services.API;

import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.UsersDto;

public interface IUsersService {
    int registerNewUser(UsersDto usersDto);
    void registerUserWithUserData(String email, String firstName, String lastName, String phone, AccountEntity accountEntity);
    void registerUserSetRole(AccountEntity accountEntity);
    int deleteUser(int id);
    void deleteAccount(AccountEntity account);
    int updateAccountDetails(String login, String password, AccountEntity account);
    int updateUserDetails(UsersDto usersUpdateDto);
    UsersDto getUserById(int id);

    UsersEntity getUserByAccountId(int id);

    AccountEntity getAccountById(int id);

    UsersDto getUserDtoByAccountId(int id);
}
