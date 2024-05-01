create table usuarios(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    sobrenome varchar(100) not null,
    email varchar(100) not null,
    login varchar(100) not null,
    senha varchar(255) not null,
    created_at date not null,


    primary key(id)
)