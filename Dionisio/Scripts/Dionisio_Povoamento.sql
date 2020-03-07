use dionisio;
insert into dionisio.cepa values(
	"Aligoté",
    "França"
);

insert into dionisio.cepa values(
	"Barbera",
    "Italia"
);

insert into dionisio.cepa values(
	"Brunello",
    "Italia"
);

insert into dionisio.cepa values(
	"Cabernet Franc",
    "França"
);

insert into dionisio.cepa values(
	"Zinfandel",
    "Estados Unidos"
);

insert into dionisio.cepa values(
	"Sauvignon Blanc",
    "França"
);

insert into dionisio.cepa values(
	"Tannat",
    "Portugal"
);

insert into dionisio.cepa values(
	"Trincadeira",
    "Portugal"
);

insert into dionisio.propriedade values(
	"Maison Blanche",
    "Ariadne",
    "Borgonha, França"
);

insert into dionisio.propriedade values(
	"Casa Vermelha",
    "Castor",
    "Alentejo, Portugal"
);

insert into dionisio.propriedade values(
	"Green House",
    "Pollux",
    "California, EUA"
);

insert into dionisio.propriedade values(
	"Casa Nera",
    "Estáfilo",
    "Piemonte, Italia"
);

insert into dionisio.telefone values(
	"Maison Blanche",
    1234567891
);

insert into dionisio.emails values(
	"Maison Blanche",
    "mblanche@olympus.com"
);

insert into dionisio.telefone values(
	"Casa Vermelha",
    1098765432
);

insert into dionisio.emails values(
	"Casa Vermelha",
    "cvermelha@olympus.com"
);

insert into dionisio.telefone values(
	"Green House",
    1234109876
);

insert into dionisio.emails values(
	"Green House",
    "ghouse@olympus.com"
);

insert into dionisio.telefone values(
	"Casa Nera",
    1178910123
);

insert into dionisio.emails values(
	"Casa Nera",
    "cnera@olympus.com"
);

insert into dionisio.terroir values(
	"França",
    "Humífero",
    "79",
    "75",
    "700",
    "15",
    "Maison Blanche"
);

insert into dionisio.terroir values(
	"Italia",
    "Humífero",
    "139",
    "78",
    "798",
    "15.7",
    "Casa Nera"
);

insert into dionisio.terroir values(
	"Portugal",
    "Argiloso",
    "112",
    "68",
    "650",
    "18",
    "Casa Vermelha"
);

insert into dionisio.terroir values(
	"Estados Unidos",
    "Argiloso",
    "126",
    "69",
    "675",
    "25",
    "Green House"
);

insert into dionisio.parreiral values(
	1,
    30,
    200,
    20170101,
    "Maison blanche",
    "Aligoté"
);

insert into dionisio.parreiral values(
	2,
    25,
    180,
    20170101,
    "Maison Blanche",
    "Cabernet Franc"
);

insert into dionisio.parreiral values(
	3,
    30,
    210,
    20170101,
    "Maison Blanche",
    "Sauvignon Blanc"
);

insert into dionisio.parreiral values(
	4,
    30,
    220,
    20170101,
    "Casa Nera",
    "Barbera"
);

insert into dionisio.parreiral values(
	5,
    40,
    250,
    20170101,
    "Casa Nera",
    "Brunello"
);

insert into dionisio.parreiral values(
	6,
    40,
    260,
    20170101,
    "Casa Vermelha",
    "Tannat"
);

insert into dionisio.parreiral values(
	7,
    50,
    300,
    20170101,
    "Casa Vermelha",
    "Trincadeira"
);

insert into dionisio.parreiral values(
	8,
    45,
    300,
    20170101,
    "Green House",
    "Zinfandel"
);

insert into dionisio.parreiral values(
	9,
    45,
    300,
    20170101,
    "Green House",
    "Zinfandel"
);

insert into dionisio.colheita values(
	1,
    20161231,
    true,
    20170101,
    20170201,
    1,
    "Aligoté"
);

insert into dionisio.colheita values(
	2,
    20161231,
    true,
    20170101,
    20170201,
    2,
    "Cabernet Franc"
);

