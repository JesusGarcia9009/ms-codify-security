# ms-codify-security

Microservicio orientado al perfilamiento de manera global en la aplicacion, asi como la gestion del Tenant como variable global

## Comenzando 🚀

Descargar Fuentes de git

```
git clone https://github.com/JesusGarcia9009/ms-codify-security.git
git checkout main
```
Una vez descargada las fuentes de debe ejecutar en consola:

```
mvn clean install
```

Ademas de esto, se debe editar los archivo 'yml' donde se encuentran las configuraciones de conexion con el ConfigServer, su nombre debe ser:
> **bootstrap.yml**

En el cual se debe fijar la ruta de acceso al Config Server y el usuario de git y el nombre del archivo de propiedades.
 
## Agrupación
La estructura del proyecto es la siguiente

- com.ms.codify
- com.ms.codify.config
- com.ms.codify.controller
- com.ms.codify.dto
- com.ms.codify.entities
- com.ms.codify.enums
- com.ms.codify.exception
- com.ms.codify.repository
- com.ms.codify.service
- com.ms.codify.utils

## Pre-requisitos 🛠

- Maquina Virtual de Java
- Maven
- Variables de entorno
- Docker 
- IDE
- Lombok


## Ejecutando las pruebas ⚙

Comando para ejecutar nuestros test unitarios con mockito y luego subir a el reporte a sonar.

```
mvn test sonar:sonar
```

## Despliegue 📦

* Despliegue en IC: solo se debe solicitar un merge request a develop.

* Despliegue en TEST, PREPROD, PRODUCCION: se debe hacer el checkout a la rama mencionada en el documento de release y luego ejecutar los comandos con los valores especificado en dicho documento.

```
$mvn clean install
$docker build -t registry.gitlab.com/{component}:{release}_{enviroment} .
$docker push registry.gitlab.com/{component}:{release}_{enviroment}
$kubectl apply -f k8s
```

## Construido con 🛠


Herramientas y lenguajes utilizados


* [Java](https://www.java.com/) - Lenguaje de programacion.
* [Maven](https://maven.apache.org/) - Manejador de dependencias.
* [Eclipse](https://www.eclipse.org/) - IDE de desarrollo.
* [DBeaver](https://dbeaver.io//) - Herramienta de base de datos.
* [Swagger](https://swagger.io/) - Documentacion de los servicios.
* [Lombok](https://projectlombok.org/) - Creacion de metodos basicos de objetos.


## Autores.

* **Jesús García** - *Trabajo Inicial-Programación-Dcumentación* 

* **Hector Humeres** - *Trabajo Inicial-Programación-Dcumentación* 


## Agradecimientos


* Gracias a todos los participantes del proyecto, desde sus inicios hasta su fin.


