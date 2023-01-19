create table cliente(
    id bigserial, -- serial e suas versões são o auto increment do postgresql
    nome varchar(50),
    email varchar(50),
    telefone varchar(20),

    primary key(id)
);