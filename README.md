# RevolutMoneyTransfer
### Assumptions
- Money get transfered in same currency.
- All test cases will run inside a test environment.
- Minus amount can be added to account. 

##API
URL: http://localhost:8080/transfers
Request Type:```POST```
Body: 
```xml
{
	"accountTo":"00123",
	"accountFrom":"00124",
	"branch": "001",
	"amount":50.00
}
```
### Server Responses

```xml 
Code: 202 
Reason: Accepted 
Response:
```

```xml 
Code: 400 
Reason: Bad Request[Invalid Account Number]
Response:
{
    "path": "/transfers",
    "error": "Bad Request",
    "message": "Please Insert Valid Account Id!",
    "timestamp": "Thu May 23 23:05:54 BDT 2019",
    "status": "400"
}
```

```xml 
Code: 400
Reason: Bad Request[Invalid Branch]
Response:
{
    "path": "/transfers",
    "error": "Bad Request",
    "message": "Please Insert Valid Branch!",
    "timestamp": "Thu May 23 23:07:42 BDT 2019",
    "status": "400"
}
```

```xml 
Code: 406
Reason: Not Acceptable[Insufficient Amount]
Response: 
{
    "path": "/transfers",
    "error": "Not Acceptable",
    "message": "Insufficient Amount",
    "timestamp": "Thu May 23 23:08:24 BDT 2019",
    "status": "406"
}
```

## Class Diagram
![class diagram](https://github.com/zeromsi/RevolutMoneyTransfer/blob/master/documentation/classDiagram.png)

## API Call graph
![API call graph](https://github.com/zeromsi/RevolutMoneyTransfer/blob/master/documentation/layer.png)

