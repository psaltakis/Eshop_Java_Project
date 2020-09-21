
package entities;
import java.util.Date;


public abstract class User {
    private String name;
    private String username;
    private String telephone;
    private String email;
    private String password;
    private Date dateRegistered;

    public User(String name, String username, String telephone, String email, String password, Date dateRegistered) {
        this.name = name;
        this.username = username;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.dateRegistered = dateRegistered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
    public abstract String getUserInfo();
}
