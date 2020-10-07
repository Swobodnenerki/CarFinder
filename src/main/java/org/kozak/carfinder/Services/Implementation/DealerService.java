package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.*;
import org.kozak.carfinder.Repositories.API.IDealerDao;
import org.kozak.carfinder.Models.DealerDto;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Repositories.API.IAccountDao;
import org.kozak.carfinder.Repositories.API.IRolesDao;
import org.kozak.carfinder.Services.API.IDealerService;
import org.kozak.carfinder.Services.API.IUsersService;
import org.kozak.carfinder.Services.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DealerService implements IDealerService {
    @Autowired
    IAccountDao accountsDao;
    @Autowired
    IUsersDao usersDao;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IRolesDao rolesDao;
    @Autowired
    IDealerDao dealerDao;

    @Override
    public int registerNewDealer(UsersDto usersDto, DealerDto dealerDto) {
        if(accountsDao.findAccountEntitiesByLogin(usersDto.getLogin()) != null) return Const.loginAlreadyUsed;
        if(usersDao.findUsersEntitiesByEmail(usersDto.getEmail()) !=null) return Const.emailAlreadyUsed;
        AccountEntity account = new AccountEntity();
        account.setLogin(usersDto.getLogin());
        account.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        accountsDao.save(account);
        this.registerDealerWithUserData(usersDto.getEmail(),usersDto.getFirstName(), usersDto.getLastName(), usersDto.getPhone(), account, dealerDto);
        this.registerDealerSetRole(account);
        return Const.registrationSuccess;

    }

    @Override
    public void registerDealerWithUserData(String email, String firstName, String lastName, String phone, AccountEntity account, DealerDto dealerDto) {
        UsersEntity user = new UsersEntity();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setAccountByAccountid(account);
        usersDao.save(user);
        this.registerDealerWithDealerData(dealerDto.getName(), dealerDto.getCity(), dealerDto.getStreet(), dealerDto.getStreetNumber(), user);

    }

    @Override
    public void registerDealerWithDealerData(String name, String city, String street, int streetNumber, UsersEntity user) {
        DealerEntity dealer = new DealerEntity();
        dealer.setName(name);
        dealer.setCity(city);
        dealer.setStreet(street);
        dealer.setStreetNumber(streetNumber);
        dealer.setUsersByUserid(user);
        dealerDao.save(dealer);

    }

    @Override
    public void registerDealerSetRole(AccountEntity account) {
        RolesEntity role = new RolesEntity();
        role.setRole("dealer");
        role.setAccountByAccountid(account);
        rolesDao.save(role);
    }
}
