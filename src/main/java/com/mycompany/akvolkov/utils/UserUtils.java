package com.mycompany.akvolkov.utils;

public class UserUtils {
    public static String getAvatar(String login) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append("https://avatars.dicebear.com/v2/identicon/")
                .append(login)
                .append(".svg").toString();
    }
}
