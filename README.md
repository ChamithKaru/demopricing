# Demo Pricing
Demo project for pricing module in spring boot 2.5.0

###System requirements
Java version 11.0.9
Gradle version  6.7.1
Postgre version 13.1

####Before start, create a postgre db 'pricing' with below user credentials
user : postgres 

pw : postgres

## curl request of get all items
`curl --location --request GET 'http://localhost:8081/demopricing/getAllItems' \
--header 'Content-Type: application/json' \
--data-raw '[{
"itemId": 1,
"numOfItem": 21
}]'`


## sample curl request of price calculation

`curl --location --request GET 'http://localhost:8081/demopricing/calculateTotal' \
--header 'Content-Type: application/json' \
--data-raw '[
{
"itemId": 2,
"numOfItem": 16
},
{
"itemId": 1,
"numOfItem": 23
}
]'`

