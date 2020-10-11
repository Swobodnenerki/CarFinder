package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.UsersDto;
import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.RolesEntity;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Repositories.API.IAccountDao;
import org.kozak.carfinder.Repositories.API.IRolesDao;
import org.kozak.carfinder.Services.API.IUsersService;
import org.kozak.carfinder.Services.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersService {
    @Autowired
    IAccountDao accountsDao;
    @Autowired
    IUsersDao usersDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IRolesDao rolesDao;

    @Override
    public int registerNewUser(UsersDto usersDto) {
        if(accountsDao.findAccountEntitiesByLogin(usersDto.getLogin()) != null) return Const.loginAlreadyUsed;
        if(usersDao.findUsersEntitiesByEmail(usersDto.getEmail()) !=null) return Const.emailAlreadyUsed;
        AccountEntity account = new AccountEntity();
        account.setLogin(usersDto.getLogin());
        account.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        account.setPassword(usersDto.getPassword());
        accountsDao.save(account);
        this.registerUserWithUserData(usersDto.getEmail(),usersDto.getFirstName(), usersDto.getLastName(), usersDto.getPhone(), account);
        this.registerUserSetRole(account);
        return Const.registrationSuccess;
    }

    @Override
    public void registerUserWithUserData(String email, String firstName, String lastName, String phone, AccountEntity account) {
        UsersEntity user = new UsersEntity();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setAccountByAccountid(account);
        usersDao.save(user);
        return;
    }

    @Override
    public void registerUserSetRole(AccountEntity account) {
        RolesEntity role = new RolesEntity();
        role.setRole("user");
        role.setAccountByAccountid(account);
        rolesDao.save(role);
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public void deleteAccount(AccountEntity account) {

    }

    @Override
    public int updateAccountDetails(String login, String password, AccountEntity account) {
        return 0;
    }

    @Override
    public int updateUserDetails(UsersDto usersDto) {
        return 0;
    }
}
