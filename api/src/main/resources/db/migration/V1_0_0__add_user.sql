create table user
(
    user_id   bigint not null,
    city      varchar(255),
    street    varchar(255),
    zipcode   varchar(255),
    birthday  datetime(6),
    create_at datetime(6),
    email     varchar(255),
    nick_name varchar(255),
    password  varchar(255),
    role      varchar(255),
    text_id   varchar(255),
    primary key (user_id)
);