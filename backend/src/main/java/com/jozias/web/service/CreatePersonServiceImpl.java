package com.jozias.web.service;

import com.jozias.web.dto.input.PersonRequest;
import com.jozias.web.entity.Person;
import com.jozias.web.mapper.PerssonMapper;
import com.jozias.web.repository.AddressRepository;
import com.jozias.web.repository.PersonRepository;
import exception.CpfInUseExceptionException;
import exception.InvalidBirthOfDateException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreatePersonServiceImpl implements CriarPessoaService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public CreatePersonServiceImpl(final PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    @Override
    public Person criar(PersonRequest personRequest) {
        Person person = PerssonMapper.toEntity(personRequest);
        validarUnicidadePeloCpf(person);
        validarDataDeNascimento(person);
        person.getAddress().setPerson(person);
        Person personSalva = personRepository.save(person);
//        if (true) throw new RuntimeException("Teste");
        return personSalva;
    }

    private void validarUnicidadePeloCpf(final Person person) {
        personRepository.findByCpf((person.getCpf()))
                .ifPresent(pessoaEncontrada -> {
                    throw new CpfInUseExceptionException(String.format("CPF %s já está em uso por outra pessoa", person.getCpf()));
                });
    }

    private static void validarDataDeNascimento(Person person) {
        if (person.getNascimento().after(new Date())) {
            throw new InvalidBirthOfDateException("Data de nascimento não pode ser maior que o dia atual");
        }
    }
}
