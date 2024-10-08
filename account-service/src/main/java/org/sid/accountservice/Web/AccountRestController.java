package org.sid.accountservice.Web;

import lombok.RequiredArgsConstructor;
import org.sid.accountservice.client.CustomerRestClient;
import org.sid.accountservice.entiities.BankAccount;
import org.sid.accountservice.model.Customer;
import org.sid.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class AccountRestController {
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient restClient;

    @GetMapping("/accounts")
    public List<BankAccount> findAll() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
         accounts.forEach(
                 account->{
             account.setCustomer(restClient.findCustomerById(account.getCustomerId()));
         });
         return accounts;
    }
    @GetMapping("/accounts/{accountId}")
    public BankAccount findById(@PathVariable String accountId) {
        BankAccount bankAccount= bankAccountRepository.findById(accountId).get();
        Customer customer= restClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomerId(customer.getId());
        return bankAccount;
    }
}
