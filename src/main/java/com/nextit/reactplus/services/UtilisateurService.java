package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.ChangerMotDePasseUtilisateurDto;
import com.nextit.reactplus.dto.UtilisateurDto;
import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);

    UtilisateurDto findByEmail(String email);

    UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}