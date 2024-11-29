# AYGO-PROYECTO

## Arquitectura propuesta 

![alt text](docs/images/02-componentes.drawio.png)


### Backend Facade (Gateway)
- Una aplicación Spring Boot que actúa como la puerta de enlace API, desplegada en una instancia EC2 independiente.
- Este componente gestionará y dirigirá las solicitudes entrantes desde el cliente. Recibirá solicitudes POST del front-end, las validará y luego las enviará al servicio batch.

### Servicio Batch (Spring Batch)
- Una aplicación para procesamiento batch implementada en Java y desplegada utilizando Docker. Manejará la lógica de leer, procesar y enviar los datos que se encuentren en db para el servicio de notificacion.

- El batch  interactuará con una base de datos relacional para recuperar formas de contacto como correos a enviar.
- El batch procesara la data leida y la enviara la solicitud al servicio de notificaciones

### Servicio Notificaciones 
- Servicio especializado a recibir peticiones para envio de correos.

### Load Balancer (Spring Cloud Gateway)
- Balanceador de carga que se encargara de distribuir las peticiones enviadas por el batch al servicio de notificaciones, usando el algoritmo Round Robin

### Servicio Discovery (Spring Cloud Netflix)

- Actúa como un servicio de registro de servicios donde cada instancia de un servicio se registra para que otros servicios puedan encontrarla y se puedan comunicar de manera distribuida.


### Servicio configuracion (Spring Cloud Config)

- Servicio que almacena la configuracion de los servicios, funcionando como un middleware entre los microservicios y el repositorio, para obtener la configuracion.