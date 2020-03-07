use dionisio;


#consulta 1:

SELECT *
FROM dionisio.vinho;

consulta 2:

SELECT s.*,a.nota,v.nome
FROM (dionisio.safra AS s LEFT OUTER JOIN dionisio.avaliação AS a ON a.id_safra=s.id)  JOIN  dionisio.vinho  AS v
WHERE s.id_vinho= "id" AND v.id= "id"
ORDER BY s.quantidade DESC ;

OU

SELECT s.*,a.nota,v.nome
FROM (dionisio.safra AS s LEFT OUTER JOIN dionisio.avaliação AS a ON a.id_safra=s.id)  JOIN  dionisio.vinho  AS v
WHERE s.id_vinho= "id" AND v.id= "id"
ORDER BY a.nota DESC ;

consulta 3:

SELECT 	dionisio.propriedade.nome, sum(dionisio.safra.quantidade)
FROM 	dionisio.propriedade, dionisio.parreiral,dionisio.colheita, dionisio.produção, dionisio.safra
WHERE 	dionisio.parreiral.nome_propriedade=dionisio.propriedade.nome AND
		colheita.id_parreiral=dionisio.parreiral.id AND
        dionisio.produção.id_colheita=dionisio.colheita.id AND
        dionisio.safra.id=dionisio.produção.id_safra AND
        dionisio.colheita.data_colheita like '2016%'
GROUP BY dionisio.propriedade.nome;

consulta 4:

SELECT distinct	dionisio.cepa.nome
FROM 	dionisio.cepa, dionisio.parreiral
WHERE 	dionisio.cepa.nome=dionisio.parreiral.nome_cepa AND
		dionisio.parreiral.nome_propriedade = "nome da propriedade";
	
consulta 5:

SELECT	A.n AS Cepa, A.c AS Colheita, MAX(A.q) AS Quantidade
FROM(
	SELECT	dionisio.colheita.cepa_nome AS n, dionisio.colheita.data_colheita AS c, SUM(dionisio.safra.quantidade) AS q
	FROM 	dionisio.produção, dionisio.colheita, dionisio.safra
	WHERE	dionisio.colheita.id=dionisio.produção.id_colheita AND
			dionisio.safra.id=produção.id_safra
	GROUP BY dionisio.colheita.cepa_nome, dionisio.colheita.data_colheita
    ORDER BY q DESC
)AS A
GROUP BY A.n
ORDER BY quantidade;

