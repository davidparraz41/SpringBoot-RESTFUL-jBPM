# Spring Boot-RESTFUL-jBPM

#### Resumen del proyecto:
La idea central del proyecto es construir una API REST de demostración, que sea capaz de realizar operaciones CRUD y administrar tareas y procesos BPM usando el conjunto de herramientas de Jbpm. 

El proyecto está construido sobre el Framework Spring, usando las tecnologías Spring Boot para configurar el proyecto, Spring Data para el acceso a los datos, las herramientas de Jbpm para la administración del proceso y tareas BPM y PostgreSQL como base de datos.

Para más detalles sobre el framework de Spring visite https://spring.io/

Para más detalles sobre jbpm puede acceder a la documentación oficial y  descargar el conjunto de herramientas completa desde aqui -> https://www.jbpm.org/

##### Requisitos del proyecto:
-	JDK 8 
-	MAVEN 3.3+
-	JBPM 7.23.0.Final
-	PostgreSQL 9.6
-	SoapUI 5.5.0

#### Escenario de prueba:
Un cliente necesita obtener una cotización del arriendo de una automóvil. Para esto por medio del sitio web de una empresa dedicada al arriendo de vehículos, de ahora en adelante“rentacar”envía una solicitud de cotización de un vehículo en particular. La solicitud de cotización es recibida por un ejecutivo de la empresa, quien la procesa y envía a sus superiores para ser aprobada. Una vez finalizado el proceso de la solicitud de cotización, se le enviara un email al cliente con la información solicitada. 
La regla de negocio de este proceso es la siguiente: 
Si cualquiera de los superiores del ejecutivo rechaza la cotización, esta será devuelta a al ejecutivo para que realice las correcciones correspondientes y deberá volver a ser revisada para su aprobación.
Para automatizar el proceso de solicitud de cotización del cliente usaremos las herramientas de jBPM, donde crearemos un proceso de negocio (Business Process) denominado“solicitudCotizacion”y crearemos las tereas necesarias para cumplir con los requisitos del negocio.

#### Configuración y ejecución del proyecto
La idea es que la configuración del proyecto sea ágil y centralizada, por lo tanto toda la configuración del proyecto la podemos encontrar en el archivo de propiedades application.properties y en la clase StartApplication.java. 
Para iniciar y probar las funcionalidades del proyecto se deben seguir los siguientes pasos de configuración:
1. 	Crear el usuario y la base de datos según el archivo de propiedades
2. 	Descargar e iniciar el servidor de jBPM.
3. 	Crear e importar el proceso de solicitud siguiendo las siguientes acciones:

###### Login -> Design -> MySpace -> Add Project[nombre: rentacar] -> Import Asset[cargar archivo “solicitudCotizacion.bpmn”] -> Deploy

4. Esta acción debería desplegar el nuevo proceso e iniciar el servidor de prueba para conectarnos a el e iniciar instancias de proceso y tareas.
5.  ejecutar los endpoint del archivo REST-SpringBoot-Rentacar
