/**
 * Copyright (C) 2012 - 2014 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.kraken.dto.trade;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.xeiam.xchange.currency.CurrencyPair;

public class KrakenStandardOrder {

  private final CurrencyPair currencyPair;
  private final KrakenType type;
  private final KrakenOrderType orderType;
  private final String price;
  private final String secondaryPrice;
  private final BigDecimal volume;
  private final String leverage;
  private final String positionTxId;
  private final Set<KrakenOrderFlags> orderFlags;
  private final String startTime;
  private final String expireTime;
  private final String userRefId;
  private final boolean validateOnly;
  private final Map<String, String> closeOrder;

  private KrakenStandardOrder(CurrencyPair currencyPair, KrakenType type, KrakenOrderType orderType, String price, String secondaryPrice, BigDecimal volume, String leverage, String positionTxId,
      Set<KrakenOrderFlags> orderFlags, String startTime, String expireTime, String userRefId, boolean validateOnly, Map<String, String> closeOrder) {

    this.currencyPair = currencyPair;
    this.type = type;
    this.orderType = orderType;
    this.price = price;
    this.secondaryPrice = secondaryPrice;
    this.volume = volume;
    this.leverage = leverage;
    this.positionTxId = positionTxId;
    this.orderFlags = orderFlags;
    this.startTime = startTime;
    this.expireTime = expireTime;
    this.userRefId = userRefId;
    this.validateOnly = validateOnly;
    this.closeOrder = closeOrder;
  }

  public CurrencyPair getAssetPair() {

    return currencyPair;
  }

  public KrakenType getType() {

    return type;
  }

  public KrakenOrderType getOrderType() {

    return orderType;
  }

  public String getPrice() {

    return price;
  }

  public String getSecondaryPrice() {

    return secondaryPrice;
  }

  public BigDecimal getVolume() {

    return volume;
  }

  public String getLeverage() {

    return leverage;
  }

  public String getPositionTxId() {

    return positionTxId;
  }

  public Set<KrakenOrderFlags> getOrderFlags() {

    return orderFlags;
  }

  public String getStartTime() {

    return startTime;
  }

  public String getExpireTime() {

    return expireTime;
  }

  public String getUserRefId() {

    return userRefId;
  }

  public boolean isValidateOnly() {

    return validateOnly;
  }

  public Map<String, String> getCloseOrder() {

    return closeOrder;
  }

  @Override
  public String toString() {

    return "KrakenStandardOrder [currencyPair=" + currencyPair + ", type=" + type + ", orderType=" + orderType + ", price=" + price + ", secondaryPrice=" + secondaryPrice + ", volume=" + volume
        + ", leverage=" + leverage + ", positionTxId=" + positionTxId + ", orderFlags=" + orderFlags + ", startTime=" + startTime + ", expireTime=" + expireTime + ", userRefId=" + userRefId
        + ", validateOnly=" + validateOnly + ", closeOrder=" + closeOrder + "]";
  }

  public static KrakenOrderBuilder getMarketOrderBuilder(CurrencyPair currencyPair, KrakenType type, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.MARKET, volume);
  }

  public static KrakenOrderBuilder getLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String limitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.LIMIT, volume).withPrice(limitPrice);
  }

  public static KrakenOrderBuilder getStopLossOrderBuilder(CurrencyPair currencyPair, KrakenType type, String stopLossPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS, volume).withPrice(stopLossPrice);
  }

  public static KrakenOrderBuilder getTakeProfitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String takeProfitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TAKE_PROFIT, volume).withPrice(takeProfitPrice);
  }

  public static KrakenOrderBuilder getStopLossProfitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String stopLossPrice, String takeProfitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_PROFIT, volume).withPrice(stopLossPrice).withSecondaryPrice(takeProfitPrice);
  }

  public static KrakenOrderBuilder getStopLossProfitLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String stopLossPrice, String takeProfitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_PROFIT_LIMIT, volume).withPrice(stopLossPrice).withSecondaryPrice(takeProfitPrice);
  }

  public static KrakenOrderBuilder getStopLossLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String stopLossTriggerPrice, String triggeredLimitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_LIMIT, volume).withPrice(stopLossTriggerPrice).withSecondaryPrice(triggeredLimitPrice);
  }

  public static KrakenOrderBuilder getTakeProfitLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String takeProfitTriggerPrice, String triggeredLimitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TAKE_PROFIT_LIMIT, volume).withPrice(takeProfitTriggerPrice).withSecondaryPrice(triggeredLimitPrice);
  }

  public static KrakenOrderBuilder getTrailingStopOrderBuilder(CurrencyPair currencyPair, KrakenType type, String trailingStopOffset, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TRAILING_STOP, volume).withPrice(trailingStopOffset);
  }

  public static KrakenOrderBuilder getTrailingStopLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String trailingStopOffset, String triggeredLimitOffset, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.TRAILING_STOP_LIMIT, volume).withPrice(trailingStopOffset).withSecondaryPrice(triggeredLimitOffset);
  }

  public static KrakenOrderBuilder getStopLossAndLimitOrderBuilder(CurrencyPair currencyPair, KrakenType type, String stopLossPrice, String limitPrice, BigDecimal volume) {

    return new KrakenOrderBuilder(currencyPair, type, KrakenOrderType.STOP_LOSS_AND_LIMIT, volume).withPrice(stopLossPrice).withSecondaryPrice(limitPrice);
  }

  public static class KrakenOrderBuilder {

    private final CurrencyPair currencyPair;
    private final KrakenType type;
    private final KrakenOrderType orderType;
    private String price;
    private String secondaryPrice;
    private final BigDecimal volume;
    private String leverage;
    private String positionTxId;
    private Set<KrakenOrderFlags> orderFlags;
    private String startTime;
    private String expireTime;
    private String userRefId;
    private boolean validateOnly;
    private Map<String, String> closeOrder;

    private KrakenOrderBuilder(CurrencyPair currencyPair, KrakenType type, KrakenOrderType orderType, BigDecimal volume) {

      this.currencyPair = currencyPair;
      this.type = type;
      this.orderType = orderType;
      this.volume = volume;
      this.orderFlags = EnumSet.noneOf(KrakenOrderFlags.class);
      this.startTime = "0";
      this.positionTxId = "0";
      this.validateOnly = false;
    }

    public KrakenOrderBuilder withPrice(String price) {

      this.price = price;
      return this;
    }

    public KrakenOrderBuilder withSecondaryPrice(String secondaryPrice) {

      this.secondaryPrice = secondaryPrice;
      return this;
    }

    public KrakenOrderBuilder withLeverage(String leverage) {

      this.leverage = leverage;
      return this;
    }

    public KrakenOrderBuilder withPositionTxId(String positionTxId) {

      this.positionTxId = positionTxId;
      return this;
    }

    public KrakenOrderBuilder withOrderFlags(Set<KrakenOrderFlags> orderFlags) {

      this.orderFlags.addAll(orderFlags);
      return this;
    }

    public KrakenOrderBuilder withStartTime(String startTime) {

      this.startTime = startTime;
      return this;
    }

    public KrakenOrderBuilder withExpireTime(String expireTime) {

      this.expireTime = expireTime;
      return this;
    }

    public KrakenOrderBuilder withUserRefId(String userRefId) {

      this.userRefId = userRefId;
      return this;
    }

    public KrakenOrderBuilder withValidateOnly(boolean validateOnly) {

      this.validateOnly = validateOnly;
      return this;
    }

    public KrakenOrderBuilder withCloseOrder(KrakenOrderType orderType, String price, String secondaryPrice) {

      closeOrder = new HashMap<String, String>();
      closeOrder.put("ordertype", orderType.toString());
      closeOrder.put("price", price);
      closeOrder.put("price2", secondaryPrice);
      return this;
    }

    public KrakenStandardOrder buildOrder() {

      return new KrakenStandardOrder(currencyPair, type, orderType, price, secondaryPrice, volume, leverage, positionTxId, orderFlags, startTime, expireTime, userRefId, validateOnly, closeOrder);
    }

    @Override
    public String toString() {

      return "KrakenOrderBuilder [currencyPair=" + currencyPair + ", type=" + type + ", orderType=" + orderType + ", price=" + price + ", secondaryPrice=" + secondaryPrice + ", volume=" + volume
          + ", leverage=" + leverage + ", positionTxId=" + positionTxId + ", orderFlags=" + orderFlags + ", startTime=" + startTime + ", expireTime=" + expireTime + ", userRefId=" + userRefId
          + ", validateOnly=" + validateOnly + ", closeOrder=" + closeOrder + "]";
    }

    public CurrencyPair getAssetPair() {

      return currencyPair;
    }

    public KrakenType getType() {

      return type;
    }

    public KrakenOrderType getOrderType() {

      return orderType;
    }

    public String getPrice() {

      return price;
    }

    public String getSecondaryPrice() {

      return secondaryPrice;
    }

    public BigDecimal getVolume() {

      return volume;
    }

    public String getLeverage() {

      return leverage;
    }

    public String getPositionTxId() {

      return positionTxId;
    }

    public Set<KrakenOrderFlags> getOrderFlags() {

      return orderFlags;
    }

    public String getStartTime() {

      return startTime;
    }

    public String getExpireTime() {

      return expireTime;
    }

    public String getUserRefId() {

      return userRefId;
    }

    public boolean isValidateOnly() {

      return validateOnly;
    }

    public Map<String, String> getCloseOrder() {

      return closeOrder;
    }
  }
}
