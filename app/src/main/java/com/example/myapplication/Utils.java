package com.example.myapplication;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Utils {
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";

    public static String generateRandomHexToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); // Hexadecimal encoding
    }

    public static boolean sendMailToUser(String mail, String code){
        System.out.println("enter in sendMailToUser");
        JavaMailAPI javaMailAPI = new JavaMailAPI(
                mail,
                "My body",
                "Your code is " + code
        );
        try {
            javaMailAPI.execute();
            System.out.println("====> sent");
            return true;
        }
        catch (Exception e){
            System.out.println("sendMailToUser ===========> " + e);
            return false;
        }
    }
}
