/*
 * Module: TPL
 * Autor: DC
 * Date: 2022-02-04
 * Description: Create table tpl_tbl_fmt
 * */

-- 1. Create table
DROP TABLE tpl_tbl_fmt;
CREATE TABLE tpl_tbl_fmt (
	i_fmt_id			SERIAL NOT NULL 
	,d_fmt_rgs_dte		DATE NOT NULL DEFAULT current_date
	,s_fmt_rgs_tme		TEXT NOT NULL DEFAULT btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text)
	,i_prs_rol_id		INTEGER NOT NULL
	,i_unt_sub_id		INTEGER NOT NULL 
	,i_prs_apn_elb_id	INTEGER NOT NULL 
	,i_prs_apn_rvw_id	INTEGER NOT NULL 
	,i_prs_apn_apr_id	INTEGER NOT NULL
	,i_mdl_id			INTEGER NOT NULL
	,s_fmt_lgo			TEXT
	,s_fmt_nme			TEXT
	,s_fmt_ttl			TEXT 
	,s_fmt_cde			TEXT 
	,s_fmt_edt			TEXT 
	,d_fmt_dte			DATE
	,b_fmt_act			BOOLEAN NOT NULL
	,d_fmt_dte_elb		DATE 
	,d_fmt_dte_rvw		DATE
	,d_fmt_dte_apr		DATE
	,CONSTRAINT i_pk_tpl_fmt_id PRIMARY KEY(i_fmt_id)
	,CONSTRAINT i_fk_scr_prs_rol_tpl_fmt_id 	FOREIGN KEY(i_prs_rol_id) 		REFERENCES scr_tbl_prs_rol(i_prs_rol_id)
	,CONSTRAINT i_fk_ins_unt_tpl_fmt_id 		FOREIGN KEY(i_unt_sub_id) 		REFERENCES ins_tbl_unt(i_unt_id)
	,CONSTRAINT i_fk_dta_prs_apn_tpl_fmt_elb_id FOREIGN KEY(i_prs_apn_elb_id) 	REFERENCES dta_tbl_prs_apn(i_prs_apn_id)
	,CONSTRAINT i_fk_dta_prs_apn_tpl_fmt_rvw_id FOREIGN KEY(i_prs_apn_rvw_id) 	REFERENCES dta_tbl_prs_apn(i_prs_apn_id)
	,CONSTRAINT i_fk_dta_prs_apn_tpl_fmt_apr_id FOREIGN KEY(i_prs_apn_apr_id) 	REFERENCES dta_tbl_prs_apn(i_prs_apn_id)
);
COMMENT ON TABLE tpl_tbl_fmt IS 'Almacena los formatos para mostrar en pantalla.';
-- 2. Comment atributte table
COMMENT ON COLUMN tpl_tbl_fmt.i_fmt_id IS 'ID';
COMMENT ON COLUMN tpl_tbl_fmt.d_fmt_rgs_dte IS 'Fecha registro';
COMMENT ON COLUMN tpl_tbl_fmt.s_fmt_rgs_tme IS 'Hora registro';
COMMENT ON COLUMN tpl_tbl_fmt.i_prs_rol_id IS 'FK --> Usuario que registra';
COMMENT ON COLUMN tpl_tbl_fmt.i_unt_sub_id IS 'FK --> Sub-Unidad';
COMMENT ON COLUMN tpl_tbl_fmt.i_prs_apn_elb_id IS 'FK --> Persona Elabora';
COMMENT ON COLUMN tpl_tbl_fmt.i_prs_apn_rvw_id IS 'FK --> Persona Revisa';
COMMENT ON COLUMN tpl_tbl_fmt.i_prs_apn_apr_id IS 'FK --> Persona Aprueba';
COMMENT ON COLUMN tpl_tbl_fmt.i_mdl_id IS 'FK --> Modulo o Aplicación al que pertenece el Formato';
COMMENT ON COLUMN tpl_tbl_fmt.s_fmt_lgo IS 'Logo';
COMMENT ON COLUMN tpl_tbl_fmt.s_fmt_nme IS 'Nombre formato';
COMMENT ON COLUMN tpl_tbl_fmt.s_fmt_ttl IS 'Título formato';
COMMENT ON COLUMN tpl_tbl_fmt.s_fmt_cde IS 'Código formato';
COMMENT ON COLUMN tpl_tbl_fmt.s_fmt_edt IS 'Edición formato';
COMMENT ON COLUMN tpl_tbl_fmt.d_fmt_dte IS 'Fecha de aprobación formato';
COMMENT ON COLUMN tpl_tbl_fmt.b_fmt_act IS 'Activo/No activo';
COMMENT ON COLUMN tpl_tbl_fmt.d_fmt_dte_elb IS 'Fecha de firma de elaboración';
COMMENT ON COLUMN tpl_tbl_fmt.d_fmt_dte_rvw IS 'Fecha de firma de revisión';
COMMENT ON COLUMN tpl_tbl_fmt.d_fmt_dte_apr IS 'Fecha de firma de aprobación';
-- 3. Create index table 
CREATE UNIQUE INDEX i_idx_tpl_fmt_id ON tpl_tbl_fmt USING btree(i_fmt_id);
CREATE INDEX i_idx_tpl_fmt_prs_rol_id ON tpl_tbl_fmt USING btree(i_prs_rol_id);
CREATE INDEX i_idx_tpl_fmt_unt_sub_id ON tpl_tbl_fmt USING btree(i_unt_sub_id);
CREATE INDEX i_idx_tpl_fmt_apn_elb_id ON tpl_tbl_fmt USING btree(i_prs_apn_elb_id);
CREATE INDEX i_idx_tpl_fmt_apn_rvw_id ON tpl_tbl_fmt USING btree(i_prs_apn_rvw_id);
CREATE INDEX i_idx_tpl_fmt_apn_apr_id ON tpl_tbl_fmt USING btree(i_prs_apn_apr_id);
CREATE INDEX i_idx_tpl_fmt_scr_mdl_mdl_id ON tpl_tbl_fmt USING btree(i_mdl_id);
-- https://popsql.com/learn-sql/postgresql/how-to-create-an-index-in-postgresql
CREATE INDEX CONCURRENTLY b_idx_tpl_fmt_act ON tpl_tbl_fmt USING btree(b_fmt_act) WHERE b_fmt_act IS TRUE;
-- 4. Select 
SELECT * FROM tpl_tbl_fmt;



