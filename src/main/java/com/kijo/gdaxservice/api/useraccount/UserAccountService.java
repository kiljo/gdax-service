package com.kijo.gdaxservice.api.useraccount;

import java.util.List;

import com.kijo.gdaxservice.api.exchange.GdaxExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * Created by robevansuk on 17/02/2017.
 */
@Component
public class UserAccountService {

  private static final String USER_ACCOUNT_ENDPOINT = "/users/self/trailing-volume";

  @Autowired
  GdaxExchange gdaxExchange;

  /**
   * Returns the 30 day trailing volume information from all accounts for the key
   * provided
   * 
   * @return UserAccountData
   */
  public List<UserAccountData> getTrailingVolume() {
    return gdaxExchange.getAsList(USER_ACCOUNT_ENDPOINT, new ParameterizedTypeReference<UserAccountData[]>() {
    });
  }
}
