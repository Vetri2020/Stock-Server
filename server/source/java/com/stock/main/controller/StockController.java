package com.stock.main.controller;

import com.stock.main.model.StockData;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/stock/{symbol}")

    // Returns jsonobject if stock symbol is found, otherwise returns empty json object
    // Throws RestClientException
    public JSONObject getStockData(@PathVariable("symbol") String symbol, @RequestParam(value = "stock_exchange", required = false) String stockExchanges) throws RestClientException {

        String apiToken = "zjcBNjbL07GwzwkpkP2cbf0N9QGeBOhaKxBjxx3XoYCnQn5lV5qWi3rW0ozH";
        if (stockExchanges == null)
            stockExchanges = "AMEX";
        String[] exchanges = stockExchanges.split(",");
        List<String> exchangeList = Arrays.asList(exchanges);

        //Initialize stock data by calling stock api

        String url = "https://www.worldtradingdata.com/api/v1/stock?symbol=" + symbol + "&api_token=" + apiToken;
        //Gets stock list by from worldtradingdata.com through REST API
        List list = getStockList(url);
        if (list == null || list.isEmpty())
            return new JSONObject();
        StockData stockData = new StockData((LinkedHashMap)list.get(0));
        JSONObject outputJson = new JSONObject();
        outputJson.put(stockData.getStockExchange(),stockData.toJSONObject());
        System.out.println(stockData.getStockExchange());
        /* If multiple exchanges are given in query parameter, 'stock_search' api should be used..'stock' api don't support
         exchanges in query params.
         We are getting stock info and store it in StockData object and then update the price,currency data only in case of
         getting stock details from more than one exchanges*/
        for (String exchange : exchangeList) {
            if (exchange.equals(stockData.getStockExchange()))
                continue;
            url = "https://www.worldtradingdata.com/api/v1/stock_search?search_term="+symbol+"&search_by=symbol"+"&api_token="+apiToken+"&stock_exchange="+stockExchanges;
            list = getStockList(url);
            for (Object object: list) {
                LinkedHashMap<String, String> linkedHashMap = (LinkedHashMap) object;
                if (stockData.getSymbol().equals(linkedHashMap.get("symbol"))) {
                    JSONObject cloneData = stockData.toJSONObject();
                    cloneData.put("price",linkedHashMap.get("price"));
                    cloneData.put("currency",linkedHashMap.get("currency"));
                    outputJson.put(linkedHashMap.get("stock_exchange_short"),cloneData);
                }
            }
        }
        return outputJson;
    }

    private List getStockList (String url){
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(url, Object.class);
        LinkedHashMap responseMap = (LinkedHashMap) responseEntity.getBody();
        return (ArrayList) responseMap.get("data");
    }

}
