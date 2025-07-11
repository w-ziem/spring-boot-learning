DELIMITER $$

CREATE PROCEDURE findProductByPrice(
    minPrice DECIMAL(10,2),
    maxPrice DECIMAL(10,2)
)
BEGIN
    SELECT p.id, p.name, p.description, p.price, p.category_id
    FROM products p
    WHERE p.price BETWEEN  minPrice AND maxPrice
    ORDER BY name;

END $$

DELIMITER ;