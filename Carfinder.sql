PGDMP     /                    y         	   Carfinder    12.2    12.2 C    Y           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Z           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            [           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            \           1262    16456 	   Carfinder    DATABASE     �   CREATE DATABASE "Carfinder" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Polish_Poland.1250' LC_CTYPE = 'Polish_Poland.1250';
    DROP DATABASE "Carfinder";
                postgres    false            �            1259    16469    account    TABLE     �   CREATE TABLE public.account (
    id integer NOT NULL,
    login character varying(30) NOT NULL,
    password character varying(30) NOT NULL
);
    DROP TABLE public.account;
       public         heap    postgres    false            �            1259    16467    account_id_seq    SEQUENCE     �   CREATE SEQUENCE public.account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.account_id_seq;
       public          postgres    false    205            ]           0    0    account_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;
          public          postgres    false    204            �            1259    16516    advert    TABLE     �  CREATE TABLE public.advert (
    id integer NOT NULL,
    brand character varying(30) NOT NULL,
    model character varying(30) NOT NULL,
    type character varying(30) NOT NULL,
    fuel_type character varying(30) NOT NULL,
    engine character varying(30) NOT NULL,
    gearbox character varying(30) NOT NULL,
    "trim" character varying(30) NOT NULL,
    colour character varying(50) NOT NULL,
    price double precision NOT NULL,
    dealer_id integer
);
    DROP TABLE public.advert;
       public         heap    postgres    false            �            1259    16514    advert_id_seq    SEQUENCE     �   CREATE SEQUENCE public.advert_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.advert_id_seq;
       public          postgres    false    213            ^           0    0    advert_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.advert_id_seq OWNED BY public.advert.id;
          public          postgres    false    212            �            1259    16459 	   car_specs    TABLE     �  CREATE TABLE public.car_specs (
    id integer NOT NULL,
    brand character varying(30) NOT NULL,
    model character varying(30) NOT NULL,
    type character varying(30) NOT NULL,
    fuel_type character varying(30) NOT NULL,
    engine character varying(30) NOT NULL,
    gearbox character varying(30) NOT NULL,
    "trim" character varying(30) NOT NULL,
    colour character varying(50) NOT NULL,
    price double precision NOT NULL
);
    DROP TABLE public.car_specs;
       public         heap    postgres    false            �            1259    16457    car_specs_id_seq    SEQUENCE     �   CREATE SEQUENCE public.car_specs_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.car_specs_id_seq;
       public          postgres    false    203            _           0    0    car_specs_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.car_specs_id_seq OWNED BY public.car_specs.id;
          public          postgres    false    202            �            1259    16503    dealer    TABLE     �   CREATE TABLE public.dealer (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    city character varying(30) NOT NULL,
    street character varying(50) NOT NULL,
    street_number integer NOT NULL,
    user_id integer
);
    DROP TABLE public.dealer;
       public         heap    postgres    false            �            1259    16501    dealer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.dealer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.dealer_id_seq;
       public          postgres    false    211            `           0    0    dealer_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.dealer_id_seq OWNED BY public.dealer.id;
          public          postgres    false    210            �            1259    16545    intrest    TABLE     e   CREATE TABLE public.intrest (
    id integer NOT NULL,
    user_id integer,
    advert_id integer
);
    DROP TABLE public.intrest;
       public         heap    postgres    false            �            1259    16543    intrest_id_seq    SEQUENCE     �   CREATE SEQUENCE public.intrest_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.intrest_id_seq;
       public          postgres    false    217            a           0    0    intrest_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.intrest_id_seq OWNED BY public.intrest.id;
          public          postgres    false    216            �            1259    16529    photos    TABLE     x   CREATE TABLE public.photos (
    id integer NOT NULL,
    url character varying(500) NOT NULL,
    advert_id integer
);
    DROP TABLE public.photos;
       public         heap    postgres    false            �            1259    16527    photos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.photos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.photos_id_seq;
       public          postgres    false    215            b           0    0    photos_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.photos_id_seq OWNED BY public.photos.id;
          public          postgres    false    214            �            1259    16490    roles    TABLE     x   CREATE TABLE public.roles (
    id integer NOT NULL,
    role character varying(10) NOT NULL,
    account_id integer
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    16488    roles_id_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.roles_id_seq;
       public          postgres    false    209            c           0    0    roles_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;
          public          postgres    false    208            �            1259    16477    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    email character varying(50) NOT NULL,
    phone character varying(9) NOT NULL,
    account_id integer
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16475    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    207            d           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    206            �
           2604    16472 
   account id    DEFAULT     h   ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);
 9   ALTER TABLE public.account ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    16519 	   advert id    DEFAULT     f   ALTER TABLE ONLY public.advert ALTER COLUMN id SET DEFAULT nextval('public.advert_id_seq'::regclass);
 8   ALTER TABLE public.advert ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    212    213            �
           2604    16462    car_specs id    DEFAULT     l   ALTER TABLE ONLY public.car_specs ALTER COLUMN id SET DEFAULT nextval('public.car_specs_id_seq'::regclass);
 ;   ALTER TABLE public.car_specs ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    16506 	   dealer id    DEFAULT     f   ALTER TABLE ONLY public.dealer ALTER COLUMN id SET DEFAULT nextval('public.dealer_id_seq'::regclass);
 8   ALTER TABLE public.dealer ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            �
           2604    16548 
   intrest id    DEFAULT     h   ALTER TABLE ONLY public.intrest ALTER COLUMN id SET DEFAULT nextval('public.intrest_id_seq'::regclass);
 9   ALTER TABLE public.intrest ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            �
           2604    16532 	   photos id    DEFAULT     f   ALTER TABLE ONLY public.photos ALTER COLUMN id SET DEFAULT nextval('public.photos_id_seq'::regclass);
 8   ALTER TABLE public.photos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            �
           2604    16493    roles id    DEFAULT     d   ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            �
           2604    16480    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            J          0    16469    account 
   TABLE DATA           6   COPY public.account (id, login, password) FROM stdin;
    public          postgres    false    205   �J       R          0    16516    advert 
   TABLE DATA           v   COPY public.advert (id, brand, model, type, fuel_type, engine, gearbox, "trim", colour, price, dealer_id) FROM stdin;
    public          postgres    false    213   �K       H          0    16459 	   car_specs 
   TABLE DATA           n   COPY public.car_specs (id, brand, model, type, fuel_type, engine, gearbox, "trim", colour, price) FROM stdin;
    public          postgres    false    203    O       P          0    16503    dealer 
   TABLE DATA           P   COPY public.dealer (id, name, city, street, street_number, user_id) FROM stdin;
    public          postgres    false    211   �S       V          0    16545    intrest 
   TABLE DATA           9   COPY public.intrest (id, user_id, advert_id) FROM stdin;
    public          postgres    false    217   U       T          0    16529    photos 
   TABLE DATA           4   COPY public.photos (id, url, advert_id) FROM stdin;
    public          postgres    false    215   sU       N          0    16490    roles 
   TABLE DATA           5   COPY public.roles (id, role, account_id) FROM stdin;
    public          postgres    false    209   �[       L          0    16477    users 
   TABLE DATA           T   COPY public.users (id, first_name, last_name, email, phone, account_id) FROM stdin;
    public          postgres    false    207   _\       e           0    0    account_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.account_id_seq', 40, true);
          public          postgres    false    204            f           0    0    advert_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.advert_id_seq', 56, true);
          public          postgres    false    212            g           0    0    car_specs_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.car_specs_id_seq', 41, true);
          public          postgres    false    202            h           0    0    dealer_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.dealer_id_seq', 13, true);
          public          postgres    false    210            i           0    0    intrest_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.intrest_id_seq', 39, true);
          public          postgres    false    216            j           0    0    photos_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.photos_id_seq', 49, true);
          public          postgres    false    214            k           0    0    roles_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.roles_id_seq', 39, true);
          public          postgres    false    208            l           0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 38, true);
          public          postgres    false    206            �
           2606    16474    account account_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public            postgres    false    205            �
           2606    16521    advert advert_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.advert
    ADD CONSTRAINT advert_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.advert DROP CONSTRAINT advert_pkey;
       public            postgres    false    213            �
           2606    16464    car_specs car_specs_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.car_specs
    ADD CONSTRAINT car_specs_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.car_specs DROP CONSTRAINT car_specs_pkey;
       public            postgres    false    203            �
           2606    16508    dealer dealer_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.dealer
    ADD CONSTRAINT dealer_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.dealer DROP CONSTRAINT dealer_pkey;
       public            postgres    false    211            �
           2606    16550    intrest intrest_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.intrest
    ADD CONSTRAINT intrest_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.intrest DROP CONSTRAINT intrest_pkey;
       public            postgres    false    217            �
           2606    16537    photos photos_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.photos
    ADD CONSTRAINT photos_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.photos DROP CONSTRAINT photos_pkey;
       public            postgres    false    215            �
           2606    16495    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    209            �
           2606    16482    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    207            �
           2606    16522    advert advert_dealer_id_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.advert
    ADD CONSTRAINT advert_dealer_id_fkey FOREIGN KEY (dealer_id) REFERENCES public.dealer(id);
 F   ALTER TABLE ONLY public.advert DROP CONSTRAINT advert_dealer_id_fkey;
       public          postgres    false    2747    211    213            �
           2606    16509    dealer dealer_user_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.dealer
    ADD CONSTRAINT dealer_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.dealer DROP CONSTRAINT dealer_user_id_fkey;
       public          postgres    false    2743    211    207            �
           2606    16556    intrest intrest_advert_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.intrest
    ADD CONSTRAINT intrest_advert_id_fkey FOREIGN KEY (advert_id) REFERENCES public.advert(id);
 H   ALTER TABLE ONLY public.intrest DROP CONSTRAINT intrest_advert_id_fkey;
       public          postgres    false    217    2749    213            �
           2606    16551    intrest intrest_user_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.intrest
    ADD CONSTRAINT intrest_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 F   ALTER TABLE ONLY public.intrest DROP CONSTRAINT intrest_user_id_fkey;
       public          postgres    false    2743    217    207            �
           2606    16538    photos photos_advert_id_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.photos
    ADD CONSTRAINT photos_advert_id_fkey FOREIGN KEY (advert_id) REFERENCES public.advert(id);
 F   ALTER TABLE ONLY public.photos DROP CONSTRAINT photos_advert_id_fkey;
       public          postgres    false    2749    213    215            �
           2606    16496    roles roles_account_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.account(id);
 E   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_account_id_fkey;
       public          postgres    false    209    205    2741            �
           2606    16483    users users_account_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.account(id);
 E   ALTER TABLE ONLY public.users DROP CONSTRAINT users_account_id_fkey;
       public          postgres    false    205    2741    207            J   C  x�E�]r� ����Z����A^F�UZV<}`���.�ѮFA��i���pCO~�Yye�$H��u~j�&�azM@C�<�a=B�׭��BHZx�c8H�P��'�g 
