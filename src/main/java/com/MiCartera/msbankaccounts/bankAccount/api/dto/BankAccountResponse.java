package com.MiCartera.msbankaccounts.bankAccount.api.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponse {
  private Long id;
  private Long userId;
  private String bankName;
  private String accountName;
  private String accountNumber;
  private String currency;
  private BigDecimal balance;
  private Boolean active;
}