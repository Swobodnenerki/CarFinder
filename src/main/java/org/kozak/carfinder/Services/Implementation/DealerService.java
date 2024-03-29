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

    @Autowired
    UsersService usersService;

    @Override
    public int registerNewDealer(DealerDto dealerDto) {
        if(accountsDao.findAccountEntitiesByLogin(dealerDto.getLogin()) != null) return Const.loginAlreadyUsed;
        if(usersDao.findUsersEntitiesByEmail(dealerDto.getEmail()) !=null) return Const.emailAlreadyUsed;
        AccountEntity account = new AccountEntity();
        account.setLogin(dealerDto.getLogin());
        account.setPassword(passwordEncoder.encode(dealerDto.getPassword()));
        accountsDao.save(account);
//        this.registerDealerWithUserData(dealerDto.getEmail(),dealerDto.getFirstName(), dealerDto.getLastName(), dealerDto.getPhone(), account, dealerDto);
//        this.registerDealerSetRole(account);
        UsersEntity user = new UsersEntity();
        user.setEmail(dealerDto.getEmail());
        user.setFirstName(dealerDto.getFirstName());
        user.setLastName(dealerDto.getLastName());
        user.setPhone(dealerDto.getPhone());
        user.setAccountByAccountid(account);
        usersDao.save(user);
        DealerEntity dealer = new DealerEntity();
        dealer.setName(dealerDto.getName());
        dealer.setCity(dealerDto.getCity());
        dealer.setStreet(dealerDto.getStreet());
        dealer.setStreetNumber(dealerDto.getStreetNumber());
        dealer.setUsersByUserid(user);
        dealerDao.save(dealer);
        RolesEntity role = new RolesEntity();
        role.setRole("dealer");
        role.setAccountByAccountid(account);
        rolesDao.save(role);
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

    @Override
    public int getRoleByUserId(int userId) {
        Optional<UsersEntity> user = usersDao.findById(userId);
        AccountEntity account = user.get().getAccountByAccountid();
        RolesEntity role=rolesDao.findRolesEntitiesByAccountByAccountid(account);
        if(role.getRole().equals("user")) return 0;
        return 1;
    }

    @Override
    public DealerEntity getDealerById(int id) {
        return dealerDao.findById(id).get();
    }

    @Override
    public int getDealerIdByUserId(int id) {
        UsersEntity user = usersDao.findById(id).get();
        Optional<DealerEntity> dealer = Optional.ofNullable(dealerDao.findDealerEntitiesByUsersByUserid(user));
        if(dealer.isEmpty()) return 0;
        int dealerId = dealer.get().getId();
        return dealerId;
    }
    @Override
    public DealerDto getDealerDtoByUserId(int userId){
        UsersEntity user = usersDao.findById(userId).get();
        int dealerId = this.getDealerIdByUserId(userId);
        DealerDto dealerDto = new DealerDto();
        Optional<DealerEntity> dealer = dealerDao.findById(dealerId);
        if(dealer.isEmpty()) return null;
        dealerDto.setUserId(userId);
        dealerDto.setDealerId(dealerId);
        dealerDto.setFirstName(user.getFirstName());
        dealerDto.setLastName(user.getLastName());
        dealerDto.setEmail(user.getEmail());
        dealerDto.setPhone(user.getPhone());
        dealerDto.setName(dealer.get().getName());
        dealerDto.setCity(dealer.get().getCity());
        dealerDto.setStreet(dealer.get().getStreet());
        dealerDto.setStreetNumber(dealer.get().getStreetNumber());
        return dealerDto;
    }

    @Override
    public int updateDealerByUserId(DealerDto dealerDto) {
        int dealerId = this.getDealerIdByUserId(dealerDto.getUserId());
        Optional<DealerEntity> dealer = dealerDao.findById(dealerId);
        if(dealer.isEmpty()) return Const.dealerDoesNotExit;

        UsersDto usersDto = new UsersDto();
        usersDto.setUserId(dealerDto.getUserId());
        usersDto.setEmail(dealerDto.getEmail());
        usersDto.setPhone(dealerDto.getPhone());
        usersDto.setFirstName(dealerDto.getFirstName());
        usersDto.setLastName(dealerDto.getLastName());
        int result = usersService.updateUserDetails(usersDto);
        if (result == Const.emailAlreadyUsed)
            return Const.emailAlreadyUsed;
        if(!dealerDto.getName().equals(dealer.get().getName()))
            dealer.get().setName(dealerDto.getName());
        if(!dealerDto.getCity().equals(dealerDto.getCity()))
            dealer.get().setCity(dealerDto.getCity());
        if(!dealerDto.getStreet().equals(dealerDto.getStreet()))
            dealer.get().setCity(dealerDto.getCity());
        if(dealerDto.getStreetNumber()!= dealer.get().getStreetNumber())
            dealer.get().setStreetNumber(dealerDto.getStreetNumber());
        dealerDao.save(dealer.get());

        return Const.dealerDetailsUpdateSuccess;
    }

}
