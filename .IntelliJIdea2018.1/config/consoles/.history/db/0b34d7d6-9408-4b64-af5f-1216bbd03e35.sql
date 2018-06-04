use STALIN;
;-- -. . -..- - / . -. - .-. -.--
CREATE TABLE `permisos` (
  `id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;