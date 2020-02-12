package com.kijo.gdaxservice.api.withdrawals;

import java.math.BigDecimal;

import com.kijo.gdaxservice.api.entity.CoinbasePaymentRequest;
import com.kijo.gdaxservice.api.entity.CryptoPaymentRequest;
import com.kijo.gdaxservice.api.entity.MonetaryRequest;
import com.kijo.gdaxservice.api.entity.PaymentRequest;
import com.kijo.gdaxservice.api.entity.PaymentResponse;
import com.kijo.gdaxservice.api.exchange.GdaxExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * Created by robevansuk on 16/02/2017.
 */
@Component
public class WithdrawalsService {

  private static final String WITHDRAWALS_ENDPOINT = "/withdrawals";
  private static final String PAYMENT_METHOD = "/payment-method";
  private static final String COINBASE = "/coinbase-account";
  private static final String CRYPTO = "/crypto";

  @Autowired
  GdaxExchange gdaxExchange;

  public PaymentResponse makeWithdrawalToPaymentMethod(BigDecimal amount, String currency, String paymentMethodId) {
    PaymentRequest request = new PaymentRequest(amount, currency, paymentMethodId);
    return makeWithdrawal(request, PAYMENT_METHOD);
  }

  // TODO untested - needs coinbase account ID to work.
  public PaymentResponse makeWithdrawalToCoinbase(BigDecimal amount, String currency, String coinbaseAccountId) {
    CoinbasePaymentRequest request = new CoinbasePaymentRequest(amount.setScale(8, BigDecimal.ROUND_DOWN), currency,
        coinbaseAccountId);
    return makeWithdrawal(request, COINBASE);
  }

  // TODO untested - needs a crypto currency account address
  public PaymentResponse makeWithdrawalToCryptoAccount(BigDecimal amount, String currency,
      String cryptoAccountAddress) {
    CryptoPaymentRequest request = new CryptoPaymentRequest(amount.setScale(8, BigDecimal.ROUND_DOWN), currency,
        cryptoAccountAddress);
    return makeWithdrawal(request, CRYPTO);
  }

  private PaymentResponse makeWithdrawal(MonetaryRequest request, String withdrawalType) {
    return gdaxExchange.post(WITHDRAWALS_ENDPOINT + withdrawalType, new ParameterizedTypeReference<PaymentResponse>() {
    }, request);
  }
}
