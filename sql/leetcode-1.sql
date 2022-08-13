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
