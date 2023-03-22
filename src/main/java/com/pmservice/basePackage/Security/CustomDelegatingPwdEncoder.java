package com.pmservice.basePackage.Security;

public interface CustomDelegatingPwdEncoder {

    void encodePassword(String username, String password) throws Exception;

    Boolean checkPassword(String username, String password) throws Exception;
    
}
