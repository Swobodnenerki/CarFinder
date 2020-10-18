package org.kozak.carfinder;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kozak.carfinder.Models.*;
import org.kozak.carfinder.Repositories.API.IDealerDao;
import org.kozak.carfinder.Repositories.API.IRolesDao;
import org.kozak.carfinder.Services.Implementation.DealerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.AdvertDto;
import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.UsersDto;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Repositories.API.IAccountDao;
import org.kozak.carfinder.Services.Const;
import org.kozak.carfinder.Services.Implementation.UsersService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {

    @Mock
    private IUsersDao usersDao;
    @Mock
    private IAccountDao accountDao;
    @Mock
    private IRolesDao rolesDao;
    @Mock
    private IDealerDao dealerDao;
    @InjectMocks
    private UsersService usersService;
    @InjectMocks
    private DealerService dealerService;

    DealerEntity dealer;
    UsersEntity user;
    AccountEntity account;
    RolesEntity role;
    UsersDto usersDto;
    DealerDto dealerDto;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);

        account = new AccountEntity();
        account.setLogin("logindamian");
        account.setPassword("Bumerang@41");
        user = new UsersEntity();
        user.setFirstName("Damian");
        user.setLastName("Damian");
        user.setEmail("widly@lublopata.ro");
        user.setAccountByAccountid(account);
        role = new RolesEntity();
        role.setAccountByAccountid(account);
        dealer = new DealerEntity();
        dealer.setName("MB Motors");
        dealer.setCity("Warsaw");
        dealer.setStreet("Pulawska");
        dealer.setStreetNumber(34);
        dealer.setUsersByUserid(user);





        usersDto = new UsersDto();
        usersDto.setEmail("widly@lublopata.ro");
        usersDto.setLogin("logindamian");
        usersDto.setPassword("Bumranng@41");
        usersDto.setFirstName("Damian");
        usersDto.setLastName("Damian");
        usersDto.setPhone("123123123");
        usersDto.setAccountId(1);
        usersDto.setUserId(1);
        dealerDto = new DealerDto();
        dealerDto.setName("MB Motors");
        dealerDto.setCity("Warsaw");
        dealerDto.setStreet("Pulawska");
        dealerDto.setStreetNumber(34);
        dealerDto.setDealerId(1);


    }
    @Test
    public void testRegisterNewUser()
    {
        when(accountDao.findAccountEntitiesByLogin(any(String.class))).thenReturn(null);
        when(usersDao.findUsersEntitiesByEmail(any())).thenReturn(null);
        when(usersDao.save(any())).thenReturn(user);
        when(accountDao.save(any(AccountEntity.class))).thenReturn(account);

        int result = usersService.registerNewUser(usersDto);

        assertEquals(result, Const.registrationSuccess);
    }
    @Test
    public void testRegisterNewDealer(){
        when(accountDao.findAccountEntitiesByLogin(any(String.class))).thenReturn(null);
        when(usersDao.findUsersEntitiesByEmail(any())).thenReturn(null);
        when(usersDao.save(any())).thenReturn(user);
        when(accountDao.save(any(AccountEntity.class))).thenReturn(account);
        int result = dealerService.registerNewDealer(dealerDto);
        assertEquals(result, Const.registrationSuccess);
    }



}
