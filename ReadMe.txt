Your Choice Pizza Application
______________________________


Swagger URL : http://localhost:8080/swagger-ui.html

H2 Database URL : http://localhost:8080/h2-console/login.do

h2-console JDBC URL  : jdbc:h2:mem:testdb


POST /pizza/order - input data
------------------------------
{  
   "customerName":"Customer name",
   "customerAddress":"Address 1",
   "customerContact":"+64 11 452 3625",
   "totalAmount":"22.00 ",
   "pizzaOrderCollection":[  
      {  
         "pizzaSize":{  
            "pizzaSizeId":3
         },
         "price":null,
         "notes":null,
         "crust":{  
            "custId":10
         },
         "pizza":{  
            "pizzaId":1001
         },
         "pizzaToppingCollection":[  
            {  
               "toppingId":{  
                  "toopingId":110
               }
            }
         ]
      }
   ]
}


//TODO: Back end

1) Implement second level cache for all entity 
2) Swagger documentation 
3) Java documentation
4) Login for delivery and delete order
5) Google, Facebook sign in (Oauth 2 implementation)
6) Implement HATEOAS (Hypermedia as the Engine of Application State)
7) Hibernate query tuning
8) Implement unit test and integration test  
9)  Exception handling and proper rest response code
10) Password hashing
11) URL encryption  
12) Payment gate way integration 
13) Email, SMS, Push notification
14) Restful request response encryption and sanitizer html code
 

//TODO:Front end


