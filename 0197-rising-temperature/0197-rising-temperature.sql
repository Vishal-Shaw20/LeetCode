# Write your MySQL query statement below

WITH cte AS (
    SELECT 
        id, 
        recordDate, 
        temperature, 
        LAG(temperature) OVER(ORDER BY recordDate) as prevTemp,
        LAG(recordDate) OVER(ORDER BY recordDate) as prevDate
    FROM Weather
)
SELECT id
FROM cte
WHERE temperature > prevTemp AND
    DATEDIFF(recordDate, prevDate) = 1;   