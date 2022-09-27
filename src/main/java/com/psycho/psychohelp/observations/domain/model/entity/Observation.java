package com.psycho.psychohelp.observations.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@With
@Entity
@Table(name="observations")
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "psychologist_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Psychologist psychologist;

    public Observation(Long id, String description, Psychologist psychologist) {
        this.id = id;
        this.description = description;
        this.psychologist = psychologist;
    }
}
