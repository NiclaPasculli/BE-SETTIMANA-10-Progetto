PGDMP         -                z            film    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    25442    film    DATABASE     `   CREATE DATABASE film WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE film;
                postgres    false            ?            1259    25444    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    25443    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    25444    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   v       ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 8, true);
          public          postgres    false    209            ]           2606    25450    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?      x?u?KR?0  ?5?"f??+᳤E[>?*T??&J?PJ?2????u????L]w%?D??+ޣ??O??%T?lTn??p?G^???e1??˽??V5???X?h)f?=e???L耥?A gT`??%۷?0?&??ćy???M???v??
????Y?݃??j??܏????)?H?z"n??q:,S???C?9G?????i;F?\??<3?쓠?????3??5??????^?jձf?osG5???߫*??pd?     