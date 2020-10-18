package org.kozak.carfinder.Services.Exceptions;

public class EmailAlreadyUsedException extends Exception {
    public EmailAlreadyUsedException(String message){
        super(message);
    }
}
