package com.psycho.psychohelp.observations.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import com.psycho.psychohelp.psychologist.resource.PsychologistResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ObservationResource {
    private Long id;
    private String description;
    private PsychologistResource psychologist;
}
