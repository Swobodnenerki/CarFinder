package org.kozak.carfinder.Services.Exceptions;

public class LoginAlreadyUsedException extends Exception {
    public LoginAlreadyUsedException(String message){
        super(message);
    }
}

