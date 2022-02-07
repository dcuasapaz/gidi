/*
 * Module: SCR
 * Autor: DC
 * Date: 2022-02-04
 * Description: Insert modulo de template;
 * */
SELECT * FROM scr_tbl_opt WHERE i_opt_tpe = 2 ORDER BY 1;

INSERT INTO scr_tbl_opt 
	VALUES(24
			,2
			,4
			,'Template'
			,'tpl'
			,'Módulo que almacena los formatos del sistema'
			,1
			,-99
			,current_date
			,btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text)
			,true);
		
INSERT INTO scr_tbl_opt 
	VALUES(25
			,2
			,5
			,'App --> Colección de Referencia del CIREV'
			,'app-crf'
			,'Módulo/Aplicación de la Colección de Referencia del CIREV'
			,1
			,-99
			,current_date
			,btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text)
			,true);

INSERT INTO scr_tbl_opt 
	VALUES(26
			,2
			,5
			,'App --> Proyectos SIT del CIREV'
			,'app-sit'
			,'Módulo/Aplicación de los Proyectos SIT del CIREV'
			,1
			,-99
			,current_date
			,btrim(btrim("left"((((date_part('hour'::text, 'now'::text::time with time zone)::text || ':'::text) || date_part('minute'::text, 'now'::text::time with time zone)) || ':'::text) || date_part('second'::text, 'now'::text::time with time zone)::text, 8), '.'::text), ' '::text)
			,true);
