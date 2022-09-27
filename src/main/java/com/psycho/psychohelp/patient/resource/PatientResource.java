package com.psycho.psychohelp.patient.resource;

import com.psycho.psychohelp.patient.domain.model.entity.State;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class PatientResource {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Date date;
    private String gender;
    private String img;
    private State state;
}
