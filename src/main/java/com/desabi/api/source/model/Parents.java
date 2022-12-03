package com.desabi.api.source.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Parents {

    @NotNull(message = "El nombre del padre es requerido")
    @NotBlank(message = "El nombre del padre es requerido")
    private String father;

    @NotNull(message = "El nombre de la madre es requerido")
    @NotBlank(message = "El nombre de la madre es requerido")
    private String mother;
}
