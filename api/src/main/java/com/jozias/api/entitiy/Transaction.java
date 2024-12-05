package com.jozias.api.entitiy;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;
    @Enumerated(STRING)
    private TransactionType transactionType;
    @Getter(AccessLevel.NONE)
    private BigDecimal value;
    @CreationTimestamp
    private LocalDateTime transactionDate;

    public BigDecimal getTransactionValue() {
        return this.getTransactionType() == TransactionType.DEPOSIT ? this.value : this.value.negate();
    }
}
