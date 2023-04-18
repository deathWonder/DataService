--liquibase formatted sql

--changeset Sabir:1
create table homework.CUSTOMERS
(
    id           SERIAL primary key,
    name         varchar(30)                             NOT NULL,
    surname      varchar(30)                             NOT NULL,
    age          int CHECK (age >= 0) CHECK (age <= 100) NOT NULL,
    phone_number varchar(11) UNIQUE
);
--rollback drop table CUSTOMERS;

--changeset Sabir:2
create table homework.ORDERS
(
    id           SERIAL PRIMARY KEY,
    data         date default current_date,
    customerId   INTEGER,
    product_name varchar(30)             NOT NULL,
    amount       int CHECK (amount >= 0) not null,
    FOREIGN KEY (CustomerId) REFERENCES homework.CUSTOMERS (id)
);
--rollback drop table ORDERS;

--changeset Sabir:3
insert into homework.CUSTOMERS (name, surname, age, phone_number)
VALUES ('Vladimir', 'Max', 35, 89999998877);
insert into homework.CUSTOMERS (name, surname, age, phone_number)
VALUES ('Ola', 'Min', 28, 89999998876);
insert into homework.CUSTOMERS (name, surname, age, phone_number)
VALUES ('Sabir', 'Bishop', 25, 89999998875);
insert into homework.CUSTOMERS (name, surname, age, phone_number)
VALUES ('SABIR', 'Shop', 26, 89999998874);
--rollback drop values from table CUSTOMERS;

--changeset Sabir:4
insert into homework.ORDERS(CustomerId, product_name, amount)
VALUES (1, 'стириальная машинка', 5000);
insert into homework.ORDERS(CustomerId, product_name, amount)
VALUES (2, 'пылесос', 2500);
insert into homework.ORDERS(CustomerId, product_name, amount)
VALUES (3, 'часы', 1500);
insert into homework.ORDERS(CustomerId, product_name, amount)
VALUES (4, 'машина', 150000);
--rollback drop values from table ORDERS;