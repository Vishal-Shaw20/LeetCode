# Write your MySQL query statement below

WITH date_cte AS (
    SELECT 
        visited_on,
        SUM(AMOUNT) as amount
    FROM Customer
    GROUP BY visited_on
),
final_cte AS (
    SELECT 
        visited_on,
        SUM(amount) OVER(
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) as amount,
        ROUND(
            AVG(amount) OVER(
                ORDER BY visited_on
                ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
            ), 2
        ) as average_amount,
        ROW_NUMBER() OVER(ORDER BY visited_on) as num
    FROM date_cte
)
SELECT 
    visited_on,
    amount,
    average_amount
FROM final_cte
WHERE num >= 7;