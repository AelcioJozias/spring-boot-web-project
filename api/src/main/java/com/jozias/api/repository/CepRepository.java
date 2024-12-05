package com.jozias.api.repository;

import com.jozias.api.entitiy.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CepRepository extends JpaRepository<Cep, Integer> {
    Optional<Cep> findByCep(String cep);
}
