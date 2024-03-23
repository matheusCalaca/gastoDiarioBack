CREATE TABLE IF NOT EXISTS gasto
(
    data_compra  date,
    valor        decimal(38, 2),
    categoria_id bigint,
    id           bigint not null,
    user_id      bigint,
    nome         varchar(255),
    primary key (id)
);

alter table gasto
    add constraint FKcsnc3vcoms1vm2k1a4xsrla6c
        foreign key (categoria_id)
            references categoria (id);

alter table gasto
    add constraint FKnk8c8g83ornxgmf2iv29lxqwg
        foreign key (user_id)
            references user (id);
