package com.kijo.gdaxservice.api.accounts;

/**
 * Created by irufus on 2/18/15.
 */
public class Account {
  private String id;
  private String currency;
  private Double balance;
  private Double available;
  private Double hold;
  private String profile_id;

  public Account() {
    this.balance = 0.0;
    this.available = 0.0;
    this.hold = 0.0;
  }

  public Account(String id, String currency, Double balance, Double available, Double hold, String profile_id) {
    this.id = id;
    this.currency = currency;
    this.balance = balance;
    this.available = available;
    this.hold = hold;
    this.profile_id = profile_id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Double getHold() {
    return hold;
  }

  public void setHold(Double hold) {
    this.hold = hold;
  }

  public Double getAvailable() {
    return available;
  }

  public void setAvailable(Double available) {
    this.available = available;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getProfile_id() {
    return profile_id;
  }

  public void setProfile_id(String profile_id) {
    this.profile_id = profile_id;
  }
}
