package com.jozias.web.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @Column(name = "pessoa_id")
    private Long id;
    private String cep;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    @OneToOne
    @MapsId
    @JoinColumn(name = "pessoa_id")
    private Person person;
}
