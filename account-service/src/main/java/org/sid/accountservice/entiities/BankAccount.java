package org.sid.accountservice.entiities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.accountservice.enums.AccountType;
import org.sid.accountservice.model.Customer;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BankAccount {
    @Id
    private  String accountId;
    private Date createdAt;
    private Double balance;
    private  String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
