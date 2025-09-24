package com.devsuperior.auladev.entities.dto;

import com.devsuperior.auladev.service.validation.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@UserInsertValid
public class UserInsertDTO extends UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Campo obrigatório")
    private String password;

    public UserInsertDTO() {
        super();
    }

}
