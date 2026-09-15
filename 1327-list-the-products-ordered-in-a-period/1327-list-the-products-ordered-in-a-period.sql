# Write your MySQL query statement below

WITH cte AS (
    SELECT
        product_id,
        SUM(unit) as unit
    FROM Orders
    WHERE YEAR(order_date) = 2020 AND
        MONTH(order_date) = 2
    GROUP BY product_id
)
SELECT 
    p.product_name,
    c.unit
FROM Products as p
LEFT JOIN cte as c ON
    p.product_id = c.product_id
WHERE c.unit >= 100;