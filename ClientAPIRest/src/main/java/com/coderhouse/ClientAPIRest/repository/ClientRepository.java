package com.coderhouse.ClientAPIRest.repository;

import com.coderhouse.ClientAPIRest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
