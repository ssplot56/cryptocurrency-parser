# Crypto-parser

### Project description:
This is an application that receives the latest information from CEX.IO, writes the data to MongoDB, and allows you to receive sorted data by key endpoints and create a CSV report.

### Features:
* Every 10 seconds app get latest information about three main pars: BTC/USD, ETH/USD, XRP/USD. Data collect in MongoDB.
* Ability to receive lowest price of selected cryptocurrency by _/cryptocurrencies/minprice?name=[currency_name]_ endpoint.
* Ability to receive highest price of selected cryptocurrency by _/cryptocurrencies/maxprice?name=[currency_name]_ endpoint.
* Ability to receive page with selected number of elements with sorting by price from lowest to highest by _/cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size]_ endpoint
* Ability to generete a CSV report by _/cryptocurrencies/csv_ endpoint.

### Applicaton was built with:
* Java 11
* Spring Boot
* Spring Data
* Mongo DB
* Cryptocurrency rest api (https://cex.io/rest-api)
