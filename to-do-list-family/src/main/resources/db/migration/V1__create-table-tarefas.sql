create table tarefas(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    descricao varchar(500) not null,
    status varchar(10) not null,
    primary key(id)
)