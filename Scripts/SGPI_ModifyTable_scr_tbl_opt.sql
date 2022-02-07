/*
 * Module: SCR
 * Autor: DC
 * Date: 2022-02-04
 * Description: Alter table; add column cde; unique cde; index status TRUE;
 * */
UPDATE scr_tbl_opt SET i_clr_cde = -99 WHERE i_opt_tpe = 2;
-- https://popsql.com/learn-sql/postgresql/how-to-create-an-index-in-postgresql
CREATE INDEX CONCURRENTLY b_idx_scr_opt_stt ON scr_tbl_opt USING btree(b_opt_stt) WHERE b_opt_stt IS TRUE;
ALTER TABLE scr_tbl_opt ADD COLUMN s_opt_cde TEXT;
ALTER TABLE scr_tbl_opt ADD CONSTRAINT s_unq_scr_opt_cde UNIQUE (s_opt_cde);
UPDATE scr_tbl_opt SET s_opt_cde = 'tpl' WHERE i_opt_cde = 24;
SELECT * FROM scr_tbl_prs_rol AS stpr ORDER BY 1;
SELECT * FROM dta_tbl_prs AS stpr ORDER BY 1;

SELECT * FROM scr_tbl_opt WHERE i_opt_tpe = 2 ORDER BY 1;

UPDATE scr_tbl_opt SET s_opt_cde = 'ins' WHERE i_opt_cde = 21;
UPDATE scr_tbl_opt SET s_opt_cde = 'scr' WHERE i_opt_cde = 22;
UPDATE scr_tbl_opt SET s_opt_cde = 'dta' WHERE i_opt_cde = 23;