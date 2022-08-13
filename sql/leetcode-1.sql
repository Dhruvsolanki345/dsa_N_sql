-- https://leetcode.com/problems/combine-two-tables/
-- 175. Combine Two Table

select firstname, lastname, city, state 
from person p left join address a
on p.personid = a.personid;
