package com.kijo.gdaxservice.api.marketdata;

import java.util.List;

import com.kijo.gdaxservice.api.exchange.GdaxExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * Created by robevansuk on 07/02/2017.
 */
@Component
public class MarketDataService {

  @Autowired
  GdaxExchange exchange;

  public static final String PRODUCT_ENDPOINT = "/products";

  public MarketData getMarketDataOrderBook(String productId, String level) {
    String marketDataEndpoint = PRODUCT_ENDPOINT + "/" + productId + "/book";
    if (level != null && !level.equals("") && !level.equals("1"))
      marketDataEndpoint += "?level=" + level;
    return exchange.get(marketDataEndpoint, new ParameterizedTypeReference<MarketData>() {
    });
  }

  public List<Trade> getTrades(String productId) {
    String tradesEndpoint = PRODUCT_ENDPOINT + "/" + productId + "/trades";
    return exchange.getAsList(tradesEndpoint, new ParameterizedTypeReference<Trade[]>() {
    });
  }
}
