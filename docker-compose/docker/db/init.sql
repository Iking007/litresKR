--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2022-12-23 00:11:07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3344 (class 1262 OID 24675)
-- Name: litres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE litres WITH TEMPLATE = template0;


ALTER DATABASE litres OWNER TO postgres;

\connect litres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 24676)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    id bigint NOT NULL,
    download character varying(255),
    img character varying(255),
    str character varying(255),
    title character varying(255),
    writer character varying(255)
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24693)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 24699)
-- Name: hibernate_sequences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    next_val bigint
);


ALTER TABLE public.hibernate_sequences OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24683)
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_role (
    user_id bigint NOT NULL,
    roles character varying(255)
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24686)
-- Name: usr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usr (
    id bigint NOT NULL,
    active boolean NOT NULL,
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.usr OWNER TO postgres;

--
-- TOC entry 3334 (class 0 OID 24676)
-- Dependencies: 214
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.book VALUES (3, '', '', 'Описание', 'Мартин Иден', 'Джек Лондон');
INSERT INTO public.book VALUES (9, '', '', 'qwerty', 'qwerty', 'qwerty');
INSERT INTO public.book VALUES (5, '', '', 'йцуц', 'йцу', 'йцук');


--
-- TOC entry 3338 (class 0 OID 24699)
-- Dependencies: 218
-- Data for Name: hibernate_sequences; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.hibernate_sequences VALUES ('default', 5);


--
-- TOC entry 3335 (class 0 OID 24683)
-- Dependencies: 215
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_role VALUES (1, 'ADMIN');
INSERT INTO public.user_role VALUES (2, 'USER');
INSERT INTO public.user_role VALUES (4, 'MODER');


--
-- TOC entry 3336 (class 0 OID 24686)
-- Dependencies: 216
-- Data for Name: usr; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usr VALUES (1, true, '1234567890', 'mahinka007@mail.ru');
INSERT INTO public.usr VALUES (2, true, '1234567890-', 'djin_21@mail.ru');
INSERT INTO public.usr VALUES (4, true, '1234567890', 'pasha_3228@mail.ru');


--
-- TOC entry 3345 (class 0 OID 0)
-- Dependencies: 217
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 9, true);


--
-- TOC entry 3186 (class 2606 OID 24682)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- TOC entry 3190 (class 2606 OID 24703)
-- Name: hibernate_sequences hibernate_sequences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);


--
-- TOC entry 3188 (class 2606 OID 24692)
-- Name: usr usr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usr
    ADD CONSTRAINT usr_pkey PRIMARY KEY (id);


--
-- TOC entry 3191 (class 2606 OID 24694)
-- Name: user_role fkfpm8swft53ulq2hl11yplpr5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkfpm8swft53ulq2hl11yplpr5 FOREIGN KEY (user_id) REFERENCES public.usr(id);


-- Completed on 2022-12-23 00:11:07

--
-- PostgreSQL database dump complete
--

