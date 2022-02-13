Java spring boot MVC
proyecto desarrollador en java spring boot (crud)+validacion(thymeleaf) en inputs

CRUD de usuarios con css de Bootstrap 5.1

--install run
Apache Maven 3.8.4
jdk-17.0.2
https://start.spring.io
Java 17

--dependecias de maven 
Spring Web 
MySQL Driver
Thymeleaf 
Spring Data JPA 
Spring Boot DevTools
Rest Repositories 

¡importante configurar el archivo properties para la conexcion mysql¡
necesitas crear en tu servidor Mysql esta tabla para poder correr el proyecto

CREATE TABLE `datosuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(255) NOT NULL,
  `Apellido` varchar(255) NOT NULL,
  `Telefono` varchar(40) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 |

