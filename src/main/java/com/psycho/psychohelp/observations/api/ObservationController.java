package com.psycho.psychohelp.observations.api;

import com.psycho.psychohelp.observations.domain.service.ObservationService;
import com.psycho.psychohelp.observations.mapping.ObservationMapper;
import com.psycho.psychohelp.observations.resource.CreateObservationResource;
import com.psycho.psychohelp.observations.resource.ObservationResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Observation")
@RestController
@RequestMapping("/api/v1/observations")
@CrossOrigin
public class ObservationController {
    @Autowired
    private ObservationService observationService;

    @Autowired
    private ObservationMapper mapper;

    @Operation(summary = "Get Observations", description = "Get All Observations")
    @GetMapping
    public List<ObservationResource> getAllObservations(){
        return mapper.toResource(observationService.getAll());
    }

    @Operation(summary = "Create new Observation", description = "Create new Observation")
    @PostMapping("psychologists/{psychologistId}")
    public ObservationResource createObservation(@PathVariable Long psychologistId, @Valid @RequestBody CreateObservationResource request){
        return mapper.toResource(observationService.create(mapper.toModel(request),psychologistId));
    }
}
