package org.example.linksphere.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "tb_role")
public class RoleModel {

    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

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
