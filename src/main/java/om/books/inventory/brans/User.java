package om.books.inventory.brans;


import om.books.inventory.enums.UserRole;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("BookInventory")

public class User {
    private int userId;
    private String firstName;
    private String surname;
    private String userName;
    private UserRole userRole;

    public User(){

    }

    public User(int userId, String firstName, String surname, String userName, UserRole userRole) {
        this.userId = userId;
        this.firstName = firstName;
        this.surname = surname;
        this.userName = userName;
        this.userRole = userRole;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
