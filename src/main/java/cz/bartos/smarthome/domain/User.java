package cz.bartos.smarthome.domain;

import java.io.Serializable;
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
    private long id;
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    private String email;
    private String surname;
    private String password;
    private Role role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}
