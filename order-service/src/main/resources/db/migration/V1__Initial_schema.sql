CREATE TABLE orders (
      id                  BIGSERIAL PRIMARY KEY NOT NULL,
      product_category           varchar(255) NOT NULL,
      product_size           varchar(255),
      product_price          float8,
      quantity            int NOT NULL,
      status              varchar(255) NOT NULL,
      created_date        timestamp NOT NULL,
      last_modified_date  timestamp NOT NULL,
      version             integer NOT NULL
);