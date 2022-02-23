/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*
 * Module: SIT
 * Autor: DC
 * Date: 2022-02-08
 * Description: add column auditoria
 * 				; index
 * 				; comment
 * */

ALTER TABLE sit_tbl_opt ADD COLUMN d_opt_rgs_dte date NOT NULL DEFAULT current_date;
ALTER TABLE sit_tbl_opt ADD COLUMN s_opt_rgs_tme text NOT NULL DEFAULT btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text);
ALTER TABLE sit_tbl_opt ADD COLUMN i_opt_rgs_prs_rol_id integer NOT NULL DEFAULT 1;
ALTER TABLE sit_tbl_opt ADD CONSTRAINT i_fk_scr_prs_rol_sit_opt_id FOREIGN KEY(i_opt_rgs_prs_rol_id) REFERENCES scr_tbl_prs_rol(i_prs_rol_id);
ALTER TABLE sit_tbl_opt ALTER COLUMN b_opt_stt SET DEFAULT TRUE ;
ALTER TABLE sit_tbl_opt ALTER COLUMN b_opt_stt SET NOT NULL;

COMMENT ON COLUMN sit_tbl_opt.d_opt_rgs_dte IS 'Fecha registro';
COMMENT ON COLUMN sit_tbl_opt.s_opt_rgs_tme IS 'Hora registro';
COMMENT ON COLUMN sit_tbl_opt.b_opt_stt IS 'Activo/No activo';
COMMENT ON COLUMN sit_tbl_opt.i_opt_rgs_prs_rol_id IS 'FK --> Usuario que registra';

COMMENT ON COLUMN sit_tbl_opt.i_opt_id IS 'ID'; 
COMMENT ON COLUMN sit_tbl_opt.i_opt_fth IS 'FK --> Código padre'; 
COMMENT ON COLUMN sit_tbl_opt.s_opt_nme IS 'Nombre opción'; 
COMMENT ON COLUMN sit_tbl_opt.s_opt_acr IS 'Acronimo opción'; 
COMMENT ON COLUMN sit_tbl_opt.s_opt_dsc IS 'Descripción opción'; 

CREATE INDEX CONCURRENTLY b_idx_sit_opt_stt_t ON sit_tbl_opt USING btree(b_opt_stt) WHERE b_opt_stt IS TRUE;
CREATE INDEX CONCURRENTLY b_idx_sit_opt_stt_f ON sit_tbl_opt USING btree(b_opt_stt) WHERE b_opt_stt IS FALSE;

UPDATE sit_tbl_opt SET b_opt_stt = TRUE WHERE i_opt_fth = 7;
UPDATE sit_tbl_opt SET b_opt_stt = FALSE WHERE i_opt_id = 702;

SELECT * FROM sit_tbl_opt AS sto WHERE i_opt_fth = 7 AND b_opt_stt = TRUE ORDER BY 1;

SELECT * FROM sit_tbl_opt AS sto WHERE i_opt_fth = 2 AND b_opt_stt = TRUE ORDER BY 1;
UPDATE sit_tbl_opt SET b_opt_stt = TRUE WHERE i_opt_fth = 2;
UPDATE sit_tbl_opt SET b_opt_stt = FALSE  WHERE i_opt_id = 201;
UPDATE sit_tbl_opt SET b_opt_stt = FALSE  WHERE i_opt_id = 203;


SELECT * FROM sit_tbl_opt AS sto ORDER BY 1;


SELECT * FROM sit_tbl_opt AS sto WHERE i_opt_fth = 6 AND b_opt_stt = TRUE ORDER BY 1;
UPDATE sit_tbl_opt SET b_opt_stt = TRUE WHERE i_opt_fth = 6;
/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*
 * Module: SIT
 * Autor: DC
 * Date: 2022-02-22
 * Description: update, sex, genus/specie
 * */
SELECT * FROM sit_tbl_opt AS sto ORDER BY 1;
UPDATE sit_tbl_opt SET b_opt_stt = TRUE WHERE i_opt_fth = 4;
UPDATE sit_tbl_opt SET b_opt_stt = TRUE WHERE i_opt_fth = 5;
SELECT * FROM sit_tbl_opt AS sto WHERE i_opt_fth = 4 AND b_opt_stt = TRUE ORDER BY 1;
SELECT * FROM sit_tbl_opt AS sto WHERE i_opt_fth = 5 AND b_opt_stt = TRUE ORDER BY 1;

ALTER TABLE sit_tbl_opt ADD COLUMN i_opt_ctg integer NOT NULL DEFAULT -99;
COMMENT ON COLUMN sit_tbl_opt.i_opt_ctg IS 'Short Column';
UPDATE sit_tbl_opt SET i_opt_ctg = 1 WHERE i_opt_id = 601;
UPDATE sit_tbl_opt SET i_opt_ctg = 2 WHERE i_opt_id = 602;
UPDATE sit_tbl_opt SET i_opt_ctg = 3 WHERE i_opt_id = 603;
UPDATE sit_tbl_opt SET i_opt_ctg = 4 WHERE i_opt_id = 604;

