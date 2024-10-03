package org.example.linksphere.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;

@Entity
@Data
@Table(name = "tb_role")
@EqualsAndHashCode(of = "id")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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