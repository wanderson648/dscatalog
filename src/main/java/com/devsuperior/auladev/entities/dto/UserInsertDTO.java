package com.devsuperior.auladev.entities.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UserInsertDTO extends UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Campo obrigatório")
    private String password;

    public UserInsertDTO() {
        super();
    }

}
