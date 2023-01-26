create table ocorrencia(
    id bigserial not null,
    entrega_id bigserial not null,
    descricao text not null,
    data_registro timestamp not null,

    primary key (id)
);

alter table ocorrencia add constraint fk_ocorrencia_entrega foreign key (entrega_id) references entrega (id);