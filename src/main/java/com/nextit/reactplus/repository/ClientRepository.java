package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}