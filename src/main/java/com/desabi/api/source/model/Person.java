package com.desabi.api.source.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class Person {

    @NotNull(message = "El nombre de la persona es requerido")
    @NotBlank(message = "El nombre de la persona es requerido")
    protected String name;

    @Positive(message = "La edad debe ser un numero positivo")
    protected Integer age;

    @Valid
    @NotNull(message = "La información es requerida")
    protected Information information;
}
