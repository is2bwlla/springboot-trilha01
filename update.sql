alter table tbinstrutores
       add column ativo bool not null;

    create table tbaprendizes (
        id integer not null auto_increment,
        curso enum ('ADM','DS','MANUFATURA','MECATRONICA'),
        edv varchar(255),
        email varchar(255),
        ferias bit,
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;
