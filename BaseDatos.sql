

CREATE DATABASE pichincha1
WITH
    OWNER = test
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA pc
    AUTHORIZATION test;

-- Table: pc.cliente

-- DROP TABLE pc.cliente;

CREATE TABLE pc.cliente
(
    cli_contrasena character varying(255) COLLATE pg_catalog."default",
    cli_estado character varying(255) COLLATE pg_catalog."default",
    per_id bigint NOT NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (per_id),
    CONSTRAINT fkndty26om7h6vrb00nyfg86qmc FOREIGN KEY (per_id)
        REFERENCES pc.persona (per_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
    TABLESPACE pg_default;

ALTER TABLE pc.cliente
    OWNER to test;

-- Table: pc.cuenta

-- DROP TABLE pc.cuenta;

CREATE TABLE pc.cuenta
(
    cta_id bigint NOT NULL,
    cta_estado character varying(255) COLLATE pg_catalog."default",
    cta_numero bigint,
    cta_saldo_inicial bigint,
    cta_tipo_cuenta character varying(255) COLLATE pg_catalog."default",
    per_id bigint,
    CONSTRAINT cuenta_pkey PRIMARY KEY (cta_id)
)
WITH (
    OIDS = FALSE
)
    TABLESPACE pg_default;

ALTER TABLE pc.cuenta
    OWNER to test;


-- Table: pc.movimiento

-- DROP TABLE pc.movimiento;

CREATE TABLE pc.movimiento
(
    mov_id bigint NOT NULL,
    cta_id bigint,
    mov_saldo bigint,
    mov_tipo character varying(255) COLLATE pg_catalog."default",
    mov_valor bigint,
    mov_fecha timestamp(6) without time zone,
    CONSTRAINT movimiento_pkey PRIMARY KEY (mov_id)
)
WITH (
    OIDS = FALSE
)
    TABLESPACE pg_default;

ALTER TABLE pc.movimiento
    OWNER to test;

-- Table: pc.persona

-- DROP TABLE pc.persona;

CREATE TABLE pc.persona
(
    per_id bigint NOT NULL DEFAULT nextval('pc.persona_per_id_seq'::regclass),
    per_direccion character varying(255) COLLATE pg_catalog."default",
    per_edad integer,
    per_genero character varying(255) COLLATE pg_catalog."default",
    per_identificacion character varying(255) COLLATE pg_catalog."default",
    per_nombre character varying(255) COLLATE pg_catalog."default",
    per_telefono character varying(255) COLLATE pg_catalog."default",
    cli_id bigint,
    CONSTRAINT persona_pkey PRIMARY KEY (per_id)
)
WITH (
    OIDS = FALSE
)
    TABLESPACE pg_default;

ALTER TABLE pc.persona
    OWNER to test;