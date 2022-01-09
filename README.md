# PROBLEM STATEMENT
Create a server that allows you to look up a country by name and returns the full name,
population, and a list of its official currencies including the current exchange rate to IDR.
Requests should require a valid JWT obtained from a separate /login endpoint(make your
assumptions here for partial flow, OAuth2 flow is preferred). Store the exchange rates of the
currencies queried so far by users for audit purposes.

Rate-limit the APIs to 30 requests per minute.

### Open APIs:
● https://restcountries.com/ (country lookup and general information)

● https://fixer.io (exchange rates)