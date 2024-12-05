

CREATE TABLE transaction (
    id SERIAL PRIMARY KEY,
    account_id INTEGER NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    transaction_type VARCHAR(10) NOT NULL,
    value DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_conta FOREIGN KEY (account_id) REFERENCES Account(id)
);