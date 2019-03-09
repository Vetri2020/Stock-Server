# Stock-Server

Please make use of the free API from https://www.worldtradingdata.com to complete this challenge.
Create a micro-service with the following endpoint,

 /stock/{symbol}

Returns the stock prices of the given stock symbol from the exchanges provided in the query
parameter. If no query parameter is given then return the value of stock from AMEX (default) stock
exchange.

symbol must be a valid stock symbol.

 Query Params:

stock_exchange - Optional. This should accept all valid exchange names. eg.
stock_exchange=NASDAQ,NYSE

 Response:

{
"NASDAQ":{
"symbol":"AAPL",
"name":"Apple Inc.",
"price":"154.94",
"close_yesterday":"154.94",
"currency":"USD",
"market_cap":"732835688367",
"volume":"142022",
"timezone":"EST",
"timezone_name":"America/New_York",
"gmt_offset":"-18000",
"last_trade_time":"2019-01-16 16:00:01"
}
}

Download stock-server.jar from repository and use in your project.

Dependencies:

All spring boot web starter related jar files - As this microservice is developed in spring boot.
json-smart-2.3.jar - For parsing json input and sending json response as output.