insert into dionisio.colheita values(
	3,
    20161231,
    true,
    20170101,
    20170201,
    3,
    "Sauvignon Blanc"
);

insert into dionisio.colheita values(
	4,
    20161231,
    false,
    20170101,
    20170201,
    4,    
    "Barbera"
);

insert into dionisio.colheita values(
	5,
    20161231,
    false,
    20170101,
    20170201,
    5,
    "Brunello"
);

insert into dionisio.colheita values(
	6,
    20161231,
    false,
    20170101,
    20170201,
    6,
    "Tannat"
);

insert into dionisio.colheita values(
	7,
    20161231,
    false,
    20170101,
    20170201,
    7,
    "Trincadeira"
);

insert into dionisio.colheita values(
	8,
    20161231,
    false,
    20170101,
    20170201,
    8,
    "Zinfandel"
);

insert into dionisio.colheita values(
	9,
    20161231,
    false,
    20170101,
    20170201,
    9,
    "Zinfandel"
);

insert into dionisio.vinho values(
	1,
    "Bourgogne Aligoté",
    true,
    
);

insert into dionisio.vinho (id, nome, classificação) values(
	2,
    "Jean Bouchard Chablis",
    false
);

insert into dionisio.vinho (id, nome, classificação) values(
	3,
    "Castellani Primitivo",
    true
);

insert into dionisio.vinho (id, nome, classificação) values(
	4,
    "San Silvestro Primeira Rosso",
    true
);

insert into dionisio.vinho (id, nome, classificação) values(
	5,
    "Monte Da Ravasqueira",
    false
);

insert into dionisio.vinho (id, nome, classificação) values(
	6,
    "Concha Y Toro Reservado",
    true
);

insert into dionisio.safra values(
	1,
	1980,
    200,
    1
);

insert into dionisio.safra values(
	2,
	1940,
    250,
    2
);

insert into dionisio.safra values(
	3,
	1910,
    200,
    3
);

insert into dionisio.safra values(
	4,
	2000,
    300,
    4
);
insert into dionisio.safra values(
	5,
	1975,
	150,
    5
);

insert into dionisio.safra values(
	6,
	1988,
    600,
    6
);

insert into dionisio.produção values(
	1,
    1
);

insert into dionisio.produção values(
	2,
    2
);

insert into dionisio.produção values(
	3,
    2
);

insert into dionisio.produção values(
	4,
    3
);

insert into dionisio.produção values(
	5,
    4
);

insert into dionisio.produção values(
	6,
    5
);

insert into dionisio.produção values(
	7,
    5
);

insert into dionisio.produção values(
	8,
    6
);

insert into dionisio.produção values(
	9,
    6
);

insert into dionisio.avaliação values(
	"Wine Spectator",
    98,
    1
);

insert into dionisio.avaliação values(
	"Robert Parker",
    91,
    1
);

insert into dionisio.avaliação values(
	"Wine Spectator",
    97,
    2
);

insert into dionisio.avaliação values(
	"Wine Enthusiast",
    96,
    2
);

insert into dionisio.avaliação values(
	"Robert Parker",
    90,
    3
);

insert into dionisio.avaliação values(
	"Wine Enthusiast",
    91,
    3
);

insert into dionisio.avaliação values(
	"Robert Parker",
    99,
    4
);

insert into dionisio.avaliação values(
	"Wine Enthusiast",
    89,
    4
);

insert into dionisio.avaliação values(
	"Wine Spectator",
    92,
    5
);

insert into dionisio.avaliação values(
	"Wine Enthusiast",
    93,
    5
);

insert into dionisio.avaliação values(
	"Wine Spectator",
    85,
    6
);

insert into dionisio.avaliação values(
	"Wine Enthusiast",
    89,
    6
);

insert into dionisio.safra values(
	7,
	1933,
    3000,
    6
);

insert into dionisio.colheita values(
	10,
    20170101,
    false,
    20170101,
    20170201,
    9,
    "Trincadeira"
);

insert into dionisio.produção values(
	10,
    7
);
