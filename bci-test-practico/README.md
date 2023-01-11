# Test banco bci

> El servicio cuenta con 4 endpoint, se comporte informacion generacion con curl
> ,dejo como antecente que se cumplieron todos los items mencionados, para revisar swagger necesita habilitar la ruta, tambien le comento que dejo una carpeta con todas las imagenes dle flujo


## Enpoint generacion de token
```bash
 http://localhost:8082/bci-test-practico/token/user/DANIELESPARZA@SSFF.CL/PASS123   metodo : POST, 
 El token tiene que estar persistentes por lo tanto se ocupa en los otros llamados
-> Si no genera un token no puede consultar las rutas.
 
 Objetivos y validaciones
 
1-Cuando se genera el token se valida la contraseña y correo.
2-Se actualiza la fecha de last_login


curl -X POST 'http://localhost:8082/bci-test-practico/token/user/DANIELESPARZA@SSFF.CL/PASS123' -H 'Cookie: JSESSIONID=5A342970BF13045D056E5659E1E6A22C'

```



## Enpoint creacion usuario
```bash
 http://localhost:8082/bci-test-practico/api/v1/cliente metodo : POST, 
Nos permite crear usuario, es necesario pasar parametros validos ya que se incorporaron validacion internas
Tambien es necesario pasar el token ya que fue un requerimiento inicial que el token fuera persistido

Objetivos y validaciones

1-validacion correo unico
2-datos obligatorios
3-correo valido
4-Clave con expresion regular
5-id generado como UUID
6-Fecha creacion
7-Estado cliente


curl -X POST 'http://localhost:8082/bci-test-practico/api/v1/cliente' -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiREFOSUVMRVNQQVJaQUBTU0ZGLkNMIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY3MzM5ODY0MywiZXhwIjoxNjczMzk5MjQzfQ.Ynysv98h_QZAPr_D1qybBoaD6GXW9U6nS6nZDjiC9XgoQWAsNHu2TT965HgniTMqQTfWKIygeQMi4MdaWfjvFw' -H 'Content-Type: application/json' -H 'Cookie: JSESSIONID=B51DA32568291FD75323AF409EFE6418' --data-raw '{
  "email": "AAA@GMAIL.COM",
  "id": "string",
  "isactive": "1",
  "name": "DANIMAL",
  "password": "string",
  "phones": [
    {
      "citycode": "string",
      "contrycode": "string",
      "id": "string",
      "number": "string"
    }
  ]
}'

```

## Enpoint lista cliente
```bash
 http://localhost:8082/bci-test-practico/api/v1/cliente  metodo : GET, 
El siguiente endpoint lista los clientes encontrados y relacionados con la base telefono




curl -X GET 'http://localhost:8082/bci-test-practico/api/v1/cliente' -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiREFOSUVMRVNQQVJaQUBTU0ZGLkNMIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY3MzM5ODY0MywiZXhwIjoxNjczMzk5MjQzfQ.Ynysv98h_QZAPr_D1qybBoaD6GXW9U6nS6nZDjiC9XgoQWAsNHu2TT965HgniTMqQTfWKIygeQMi4MdaWfjvFw' -H 'Cookie: JSESSIONID=B51DA32568291FD75323AF409EFE6418'

```

## Enpoint actualizar cliente
```bash
 http://localhost:8082/bci-test-practico/api/v1/cliente  metodo : PUT, 
 
 El siguiente endpint nos Permite actualizar informacion del cliente

Objetivos y validaciones

1-Actualizacion de fecha modified
2-Actualizacion datos generales del cliente



curl -X PUT 'http://localhost:8082/bci-test-practico/api/v1/cliente' -H 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiREFOSUVMRVNQQVJaQUBTU0ZGLkNMIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTY3MzM5ODY0MywiZXhwIjoxNjczMzk5MjQzfQ.Ynysv98h_QZAPr_D1qybBoaD6GXW9U6nS6nZDjiC9XgoQWAsNHu2TT965HgniTMqQTfWKIygeQMi4MdaWfjvFw' -H 'Content-Type: application/json' -H 'Cookie: JSESSIONID=B51DA32568291FD75323AF409EFE6418' --data-raw '{
        "id": "bb65cf35-296f-4c73-91d6-94e7f683b326",
        "name": "DANIMAL",
        "email": "CCCC@GMAIL.COM",
        "password": "string",
        "created": "2023-01-11 09:40:04",
        "isactive": "1",
        "phones": [
            {
                "id": "e1f81fd8-a6fb-44ff-a6b9-6fecee5a1ff5",
                "number": "123",
                "citycode": "23",
                "contrycode": "123"
            }
        ],
        "lastLogin": null,
        "modified": null
    }'

```
