/*-------------------------------------------------------------------------------------------------------------------------------------*/
/*
 * Module: SIT
 * Autor: DC
 * Date: 2022-02-08
 * Description: update status
 * */
SELECT * FROM sit_tbl_ste AS sts ORDER BY 1;
UPDATE sit_tbl_ste SET b_ste_stt = FALSE WHERE i_ste_id = 3;
UPDATE sit_tbl_ste SET b_ste_stt = FALSE WHERE i_ste_id = 6;
