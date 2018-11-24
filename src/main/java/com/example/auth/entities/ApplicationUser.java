package com.example.auth.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long id;
    @Column(unique = true)
    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    public ApplicationUser() {
    }

    public ApplicationUser(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationUser)) return false;
        ApplicationUser user = (ApplicationUser) o;
        return getId() == user.getId() &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getRoles());
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
