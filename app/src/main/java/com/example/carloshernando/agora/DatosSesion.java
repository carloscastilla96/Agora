package com.example.carloshernando.agora;

import red.User;

/**
 * Created by andre on 11/14/2016.
 */

public class DatosSesion {
    static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        DatosSesion.user = user;
    }
}
