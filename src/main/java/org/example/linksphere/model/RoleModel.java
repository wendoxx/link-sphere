package org.example.linksphere.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Entity
@Data
@Table(name = "tb_role")
public class RoleModel {

    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roleId")
    private Set<UserModel> userId;

    public enum Values {

        ADMIN(1L),
        BASIC(2L);

        @Getter
        long roleId;

        Values(long roleId) {
            this.roleId = roleId;
        }
    }
}
