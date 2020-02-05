create sequence toy_id_seq;

create table toys(

    id bigint primary key,
    name varchar(128) not null

);