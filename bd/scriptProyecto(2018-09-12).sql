-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.33-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para quotevent
DROP DATABASE IF EXISTS `quotevent`;
CREATE DATABASE IF NOT EXISTS `quotevent` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quotevent`;

-- Volcando estructura para tabla quotevent.ciudad
DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE IF NOT EXISTS `ciudad` (
  `id_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.ciudad: ~2 rows (aproximadamente)
DELETE FROM `ciudad`;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`id_ciudad`, `nombre`) VALUES
	(1, 'Bogotá'),
	(2, 'Medellin');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.clasificacion
DROP TABLE IF EXISTS `clasificacion`;
CREATE TABLE IF NOT EXISTS `clasificacion` (
  `id_clasificacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_clasificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.clasificacion: ~2 rows (aproximadamente)
DELETE FROM `clasificacion`;
/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` (`id_clasificacion`, `nombre`) VALUES
	(1, 'Familiar'),
	(2, 'Corporativo');
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `n_identificacion` bigint(20) NOT NULL,
  `tipo_documento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `ciudad` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`n_identificacion`),
  KEY `FK_cliente_tipo_documento` (`tipo_documento`),
  KEY `FK_cliente_ciudad` (`ciudad`),
  CONSTRAINT `FK_cliente_ciudad` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`id_ciudad`),
  CONSTRAINT `FK_cliente_tipo_documento` FOREIGN KEY (`tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.cliente: ~1 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`n_identificacion`, `tipo_documento`, `nombre`, `apellido`, `telefono`, `celular`, `direccion`, `ciudad`, `correo`, `estado`) VALUES
	(1030654523, 1, 'andres', 'parra', '4031608', '3112284864', 'cra 80 g bis No. 43 - 48 s', 1, 'caparra95@misena.edu.co', 'Activo');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.detalle_empleado
DROP TABLE IF EXISTS `detalle_empleado`;
CREATE TABLE IF NOT EXISTS `detalle_empleado` (
  `detalle_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `evento_id_evento` int(11) NOT NULL,
  `empleado_n_identificacion` bigint(20) NOT NULL,
  `calificacion` float NOT NULL,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`detalle_empleado`),
  KEY `FK_detalle_evento_evento` (`evento_id_evento`),
  KEY `FK_detalle_evento_empleado` (`empleado_n_identificacion`),
  CONSTRAINT `FK_detalle_evento_empleado` FOREIGN KEY (`empleado_n_identificacion`) REFERENCES `empleado` (`n_identificacion`),
  CONSTRAINT `FK_detalle_evento_evento` FOREIGN KEY (`evento_id_evento`) REFERENCES `evento` (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.detalle_empleado: ~0 rows (aproximadamente)
DELETE FROM `detalle_empleado`;
/*!40000 ALTER TABLE `detalle_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_empleado` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.detalle_producto_suministro
DROP TABLE IF EXISTS `detalle_producto_suministro`;
CREATE TABLE IF NOT EXISTS `detalle_producto_suministro` (
  `id_detalle_producto_suministro` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `id_suministro` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_producto_suministro`),
  KEY `id_producto` (`id_producto`),
  KEY `id_ingrediente` (`id_suministro`),
  CONSTRAINT `FK_detalle_producto_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `FK_detalle_producto_suministro` FOREIGN KEY (`id_suministro`) REFERENCES `suministro` (`id_suministro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.detalle_producto_suministro: ~0 rows (aproximadamente)
