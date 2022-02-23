/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*
 * Module: SCR
 * Autor: DC
 * Date: 2022-02-09
 * Description: add column auditoria
 * 				; index
 * 				; comment
 * */

SELECT * FROM scr_tbl_prs_rol AS stpr ORDER BY 1;

ALTER TABLE scr_tbl_prs_rol ADD COLUMN i_prs_rol_rgs_prs_rol_id integer NOT NULL DEFAULT 1;
ALTER TABLE scr_tbl_prs_rol ADD CONSTRAINT i_fk_scr_prs_rol_scr_prs_rol_id FOREIGN KEY(i_prs_rol_rgs_prs_rol_id) REFERENCES scr_tbl_prs_rol(i_prs_rol_id);
ALTER TABLE scr_tbl_prs_rol ALTER COLUMN i_prj_id SET NOT NULL;

COMMENT ON COLUMN scr_tbl_prs_rol.d_prs_rol_dte_rgs IS 'Fecha registro';
COMMENT ON COLUMN scr_tbl_prs_rol.s_prs_rol_tme_rgs IS 'Hora registro';
COMMENT ON COLUMN scr_tbl_prs_rol.b_prs_rol_stt IS 'Activo/No activo';
COMMENT ON COLUMN scr_tbl_prs_rol.i_prs_rol_rgs_prs_rol_id IS 'FK --> Usuario que registra';
COMMENT ON COLUMN scr_tbl_prs_rol.i_prj_id IS 'FK --> Proyecto';

CREATE INDEX CONCURRENTLY i_idx_fk_scr_prs_rol_prj_5074 ON scr_tbl_prs_rol USING btree(i_prj_id) WHERE i_prj_id = 101;
CREATE INDEX CONCURRENTLY i_idx_fk_scr_prs_rol_prj_5032 ON scr_tbl_prs_rol USING btree(i_prj_id) WHERE i_prj_id = 102;

CREATE INDEX CONCURRENTLY b_idx_scr_prs_rol_stt_t ON scr_tbl_prs_rol USING btree(b_prs_rol_stt) WHERE b_prs_rol_stt IS TRUE;
CREATE INDEX CONCURRENTLY b_idx_scr_prs_rol_stt_f ON scr_tbl_prs_rol USING btree(b_prs_rol_stt) WHERE b_prs_rol_stt IS FALSE;