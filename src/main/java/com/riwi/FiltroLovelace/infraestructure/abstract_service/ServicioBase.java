package com.riwi.FiltroLovelace.infraestructure.abstract_service;
import org.springframework.data.domain.Page;

public interface ServicioBase <RequestDTO, ResponseDTO, ID>{

    ResponseDTO create(RequestDTO request);

    ResponseDTO get(ID id);

    Page<ResponseDTO> getAll(int page, int size);

    ResponseDTO update(ID id, RequestDTO request);

    void delete(ID id);

}