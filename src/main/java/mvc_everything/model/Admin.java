package mvc_everything.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "a_name", length = 64, nullable = false)
    private String username;

    @Column(name = "pass", length = 64, nullable = false)
    private String password;

    @Column(name = "f_name", length = 64, nullable = false)
    private String firstname;

    @Column(name = "l_name", length = 64, nullable = false)
    private String lastname;


    private Date signedInDate;

    private boolean active;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /*
    public Date getSignedInDate() {
        return signedInDate;
    }

    public void setSignedInDate(Date signedInDate) {
        this.signedInDate = signedInDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    */

}
