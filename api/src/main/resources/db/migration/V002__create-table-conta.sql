CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    account VARCHAR(7) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);