package com.jozias.web.service;

import com.jozias.web.dto.input.PersonRequest;
import com.jozias.web.entity.Person;
import com.jozias.web.repository.PersonRepository;
import exception.CpfInUseExceptionException;
import exception.InvalidBirthOfDateException;
import exception.PersonNoutFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UpdatePersonServiceImpl implements UpdatePersonService {

    private final PersonRepository personRepository;

    public UpdatePersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    @Override
    public Person atualizar(final PersonRequest personRequest, final Long pessoaId) {
        Person person = procurarPessoaOuLancarErroSeNaoExistir(pessoaId);
        atualizarPropriedades(personRequest, person);
        validarUnicidadePeloCpfEIdDirefenteDaPessoaAtual(person);
        validarDataDeNascimento(person);
        return personRepository.save(person);
    }

    private static void atualizarPropriedades(PersonRequest personRequest, Person person) {
        BeanUtils.copyProperties(personRequest, person, "id");
        BeanUtils.copyProperties(personRequest.endereco(), personRequest.endereco(), "id");
    }

    private Person procurarPessoaOuLancarErroSeNaoExistir(Long pessoaId) {
        Person person = personRepository.findById(pessoaId).orElseThrow(() ->
                new PersonNoutFoundException("Pessoa não encontrada")
        );
        return person;
    }

    private void validarUnicidadePeloCpfEIdDirefenteDaPessoaAtual(final Person person) {
        personRepository.findByCpfAndIdIsNot(person.getCpf(), person.getId()).ifPresent(pessoaEncontrada -> {
            throw new CpfInUseExceptionException(String.format("o CPF %s já está em uso por outra pessoa", pessoaEncontrada.getCpf()));
        });

    }

    private static void validarDataDeNascimento(Person person) {
        if (person.getNascimento().after(new Date())) {
            throw new InvalidBirthOfDateException("Data de nascimento não pode ser maior que o dia atual");
        }
    }
}
