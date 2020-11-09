# pdr-ms-common

Microservicio orientado al perfilamiento de manera global en la aplicacion

## Comenzando 🚀

Descargar Fuentes de git

```
git clone http://srv-gitlab.pdr.local/grupo-sistema-cobranzas/back-end/pdr-ms-cobranza-vista360.git
git checkout develop
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

- com.pdr.session
- com.pdr.session.config
- com.pdr.session.controller
- com.pdr.session.controller.impl
- com.pdr.session.dto
- com.pdr.session.repository
- com.pdr.session.service
- com.pdr.session.service.impl
- com.pdr.session.utils

## Pre-requisitos 🛠

- Maquina Virtual de Java
- Maven
- Variables de entorno
- Docker 
- IDE
- Lombok


### Instalación 🔧

1.- Configuracion de maven apuntando a nuestro nexus local mas las configuraciones de sonar.

```
C:\Users\{user}\.m2\settings.xml
<settings>

 <mirrors>
    <mirror>
      <id>nexus</id>
      <name>maven-central</name>
      <url>http://132.130.152.12/repository/pdr-maven/</url>
      <mirrorOf>*</mirrorOf>
    </mirror>
  </mirrors>

  <servers>
    <server>
      <id>nexus</id>
      <username>admin</username>
      <password>xxxxxxxxx</password>
    </server>
  </servers>

<pluginGroups>
    <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
  </pluginGroups>
  <profiles>
    <profile>
      <id>sonar</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <sonar.host.url>http://132.130.152.10</sonar.host.url>
        <sonar.login>10929f15034cd153365a8970d7b577e1687d012a</sonar.login>
      <!--  <sonar.projectName>Cobranza</sonar.projectName>-->
      <!--  <sonar.projectVersion>master</sonar.projectVersion>-->
      <!--<sonar.test.exclusions>**/test/**/*.*</sonar.test.exclusions>-->
      <!--<sonar.exclusions>**/config/**/*.*,**/dto/**/*.*,**/model/**/*.*,**/utils/**/*.*</sonar.exclusions>-->
      </properties>
    </profile>
  </profiles>
</settings>
```

1.- Una vez cambiadas las rutas se debe volver a correr el mvn install.

```
mvn clean install
```

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
$docker build -t registry.gitlab.com/bs2managers/{component}:{release}_{enviroment} .
$docker push registry.gitlab.com/bs2managers/{component}:{release}_{enviroment}
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

* **Nelson Alvarado** - *Trabajo Inicial-Programación-Dcumentación* 

* **Fabian Rojas** - *Trabajo Inicial-Programación-Dcumentación* 

* **Sevastian Valenzuela** - *Trabajo Inicial-Programación-Dcumentación* 

* **Patricio Martinez** - *Trabajo Inicial-Programación-Dcumentación* 


## Agradecimientos


* Gracias a todos los participantes del proyecto, desde sus inicios hasta su fin.


