package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.EntrepriseDto;
import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete(Integer id);

}