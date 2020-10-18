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
        return 0;
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
}
