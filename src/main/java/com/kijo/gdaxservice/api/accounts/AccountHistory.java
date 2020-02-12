package com.kijo.gdaxservice.api.accounts;

import java.math.BigDecimal;

import com.kijo.gdaxservice.api.entity.Detail;

/**
 * Created by irufus on 2/18/15.
 */
public class AccountHistory {
  private Integer id;
  private String created_at;
  private BigDecimal amount;
  private BigDecimal balance;
  private String type;
  private Detail detail;

  public AccountHistory() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Detail getDetail() {
    return detail;
  }

  public void setDetail(Detail detail) {
    this.detail = detail;
  }
}
