package com.jozias.web.service;

import com.jozias.web.entity.Person;
import com.jozias.web.repository.PersonRepository;
import exception.PersonNoutFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonServiceImpl implements DeletePersonService {

    private final PersonRepository personRepository;

    public DeletePersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNoutFoundException(String.format("Person id %d not found", id)));
        personRepository.delete(person);
    }
}
