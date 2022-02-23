/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*
 * Module: All
 * Autor: DC
 * Date: 2022-02-07
 * Description: Eliminar tablas innecesarias
 * 				; Alter table web_tbl_mnu_sub
 * 				; Create index
 * */

-- 1. Drop table
DROP TABLE dta_tbl_prs_edc;
DROP TABLE dta_tbl_prs_eml;
DROP TABLE dta_tbl_prs_lct;
DROP TABLE dta_tbl_prs_phn;
DROP TABLE dpa_tbl_sbc;
DROP TABLE dpa_tbl_crc;
DROP TABLE dpa_tbl_dst;
--2. Alter table 
ALTER TABLE sit_tbl_ste ADD COLUMN b_ste_stt boolean NOT NULL DEFAULT TRUE;
ALTER TABLE sit_tbl_ste ADD COLUMN d_ste_rgs_dte date NOT NULL DEFAULT current_date;
ALTER TABLE sit_tbl_ste ADD COLUMN s_ste_rgs_tme text NOT NULL DEFAULT btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text);
ALTER TABLE sit_tbl_ste ADD COLUMN i_ste_rgs_prs_rol_id integer NOT NULL DEFAULT 1;
ALTER TABLE sit_tbl_ste ADD CONSTRAINT i_fk_scr_prs_rol_sit_ste_id FOREIGN KEY(i_ste_rgs_prs_rol_id) REFERENCES scr_tbl_prs_rol(i_prs_rol_id);
-- web_tbl_mnu
ALTER TABLE web_tbl_mnu ADD COLUMN d_mnu_rgs_dte date NOT NULL DEFAULT current_date;
ALTER TABLE web_tbl_mnu ADD COLUMN s_mnu_rgs_tme text NOT NULL DEFAULT btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text);
ALTER TABLE web_tbl_mnu ADD COLUMN i_mnu_rgs_prs_rol_id integer NOT NULL DEFAULT 1;
ALTER TABLE web_tbl_mnu ADD CONSTRAINT i_fk_scr_prs_rol_web_mnu_id FOREIGN KEY(i_mnu_rgs_prs_rol_id) REFERENCES scr_tbl_prs_rol(i_prs_rol_id);
ALTER TABLE web_tbl_mnu ALTER COLUMN b_mnu_stt SET DEFAULT TRUE;
ALTER TABLE web_tbl_mnu ALTER COLUMN b_mnu_stt SET NOT NULL;
-- web_tbl_mnu_sub
ALTER TABLE web_tbl_mnu_sub ADD CONSTRAINT i_fk_web_mnu_mnu_sub_id FOREIGN KEY(i_mnu_id) REFERENCES web_tbl_mnu(i_mnu_id);
ALTER TABLE web_tbl_mnu_sub ADD COLUMN d_mnu_sub_rgs_dte date NOT NULL DEFAULT current_date;
ALTER TABLE web_tbl_mnu_sub ADD COLUMN s_mnu_sub_rgs_tme text NOT NULL DEFAULT btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text);
ALTER TABLE web_tbl_mnu_sub ADD COLUMN i_mnu_sub_rgs_prs_rol_id integer NOT NULL DEFAULT 1;
ALTER TABLE web_tbl_mnu_sub ADD CONSTRAINT i_fk_scr_prs_rol_web_mnu_sub_id FOREIGN KEY(i_mnu_sub_rgs_prs_rol_id) REFERENCES scr_tbl_prs_rol(i_prs_rol_id);
ALTER TABLE web_tbl_mnu_sub ALTER COLUMN b_mnu_sub_stt SET DEFAULT TRUE ;
ALTER TABLE web_tbl_mnu_sub ALTER COLUMN b_mnu_sub_stt SET NOT NULL;
ALTER TABLE web_tbl_mnu_sub ALTER COLUMN i_mdl_id SET NOT NULL;
ALTER TABLE web_tbl_mnu_sub ALTER COLUMN b_mnu_sub_stt SET DEFAULT TRUE;
--3. Create index
-- sit_tbl_ste 
CREATE INDEX CONCURRENTLY b_idx_atr_sit_ste_stt_t ON sit_tbl_ste USING btree(b_ste_stt) WHERE b_ste_stt IS TRUE;
CREATE INDEX CONCURRENTLY b_idx_atr_sit_ste_stt_f ON sit_tbl_ste USING btree(b_ste_stt) WHERE b_ste_stt IS FALSE;
CREATE INDEX CONCURRENTLY i_idx_sit_ste_rgs_prs_rol_id ON sit_tbl_ste USING btree(i_ste_rgs_prs_rol_id);
CREATE INDEX CONCURRENTLY i_idx_fk_sit_ste_prj_5074 ON sit_tbl_ste USING btree(i_prj_id) WHERE i_prj_id = 101;
CREATE INDEX CONCURRENTLY i_idx_fk_sit_ste_prj_5032 ON sit_tbl_ste USING btree(i_prj_id) WHERE i_prj_id = 102;
-- web_tbl_mnu 
CREATE INDEX CONCURRENTLY b_idx_web_mnu_stt_t ON web_tbl_mnu USING btree(b_mnu_stt) WHERE b_mnu_stt IS TRUE;
CREATE INDEX CONCURRENTLY b_idx_web_mnu_stt_f ON web_tbl_mnu USING btree(b_mnu_stt) WHERE b_mnu_stt IS FALSE;
-- web_tbl_mnu_sub
CREATE INDEX CONCURRENTLY b_idx_web_mnu_sub_stt_t ON web_tbl_mnu_sub USING btree(b_mnu_sub_stt) WHERE b_mnu_sub_stt IS TRUE;
CREATE INDEX CONCURRENTLY b_idx_web_mnu_sub_stt_f ON web_tbl_mnu_sub USING btree(b_mnu_sub_stt) WHERE b_mnu_sub_stt IS FALSE;
--4. Select 
SELECT * FROM sit_tbl_ste AS sts ORDER BY 1;
SELECT * FROM sit_tbl_opt ORDER BY 1;
SELECT * FROM web_tbl_mnu AS sts ORDER BY 1;
SELECT * FROM web_tbl_mnu_sub AS sts ORDER BY 1;
--5. Comment
COMMENT ON COLUMN sit_tbl_ste.d_ste_rgs_dte IS 'Fecha registro';
COMMENT ON COLUMN sit_tbl_ste.s_ste_rgs_tme IS 'Hora registro';
COMMENT ON COLUMN sit_tbl_ste.b_ste_stt IS 'Activo/No activo';
COMMENT ON COLUMN sit_tbl_ste.i_ste_rgs_prs_rol_id IS 'FK --> Usuario que registra';
COMMENT ON COLUMN sit_tbl_ste.i_ste_id IS 'ID';
COMMENT ON COLUMN sit_tbl_ste.s_ste_nme IS 'Nombre localidad';
COMMENT ON COLUMN sit_tbl_ste.i_prj_id IS 'FK --> Proyecto asociado a la localidad';
-- web_tbl_mnu
COMMENT ON COLUMN web_tbl_mnu.i_mnu_id IS 'ID'; 
COMMENT ON COLUMN web_tbl_mnu.s_mnu_nme IS 'Nombre opción';
COMMENT ON COLUMN web_tbl_mnu.s_mnu_img IS 'Imagen opción';
COMMENT ON COLUMN web_tbl_mnu.s_mnu_lnk IS 'Link opción';
COMMENT ON COLUMN web_tbl_mnu.s_mnu_dsc IS 'Descripción opción';
COMMENT ON COLUMN web_tbl_mnu.s_mnu_img IS 'Imagen opción';
COMMENT ON COLUMN web_tbl_mnu.i_mnu_ctg IS 'Orden opción';
COMMENT ON COLUMN web_tbl_mnu.d_mnu_rgs_dte IS 'Fecha registro';
COMMENT ON COLUMN web_tbl_mnu.s_mnu_rgs_tme IS 'Hora registro';
COMMENT ON COLUMN web_tbl_mnu.b_mnu_stt IS 'Activo/No activo';
COMMENT ON COLUMN web_tbl_mnu.i_mnu_rgs_prs_rol_id IS 'FK --> Usuario que registra';
-- web_tbl_mnu_sub
COMMENT ON COLUMN web_tbl_mnu_sub.i_mnu_sub_id IS 'ID'; 
COMMENT ON COLUMN web_tbl_mnu_sub.i_mnu_id IS 'FK --> Menu'; 
COMMENT ON COLUMN web_tbl_mnu_sub.s_mnu_sub_nme IS 'Nombre opción';
COMMENT ON COLUMN web_tbl_mnu_sub.s_mnu_sub_img IS 'Imagen opción';
COMMENT ON COLUMN web_tbl_mnu_sub.s_mnu_sub_lnk IS 'Link opción';
COMMENT ON COLUMN web_tbl_mnu_sub.s_mnu_sub_dsc IS 'Descripción opción';
COMMENT ON COLUMN web_tbl_mnu_sub.s_mnu_sub_img IS 'Imagen opción';
COMMENT ON COLUMN web_tbl_mnu_sub.i_mnu_sub_ctg IS 'Orden opción';
COMMENT ON COLUMN web_tbl_mnu_sub.i_mdl_id IS 'FK --> Módulo a la que pertenece la opción';
COMMENT ON COLUMN web_tbl_mnu_sub.d_mnu_sub_rgs_dte IS 'Fecha registro';
COMMENT ON COLUMN web_tbl_mnu_sub.s_mnu_sub_rgs_tme IS 'Hora registro';
COMMENT ON COLUMN web_tbl_mnu_sub.b_mnu_sub_stt IS 'Activo/No activo';
COMMENT ON COLUMN web_tbl_mnu_sub.i_mnu_sub_rgs_prs_rol_id IS 'FK --> Usuario que registra';
/*-------------------------------------------------------------------------------------------------------------------------------------*/