DELETE FROM `detalle_producto_suministro`;
/*!40000 ALTER TABLE `detalle_producto_suministro` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_producto_suministro` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.detalle_proveedor
DROP TABLE IF EXISTS `detalle_proveedor`;
CREATE TABLE IF NOT EXISTS `detalle_proveedor` (
  `id_detalle_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `proveedor_id_proveedor` int(11) NOT NULL,
  `producto_id_ingrediente` int(11) NOT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_proveedor`),
  KEY `FK_detalle_proveedor_proveedor` (`proveedor_id_proveedor`),
  KEY `FK_detalle_proveedor_ingrediente` (`producto_id_ingrediente`),
  CONSTRAINT `FK_detalle_proveedor_ingrediente` FOREIGN KEY (`producto_id_ingrediente`) REFERENCES `suministro` (`id_suministro`),
  CONSTRAINT `FK_detalle_proveedor_proveedor` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.detalle_proveedor: ~0 rows (aproximadamente)
DELETE FROM `detalle_proveedor`;
/*!40000 ALTER TABLE `detalle_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.empleado
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `n_identificacion` bigint(20) NOT NULL,
  `id_tipo_documento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cargo_id_cargo` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `barrio` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`n_identificacion`),
  KEY `FK_empleado_cargo` (`cargo_id_cargo`),
  KEY `FK_empleado_tipo_documento` (`id_tipo_documento`),
  CONSTRAINT `FK_empleado_cargo` FOREIGN KEY (`cargo_id_cargo`) REFERENCES `rol` (`id_rol`),
  CONSTRAINT `FK_empleado_tipo_documento` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.empleado: ~1 rows (aproximadamente)
DELETE FROM `empleado`;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`n_identificacion`, `id_tipo_documento`, `nombre`, `apellido`, `cargo_id_cargo`, `correo`, `direccion`, `telefono`, `barrio`, `estado`) VALUES
	(1030654523, 1, 'camilo', 'ochoa', 1, 'caparra95@misena.edu.co', 'calle 89', '5663241', 'britalia', 'Activo');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.estado_evento
DROP TABLE IF EXISTS `estado_evento`;
CREATE TABLE IF NOT EXISTS `estado_evento` (
  `id_estado_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_estado_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.estado_evento: ~4 rows (aproximadamente)
DELETE FROM `estado_evento`;
/*!40000 ALTER TABLE `estado_evento` DISABLE KEYS */;
INSERT INTO `estado_evento` (`id_estado_evento`, `nombre`) VALUES
	(1, 'Aprobado'),
	(2, 'Abonado'),
	(3, 'Cancelado'),
	(4, 'Finalizado');
/*!40000 ALTER TABLE `estado_evento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.evento
DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `solicitud_id_solicitud` int(11) NOT NULL DEFAULT '0',
  `cliente_id_cliente` bigint(20) NOT NULL DEFAULT '0',
  `tipo_evento` int(11) NOT NULL DEFAULT '0',
  `id_lugar` int(11) NOT NULL DEFAULT '0',
  `cantidad_personas` int(11) NOT NULL DEFAULT '0',
  `cantidad_meseros` int(11) NOT NULL DEFAULT '0',
  `hora_inicio` time NOT NULL DEFAULT '00:00:00',
  `hora_fin` time NOT NULL DEFAULT '00:00:00',
  `fecha` date NOT NULL,
  `precio` double NOT NULL,
  `observaciones` text,
  `estado_evento` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `FK_evento_solicitud` (`solicitud_id_solicitud`),
  KEY `FK_evento_cliente` (`cliente_id_cliente`),
  KEY `FK_evento_estado` (`estado_evento`),
  KEY `FK_evento_tipo` (`tipo_evento`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `FK_evento_cliente` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `cliente` (`n_identificacion`),
  CONSTRAINT `FK_evento_estado` FOREIGN KEY (`estado_evento`) REFERENCES `estado_evento` (`id_estado_evento`),
  CONSTRAINT `FK_evento_lugar` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id_lugar`),
  CONSTRAINT `FK_evento_solicitud` FOREIGN KEY (`solicitud_id_solicitud`) REFERENCES `solicitud` (`id_solicitud`),
  CONSTRAINT `FK_evento_tipo` FOREIGN KEY (`tipo_evento`) REFERENCES `tipo_evento` (`id_tipo_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.evento: ~0 rows (aproximadamente)
DELETE FROM `evento`;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.lugar
DROP TABLE IF EXISTS `lugar`;
CREATE TABLE IF NOT EXISTS `lugar` (
  `id_lugar` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `cantidad_persona_max` int(11) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ubicacion` varchar(200) DEFAULT NULL,
  `contacto` varchar(100) DEFAULT NULL,
  `telefono_contacto` varchar(50) DEFAULT NULL,
  `id_ciudad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_lugar`),
  KEY `id_ciudad` (`id_ciudad`),
  CONSTRAINT `FK_lugar_ciudad` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.lugar: ~1 rows (aproximadamente)
DELETE FROM `lugar`;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` (`id_lugar`, `nombre`, `descripcion`, `cantidad_persona_max`, `direccion`, `ubicacion`, `contacto`, `telefono_contacto`, `id_ciudad`) VALUES
	(1, 'parque los novios', 'parque tematico', 50, 'calle 63 ', 'Bogotá', 'andres lopez', '45456445', 1);
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.medida_producto
DROP TABLE IF EXISTS `medida_producto`;
CREATE TABLE IF NOT EXISTS `medida_producto` (
  `id_medida` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_medida`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.medida_producto: ~7 rows (aproximadamente)
DELETE FROM `medida_producto`;
/*!40000 ALTER TABLE `medida_producto` DISABLE KEYS */;
INSERT INTO `medida_producto` (`id_medida`, `nombre`) VALUES
	(1, 'kilogramos'),
	(2, 'Libras'),
	(3, 'Botellas'),
	(4, 'Litros'),
	(5, 'Gramos'),
	(6, 'Onzas'),
	(7, 'Porcion');
