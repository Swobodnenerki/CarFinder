package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.*;
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
        accountsDao.save(account);
//        UsersEntity user = new UsersEntity();
//        user.setEmail(usersDto.getEmail());
//        user.setFirstName(usersDto.getFirstName());
//        user.setLastName(usersDto.getLastName());
//        user.setPhone(usersDto.getPhone());
//        user.setAccountByAccountid(account);
//        usersDao.save(user);
        this.registerUserWithUserData(usersDto.getEmail(),usersDto.getFirstName(), usersDto.getLastName(), usersDto.getPhone(), account);
        this.registerUserSetRole(account);
//        RolesEntity role = new RolesEntity();
//        role.setRole("user");
//        role.setAccountByAccountid(account);
//        rolesDao.save(role);
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
        Optional<UsersEntity> user = usersDao.findById(usersDto.getUserId());
        if(user.isEmpty()) return Const.userDoesNotExit;

        if(usersDto.getEmail() != null && !usersDto.getEmail().equals(user.get().getEmail())){
            if(usersDao.findUsersEntitiesByEmail(usersDto.getEmail()) != null) return Const.emailAlreadyUsed;
            user.get().setEmail(usersDto.getEmail());
        }
        if(!usersDto.getPhone().equals(user.get().getPhone()))
            user.get().setPhone(usersDto.getPhone());
        if(!usersDto.getFirstName().equals(user.get().getFirstName()))
            user.get().setFirstName(usersDto.getFirstName());
        if(!usersDto.getLastName().equals(user.get().getLastName()))
            user.get().setLastName(usersDto.getLastName());
        usersDao.save(user.get());

        return Const.userDetailsUpdateSuccess;
    }

    @Override
    public UsersDto getUserById(int id) {
        UsersDto usersDto = new UsersDto();
        Optional<UsersEntity> user = usersDao.findById(id);
        if(user.isEmpty()) return null;
        usersDto.setUserId(user.get().getId());
        usersDto.setFirstName(user.get().getFirstName());
        usersDto.setLastName(user.get().getLastName());
        usersDto.setPhone(user.get().getPhone());
        usersDto.setEmail(user.get().getEmail());
        usersDto.setAccountId(user.get().getAccountByAccountid().getId());
        return usersDto;
    }

    @Override
    public UsersEntity getUserByAccountId(int id) {
        AccountEntity account = accountsDao.findById(id).get();
        return usersDao.findUsersEntitiesByAccountByAccountid(account);
    }
    @Override
    public AccountEntity getAccountById(int id) {
        AccountEntity account = accountsDao.findById(id).get();
        return account;
    }
    @Override
    public UsersDto getUserDtoByAccountId(int id) {
        UsersDto usersDto = new UsersDto();
        AccountEntity account = accountsDao.findById(id).get();
        Optional<UsersEntity> user = Optional.ofNullable(usersDao.findUsersEntitiesByAccountByAccountid(account));
        if(user.isEmpty()) return null;
        usersDto.setUserId(user.get().getId());
        usersDto.setFirstName(user.get().getFirstName());
        usersDto.setLastName(user.get().getLastName());
        usersDto.setPhone(user.get().getPhone());
        usersDto.setEmail(user.get().getEmail());
        usersDto.setAccountId(user.get().getAccountByAccountid().getId());
        return usersDto;
    }
}
