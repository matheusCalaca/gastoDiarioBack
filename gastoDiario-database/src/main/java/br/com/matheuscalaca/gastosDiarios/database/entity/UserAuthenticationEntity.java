package br.com.matheuscalaca.gastosDiarios.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "user_autentication")
public class UserAuthenticationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @NotNull
    @Column(length = 1000)
    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_AUTHENTICATION_PERMISSION",
            joinColumns = @JoinColumn(name = "user_authentication_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<PermisionEntity> permission;

    public UserAuthenticationEntity() {
    }

    public UserAuthenticationEntity(UserEntity user, String password) {
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PermisionEntity> getPermission() {
        return permission;
    }

    public void setPermission(List<PermisionEntity> permission) {
        this.permission = permission;
    }
}
