# myBank-Project
A Web Application for banking 
 myBank is a web application that provides online banking Services to its Customers.

1. Developed Account Service: It is a backend API that is used to post account details of its Customers from UI to DB, can fetch all AccountDetails from DB based on Customer-Id provided by the customer, and can also update details of the customer by Customer-Id.
2. Developed Card Service: It is a backend API that is used to create new cards for a customer, can fetch all CardDetails from DB based on the MobileNumber of the customer, can update card details by card number provided by the customer.
3. Developed Balance Service: backend API used to fetch the Available Balance of customers by customer ID.

4. Implemented Microservices architecture and made Synchronous Communication using Web Client/Spring Cloud OpenFeign to call card-service and balance-service from account-service to get details of all cards a customer has in myBank Application and balance details with his respective Account-Details.
