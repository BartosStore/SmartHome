/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.smarthome.security;

import static java.lang.Long.toHexString;
import java.security.MessageDigest;
import static java.security.MessageDigest.getInstance;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Singleton;

/**
 *
 * @author Míra
 */
/* GNU licence */
@Singleton
public class PasswordProtectorImpl implements PasswordProtector {

    private static MessageDigest messageDigest = null;
    private static final int MIN_PASSWORD_LENGHT = 4;
    private static final String MIN_PASSWORD_LENGHT_WARNING = "Hashed password is too short.";

    static {
        try {
            messageDigest = getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordProtectorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String hashPassword(String plaintextPassword, String salt) throws IllegalArgumentException {
        if (plaintextPassword.length() < MIN_PASSWORD_LENGHT) {
            throw new IllegalArgumentException(MIN_PASSWORD_LENGHT_WARNING);
        }

        String hashString = plaintextPassword.substring(0, 1) + salt + plaintextPassword.substring(1);
        byte[] digestedBytes = messageDigest.digest(hashString.getBytes());

        return converBytesToString(digestedBytes);
    }

    private static String converBytesToString(byte[] bytes) {

        StringBuilder hexStringBuffer = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            if ((0xff & bytes[i]) < 0x10) {
                hexStringBuffer.append("0"
                        + toHexString((0xFF & bytes[i])));
            } else {
                hexStringBuffer.append(toHexString(0xFF & bytes[i]));
            }
        }

        return hexStringBuffer.toString();
    }
}
