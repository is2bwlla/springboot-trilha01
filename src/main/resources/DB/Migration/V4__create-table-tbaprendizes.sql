create table tbaprendizes (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    edv varchar(100) not null,
    curso varchar(100) not null,
    ferias bool not null,
    primary key (id)
);