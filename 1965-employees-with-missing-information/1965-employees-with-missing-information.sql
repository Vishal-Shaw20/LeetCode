# Write your MySQL query statement below

SELECT 
    e.employee_id
FROM Employees as e
LEFT JOIN Salaries as s ON
    e.employee_id = s.employee_id
WHERE s.salary is NULL

UNION
    
SELECT 
    s.employee_id
FROM Employees as e
RIGHT JOIN Salaries as s ON
    e.employee_id = s.employee_id
WHERE e.name is NULL

ORDER BY employee_id;