/*!40000 ALTER TABLE `medida_producto` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.paquete
DROP TABLE IF EXISTS `paquete`;
CREATE TABLE IF NOT EXISTS `paquete` (
  `id_paquete` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `clasificacion` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL DEFAULT '',
  `lugar` int(11) DEFAULT NULL,
  `cantidad_personas` int(11) NOT NULL,
  `precio` double NOT NULL,
  `pdf` varchar(50) NOT NULL,
  `foto` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_paquete`),
  KEY `FK_paquete_clasificacion` (`clasificacion`),
  KEY `lugar` (`lugar`),
  CONSTRAINT `FK_paquete_clasificacion` FOREIGN KEY (`clasificacion`) REFERENCES `clasificacion` (`id_clasificacion`),
  CONSTRAINT `FK_paquete_lugar` FOREIGN KEY (`lugar`) REFERENCES `lugar` (`id_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.paquete: ~1 rows (aproximadamente)
DELETE FROM `paquete`;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` (`id_paquete`, `nombre`, `clasificacion`, `descripcion`, `lugar`, `cantidad_personas`, `precio`, `pdf`, `foto`, `estado`) VALUES
	(1, 'sdasd', 1, 'asdas', 1, 12, 12, 'logo 5.png', 'logo 5.png', 'Activo');
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.pedido
DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `producto_id_producto` int(11) NOT NULL DEFAULT '0',
  `proveedor_id_proveedor` int(11) NOT NULL DEFAULT '0',
  `fecha_pedido` date NOT NULL,
  `cantidad` varchar(20) NOT NULL DEFAULT '0',
  `gramaje` int(11) NOT NULL DEFAULT '0',
  `observaciones` varchar(150) DEFAULT '0',
  `fecha_sugerida` varchar(150) DEFAULT '0',
  `estado` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_pedido`),
  KEY `FK_pedido_producto` (`producto_id_producto`),
  KEY `FK_pedido_proveedor` (`proveedor_id_proveedor`),
  KEY `FK_gramaje_medida_producto` (`gramaje`),
  CONSTRAINT `FK_gramaje_medida_producto` FOREIGN KEY (`gramaje`) REFERENCES `medida_producto` (`id_medida`),
  CONSTRAINT `FK_pedido_producto` FOREIGN KEY (`producto_id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `FK_pedido_proveedor` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.pedido: ~4 rows (aproximadamente)
DELETE FROM `pedido`;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` (`id_pedido`, `producto_id_producto`, `proveedor_id_proveedor`, `fecha_pedido`, `cantidad`, `gramaje`, `observaciones`, `fecha_sugerida`, `estado`) VALUES
	(1, 1, 1, '2015-01-17', '20', 1, 'urgente', '18/01/2015', 'Activo'),
	(2, 2, 2, '2015-01-17', '20', 3, 'urgente', '19/01/2015', 'Activo'),
	(3, 3, 3, '2015-01-17', '20', 1, 'urgente', '20/01/2015', 'Activo'),
	(4, 3, 3, '2015-03-01', '24', 1, 'nose', '04/03/2015', 'Activo');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.producto
DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `foto` varchar(50) NOT NULL,
  `tipo` int(11) NOT NULL,
  `cantidad_minima` int(11) NOT NULL,
  `medida` int(11) NOT NULL,
  `precio_unidad` double NOT NULL,
  `observaciones` text,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FK_producto_medida_producto` (`medida`),
  KEY `FK_producto_tipo_producto` (`tipo`),
  CONSTRAINT `FK_producto_medida_producto` FOREIGN KEY (`medida`) REFERENCES `medida_producto` (`id_medida`),
  CONSTRAINT `FK_producto_tipo_producto` FOREIGN KEY (`tipo`) REFERENCES `tipo_producto` (`id_tipo_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.producto: ~4 rows (aproximadamente)
DELETE FROM `producto`;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id_producto`, `nombre`, `foto`, `tipo`, `cantidad_minima`, `medida`, `precio_unidad`, `observaciones`, `estado`) VALUES
	(1, 'Arroz Con Leche', '', 1, 10, 7, 3000, 'bueno', 'Activo'),
	(2, 'Vino Tinto', '', 2, 15, 3, 20000, 'rico', 'Activo'),
	(3, 'Mesa decoracion', '', 3, 10, 1, 200000, 'elegantes', 'Activo'),
	(16, 'vino añejo', '', 2, 10, 1, 20000, 'nose', 'Activo');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.proveedor
DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.proveedor: ~3 rows (aproximadamente)
DELETE FROM `proveedor`;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`id_proveedor`, `razon_social`, `direccion`, `telefono`, `correo`, `estado`) VALUES
	(1, 'Arroz Roa', 'calle 20', '9654781', 'caparra95@misena.edu.co', 'Activo'),
	(2, 'Vinos S.A', 'cra 50 ', '465871', 'caparra95@misena.edu.co', 'Activo'),
	(3, 'Mesas S.A', 'calle 40', '7569841', 'caparra95@misena.edu.co', 'Activo');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.solicitud
DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE IF NOT EXISTS `solicitud` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(50) NOT NULL DEFAULT '0',
  `cantidad_personas` int(11) DEFAULT '0',
  `telefono` varchar(20) DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `id_tipo_evento` int(11) NOT NULL DEFAULT '0',
  `hora` varchar(10) DEFAULT '0',
  `fecha` date DEFAULT NULL,
  `observaciones` varchar(150) NOT NULL DEFAULT '0',
  `estado` varchar(20) NOT NULL DEFAULT '0',
  `visto` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_solicitud`),
  KEY `FK_solicitud_tipo_evento` (`id_tipo_evento`),
  CONSTRAINT `FK_solicitud_tipo_evento` FOREIGN KEY (`id_tipo_evento`) REFERENCES `tipo_evento` (`id_tipo_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.solicitud: ~1 rows (aproximadamente)
DELETE FROM `solicitud`;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` (`id_solicitud`, `nombre_cliente`, `cantidad_personas`, `telefono`, `email`, `id_tipo_evento`, `hora`, `fecha`, `observaciones`, `estado`, `visto`) VALUES
	(1, 'camilo', 123, '3112284864', 'caparra95@misena.edu.co', 1, '2 pm', '2015-02-24', 'nose', 'Activo', 1);
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.suministro
DROP TABLE IF EXISTS `suministro`;
CREATE TABLE IF NOT EXISTS `suministro` (
  `id_suministro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT '0',
  `foto` varchar(50) DEFAULT '0',
  `cantidad` int(11) DEFAULT '0',
  `cantidad_minima` int(11) DEFAULT '0',
  `medida` int(11) DEFAULT '0',
  `precio_unidad` int(11) DEFAULT '0',
  `observaciones` varchar(50) DEFAULT '0',
  `estado` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_suministro`),
  KEY `medida` (`medida`),
  CONSTRAINT `FK_ingrediente_medida` FOREIGN KEY (`medida`) REFERENCES `medida_producto` (`id_medida`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.suministro: ~2 rows (aproximadamente)
DELETE FROM `suministro`;
/*!40000 ALTER TABLE `suministro` DISABLE KEYS */;
INSERT INTO `suministro` (`id_suministro`, `nombre`, `foto`, `cantidad`, `cantidad_minima`, `medida`, `precio_unidad`, `observaciones`, `estado`) VALUES
	(1, 'arroz', '0', 20, 10, 1, 2000, 'arroz diana', 'Activo'),
	(2, 'leche', '0', 30, 10, 4, 2500, 'leche deslactosada', 'Activo');
