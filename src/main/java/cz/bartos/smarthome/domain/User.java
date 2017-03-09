package cz.bartos.smarthome.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Míra
 */
@NamedQueries(
        {
            @NamedQuery(name = "findUserByLoginQuery", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
        }
)
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    private String email;
    private String surname;
    private String password;
    private String token;
    private Timestamp lastReading;
    @ManyToMany
    @JoinTable(name = "jt_user_role",
            joinColumns = @JoinColumn(name =  "user_fk"),
            inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Role> getRole() {
        return roles;
    }

    public void setRole(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLastReading() {
        return lastReading;
    }

    public void setLastReading(Timestamp lastReading) {
        this.lastReading = lastReading;
    }
    
    
}
