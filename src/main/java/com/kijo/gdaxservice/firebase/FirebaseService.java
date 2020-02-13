package com.kijo.gdaxservice.firebase;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kijo.gdaxservice.api.accounts.Account;

import org.springframework.stereotype.Component;

@Component
public class FirebaseService {

  private static final String ACCOUNTS_ENDPOINT = "server/saving-data/accounts";

  public void updateAccounts(List<Account> accounts) {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference accountRef = database.getReference(ACCOUNTS_ENDPOINT);
    Map<String, Object> map = accounts.stream().collect(Collectors.toMap(Account::getId, Function.identity()));
    accountRef.updateChildrenAsync(map);
  }
}
