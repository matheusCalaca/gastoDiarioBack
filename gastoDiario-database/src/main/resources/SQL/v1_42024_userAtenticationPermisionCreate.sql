CREATE TABLE IF NOT EXISTS USER_AUTENTICATION_PERMISSION
(
    permission_id bigint not null,
    user_authentication_id bigint not null
);

ALTER TABLE `gastodiario`.`user_autentication_permission`
    ADD INDEX `FK15gpyl32h4c49qfkxspeiadpb_idx` (`permission_id` ASC) VISIBLE,
    ADD INDEX `FK8e2e461cql38x09wsnhob3lel_idx` (`user_authentication_id` ASC) VISIBLE;
;
ALTER TABLE `gastodiario`.`user_autentication_permission`
    ADD CONSTRAINT `FK15gpyl32h4c49qfkxspeiadpb`
        FOREIGN KEY (`permission_id`)
            REFERENCES `gastodiario`.`permision` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT `FK8e2e461cql38x09wsnhob3lel`
        FOREIGN KEY (`user_authentication_id`)
            REFERENCES `gastodiario`.`user_autentication` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
