package com.kijo.gdaxservice.api.products;

import java.util.List;

import com.kijo.gdaxservice.api.entity.Product;
import com.kijo.gdaxservice.api.exchange.GdaxExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * Created by robevansuk on 03/02/2017.
 */
@Component
public class ProductService {

  @Autowired
  GdaxExchange exchange;

  public static final String PRODUCTS_ENDPOINT = "/products";

  // no paged products necessary
  public List<Product> getProducts() {
    return exchange.getAsList(PRODUCTS_ENDPOINT, new ParameterizedTypeReference<Product[]>() {
    });
  }
}
