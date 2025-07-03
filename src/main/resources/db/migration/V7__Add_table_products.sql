create table products(
    id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    category_id TINYINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE RESTRICT
)