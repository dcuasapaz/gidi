-- 1. Create User
--DROP USER sgpi;
CREATE USER sgpi PASSWORD 'Sgpi!DvlEnv';
-- 2. Permisos
ALTER ROLE sgpi SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN;
ALTER USER sgpi WITH PASSWORD 'Sgpi!DvlEnv';
ALTER USER sgpi WITH CONNECTION LIMIT 100;
-- 3. Create database
CREATE DATABASE sgpi_dvl OWNER sgpi;
