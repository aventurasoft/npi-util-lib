# Librerías utilitarias Portal Novaris (npi-util-lib)
Componentes comunes y utilitarios para los proyectos de Novaris Portal.

## Configuracion repositorio Maven corporativo
Para poder acceder a los artefactos de la plataforma es necesario generar la llave de acceso y configurar el archivo settings.xml incorporando en la seccion servers la siguiente configuracion:


```xml
<settings>
    <servers>
        ...
        <server>
            <id>github</id>
            <username>**reemplazar_usuario**</username>
            <password>**llave_generada**</password>
        </server>
        ...
    </servers>
</settings>

```
## Repositorio
El repositorio de la librería se encuentra en el siguiente enlace:

```xml
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/aventurasoft/npi-util-lib</url>
    </repository>
```

## Instalación
Para instalar la librería en un proyecto, se debe incorporar la dependencia en pom.xml:
```xml 
<dependency>
    <groupId>com.inttao.npi.backend.util</groupId>
    <artifactId>npi-util-lib</artifactId>
    <version>{$version}</version>
</dependency>
```
