package org.kozak.carfinder.Services.Implementation;

import org.kozak.carfinder.Models.AccountEntity;
import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.RolesEntity;
import org.kozak.carfinder.Models.UserDetailsImplementation;
import org.kozak.carfinder.Repositories.API.IRolesDao;
import org.kozak.carfinder.Repositories.API.IAccountDao;
import org.kozak.carfinder.Repositories.API.IUsersDao;
import org.kozak.carfinder.Repositories.API.IDealerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsServiceImplementation implements UserDetailsService {

    IUsersDao userDao;

    @Autowired
    IAccountDao accountDao;

    @Autowired
    IDealerDao dealerDao;

    @Autowired
    IRolesDao rolesDao;

    @Autowired
    public UsersDetailsServiceImplementation(IUsersDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        AccountEntity account = accountDao.findAccountEntitiesByLogin(userLogin);
        UsersEntity user = userDao.findUsersEntitiesByAccountByAccountid(account);
        RolesEntity role = rolesDao.findRolesEntitiesByAccountByAccountid(account);
        if (account == null) {
            throw new UsernameNotFoundException("There is no user with login: " + userLogin);
        }
//        if(dealerDao.findDealerEntitiesByUsersByUserid(user)==null) {
//            return new UserDetailsImplementation(account, "ROLE_DEALER");
//        }
        if(role.getRole()=="dealer"){
            return new UserDetailsImplementation(account, "DEALER");
        }
        else {
            return new UserDetailsImplementation(account, "USER");
        }
    }
}
