package com.kijo.gdaxservice.api.deposits;

import java.math.BigDecimal;

import com.kijo.gdaxservice.api.entity.CoinbasePaymentRequest;
import com.kijo.gdaxservice.api.entity.PaymentResponse;
import com.kijo.gdaxservice.api.exchange.GdaxExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * Created by robevansuk on 16/02/2017.
 */
@Component
public class DepositService {

  private static final String DEPOSIT_ENDPOINT = "/deposits";
  private static final String PAYMENTS = "/payment-method";
  private static final String COINBASE_PAYMENT = "/coinbase-account";

  @Autowired
  GdaxExchange exchange;

  /**
   * @param amount
   * @param currency
   * @param paymentMethodId
   * @return PaymentResponse
   */
  public PaymentResponse depositViaPaymentMethod(BigDecimal amount, String currency, final String paymentMethodId) {
    CoinbasePaymentRequest coinbasePaymentRequest = new CoinbasePaymentRequest(amount, currency, paymentMethodId);
    return exchange.post(DEPOSIT_ENDPOINT + PAYMENTS, new ParameterizedTypeReference<PaymentResponse>() {
    }, coinbasePaymentRequest);
  }

  /**
   * @param amount
   * @param currency
   * @param coinbaseAccountId
   * @return PaymentResponse
   */
  public PaymentResponse depositViaCoinbase(BigDecimal amount, String currency, String coinbaseAccountId) {
    CoinbasePaymentRequest coinbasePaymentRequest = new CoinbasePaymentRequest(amount, currency, coinbaseAccountId);
    return exchange.post(DEPOSIT_ENDPOINT + COINBASE_PAYMENT, new ParameterizedTypeReference<PaymentResponse>() {
    }, coinbasePaymentRequest);
  }
}
