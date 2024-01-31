INSTALACION

INSTRUCCIONES DE USO

url localhost:8081/user

post (crear usuario): recibe un json con las siguientes caracteristicas
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

password debe contener Mayúscula,  minúsculas, y números, caracteres especiales (entre 8-20 caracteres).
email espera un formato correcto ( aaaaaaa@dominio.cl )

