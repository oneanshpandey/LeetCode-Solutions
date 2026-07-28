# Write your MySQL query statement below
SELECT 
   e.name AS Employee
FROM
   Employee AS e
INNER JOIN
   Employee AS m
ON  
   e.managerID = m.id
WHERE 
   e.salary > m.salary;