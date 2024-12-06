# Manual para Compilar y Ejecutar un Servicio de Discovery con Spring Eureka

Este manual te guiará para compilar y ejecutar un **servicio de Discovery** basado en **Spring Eureka** utilizando Maven.


## Paso 1: Clonar o Acceder al Proyecto

Si aún no tienes el proyecto en tu máquina, clónalo o navega al directorio del proyecto. Usa el siguiente comando para clonar desde un repositorio (reemplaza `<repository-url>` con la URL de tu repositorio):

```bash
git clone https://github.com/Rincon10/AYGO-PROYECTO.git
```

luego, nos dirigimos a la carpeta

```bash
cd 01-discovery-service
```


## Paso 2: Compilar el Proyecto con Maven

n el directorio raíz del proyecto, ejecuta el siguiente comando 

```bash
mvn clean install
```

### Paso 3: Comandos para ejecutar la aplicacion 

Para ejecutar el proyecto usa el siguiente comando:

### Windows


```bash
java -cp "target/classes;target/dependency/*" com.escuelaing.edu.co.distribuited_systems.eureka.servicio_eureka_server.ServicioEurekaServerApplication
```

### Linux

```bash
java -cp "target/classes:target/dependency/*" com.escuelaing.edu.co.distribuited_systems.eureka.servicio_eureka_server.ServicioEurekaServerApplication
```

si, todo ejecuta de manera correcta deberia ver el siguiente log

![alt text](../docs/images/01-discovery-service/01-cmd-eureka.png)

y si accedemos a el puerto 8761, veremos todos los servicios suscritos

![alt text](../docs/images/01-discovery-service/02-eureka.png)

## Manual de creacion de imagen docker

vamos a crear la imagen docker:
### Comandos Docker

```bash 
docker build --tag miusuario/servicio-eureka:1.0 .
```

iniciando contenedor
```bash
docker run -d -p <puerto_host>:<puerto_contenedor> --name nombre_instancia <tu_usuario_docker>/<nombre_imagen>:<versión>
```

entonces ejecutamos 

```bash
docker run -d -p 8761:8761 --name instancia-eureka rincon10/discovery-service:1.0 
```


si todo sale bien veriamos que el contenedor se esta ejecutando de manera correcta con 

```bash
docker ps -a
```

![alt text](../docs/images/01-discovery-service/03-eureka-docker.png)


### publicando la imagen

Para publicar la imagen en Docker Hub, sigue estos pasos:

```bash
docker login
```

y luego 

```bash
docker push rincon10/discovery-service:1.0
```

### Configuracion en AWS

1. Acceda a la máquina virtual
2. Instale Docker

```bash
sudo yum update -y
sudo yum install docker
```
3. Inicie el servicio de docker

```bash
sudo service docker start
```
4. Configure su usuario en el grupo de docker para no tener que ingresar “sudo” cada vez que invoca un comando

```bash
sudo usermod -a -G docker ec2-user
```

5. Desconectese de la máquina virtual e ingrese nuevamente para que la configuración de grupos de usuarios tenga efecto.
6. A partir de la imagen creada en Dockerhub cree una instancia de un contenedor docker independiente de la consola (opción “-d”) y con el puerto 6000 enlazado a un puerto físico de su máquina (opción -p):

```bash
sudo docker run -d -p 8761:8761 --name instancia1-eureka rincon10/discovery-service:1.0 
```

7. Abra los puertos de entrada del security group de la máxima virtual para acceder al servicio


![alt text](../docs/images/01-discovery-service/04-eureka-aws.png)