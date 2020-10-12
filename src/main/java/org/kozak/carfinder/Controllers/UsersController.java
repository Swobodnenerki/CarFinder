package org.kozak.carfinder.Controllers;

import org.kozak.carfinder.Models.AdvertDto;
import org.kozak.carfinder.Models.AdvertEntity;
import org.kozak.carfinder.Models.UsersDto;
import org.kozak.carfinder.Models.UsersEntity;
import org.kozak.carfinder.Models.RolesEntity;
import org.kozak.carfinder.Services.Implementation.UsersService;
import org.kozak.carfinder.Models.UserDetailsImplementation;
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
        UsersDto user = usersService.getUserById(userDetailsImplementation.getUserAccountsEntity().getId());
        if(user == null) throw new UserNotFoundException("There is no such user");
        return user;
    }

    @PostMapping("/user/register")
    @ResponseStatus(HttpStatus.OK)
    public void registerNewUser(@RequestBody UsersDto usersDto) throws EmailAlreadyUsedException, LoginAlreadyUsedException{
        int result = usersService.registerNewUser(usersDto);
        if(result == Const.emailAlreadyUsed) throw new EmailAlreadyUsedException("E-mail is already used!");
        if(result == Const.loginAlreadyUsed) throw new LoginAlreadyUsedException("Login is already used!");
    }

}
