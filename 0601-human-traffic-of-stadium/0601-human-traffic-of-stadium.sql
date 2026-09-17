# Write your MySQL query statement below

WITH cte AS (
    SELECT 
        id,
        visit_date,
        people
    FROM Stadium
    WHERE people >= 100
    ORDER BY visit_date
)
SELECT 
    id,
    visit_date,
    people
FROM cte as c
WHERE 
    (
        EXISTS(SELECT 1 FROM cte as x WHERE x.id = c.id - 2)
        AND
        EXISTS(SELECT 1 FROM cte as x WHERE x.id = c.id - 1)
    ) 
    OR
    (
        EXISTS(SELECT 1 FROM cte as x WHERE x.id = c.id - 1)
        AND
        EXISTS(SELECT 1 FROM cte as x WHERE x.id = c.id + 1)
    )
    OR
    (
        EXISTS(SELECT 1 FROM cte as x WHERE x.id = c.id + 1)
        AND
        EXISTS(SELECT 1 FROM cte as x WHERE x.id = c.id + 2)
    );