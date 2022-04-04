# Test Exam

Pequeño microservicio que permite mediante una apiRest crear un usuario en la base h2.

dependencias:
 -  necesita la base H2
 -  tiene swagger 
 
### Como correr swagger
Se puede hacer uso de swagger en la siguiente URL 
http://localhost:8080/userms/swagger-ui.html#
http://localhost:8080/userms/h2-console


### Como correr los test
- Run all the unit test classes.
$ mvn test

 
### Request de ejemplo:
```
{
"email":"rbar.ec@dos.com",
  "name": "ronald",
  "password": "pass1",
  "phones": [
    {
      "city_code": "09",
      "country_code": "593",
      "number": "099123123"
    },
{
      "city_code": "14",
      "country_code": "593",
      "number": "099456456"
    }
  ]
}
```

### Response
```
{
  "code": 0,
  "result": {
    "id": "04bfae8b-be67-4e5d-9fe8-38861f8878fe",
    "user": {
      "id": "04bfae8b-be67-4e5d-9fe8-38861f8878fe",
      "name": "ronald",
      "email": "rbar.ec@dos.com",
      "password": "pass1",
      "status": "act",
      "created": "2022-03-25T21:41:58.905+00:00",
      "modified": null,
      "last_login": null,
      "token": null,
      "active": false
    },
    "is_active": true
  }
}
```
