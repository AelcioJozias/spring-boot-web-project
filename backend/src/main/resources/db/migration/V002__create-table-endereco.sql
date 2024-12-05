CREATE TABLE address
(
    pessoa_id integer PRIMARY KEY,
    cep VARCHAR(11),
    rua VARCHAR(100),
    numero INTEGER,
    cidade VARCHAR(20) NOT NULL ,
    estado VARCHAR(20) NOT NULL,
    CONSTRAINT fk_endereco_pessoa foreign key (pessoa_id) references person(id)
);