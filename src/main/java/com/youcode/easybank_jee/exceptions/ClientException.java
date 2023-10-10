package com.youcode.easybank_jee.exceptions;

public class ClientException extends Exception{
    public ClientException() {}

    public ClientException(String str) {
        super(str);
    }
}
