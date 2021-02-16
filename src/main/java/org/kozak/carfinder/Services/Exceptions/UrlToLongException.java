package org.kozak.carfinder.Services.Exceptions;

public class UrlToLongException extends Exception {
    public UrlToLongException(String message){
        super(message);
    }
}
