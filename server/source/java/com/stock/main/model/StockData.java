package com.stock.main.model;

import net.minidev.json.JSONObject;

import java.util.Map;

public class StockData {
    private String symbol;
    private String name;
    private String price;
    private String close_yesterday;
    private String currency;
    private String market_cap;
    private String volume;
    private String timezone;
    private String timezone_name;
    private String gmt_offset;
    private String last_trade_time;
    private String stock_exchange_short;

    public StockData() {
    }

    public StockData (Map<String, String> map) {
        this.symbol = map.get("symbol");
        this.name = map.get("name");
        this.price = map.get("price");
        this.close_yesterday = map.get("close_yesterday");
        this.currency = map.get("currency");
        this.market_cap = map.get("market_cap");
        this.volume = map.get("volume");
        this.timezone = map.get("timezone");
        this.timezone_name = map.get("timezone_name");
        this.gmt_offset = map.get("gmt_offset");
        this.last_trade_time = map.get("last_trade_time");
        this.stock_exchange_short = map.get("stock_exchange_short");
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("symbol", symbol);
        jsonObject.put("name", name);
        jsonObject.put("price", price);
        jsonObject.put("close_yesterday", close_yesterday);
        jsonObject.put("currency", currency);
        jsonObject.put("market_cap", market_cap);
        jsonObject.put("volume", volume);
        jsonObject.put("timezone", timezone);
        jsonObject.put("timezone_name",timezone_name);
        jsonObject.put("gmt_offset", gmt_offset);
        jsonObject.put("last_trade_time", last_trade_time);
        return jsonObject;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getClose_yesterday() {
        return close_yesterday;
    }

    public void setClose_yesterday(String close_yesterday) {
        this.close_yesterday = close_yesterday;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(String market_cap) {
        this.market_cap = market_cap;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone_name() {
        return timezone_name;
    }

    public void setTimezone_name(String timezone_name) {
        this.timezone_name = timezone_name;
    }

    public String getGmt_offset() {
        return gmt_offset;
    }

    public void setGmt_offset(String gmt_offset) {
        this.gmt_offset = gmt_offset;
    }

    public String getLast_trade_time() {
        return last_trade_time;
    }

    public void setLast_trade_time(String last_trade_time) {
        this.last_trade_time = last_trade_time;
    }

    public String getStockExchange() {
        return stock_exchange_short;
    }

    public void setStockExchange(String stock_exchange_short) {
        this.stock_exchange_short = stock_exchange_short;
    }
}
