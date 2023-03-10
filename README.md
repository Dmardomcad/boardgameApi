# boardgameApi

Project made for educational purposes, developed an API REST for a blog inspired on filmaffinity but for tabletop games instead of movies.
It was made using Springboot and testing all the endpoints with Postman.
## Referencias API

All the endpoints from the API are secured, you need to authenticate yourself using httpBasic from the
endpoint /token to get the JWT.

````
POST /token
````
We can access all the endpoints using the JWT generated.

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
POST /boardgames/create
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
POST /publishers/create
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
POST /users/create
````
##### Delete one user
````
DELETE /users/{id}
````
##### Update one user
````
PUT /users/{id}
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
POST /comments/create
````
##### Delete one comment
````
DELETE /comments/{id}
````
##### Update one comment
````
PUT /comments/{id}
````

A .zip can be found inside the project with all the exported requests.