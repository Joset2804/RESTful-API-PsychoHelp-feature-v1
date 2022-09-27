package com.psycho.psychohelp.observations.service;

import com.psycho.psychohelp.observations.domain.model.entity.Observation;
import com.psycho.psychohelp.observations.domain.persistence.ObservationRepository;
import com.psycho.psychohelp.observations.domain.service.ObservationService;
import com.psycho.psychohelp.psychologist.domain.model.entity.Psychologist;
import com.psycho.psychohelp.psychologist.domain.persistence.PsychologistRepository;
import com.psycho.psychohelp.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationServiceImpl implements ObservationService {

    private final static String ENTITY = "Observation";

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private PsychologistRepository psychologistRepository;

    @Override
    public List<Observation> getAll() {
        return observationRepository.findAll();
    }

    @Override
    public Observation create(Observation observation, Long psychologistId) {
        Psychologist psychologist = psychologistRepository.findById(psychologistId)
                .orElseThrow(() -> new ResourceNotFoundException("Psychologist not found with Id " + psychologistId));
        psychologist.setPenaltiesCount(psychologist.getPenaltiesCount() + 1);
        observation.setPsychologist(psychologist);
        return observationRepository.save(observation);
    }
}

