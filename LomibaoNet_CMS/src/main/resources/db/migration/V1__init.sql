create table if not exists "user"
(
	email varchar(255) not null,
	role varchar(255) not null,
	created timestamp not null,
	modified timestamp not null,
	attributes jsonb not null,
	password_hash varchar(255) not null
);

create table if not exists article
(
	id bigint generated always as identity
		constraint article_pkey
			primary key,
	url_name varchar(255) not null,
	title varchar(255) not null,
	body varchar(255) not null,
	author varchar(255) not null,
	category_id bigint not null,
	tags jsonb not null,
	published boolean not null
);

create table if not exists category
(
	id bigint generated always as identity
		constraint category_pkey
			primary key,
	name varchar(255) not null,
	url_name varchar(255) not null,
	thumbnail_path varchar(255) not null
);

