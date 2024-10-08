package org.sid.accountservice;

import org.sid.accountservice.client.CustomerRestClient;
import org.sid.accountservice.config.GlobalConfig;
import org.sid.accountservice.entiities.BankAccount;
import org.sid.accountservice.enums.AccountType;
import org.sid.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(GlobalConfig.class)
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        return args -> {

            customerRestClient.allCustomers().forEach(c -> {
                BankAccount bankAccount1 = BankAccount.builder().accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random() * 80000)
                        .createdAt(new Date())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random() * 65432)
                        .createdAt(new Date())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount2);


            });



    };}}