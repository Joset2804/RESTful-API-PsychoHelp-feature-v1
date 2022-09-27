package com.psycho.psychohelp.observations.domain.service;

import com.psycho.psychohelp.observations.domain.model.entity.Observation;

import java.util.List;

public interface ObservationService {
    List<Observation> getAll();
    Observation create(Observation observation, Long psychologistId);
}
