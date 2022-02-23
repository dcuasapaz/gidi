/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*
 * Module: SIT
 * Autor: DC
 * Date: 2022-02-09
 * Description: add column auditoria
 * 				; index
 * 				; comment
 * */


ALTER TABLE sit_tbl_gnr_prs_prf ADD COLUMN d_prs_prf_rgs_dte date NOT NULL DEFAULT current_date;
ALTER TABLE sit_tbl_gnr_prs_prf ADD COLUMN s_prs_prf_rgs_tme text NOT NULL DEFAULT btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text);
ALTER TABLE sit_tbl_gnr_prs_prf ADD COLUMN i_prs_prf_rgs_prs_rol_id integer NOT NULL DEFAULT 1;
ALTER TABLE sit_tbl_gnr_prs_prf ADD CONSTRAINT i_fk_scr_prs_rol_sit_prs_prf_id FOREIGN KEY(i_prs_prf_rgs_prs_rol_id) REFERENCES scr_tbl_prs_rol(i_prs_rol_id);
ALTER TABLE sit_tbl_gnr_prs_prf ADD COLUMN b_prs_prf_stt BOOLEAN NOT NULL DEFAULT TRUE ;

COMMENT ON COLUMN sit_tbl_gnr_prs_prf.d_prs_prf_rgs_dte IS 'Fecha registro';
COMMENT ON COLUMN sit_tbl_gnr_prs_prf.s_prs_prf_rgs_tme IS 'Hora registro';
COMMENT ON COLUMN sit_tbl_gnr_prs_prf.b_prs_prf_stt IS 'Activo/No activo';
COMMENT ON COLUMN sit_tbl_gnr_prs_prf.i_prs_prf_rgs_prs_rol_id IS 'FK --> Usuario que registra';

CREATE INDEX CONCURRENTLY b_idx_sit_prs_prf_stt_t ON sit_tbl_gnr_prs_prf USING btree(b_prs_prf_stt) WHERE b_prs_prf_stt IS TRUE;
CREATE INDEX CONCURRENTLY b_idx_sit_prs_prf_stt_f ON sit_tbl_gnr_prs_prf USING btree(b_prs_prf_stt) WHERE b_prs_prf_stt IS FALSE;


SELECT * FROM sit_tbl_gnr_prs_prf AS stgpp ORDER BY 1;

