# Projet REST Grails

### Accès à la documentation de l'API
L'accès se fait via l'url suivante : http://localhost:8080/apidoc/   
La documentation est générée via un plugin Swagger.  

### Requete CURL

##### GET /api/v1/book/{id} - Retourne un Book en fonction de l'id
```
curl -X GET "http://localhost:8080/api/v1/book/0" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:42:35 GMT  
 
{
  "id": 1,
  "library": {
    "id": 1
  },
  "name": "livre",
  "releaseDate": "2017-11-06T07:32:30Z",
  "isbn": "123456",
  "author": "moi"
}
```

#### GET /api/v1/books - Retourne la liste des Book
```
curl -X GET "http://localhost:8080/api/v1/books" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:44:58 GMT  

[
  {
    "id": 1,
    "library": {
      "id": 1
    },
    "name": "livre",
    "releaseDate": "2017-11-06T07:32:30Z",
    "isbn": "123456",
    "author": "moi"
  },
  {
    "id": 2,
    "library": {
      "id": 1
    },
    "name": "coco",
    "releaseDate": "2017-11-06T07:32:30Z",
    "isbn": "1793468",
    "author": "moi"
  },
  {
    "id": 3,
    "library": {
      "id": 2
    },
    "name": "bouquin",
    "releaseDate": "2017-11-06T07:32:30Z",
    "isbn": "789456",
    "author": "moi"
  }
]
```

#### GET /api/v1/book/{id}/library - Retourne une Library en fonction de l'id du Book  
```
curl -X GET "http://localhost:8080/api/v1/book/1/library" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:48:11 GMT  

{
  "id": 1,
  "address": "360 mico",
  "books": [
    {
      "id": 1
    },
    {
      "id": 2
    }
  ],
  "name": "lib",
  "yearCreated": 1987
}
```

#### POST /api/v1/book - Créer un Book
```
curl -X POST "http://localhost:8080/api/v1/book?name=toto&releaseDate=2017-11-06T07%3A49%3A58.183Z&isbn=test&author=moi&library=1" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:50:28 GMT 
```

#### PUT /api/v1/book/{id} - Mettre à jour un Book en fonction de l'id
```
curl -X PUT "http://localhost:8080/api/v1/book/1?name=name" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:52:42 GMT 
```

#### DELETE /api/v1/book/{id} - Supprimer un Book en fonction de l'id
```
curl -X DELETE "http://localhost:8080/api/v1/book/2" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:54:04 GMT  

{
  "id": 2,
  "library": {
    "id": 1
  },
  "name": "coco",
  "releaseDate": "2017-11-06T07:32:30Z",
  "isbn": "1793468",
  "author": "moi"
}
```

#### GET /api/v1/library/{id} - Retourne une Library en fonction de l'id
```
curl -X GET "http://localhost:8080/api/v1/library/1" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:55:56 GMT  

{
  "id": 1,
  "address": "360 mico",
  "books": [
    {
      "id": 4
    },
    {
      "id": 1
    },
    {
      "id": 2
    }
  ],
  "name": "lib",
  "yearCreated": 1987
}
``` 

#### GET /api/v1/libraries - Retourne la liste des Libraries
```
curl -X GET "http://localhost:8080/api/v1/libraries" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:57:25 GMT  

[
  {
    "id": 1,
    "address": "360 mico",
    "books": [
      {
        "id": 4
      },
      {
        "id": 1
      },
      {
        "id": 2
      }
    ],
    "name": "lib",
    "yearCreated": 1987
  },
  {
    "id": 2,
    "address": "405 soph",
    "books": [
      {
        "id": 3
      }
    ],
    "name": "lib2",
    "yearCreated": 2006
  }
]
```
#### GET /api/v1/library/{id}/books - Retourne la liste des Book présent dans une Library en fonction de l'id
```
curl -X GET "http://localhost:8080/api/v1/library/1/books" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  content-type: application/json;charset=UTF-8  transfer-encoding: chunked  date: Mon, 06 Nov 2017 07:58:54 GMT  

[
  {
    "id": 2,
    "library": {
      "id": 1
    },
    "name": "coco",
    "releaseDate": "2017-11-06T07:32:30Z",
    "isbn": "1793468",
    "author": "moi"
  },
  {
    "id": 1,
    "library": {
      "id": 1
    },
    "name": "name",
    "releaseDate": "2017-11-06T07:32:30Z",
    "isbn": "123456",
    "author": "moi"
  },
  {
    "id": 4,
    "library": {
      "id": 1
    },
    "name": "toto",
    "releaseDate": "2017-11-06T07:49:58Z",
    "isbn": "test",
    "author": "moi"
  }
]
```

#### PUT /api/v1/library/{id} - Mettre à jour une library en fonction de l'id
```
curl -X PUT "http://localhost:8080/api/v1/library/1?name=libname" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  transfer-encoding: chunked  date: Mon, 06 Nov 2017 08:05:07 GMT 
```

#### DELETE /api/v1/library/{id} - Supprimer une library en fonction de l'id
```
curl -X DELETE "http://localhost:8080/api/v1/library/2" -H  "accept: application/json" -H  "applicationType: web"  

x-application-context: application:development  transfer-encoding: chunked  date: Mon, 06 Nov 2017 08:06:40 GMT 
```
