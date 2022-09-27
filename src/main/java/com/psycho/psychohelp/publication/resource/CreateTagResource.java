package com.psycho.psychohelp.publication.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateTagResource {
    @NotNull
    @NotBlank
    private String tag;

}
