package red;

import java.io.Serializable;


public class User implements Serializable {
    int userId;
    String name;
    String lastName;
    String userName;
    String password;

    private static final long serialVersionUID = 2L;

    public User(String name, String lastName, String userName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password=password;
    }

    //------------------GETS!-----------------------------------------------
    public int getUserId() {
        return userId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }
    //----------------------------SETS--------------------------------------------

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