�+OƏ��ĝv���K!J�[��S!*�MRw��t?<�L��8|6<΄��<roO�&��6R��[��9R���%������蘻�dI��d]U�v���e� kr��'@6�of�	u#�=ťP"^���a/%�w<i�̄R�
R�2e�j[�����z�/UR�:��{;��<���6�>��K����n�%�-����d���?ξ��      R   �  x����r�@���S���_�%�Q'��
&��lZ�ў!`5�ķ��5f�+��~����6��@�H�:G�N��<G�J�,EC�s� AH�E�ͧ>�6E��
!/�{�j�.T��w���*�M��"�h�)e� �P�Q�H�>���o��84�V[�Dg�}��q�RN�_كAal��=C��p�C\�,-�G|���ǉ�����
�G���~�0�u�%� �����]�u���m�3X.��nD%㵽�|����s`b��N����������Z�3x�	ęɚ�;��naM\G70�b�l��(ڭP������f�^�d���>;�تu9x�;D])�U��8��K<�����"X5Z.� xF��}:ΈiT8\g�hJ@b��\�A�ՠ����s�ls[c��U�t��#J��K�U�<�����k�$/Y��U��ڻzPN~Zp�:|��Ee��1B{5��W���׍ݝ�8�w���
R�V\����MT�����ax��0���	���W'���:������#������a8��;>>��?�&p}P�\��;�'�C�l�{��i1�r�\GPtkTQ.���,ϳrc�����0�y�{j����������8��I��
ق�fH�N���b�5�V��<�4�:���#8���e�mg�"�4d7���7:�]�^����Gf	ie4�UJ(s�@wS�l�k��J	؀�����gᘦ���ĺ�\��_�������q�k�!      H   �  x����r�8���)��$�X:� ��P�!Y�Fغ���)�p�}�ialbBf*;Se>�N�n�&BG"�#ų\�i��RdB!�H��m��y.#�M��A&��s���pO��N�@��Ј9�"�e]#ۄ�؞x�ؿ|����O2��P[�,�Q8���y�'.�c�\��!~����C�#)4����V`�G�7��T�A��d�@h ���T�^����Z�D���}�����L���C>�=Ң�	_J��uNx��
Mp�Iu^�B=�p�7���@$�5D�|	�D�|�x���Q2�ax�<��)_�ՙ� B�{ԡ��B� u�?{
�[ϿG���(���y0�������GP��%j�aO�"��n�g�6��<G!���i���J��V/RLoNR�1�'��uݎ!:h�&1�R�@GC<�����ͪ�<��"F�ڦ[�����-��=周b����~�
�v��5<U��+�˺�P��{h�S_�Y5����=�ˣ�a��_���L�l�.z��1���GӒs�S-����*�ƘeS��У�2���v��TՏ�}�)|7l)��ʜ'r�Ʃ2C��ڤ�z� ��r͛��.o�$x�Ē'Q��w��`֞\���΢��#^��0�6Y1�q�OU�6)��iЁ����t��ͼ�]E2���<l���~��u�ԉ���I���w�~��Z�T�^�B�Ĉ.|��L/���)���k(e.�<-J�hϤW�K4#�kfs��P�Z�©O���6P�c�:�20/-Ǐ}����]0���󢂱��e�P�� ����oU�BȞlm�U#���ԭ��81�wQ*���`
�RH�`�zq>�o�y	^����W5�sˋ4(l�4O�[��/a4L�e��u�&C�F�ߦ.{���,��.����'�3���i��q�S�v���	4b��u�H.W�\D�c�9�vM㑋��h��26QYm6�|	A!�v��ٲ�Յ���<x�`�@/~�5߬N|�	��k[c鿍g�!j����՛=���٬�K[	|�n�|X�|�jݿ\���;��e:?@>��c	/���?-2K������_t_dr��x]���a��/Eĺł����	�=l�I��3���4������L�ڱM�}�j��_� N      P   q  x�u��n�0����lU'��#��PJ����'�Z/Ʈ���ľ��^uDU�'K�7��@Y�Ҷ�yT������:M{�%���Q|"M�*?0nhG|���{�2�J>[$Hn��$����&��	Kj�a���w�eHr��������
i�u�+�����N{�:2*f#��ӧ�O��Yhڃ�2��L����clr[klr$#��(����/5���8G&�
v����r1{���x���PY}2G���+�z\,g�2�2q�ߊZ>��ٍ���掼�g��,���5�JS�3Z�������鐉�S��/|ܵѹUo�WV��V���֞V"͘H1W�%��r���b�}�_�^      V   P   x��� 1��]�*`r����X@Bh�`�Y�����4&̘�ʌ~�QP�Z��R!_�RɄ"oWcP� �}$�kJ      T   /  x��V]o�8}�~HC�[]�ԓ��4�6͠)�J�$6��!e;������������	b9�ty���C~ь��`\�z�.����M�{��7F�&�͈���eN*f�B	���TT�*�ˤ���y�;���*O�e(Uk�
76��oTk��UF.(����aTc��ko�&�=��t�h�o��)0#�`�1�W$gbM�@t��҈җ`��.V��i�uc\��ς���[�K�M@�L���ѪU! ���ѭ���������j[[�ٲqQ��ݘ�3��ec�oa��Hwu!�P�gs�b&��8')_�3��%@k�h|����#���[<���C�G�	��h�����@TΠ�5��(�ֹƈF��Qk{�z[7#2ڎn�t�Hh������D�G�ڪ>�Ѡ���gI��՞�B55�%��%��il�44nt��k���So��k�S�0H�
	a(*ʜ�BR��"�	W�c2b��#�`at����W�\ڹBP�鞷�C�q0���##9g+�@?<��]�#7�d�����γ$���+9�)�RF�<�xVV��Ia�����b�Z�7c�P$塕�w����;ܚZ����l��W�ũ$O�1|�'�%��x.`U�u�y�cB�T�IXX.�5��+�;ӆ���N�����5u�?L��kXW>��/K �6�鰙�A�Q��A[�x�[��o�_�vv0�h�hT0�pO����g�ķwILY<1�N?Rdtb�������-�����I$��$P��0�o���EA0�����N롵��2{���i"B90�<�Э��'j��e�H��T��l1���b��NY/9�t�p=�'���jh`y�/kJs�&	?�G���{|�"M�Q���Ip��XJ����8"�|[����dB�hJ�%wN"���>��Գ��I0#!�ɩ����WZ��܏���eg�m[���,_{���]���W~�?/	��b	C?����Y.>>����;���ᮞ��E�N�ƃ��`ok�+��̰)�L�)d��*MR��b�T
����L5sqr��<�'�Χ�D�L�T�$\Ti�2�2]��U�I�6F�v0�5 [��%��K�s#�ޚ���v��C;-���U0�f���u��dM�%Jq�:���Zu�I'
���&� ��۾���r~~�C��A�m0�EA#��"~��R�����]��z~1�<ƃ�����j�����o�޿�!���y��uظ��:Y29�b��p��S�F��q�����6A".ςV�1c�`N5���T���?��|A�i�&`nD,ai�O���!nL�Q�b���t�|٩g׫]����6��
�v���<�#�Y���)�9�f�{[z7\�8�i���0����i����_�����L}6W&ě�\����!J ÷�>��?�����7�������n���I؅�I�ꩤ�Ü�\c��gr�L��>X�>z���6��%��ĩ?3�c�l�?c�F��i�NK�����uV_	��)��K�T���b�/N����/$��GQ�/���      N   �   x�=�;jD1D����u��{qb���x��~���������s�ɼϯ���f�<D�;ADR��&��DO"1��\�Jnb'_��ʚeMBY�Q��Q�4P�4QִPִQ�H�{��V#p6-�:7v��{��G���7�p��7��������DGd�      L   t  x�mT�n�6}~E� �U��8�F\;���/�����͑v!Xo�/�
�W�kX*B,v8s��*�C?6<�}hʙk�>o������|(��\�ie�����ϡ	Ot���m��ƪe����Fzʄ�}��L���:l�]D[����OwՆ�C��a�6U��.r�,�RJ(I7<U}� z�jz���[��P��T��\�'��.m��i�2Bi�;p;W���[�y[�� �{.Sx�M\F ܾ��H9�,}�����) 6v�qq���$^HeB9��.��rny�@����$Z���,#����� ��D�m��<����٘�*��F#�~�c����T/TA�����j�BM=��Θ��V��By��M��CU�L���+)�x�JhI����R�j
�LC��/��/<�@Z��������~�j^�����I�5}��jKL<�>n��Q�i�@[eއ*	�#܁���oG��FJ+%i'��׿�u����4�,e�Z}f��\�ny��!�P�������\��%N����q���**?�]%��8�����<�O5}�f~�i��>D/�b�ҙ��Y��/ib���c��cS�b2��K����f��=,�u��^	u��`芇�)<�����%�%���hB�Y��Q��ԕv%@��ɝ�L�Q���G{�;��Tqj�c��9'�2(ޒ1�����4ɤy{Z&��p���X�/ ����}���'gZ���O�	c��*�}�k��)N5�?�k)j%Mlc&��;�`v~�1�]��a)�́-��м0Yz#__���0lz#�)L��SE��a�K�=����?Z��_V�\Q�9������%�ᛓi�y��Z�k��&+E�������ؾ	���u*���_���l�     