-- https://leetcode.com/problems/combine-two-tables/
-- 175. Combine Two Table

select firstname, lastname, city, state 
from person p left join address a
on p.personid = a.personid;


-- https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/
-- 1581. Customer Who Visited but Did Not Make Any Transactions

select customer_id, count(v.visit_id) as count_no_trans
from visits v left join transactions t
on v.visit_id = t.visit_id
where transaction_id is null
group by customer_id;


-- https://leetcode.com/problems/article-views-i/
-- 1148. Article Views I

select distinct viewer_id as id from views
where viewer_id = author_id
order by viewer_id;


-- https://leetcode.com/problems/rising-temperature/
-- 197. Rising Temperature

select w1.id as id 
from weather w1 join weather w2
on datediff(w1.recordDate, w2.recordDate) = 1 and w1.temperature > w2.temperature;


-- https://leetcode.com/problems/sales-person/
-- 607. Sales Person

select s.name from salesperson s
where s.sales_id not in (
    select o.sales_id from orders o
    join company c
    on o.com_id = c.com_id
    where c.name = 'RED'
);
