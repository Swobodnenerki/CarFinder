package org.kozak.carfinder.Controllers;

import org.kozak.carfinder.Models.*;
import org.kozak.carfinder.Services.Implementation.DealerService;
import org.kozak.carfinder.Services.Implementation.UsersService;
import org.kozak.carfinder.Services.Const;
import org.kozak.carfinder.Services.Exceptions.EmailAlreadyUsedException;
import org.kozak.carfinder.Services.Exceptions.LoginAlreadyUsedException;
import org.kozak.carfinder.Services.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    DealerService dealerService;

    @GetMapping("/user/{id}")
    public UsersDto getUserById(@PathVariable int id) throws UserNotFoundException{
        UsersDto user = usersService.getUserById(id);
        if(user == null) throw new UserNotFoundException("There is no such user");
        return  user;
    }

    @GetMapping("/session")
    public UsersDto getCurrentUser(Authentication authentication) throws UserNotFoundException{
        UserDetailsImplementation userDetailsImplementation =
                (UserDetailsImplementation) authentication.getPrincipal();
        UsersDto user = usersService.getUserDtoByAccountId(userDetailsImplementation.getUserAccountsEntity().getId());
        if(user == null) throw new UserNotFoundException("There is no such user");
        return user;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void registerNewUser(@RequestBody UsersDto usersDto) throws EmailAlreadyUsedException, LoginAlreadyUsedException{
        int result = usersService.registerNewUser(usersDto);
        if(result == Const.emailAlreadyUsed) throw new EmailAlreadyUsedException("E-mail is already used!");
        if(result == Const.loginAlreadyUsed) throw new LoginAlreadyUsedException("Login is already used!");
    }

    @PostMapping("/registerDealer")
    @ResponseStatus(HttpStatus.OK)
    public void registerNewDealer(@RequestBody DealerDto dealerDto) throws EmailAlreadyUsedException, LoginAlreadyUsedException{
        int result = dealerService.registerNewDealer(dealerDto);
        if(result == Const.emailAlreadyUsed) throw new EmailAlreadyUsedException("E-mail is already used!");
        if(result == Const.loginAlreadyUsed) throw new LoginAlreadyUsedException("Login is already used!");
    }

    @GetMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public String checkAuth(){
        return "Authenticate";
    }

    @GetMapping("/role/{userId}")
    public int getRoleByUserId(@PathVariable int userId){
        return dealerService.getRoleByUserId(userId);
    }

    @GetMapping("dealer/{id}")
    public DealerDto getDealerDtoById(@PathVariable int id){
        return dealerService.getDealerDtoByUserId(id);
    }

    @GetMapping("dealerIdByUserId/{userId}")
    public int getDealerIdByUserId(@PathVariable int userId){
        return dealerService.getDealerIdByUserId(userId);
    }
    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserDetails(@PathVariable int id, @RequestBody UsersDto user)
            throws EmailAlreadyUsedException
    {
        user.setUserId(id);
        int result = usersService.updateUserDetails(user);
        if(result == Const.emailAlreadyUsed)
            throw new EmailAlreadyUsedException("E-mail is already used!");
    }
    @PutMapping("/dealer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDealerDetails(@PathVariable int id, @RequestBody DealerDto dealer)
            throws EmailAlreadyUsedException
    {
        dealer.setUserId(id);
        int result = dealerService.updateDealerByUserId(dealer);
        if(result == Const.emailAlreadyUsed)
            throw new EmailAlreadyUsedException("E-mail is already used!");

    }

}
