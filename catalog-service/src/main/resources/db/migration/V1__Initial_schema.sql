CREATE TABLE product
(
   id BIGSERIAL PRIMARY KEY NOT NULL,
   category varchar (255) NOT NULL,
   price float8 NOT NULL,
   size varchar (255) NOT NULL,
   created_date timestamp NOT NULL,
   last_modified_date timestamp NOT NULL,
   version integer NOT NULL
);

create unique index unq_category_size on product(category, size);