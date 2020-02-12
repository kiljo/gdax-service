package com.kijo.gdaxservice.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.kijo.gdaxservice.api.accounts.Account;
import com.kijo.gdaxservice.api.accounts.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AccountSchedule {

  private static final Logger log = LoggerFactory.getLogger(AccountSchedule.class);

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  AccountService accountService;

  @Autowired
  public AccountSchedule(AccountService accountService) {
    this.accountService = accountService;

    log.info("Get accounts at {}", dateFormat.format(new Date()));

    List<Account> accounts = this.accountService.getAccounts();

    log.info("Accounts {}", accounts);

  }

  @Scheduled(fixedDelay = 20000)
  public void getAccounts() {
    log.info("Get accounts at {}", dateFormat.format(new Date()));

    List<Account> accounts = this.accountService.getAccounts();

    accounts.stream().forEach(a -> log.info("Account {}", a));

  }
}