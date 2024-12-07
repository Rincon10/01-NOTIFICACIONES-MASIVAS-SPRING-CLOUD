# Notification service

lo primero que haremos sera crear el topic en SNS de aws 
![alt text](../docs/images/04-notification-service/02-creacion-topic.png)



en nuestro caso lo llamamos Customer Notifications
![alt text](../docs/images/04-notification-service/01-creacion-topic.png)


para la integracion con nuestra aplicacion java, usaremos informacion que nos proporciona AWS

![alt text](../docs/images/04-notification-service/03-creacion-topic.png)


Ponemos a ejecutar nuestro servicio

![alt text](../docs/images/04-notification-service/05-ejecucion.png)

y hacemos una peticion para validar su funcionamiento

![alt text](../docs/images/04-notification-service/04-peticion-local.png)

ahora subiremos mas instancias del servicio, para validar su capacidad de escalabilidad
![alt text](../docs/images/04-notification-service/06-ejecucion-multiple-2.png)


validamos en el discovery cuantas instancias tiene
![alt text](../docs/images/04-notification-service/06-ejecucion-multiple-1.png)


