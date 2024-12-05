package com.jozias.web.service;

import com.jozias.web.entity.Person;
import com.jozias.web.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPersonServiceImpl implements SearchPersonService {

    private final PersonRepository personRepository;

    public SearchPersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> pesquisarTodasAsPessoas() {
        return personRepository.findAllOrderById();
    }
}
