CREATE TABLE IF NOT EXISTS USER
(
    id bigint not null auto_increment,
    cpf varchar(255) not null,
    email varchar(255) not null,
    nome varchar(255) not null,
    primary key (id)
);
