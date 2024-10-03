package org.example.linksphere.dto.request;

import lombok.Data;

@Data
public class UserRequestDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
}
