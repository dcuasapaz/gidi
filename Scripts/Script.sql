/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*
 * Module: SIT
 * Autor: DC
 * Date: 2022-02-09
 * Description: add column 
 * 
 * */
SELECT * FROM sit_tbl_gnr_dtl AS stg ORDER BY 1;
ALTER TABLE sit_tbl_gnr ADD COLUMN i_gnr_nmb_egs_vlb_no integer;