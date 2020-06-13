DROP TABLE IF EXISTS `accounts`;
create table accounts (
    id integer NOT NULL AUTO_INCREMENT primary key,
    mail_address varchar(255) NOT NULL,
    password char(60) NOT NULL,
    updated_at timestamp not null default current_timestamp,
    created_at timestamp not null default current_timestamp
);