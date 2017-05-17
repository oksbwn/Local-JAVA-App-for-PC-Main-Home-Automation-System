package com.oksbwn.osmc;

/**
 * Created by OKSBWN on 12/29/2014.
 */
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class authoRize extends Authenticator {
    private String username, password;

    public authoRize() {
        username = "om";
        password = "om";
    }
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }
}
