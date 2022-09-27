package com.psycho.psychohelp.observations.domain.persistence;

import com.psycho.psychohelp.observations.domain.model.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {
}

