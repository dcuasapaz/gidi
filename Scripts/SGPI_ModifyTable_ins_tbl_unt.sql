/*
 * Module: INS
 * Autor: DC
 * Date: 2022-02-04
 * Description: Alter table ins_tbl_unt; ADD COLUMN s_unt_tme_rgs
 * */

ALTER TABLE ins_tbl_unt 
	ALTER COLUMN s_unt_tme_rgs SET DEFAULT btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text);