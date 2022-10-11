package ru.kata.spring.boot_security.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String name) {
        this.role = name;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        if (role.contains("ROLE_")) {
            return role.substring(5);
        }
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role role1)) {
            return false;
        }

        if (getId() != role1.getId()) {
            return false;
        }
        return getRole().equals(role1.getRole());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getRole().hashCode();
        return result;
    }
}
