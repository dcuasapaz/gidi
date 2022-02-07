/*
 * Module: INS
 * Autor: DC
 * Date: 2022-02-04
 * Description: insert table ins_tbl_unt
 * */

SELECT * FROM ins_tbl_ent ORDER BY 1;
SELECT * FROM ins_tbl_unt ORDER BY 1;
SELECT * FROM ins_tbl_opt ORDER BY 1;
INSERT INTO ins_tbl_unt (s_unt_nme
						, s_unt_acr
						, i_ent_cde
						, i_lvl_id
						, i_unt_cde) 
VALUES('Dirección Técnica de Investigación, Desarrollo e Innovación', 'DTIDi', 1, 201, -99);
INSERT INTO ins_tbl_unt (s_unt_nme
						, s_unt_acr
						, i_ent_cde
						, i_lvl_id
						, i_unt_cde) 
VALUES('Gestión de Investigación, Desarrollo e Innovación', 'GIDI, CZ9', 1, 202, 4);
INSERT INTO ins_tbl_unt (s_unt_nme
						, s_unt_acr
						, i_ent_cde
						, i_lvl_id
						, i_unt_cde) 
VALUES('Centro de Investigación en Enfermedades Infecciosas y Vectoriales', 'CIREV', 1, 201, 5);
