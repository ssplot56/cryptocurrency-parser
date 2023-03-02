# Crypto-parser

### Project description:
This is an application that receives the latest information from CEX.IO, writes the data to MongoDB, and allows you to receive sorted data by key endpoints and create a CSV report.

### Features:
* Every 10 seconds app get latest information about the three main pairs: BTC/USD, ETH/USD, XRP/USD. Data is collected in MongoDB.
* Ability to get the lowest price of selected cryptocurrency by ***/cryptocurrencies/minprice?name=[currency_name]*** endpoint.
* Ability to get the highest price of selected cryptocurrency by ***/cryptocurrencies/maxprice?name=[currency_name]*** endpoint.
* Ability to get page with selected number of items sorted by price from lowest to highest by ***/cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size]*** endpoint.
* Ability to generete a CSV report by ***/cryptocurrencies/csv*** endpoint.

### Applicaton was built with:
* Java 11;
* Spring Boot;
* Spring Data;
* Mongo DB;
* Cryptocurrency rest api (https://cex.io/rest-api).
