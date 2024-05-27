create table member
(
    id bigint not null auto_increment,
    name varchar(10) not null,
    age bigint not null,
    primary key (id)
);



create table product
(
    id bigint not null auto_increment,
    barcode bigint not null,
    productName varchar(255) not null,
    primary key (id)
);

