INSTRUCCIONES DE USO
########################################################################################
PASO N° 1 
Con el siguiente endpoint obtener el token para crear el usuario la primera vez:

http://localhost:8080/api/login

POST login: se pasa un json con las siguientes caracateristicas

{
"email": "admin@admin.com",
"password": "12345678Pr"
}

############################################################################################
PASO N° 2

http://localhost:8080/user
POST (crear usuario): recibe un json con las siguientes caracteristicas, 
ademas pasar el token obtenido en el paso N°1 y agregarlo en el AUTHORIZATION COMO BEARER TOKEN 

{
"name": "Juan Rodriguez",
"email": "astrid3015@gmail.com",
"password": "220569Yg.",
"phone": [
{
"number": "1234567",
"cityCode": "20",
"countryCode": "56"
}
]
}
############################################################################################
PASO N° 2.1
Para hacer login con el usuario creado en paso N°2 se debe enviar un json cumpliendo las 
siguientes carasteristicas:
{
"email": "astrid3015@gmail.com",
"password": "220569Yg."
}

Es decir el correo y la contraseña con que crearon el usuario
############################################################################################

Para ver la data de la BBDD:
Se debe levantar el proyecto, ya configurado por defecto tiene el puerto 8080, se inicializa la consola en el 
siguiente endpoint http://localhost:8080/h2-console 
user: sa
Password: 

############################################################################################

Los diagrama de solucion de se encuentran en el paquete Diagram!!!

############################################################################################


password debe contener Mayúscula,  minúsculas, y números, caracteres especiales (entre 8-20 caracteres).
email espera un formato correcto ( aaaaaaa@dominio.cl )

############################################################################################
