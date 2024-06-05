package com.riwi.FiltroLovelace.infraestructure.helpers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;



@Component
public class ServiceHelper {
    
    public <Entity, ResponseDTO> List<ResponseDTO> transformList(
            List<Entity> entities,
            Function<Entity, ResponseDTO> entityToResponse) {
        return entities.stream()
                .map(entityToResponse)
                .collect(Collectors.toList());
    }

    public <Entity, ID> Entity find(ID id, JpaRepository<Entity, ID> repository, String name){
        return repository.findById(id)
        .orElseThrow() (() -> new BadIdException(name));
    }
}
