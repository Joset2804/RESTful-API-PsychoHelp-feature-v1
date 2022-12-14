package com.psycho.psychohelp.psychologist.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateScheduleResource {

    @NotNull
    @NotBlank
    private String time;
}
