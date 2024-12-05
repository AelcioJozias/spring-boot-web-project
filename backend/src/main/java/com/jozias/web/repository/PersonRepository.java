package com.jozias.web.repository;

import com.jozias.web.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Object> findByCpf(String cpf);
    Optional<Person> findByCpfAndIdIsNot(String cpf, Long id);

    @Query("SELECT p FROM Person p ORDER BY p.id desc")
    List<Person> findAllOrderById();
}