/*!40000 ALTER TABLE `suministro` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.tipo_documento
DROP TABLE IF EXISTS `tipo_documento`;
CREATE TABLE IF NOT EXISTS `tipo_documento` (
  `id_tipo_documento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_documento` varchar(50) NOT NULL DEFAULT '0',
  `abreviatura` varchar(3) NOT NULL,
  PRIMARY KEY (`id_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.tipo_documento: ~1 rows (aproximadamente)
DELETE FROM `tipo_documento`;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` (`id_tipo_documento`, `descripcion_documento`, `abreviatura`) VALUES
	(1, 'Cédula de Ciudadanía', 'CC');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.tipo_evento
DROP TABLE IF EXISTS `tipo_evento`;
CREATE TABLE IF NOT EXISTS `tipo_evento` (
  `id_tipo_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_tipo_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.tipo_evento: ~2 rows (aproximadamente)
DELETE FROM `tipo_evento`;
/*!40000 ALTER TABLE `tipo_evento` DISABLE KEYS */;
INSERT INTO `tipo_evento` (`id_tipo_evento`, `nombre`) VALUES
	(1, 'Familiar'),
	(2, 'Corporativo');
/*!40000 ALTER TABLE `tipo_evento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.tipo_producto
DROP TABLE IF EXISTS `tipo_producto`;
CREATE TABLE IF NOT EXISTS `tipo_producto` (
  `id_tipo_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipo_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.tipo_producto: ~4 rows (aproximadamente)
DELETE FROM `tipo_producto`;
/*!40000 ALTER TABLE `tipo_producto` DISABLE KEYS */;
INSERT INTO `tipo_producto` (`id_tipo_producto`, `nombre`) VALUES
	(1, 'Alimento'),
	(2, 'Licor'),
	(3, 'Menaje'),
	(4, 'Servicio');
/*!40000 ALTER TABLE `tipo_producto` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `empleado_n_identificacion` bigint(20) NOT NULL DEFAULT '0',
  `usuario` varchar(50) NOT NULL DEFAULT '0',
  `contrasenia` varchar(50) NOT NULL DEFAULT '0',
  `estado` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_usuario`),
  KEY `FK_usuario_empleado` (`empleado_n_identificacion`),
  CONSTRAINT `FK_usuario_empleado` FOREIGN KEY (`empleado_n_identificacion`) REFERENCES `empleado` (`n_identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.usuario: ~1 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `empleado_n_identificacion`, `usuario`, `contrasenia`, `estado`) VALUES
	(1, 1030654523, 'gerente', '740d9c49b11f3ada7b9112614a54be41', 'Activo');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
