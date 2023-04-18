SELECT product_name
FROM homework.ORDERS
         INNER JOIN homework.CUSTOMERS
                    ON orders.customerid = customers.id
WHERE LOWER(name) = :name;


