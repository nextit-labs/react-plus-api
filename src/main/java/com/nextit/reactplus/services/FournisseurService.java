package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.FournisseurDto;
import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    void delete(Integer id);

}