# Conversor de Monedas

Desafío de aprendizaje en donde se interactúa con el cliente para que elija una tasa de cambio en el menú que se le despliega e ingrese el valor a convertir, así como la posibilidad de ver su historial de conversiones.

# Requisitos previos

## Instalación

* Obtener una key de la api [ExchangeRate-Api](https://www.exchangerate-api.com/) que permitirá la conversión de las diferentes tasas de cambio.

<p align="center">
  <img src="https://github.com/marrsd/ONE-Challenge-Conversor-de-Monedas/blob/main/screenshots/ImagenExchangeRate-Api.png" alt="ExchangeRate-Api Key">
</p>

* Clonar el repositorio

```
git clone https://github.com/marrsd/ONE-Challenge-Conversor-de-Monedas.git
```

* Una vez clonado ingresar a la carpeta ```ONE-Challenge-Conversor-de-Monedas```

* Crear un archivo ```.env``` y agregar la Api Key dada por ExchangeRate-Api en la variable ```VAR_API_KEY=valor``` 

## Uso

Al correr el proyecto por consola aparece un menú para escoger:

* Ingrese la opción de las monedas a convertir y vea el resultado:

<p align="center">
  <img src="https://github.com/marrsd/ONE-Challenge-Conversor-de-Monedas/blob/main/screenshots/Convertir.png" alt="Convertir moneda">
</p>

* Ingrese la opción para ver el historial de todas las conversiones que ha realizado:

<p align="center">
  <img src="https://github.com/marrsd/ONE-Challenge-Conversor-de-Monedas/blob/main/screenshots/Historial.png" alt="Historial de conversiones">
</p>

* Ingrese la opción para finalizar el programa:

<p align="center">
  <img src="https://github.com/marrsd/ONE-Challenge-Conversor-de-Monedas/blob/main/screenshots/Salir.png" alt="Finalizar programa">
</p>

## Objetivos de aprendizaje

Objetivos de aprendizaje aplicados en este proyecto:

- [ ] Creación y configuración del ambiente Java.
- [ ] Java Orientado a objetos.
- [ ] Colección de datos.
- [ ] Comunicación con [ExchangeRate-Api](https://www.exchangerate-api.com/).
    - [ ] HttpClient para manejar el envio de requests Http y el manejo de los response.
    - [ ] HttpRequest para configurar y personalizar los parámetros de solicitud a la API.
    - [ ] HttpResponse para gestionar los elementos de respuesta de la API.
- [ ] Gson para la serialización y deserialización de la respuesta JSON y objetos Java.
- [ ] Lectura y escritura de ficheros con FileReader y FileWriter
- [ ] Manejo de excepciones.


### Git y GitHub

- [ ] Uso de comandos de git
- [ ] Manejo de repositorios de GitHub
- [ ] Organización en Github
