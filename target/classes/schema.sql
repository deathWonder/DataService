create table homework.CUSTOMERS (
                                    id SERIAL primary key,
                                    name varchar(30) NOT NULL,
                                    surname varchar (30) NOT NULL,
                                    age int CHECK (age>=0) CHECK (age<=100) NOT NULL,
                                    phone_number varchar(11) UNIQUE
);



create table homework.ORDERS(
                                id SERIAL PRIMARY KEY ,
                                data date default current_date,
                                customerId INTEGER,
                                product_name varchar(30) NOT NULL,
                                amount int CHECK (amount>=0) not null,
                                FOREIGN KEY (CustomerId) REFERENCES homework.CUSTOMERS (id)
);
