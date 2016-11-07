package red;

import java.io.File;
import java.io.Serializable;


/**
 * Se encrga de contener la informaci�n relevante de cada usuario.
 *
 * @author Andres
 */
public class NewUser implements Serializable {
    int userId;
    String name;
    String lastName;
    String userName;

    String password;
    String email;


    private static final long serialVersionUID = 12L;

    public NewUser(String name, String lastName, String userName,String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password= password;
        this.email= email;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

}
