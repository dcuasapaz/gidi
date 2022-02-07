DROP VIEW scr.scr_qry_mdl;
CREATE OR REPLACE VIEW scr.scr_qry_mdl AS 
SELECT 
	i_opt_cde AS i_mdl_cde
	,d_opt_dte_rgs AS d_mdl_rgs_dte
	,s_opt_tme_rgs AS s_mdl_rgs_tme
	,i_opt_ctg AS i_mdl_ctg
	,s_opt_nme AS s_mdl_nme
	,s_opt_cde AS s_mdl_cde
	,s_opt_dsc AS s_mdl_dsc
	,b_opt_stt AS b_mdl_stt
FROM scr_tbl_opt
WHERE 
	i_opt_tpe = 2
ORDER BY 1;