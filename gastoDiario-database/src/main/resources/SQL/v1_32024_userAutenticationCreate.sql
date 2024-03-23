CREATE TABLE IF NOT EXISTS USER_AUTENTICATION
(
    id bigint not null auto_increment,
    user_id bigint,
    password varchar(1000) not null,
    primary key (id)
);

alter table user_autentication
    add constraint UK_6lfohw791k523geeug12wepng unique (user_id);

alter table user_autentication
    add constraint FK1hv7xw4kiyp96lf406dndidl9
        foreign key (user_id)
            references user (id);