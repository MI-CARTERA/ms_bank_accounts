package com.MiCartera.msbankaccounts.bankAccount.domain;

import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bankAccounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;
  private String bankName;
  private String accountName;
  private String accountNumber;
  private String currency;
  private BigDecimal balance;
  private Boolean active;
}