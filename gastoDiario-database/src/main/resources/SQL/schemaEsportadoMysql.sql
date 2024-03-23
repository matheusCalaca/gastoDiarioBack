CREATE DATABASE `gastodiario`;


CREATE TABLE `categoria`
(
    `id`   bigint NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `gasto`
(
    `data_compra`  date           DEFAULT NULL,
    `valor`        decimal(38, 2) DEFAULT NULL,
    `categoria_id` bigint         DEFAULT NULL,
    `id`           bigint NOT NULL AUTO_INCREMENT,
    `user_id`      bigint         DEFAULT NULL,
    `nome`         varchar(255)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKcsnc3vcoms1vm2k1a4xsrla6c` (`categoria_id`),
    KEY `FKnk8c8g83ornxgmf2iv29lxqwg` (`user_id`),
    CONSTRAINT `FKcsnc3vcoms1vm2k1a4xsrla6c` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
    CONSTRAINT `FKnk8c8g83ornxgmf2iv29lxqwg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `permision`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT,
    `permission` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_qdnliv08nvorxvknbrm6d50yu` (`permission`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `user`
(
    `id`    bigint       NOT NULL AUTO_INCREMENT,
    `cpf`   varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `nome`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_2qv8vmk5wxu215bevli5derq` (`cpf`),
    UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `user_autentication`
(
    `id`       bigint        NOT NULL AUTO_INCREMENT,
    `user_id`  bigint DEFAULT NULL,
    `password` varchar(1000) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_6lfohw791k523geeug12wepng` (`user_id`),
    CONSTRAINT `FK1hv7xw4kiyp96lf406dndidl9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `user_authentication_permission`
(
    `permission_id`          bigint NOT NULL,
    `user_authentication_id` bigint NOT NULL,
    KEY `FK15gpyl32h4c49qfkxspeiadpb` (`permission_id`),
    KEY `FK8e2e461cql38x09wsnhob3lel` (`user_authentication_id`),
    CONSTRAINT `FK15gpyl32h4c49qfkxspeiadpb` FOREIGN KEY (`permission_id`) REFERENCES `permision` (`id`),
    CONSTRAINT `FK8e2e461cql38x09wsnhob3lel` FOREIGN KEY (`user_authentication_id`) REFERENCES `user_autentication` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
