create schema Dionisio ;
use Dionisio;

create table Dionisio.propriedade (
	nome varchar(40) primary key,
	adm varchar(40),
	endereço varchar(60)
);

create table Dionisio.telefone(
	nome varchar(40) not null,
    num varchar(11) primary key,
    foreign key(nome) references propriedade(nome)
    on delete cascade on update cascade
);

create table Dionisio.emails(
	nome varchar(40) not null,
    endereço varchar(25) primary key,
    foreign key(nome) references propriedade(nome)
    on delete cascade on update cascade
);

create table Dionisio.terroir(
	região varchar(20) primary key,
    solo varchar(15),
    altitude int,
    umidade int,
    indice_pluviometrico int,
    temp float,
    nome_propriedade varchar(40),
    foreign key(nome_propriedade) references propriedade(nome)
    on delete restrict on update cascade
);

create table Dionisio.cepa(
	nome varchar(40) primary key,
    região varchar(20)
);

create table Dionisio.parreiral(
	id int primary key,
    qtd_vinhas int,
    area int,
    data_plantio  date,
    nome_propriedade varchar(40),
    nome_cepa varchar(20),
    foreign key(nome_propriedade) references propriedade(nome)
    on delete cascade on update cascade,
    foreign key(nome_cepa) references cepa(nome) 
    on delete set null on update cascade
);

create table Dionisio.colheita(
	id int primary key,
    data_colheita date,
    material boolean, -- true para madeira, false para metal
    i_maturação date,
    f_maturação date,
    id_parreiral int,
    cepa_nome varchar(40),
    foreign key(id_parreiral) references parreiral(id)
    on delete set null on update cascade,
    foreign key(cepa_nome) references cepa(nome)
    on delete restrict on update cascade
);

create table Dionisio.vinho(
	id int primary key,
    nome varchar(30),
    classificação boolean, -- true para varietal, false para assemblage
    rotulo longblob
);

create table Dionisio.safra(
	id int ,
	ano year,
    quantidade int,
    id_vinho int,
    primary key(id_vinho,ano),
	unique(id),
    foreign key(id_vinho) references vinho(id)
    on delete restrict on update cascade
);

create table Dionisio.produção(
	id_colheita int,
    id_safra int,
    primary key(id_colheita, id_safra),
    foreign key(id_colheita) references colheita(id)
    on delete restrict on update cascade,
    foreign key(id_safra) references safra(id)
    on delete restrict on update cascade
);

create table Dionisio.avaliação(
	nome varchar(25),
    nota int,
    id_safra int,
    primary key (nome,id_safra),
    foreign key(id_safra) references safra(id)
    on delete cascade on update cascade
);
