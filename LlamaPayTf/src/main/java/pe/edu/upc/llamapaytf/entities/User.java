package pe.edu.upc.llamapaytf.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nameUser", nullable = false, length = 30)
    private String nameUser;
    @Column(name = "lastnameUser", nullable = false, length = 30)
    private String lastnameUser;
    @Column(name = "emailUser", nullable = false, length = 50)
    private String emailUser;
    @Column(name = "birthdayUser", nullable = false)
    private Date birthdayUser;
    @Column(name = "registrationDateUser", nullable = false)
    private Timestamp registrationDateUser;

    @Column(length = 30, unique = true)
    private String username;
    @Column(length = 200)
    private String password;
    private Boolean enabled;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Rol> roles;


    public User() {
    }

    public User(int idUser, String nameUser, String lastnameUser, String emailUser, Date birthdayUser, Timestamp registrationDateUser, String username, String password, Boolean enabled, List<Rol> roles) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.lastnameUser = lastnameUser;
        this.emailUser = emailUser;
        this.birthdayUser = birthdayUser;
        this.registrationDateUser = registrationDateUser;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Date getBirthdayUser() {
        return birthdayUser;
    }

    public void setBirthdayUser(Date birthdayUser) {
        this.birthdayUser = birthdayUser;
    }

    public Timestamp getRegistrationDateUser() {
        return registrationDateUser;
    }

    public void setRegistrationDateUser(Timestamp registrationDateUser) {
        this.registrationDateUser = registrationDateUser;
    }

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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}


