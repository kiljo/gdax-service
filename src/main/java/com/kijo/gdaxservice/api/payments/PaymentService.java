package com.kijo.gdaxservice.api.payments;

import java.util.List;

import com.kijo.gdaxservice.api.exchange.GdaxExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * Created by robevansuk on 16/02/2017.
 */
@Component
public class PaymentService {

  private static final String PAYMENT_METHODS_ENDPOINT = "/payment-methods";
  private static final String COINBASE_ACCOUNTS_ENDPOINT = "/coinbase-accounts";

  @Autowired
  GdaxExchange gdaxExchange;

  public List<PaymentType> getPaymentTypes() {
    return gdaxExchange.getAsList(PAYMENT_METHODS_ENDPOINT, new ParameterizedTypeReference<PaymentType[]>() {
    });
  }

  public List<CoinbaseAccount> getCoinbaseAccounts() {
    return gdaxExchange.getAsList(COINBASE_ACCOUNTS_ENDPOINT, new ParameterizedTypeReference<CoinbaseAccount[]>() {
    });
  }
}