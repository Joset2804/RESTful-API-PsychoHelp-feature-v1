package com.psycho.psychohelp.observations.mapping;

import com.psycho.psychohelp.observations.domain.model.entity.Observation;
import com.psycho.psychohelp.observations.resource.CreateObservationResource;
import com.psycho.psychohelp.observations.resource.ObservationResource;
import com.psycho.psychohelp.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ObservationMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    // Object Mapping
    public ObservationResource toResource(Observation model){
        return mapper.map(model, ObservationResource.class);
    }

    public List<ObservationResource> toResource(List<Observation> model)
    {
        return mapper.mapList(model, ObservationResource.class);
    }

    public Observation toModel(CreateObservationResource resource){
        return mapper.map(resource, Observation.class);
    }


}
