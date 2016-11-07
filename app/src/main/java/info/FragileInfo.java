package info;

public class FragileInfo {

    String password;
    String email;
    String user;

    /**
     * se guarda la informaci�n delicada de cada usuario.
     *
     * @param email
     * @param user
     * @param password
     */
    public FragileInfo(String email, String user, String password) {
        this.email = email;
        this.user = user;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUser() {
        return user;
    }

}
