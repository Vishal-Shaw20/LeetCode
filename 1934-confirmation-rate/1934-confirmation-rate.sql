# Write your MySQL query statement below

SELECT 
    s.user_id,
    ROUND(SUM(CASE WHEN action = "confirmed" THEN 1 ELSE 0 END)/COUNT(*), 2) as confirmation_rate
FROM Signups as s
LEFT JOIN Confirmations as c ON
    s.user_id = c.user_id
GROUP BY user_id;