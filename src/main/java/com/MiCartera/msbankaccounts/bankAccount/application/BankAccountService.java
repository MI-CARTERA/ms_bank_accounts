package com.MiCartera.msbankaccounts.bankAccount.application;

import com.MiCartera.msbankaccounts.bankAccount.domain.BankAccount;
import com.MiCartera.msbankaccounts.bankAccount.infrastructure.BankAccountRepository;
import com.MiCartera.msbankaccounts.bankAccount.api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BankAccountService {

  private final BankAccountRepository repository;

  public BankAccountResponse create(BankAccountCreateRequest req) {
    BankAccount entity = BankAccount.builder()
      .userId(req.getUserId())
      .bankName(req.getBankName())
      .accountName(req.getAccountName())
      .accountNumber(req.getAccountNumber())
      .currency(req.getCurrency())
      .balance(req.getBalance())
      .active(req.getActive())
      .build();

    BankAccount saved = repository.save(entity);
    return toResponse(saved);
  }

  @Transactional(readOnly = true)
  public List<BankAccountResponse> list() {
    return repository.findAll().stream().map(this::toResponse).toList();
  }

  @Transactional(readOnly = true)
  public BankAccountResponse get(Long id) {
    BankAccount e = repository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BankAccount no encontrado: " + id));
    return toResponse(e);
  }

  public BankAccountResponse update(Long id, BankAccountUpdateRequest req) {
    BankAccount e = repository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BankAccount no encontrado: " + id));

    e.setUserId(req.getUserId());
    e.setBankName(req.getBankName());
    e.setAccountName(req.getAccountName());
    e.setAccountNumber(req.getAccountNumber());
    e.setCurrency(req.getCurrency());
    e.setBalance(req.getBalance());
    e.setActive(req.getActive());

    BankAccount saved = repository.save(e);
    return toResponse(saved);
  }

  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BankAccount no encontrado: " + id);
    }
    repository.deleteById(id);
  }

  private BankAccountResponse toResponse(BankAccount e) {
    return BankAccountResponse.builder()
      .id(e.getId())
      .userId(e.getUserId())
      .bankName(e.getBankName())
      .accountName(e.getAccountName())
      .accountNumber(e.getAccountNumber())
      .currency(e.getCurrency())
      .balance(e.getBalance())
      .active(e.getActive())
      .build();
  }
}