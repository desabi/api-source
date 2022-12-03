package com.desabi.api.source.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class Information {

    @Positive(message = "La estatura debe ser un numero positivo")
    private Double height;

    @Valid
    @NotNull(message = "El nombre de los padres es requerido")
    private Parents parents;
}
