# customerloyaltyapi
customer loyalty backend api
Functinalites
1. Able to Create Customers
2. Able to Add loyalty points
3. Able to to view the customer points
4. Able to redeem points

Below is the class digram of the API
![class digram](https://github.com/kanishka-dot/customerloyaltyapi/assets/57704517/ec2124f2-7f1e-48fe-80dd-48d2e494b3a5)


Below API calls and result

##GET ALL Customers (http://localhost:8080/customer/api/v1/getllcustomers)

Result
```
[
    {
        "id": 202,
        "firstname": "janak",
        "lastname": "sura",
        "address": "25 lm",
        "loyalty": {
            "custid": 202,
            "totalpoints": 70.0,
            "totalredeem": 60.0
        }
    },
    {
        "id": 252,
        "firstname": "maduma",
        "lastname": "payagala",
        "address": "homagama",
        "loyalty": {
            "custid": 252,
            "totalpoints": 60.0,
            "totalredeem": 30.0
        }
    }
	]
```	
		
##POST new customer (	http://localhost:8080/customer/api/v1/createcustomer)

	request body	
```	
		{
		"firstname": "maduma",
		"lastname": "payagala",
		"address": "homagama",
		"loyalty":null
	}
```	
	Result
	
	200 OK
	
	
##	add point to customer (http://localhost:8080/loyalty/api/v1/addLoyaltyPoints)
	
	
```	
	{
    "id":202,
    "pointAdd":10,
    "pointDeduct":0
}
```
result
```
{
    "id": 202,
    "totalPoints": 80.0,
    "totalRedeem": 60.0,
    "updateStatus": true,
    "remark": "Customer loyalty point added"
}
```
## Deduct point from  customer(http://localhost:8080/loyalty/api/v1/deductLoyaltyPoints)

```
{
    "id":202,
    "pointAdd":0,
    "pointDeduct":40
}
```
Result
```
{
    "id": 202,
    "totalPoints": 80.0,
    "totalRedeem": 70.0,
    "updateStatus": true,
    "remark": "Customer loyalty point deducted"
}
```
Invalid result
```
{
    "id": 202,
    "totalPoints": 0.0,
    "totalRedeem": 0.0,
    "updateStatus": false,
    "remark": "Invalid point amount"
}
```
