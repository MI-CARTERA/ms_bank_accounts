package com.MiCartera.msbankaccounts.bankAccount.api;

import com.MiCartera.msbankaccounts.bankAccount.application.BankAccountService;
import com.MiCartera.msbankaccounts.bankAccount.api.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/bank-accounts")
@RequiredArgsConstructor
public class BankAccountController {

  private final BankAccountService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BankAccountResponse create(@RequestBody @Valid BankAccountCreateRequest req) {
    return service.create(req);
  }

  @GetMapping
  public List<BankAccountResponse> list() {
    return service.list();
  }

  @GetMapping("/{id}")
  public BankAccountResponse get(@PathVariable Long id) {
    return service.get(id);
  }

  @PutMapping("/{id}")
  public BankAccountResponse update(@PathVariable Long id, @RequestBody @Valid BankAccountUpdateRequest req) {
    return service.update(id, req);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}