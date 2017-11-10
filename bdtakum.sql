-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2017 a las 09:50:52
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdtakum`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cateprod`
--

CREATE TABLE `cateprod` (
  `CAPRCODI` int(3) NOT NULL,
  `CAPRNOMB` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `CAPRDESC` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `PRODCODI` int(3) NOT NULL,
  `PRODNOMB` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `PRODDESC` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `PRODCOST` int(10) NOT NULL,
  `PRODCAPR` int(3) NOT NULL,
  `PRODUSUA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `ROLIDENT` int(3) NOT NULL,
  `ROLNOMBR` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `ROLDESCR` varchar(100) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`ROLIDENT`, `ROLNOMBR`, `ROLDESCR`) VALUES
(1, 'Administrador', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non luctus tellus, quis tempus volutpat'),
(2, 'Caja', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non luctus tellus, quis tempus volutpat'),
(3, 'Asesoria', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non luctus tellus, quis tempus volutpat');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `USUACODI` int(3) NOT NULL,
  `USUATERC` int(20) NOT NULL,
  `USUANOMB` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `USUAAPEL` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `USUADIRE` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `USUAEMAI` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `USUAROL` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`USUACODI`, `USUATERC`, `USUANOMB`, `USUAAPEL`, `USUADIRE`, `USUAEMAI`, `USUAROL`) VALUES
(1, 123456, 'Pepito', 'Perez', 'prueba', 'mail@mail.com', 1),
(2, 4567890, 'Lolita', 'Muñoz', NULL, NULL, 3),
(4, 874356, 'Claudio', 'Perez', NULL, NULL, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cateprod`
--
ALTER TABLE `cateprod`
  ADD PRIMARY KEY (`CAPRCODI`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`PRODCODI`),
  ADD KEY `FK_PRODUSUA` (`PRODUSUA`),
  ADD KEY `FK_PRODCAPR` (`PRODCAPR`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`ROLIDENT`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`USUACODI`),
  ADD KEY `FK_USUAROL` (`USUAROL`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cateprod`
--
ALTER TABLE `cateprod`
  MODIFY `CAPRCODI` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `PRODCODI` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `ROLIDENT` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `USUACODI` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `FK_PRODCAPR` FOREIGN KEY (`PRODCAPR`) REFERENCES `cateprod` (`CAPRCODI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PRODUSUA` FOREIGN KEY (`PRODUSUA`) REFERENCES `usuario` (`USUACODI`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_USUAROL` FOREIGN KEY (`USUAROL`) REFERENCES `rol` (`ROLIDENT`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
