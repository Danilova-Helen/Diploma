package ru.isu.diploma.model;

import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import java.io.Serializable;
import java.util.Set;

@Embeddable
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    private String role;

    public Role(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

}