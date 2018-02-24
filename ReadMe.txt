
Swagger URL : http://localhost:8080/swagger-ui.html
H2 Database URL : http://localhost:8080/h2-console/login.do


POST /pizza/order - input data
------------------------------
{
   "customerName":"Customer name",
   "customerAddress":"Address 1",
   "customerContact":"+64 11 452 3625",
   "totalAmount":22.00",
   "pizzaOrderCollection":[
      {
         "pizzaOrderId":10001,
         "pizzaSizeId":{
            "pizzaSizeId":3
         },
         "price":null,
         "notes":null,
         "crustId":{
            "custId":10
         },
         "pizzaId":{
            "pizzaId":1001
         },
         "pizzaToppingCollection":[
            {
               "id":1,
               "toppingId":{
                  "toopingId":110
               }
            }
         ]
      }
   ]
}