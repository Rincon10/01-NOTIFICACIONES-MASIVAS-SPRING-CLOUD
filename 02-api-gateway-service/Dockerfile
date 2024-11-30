FROM openjdk:22
WORKDIR /usrapp/bin
COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency
CMD ["java","-cp","./classes:./dependency/*","com.escuelaing.edu.co.distribuited_systems.servicio_gateway.ServicioGatewayApplication"]