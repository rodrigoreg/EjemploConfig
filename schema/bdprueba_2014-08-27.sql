# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: desarrollo.is.escuelaing.edu.co (MySQL 5.1.63-max)
# Database: bdprueba
# Generation Time: 2014-08-27 15:04:48 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ALM_CLIENTES
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ALM_CLIENTES`;

CREATE TABLE `ALM_CLIENTES` (
  `idcliente` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table ALM_DESPACHOS
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ALM_DESPACHOS`;

CREATE TABLE `ALM_DESPACHOS` (
  `iddespacho` int(11) NOT NULL AUTO_INCREMENT,
  `qrcode` blob,
  `VEHICULOS_placa` varchar(6) NOT NULL,
  `PEDIDOS_idpedido` int(11) NOT NULL,
  PRIMARY KEY (`iddespacho`),
  KEY `fk_DESPACHOS_VEHICULOS1` (`VEHICULOS_placa`),
  KEY `fk_DESPACHOS_PEDIDOS1` (`PEDIDOS_idpedido`),
  CONSTRAINT `fk_DESPACHOS_PEDIDOS1` FOREIGN KEY (`PEDIDOS_idpedido`) REFERENCES `ALM_PEDIDOS` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DESPACHOS_VEHICULOS1` FOREIGN KEY (`VEHICULOS_placa`) REFERENCES `ALM_VEHICULOS` (`placa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table ALM_DETALLES_PEDIDO
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ALM_DETALLES_PEDIDO`;

CREATE TABLE `ALM_DETALLES_PEDIDO` (
  `PRODUCTOS_idproducto` int(11) NOT NULL,
  `PEDIDOS_idpedido` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`PRODUCTOS_idproducto`,`PEDIDOS_idpedido`),
  KEY `fk_DETALLE_PEDIDO_PRODUCTOS1` (`PRODUCTOS_idproducto`),
  KEY `fk_DETALLES_PEDIDO_PEDIDOS1` (`PEDIDOS_idpedido`),
  CONSTRAINT `fk_DETALLES_PEDIDO_PEDIDOS12` FOREIGN KEY (`PEDIDOS_idpedido`) REFERENCES `ALM_PEDIDOS` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DETALLE_PEDIDO_PRODUCTOS12` FOREIGN KEY (`PRODUCTOS_idproducto`) REFERENCES `ALM_PRODUCTOS` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table ALM_PEDIDOS
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ALM_PEDIDOS`;

CREATE TABLE `ALM_PEDIDOS` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_radicacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `CLIENTES_idcliente` int(11) NOT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `fk_PEDIDOS_CLIENTES1` (`CLIENTES_idcliente`),
  CONSTRAINT `fk_PEDIDOS_CLIENTES1` FOREIGN KEY (`CLIENTES_idcliente`) REFERENCES `ALM_CLIENTES` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table ALM_PRODUCTOS
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ALM_PRODUCTOS`;

CREATE TABLE `ALM_PRODUCTOS` (
  `idproducto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` bigint(20) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table ALM_VEHICULOS
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ALM_VEHICULOS`;

CREATE TABLE `ALM_VEHICULOS` (
  `placa` varchar(6) NOT NULL,
  `capacidad` int(11) NOT NULL,
  PRIMARY KEY (`placa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
