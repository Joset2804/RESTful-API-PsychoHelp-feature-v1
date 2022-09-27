package com.psycho.psychohelp.observations.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("observationMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ObservationMapper observationMapper(){
        return new ObservationMapper();
    }
}
