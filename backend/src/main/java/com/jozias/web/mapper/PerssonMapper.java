package com.jozias.web.mapper;

import com.jozias.web.dto.input.PersonRequest;
import com.jozias.web.dto.output.AddressResponse;
import com.jozias.web.dto.output.PersonResponse;
import com.jozias.web.dto.output.ResumedPersonResponse;
import com.jozias.web.entity.Address;
import com.jozias.web.entity.Person;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class PerssonMapper {

    public static Person toEntity(final PersonRequest personRequest) {
        Person person = new Person();
        BeanUtils.copyProperties(personRequest, person);
        Address address = new Address();
        BeanUtils.copyProperties(personRequest.endereco(), address);
        person.setAddress(address);
        return person;
    }

    public static ResumedPersonResponse toPessoaResumo(final Person person) {
        return new ResumedPersonResponse(
                person.getId(),
                person.getNome(),
                person.getCpf(),
                person.getAddress().getCidade(),
                person.getAddress().getEstado()
        );
    }

    public static PersonResponse toPessoaResponse(final Person person) {
        return new PersonResponse(
                person.getNome(),
                person.getCpf(),
                person.getNascimento(),
                new AddressResponse(
                        person.getAddress().getCep() != null ? person.getAddress().getCep() : null,
                        person.getAddress().getRua() != null ? person.getAddress().getRua() : null,
                        person.getAddress().getNumero() != null ? person.getAddress().getNumero() : null,
                        person.getAddress().getCidade() != null ? person.getAddress().getCidade() : null,
                        person.getAddress().getEstado() != null ? person.getAddress().getEstado() : null
                )
        );
    }

}
