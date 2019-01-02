package com.example.auth.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private User user;
    private Timestamp creationTime;
    private String token;

    public Token(User user, String  token) {
        this.user = user;
        this.creationTime = new Timestamp(System.currentTimeMillis());
        this.token = token;
    }

    public Token() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;
        Token token1 = (Token) o;
        return getId() == token1.getId() &&
                Objects.equals(getUser(), token1.getUser()) &&
                Objects.equals(getCreationTime(), token1.getCreationTime()) &&
                Objects.equals(getToken(), token1.getToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getCreationTime(), getToken());
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", user=" + user +
                ", creationTime=" + creationTime +
                ", token='" + token + '\'' +
                '}';
    }
}
