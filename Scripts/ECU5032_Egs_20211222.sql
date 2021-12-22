ALTER TABLE sit_qry_egs_04 SET SCHEMA sit_ecu5032_2021;
ALTER TABLE sit_qry_larvae_04 SET SCHEMA sit_ecu5032_2021;
SELECT min(d_dte_clc), max(d_dte_clc), count(*) FROM sit_ecu5032_2021.sit_qry_01_field_egs_02;
SELECT min(d_dte_clc), max(d_dte_clc), count(*) FROM sit_ecu5032_2021.sit_qry_01_field_egs; 	
 	
 WITH
 tmp01 AS (
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_01
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_02
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_03
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_04
 ORDER BY 6,7)
 SELECT 
 DISTINCT "Fecha colecta" 
 FROM tmp01
 
 
 -- Vista general (consolidada de huevos) de campo
 CREATE OR REPLACE VIEW sit_ecu5032_2021.sit_qry_01_egs_gnr_field AS 
 WITH
 tmp01 AS (
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_01
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_02
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_03
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_04
 ORDER BY 6,7)
 SELECT
 	to_date("Fecha instalacion",'yyyy-MM-dd') AS d_dte_set,
 	to_date("Fecha colecta",'yyyy-MM-dd') AS d_dte_clc,
 	BTRIM("Localidad") AS s_ste_nme,
 	sif_sql(length(BTRIM("Ovitrampa")::text) = 2, "left"(BTRIM("Ovitrampa")::text, 1), "left"(BTRIM("Ovitrampa")::text, 2))::smallint AS i_trp_nmb,
    "right"(BTRIM("Ovitrampa")::text, 1) AS s_trp_ltr,
 	--"CANTIDAD"::smallint,
 	"ENTEROS"::SMALLINT AS i_nmb_egs_int,
 	 iif_sql("ROT0S" = 'O', 0 , "ROT0S"::integer)::integer AS i_nmb_egs_brk,
 	(iif_sql("ROT0S" = 'O', 0 , "ROT0S"::integer)::integer + "ENTEROS"::smallint) AS i_nmb_egs_ttl,
 	--sif_sql((iif_sql("ROT0S" = 'O', 0 , "ROT0S"::integer)::integer + "ENTEROS"::smallint) = "CANTIDAD"::SMALLINT, 'SI','NO'),
 	Count(*) AS i_ttl_rpt
 FROM tmp01
 WHERE 
 	"Fecha instalacion"::date IS NOT NULL 
 	AND "Type"::text = 'Field'::TEXT
 GROUP BY 
 	"Localidad",
 	"Ovitrampa",
 	"Fecha instalacion",
 	"Fecha colecta",
 	"CANTIDAD",
 	"ROT0S",
 	"ENTEROS"
 ORDER BY 1,2,3,4,5;

 CREATE OR REPLACE VIEW sit_ecu5032_2021.sit_qry_01_egs_gnr_field_ttl_miramar AS 
 SELECT 
 	i_trp_nmb,
 	s_trp_ltr,
 	Sum(i_nmb_egs_ttl) AS i_nmb_egs_ttl
 FROM sit_ecu5032_2021.sit_qry_01_egs_gnr_field
 WHERE s_ste_nme = 'Miramar'
 GROUP BY 1,2
 
  CREATE OR REPLACE VIEW sit_ecu5032_2021.sit_qry_01_egs_gnr_field_ttl_bellavista AS 
 SELECT 
 	i_trp_nmb,
 	s_trp_ltr,
 	Sum(i_nmb_egs_ttl) AS i_nmb_egs_ttl
 FROM sit_ecu5032_2021.sit_qry_01_egs_gnr_field
 WHERE s_ste_nme = 'Bellavista'
 GROUP BY 1,2
 
