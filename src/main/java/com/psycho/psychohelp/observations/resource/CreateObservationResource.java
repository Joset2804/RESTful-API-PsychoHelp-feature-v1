package com.psycho.psychohelp.observations.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateObservationResource {
    @NotNull
    @NotBlank
    private String description;
}
