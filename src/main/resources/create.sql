create table customers
(
    id               integer not null
        constraint customers_pk
            primary key,
    fullname         varchar(255),
    date_of_birthday date,
    gender           varchar(255),
    sn_passport      varchar(255)
);

alter table customers
    owner to kriuchkov;

create unique index customers_id_uindex
    on customers (id);

create table contracts
(
    id                  integer not null
        constraint contracts_pk
            primary key,
    d_of_start_contract date,
    d_of_end_contract   date,
    n_of_contract       integer,
    customer_id         integer,
    contract_type       varchar(255),
    detailed_info       varchar(255)
);

alter table contracts
    owner to kriuchkov;

create unique index contracts_id_uindex
    on contracts (id);
