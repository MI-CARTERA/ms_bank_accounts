package com.MiCartera.msbankaccounts.bankAccount.api.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountCreateRequest {
  private Long userId;
  private String bankName;
  private String accountName;
  private String accountNumber;
  private String currency;
  private BigDecimal balance;
  private Boolean active;
}