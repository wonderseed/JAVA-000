CREATE TABLE IF NOT EXISTS product_info(
    id              serial,
    product_id      varchar(255) not null,
    product_name    varchar(50) not null,
    product_detail  varchar(255) not null,
    product_price   bigint not null,
    store_num       bigint not null,
    warehouse_id    varchar(255),
    primary key (product_id)
);

create index if not exists product_info_01 on product_info(product_id);
create index if not exists product_info_02 on product_info(product_name);

create table if not exists  order_info(
  id                    serial,
  order_id              varchar(255) not null,
  order_name            varchar(255) not null,
  create_time           bigint not null,
  end_time              bigint not null,
  related_product_id    varchar(255) not null,
  buyer_id              varchar(50) not null,
  seller_id             varchar(50) not null,
  primary key (order_id)
);

create index if not exists order_info_01 on order_info(end_time);
create index if not exists order_info_02 on order_info(related_product_id);
create index if not exists order_info_03 on order_info(seller_id,buyer_id);

create table if not exists user_info(
    id              serial,
    user_id         varchar(255) not null,
    user_name       varchar(25) not null,
    email           varchar(50) not null,
    create_time     bigint not null,
    user_level      varchar(10) not null,
    account_balance bigint,
    user_address    varchar(255) not null,
    primary key (user_id)
);

create index if not exists user_info_01 on user_info(user_name,email);
create index if not exists user_info_02 on user_info(user_address);

CREATE table if not exists warehouse(
  id                    serial,
  address               varchar(255) not null,
  administrator         varchar(50) not null,
  store_product_type    varchar(50) not null,
  primary key (id)
);
