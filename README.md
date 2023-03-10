# boardgameApi
Se ha realizado este proyecto para desarrollar una API REST para un blog inspirado en filmaffinity pero de juegos de mesa en lugar de 
películas.

## Referencias API
Todos los endpoints de la API son seguros, es necesario una autenticación usando httpBasic mediante el
endpoint /token para conseguir el JWT.

````
POST /token
````
Usando el token se pueden acceder a todos los demás endpoints de la API.

### Endpoints

---
#### Boardgames
##### Get all boardgames
````
GET /boardgames
````
##### Get one boardgame
````
GET /boardgames/{id}
````
##### Create one boardgame
````
POST /boardgames/
````
##### Delete one boardgame
````
DELETE /boardgames/
````
##### Update one boardgame
````
PUT /boardgames/{id}
````
---
#### Publisher
##### Get all publishers
````
GET /publishers
````
##### Get one publisher
````
GET /publishers/{id}
````
##### Create one publisher
````
POST /publishers/
````
##### Delete one publisher
````
DELETE /publishers/{id}
````
##### Update one publisher
````
PUT /publishers/{id}
````
---
#### User
##### Get all users
````
GET /users
````
##### Get one user
````
GET /users/{id}
````
##### Create one user
````
POST /users/
````
##### Delete one user
````
DELETE /users/
````
##### Update one user
````
PUT /users/
````
---
#### Comments
##### Get all comments
````
GET /comments
````
##### Get one comment
````
GET /comments/{id}
````
##### Create one comment
````
POST /comments/
````
##### Delete one comment
````
DELETE /comments/{id}
````
##### Update one comment
````
PUT /comments/
````