CREATE OR REPLACE VIEW sit_ecu5032_2021.sit_qry_01_egs_gnr_field_ttl_avr AS 
 SELECT
    "right"(smn_epd(date_part('year'::text,d_dte_clc)::numeric, date_part('month'::text, d_dte_clc)::numeric, date_part('day'::text, d_dte_clc)::numeric)::text, 2)::SMALLINT AS i_epi_wk,
    s_ste_nme,
 	round(avg(i_nmb_egs_ttl),2) AS i_nmb_egs_avr
 FROM sit_ecu5032_2021.sit_qry_01_egs_gnr_field
 GROUP BY d_dte_clc, s_ste_nme
 ORDER BY 1,2

 
-- Vista general (consolidada de huevos) de laboratorio
 CREATE OR REPLACE VIEW sit_ecu5032_2021.sit_qry_01_egs_gnr_lab AS 
 WITH
 tmp01 AS (
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_01
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_02
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_03
 UNION
 SELECT * FROM sit_ecu5032_2021.sit_qry_egs_04
 ORDER BY 6,7)
 SELECT
 	to_date("Fecha instalacion",'yyyy-MM-dd') AS d_dte_set,
 	to_date("Fecha colecta",'yyyy-MM-dd') AS d_dte_clc,
 	BTRIM("Localidad") AS s_ste_nme,
 	--sif_sql(length(BTRIM("Ovitrampa")::text) = 2, "left"(BTRIM("Ovitrampa")::text, 1), "left"(BTRIM("Ovitrampa")::text, 2))::smallint AS i_trp_nmb,
    ---"right"(BTRIM("Ovitrampa")::text, 1) AS s_trp_ltr,
    btrim("Ovitrampa") AS s_tpe,
 	btrim("Type")::SMALLINT AS i_tpe_nmb,
 	--"CANTIDAD"::smallint,
 	"ENTEROS"::SMALLINT AS i_nmb_egs_int,
 	 iif_sql("ROT0S" = 'O', 0 , "ROT0S"::integer)::integer AS i_nmb_egs_brk,
 	(iif_sql("ROT0S" = 'O', 0 , "ROT0S"::integer)::integer + "ENTEROS"::smallint) AS i_nmb_egs_ttl,
 	--sif_sql((iif_sql("ROT0S" = 'O', 0 , "ROT0S"::integer)::integer + "ENTEROS"::smallint) = "CANTIDAD"::SMALLINT, 'SI','NO'),
 	Count(*) AS i_ttl_rpt
 FROM tmp01
 WHERE 
 	"Fecha instalacion"::date IS NOT NULL 
 	AND "Type"::text != 'Field'::TEXT
 GROUP BY 
 	"Localidad",
 	"Ovitrampa",
 	"Fecha instalacion",
 	"Fecha colecta",
 	"CANTIDAD",
 	"ROT0S",
 	"ENTEROS",
 	"Type"::text
 ORDER BY 1,2,3,4,5;

 CREATE OR REPLACE VIEW sit_ecu5032_2021.sit_qry_01_egs_gnr_lab_site AS 
 SELECT
    s_ste_nme,
 	s_tpe,
 	i_tpe_nmb,
 	Sum(i_nmb_egs_ttl) AS i_nmb_egs_ttl
 FROM sit_ecu5032_2021.sit_qry_01_egs_gnr_lab
 GROUP BY 1,2,3
 
CREATE OR REPLACE VIEW sit_ecu5032_2021.sit_qry_01_egs_gnr_lab_site_epi AS 
 SELECT
    "right"(smn_epd(date_part('year'::text,d_dte_clc)::numeric, date_part('month'::text, d_dte_clc)::numeric, date_part('day'::text, d_dte_clc)::numeric)::text, 2)::SMALLINT AS i_epi_wk,
    s_ste_nme,
    s_tpe,
 	i_tpe_nmb,
 	round(avg(i_nmb_egs_ttl),2) AS i_nmb_egs_avr
 FROM sit_ecu5032_2021.sit_qry_01_egs_gnr_lab
 GROUP BY d_dte_clc, s_ste_nme, s_tpe, i_tpe_nmb
 ORDER BY 1,2