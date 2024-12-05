package com.jozias.api.entitiy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String account;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter(lombok.AccessLevel.NONE)
    private List<Transaction> transactions = new ArrayList<>();
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        this.transactions.remove(transaction);
    }

    public BigDecimal getCurrentTotalBalance() {
        return transactions.stream()
                .map(Transaction::getTransactionValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }
}