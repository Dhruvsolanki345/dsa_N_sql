-- https://leetcode.com/problems/big-countries/
-- 595. Big Countries

-- using or
select name, population, area from world where area >= 3000000 or population >= 25000000

-- using union
select name, population, area from world where area >= 3000000 
union
select name, population, area from world where population >= 25000000


-- 1757. Recyclable and Low Fat Products
-- https://leetcode.com/problems/recyclable-and-low-fat-products/

select product_id from products where low_fats = "Y" and recyclable = "Y"


-- https://leetcode.com/problems/find-customer-referee/
-- 584. Find Customer Referee

-- using <>
select name from customer where referee_id <> 2 or referee_id is null;
-- using !=
select name from customer where referee_id != 2 or referee_id is null;


-- https://leetcode.com/problems/customers-who-never-order/
-- 183. Customers Who Never Order

-- using subquery and not in
select name as 'customers' from customers where id not in (select customerid from orders);

-- using left join
select name as 'customers' 
from customers c 
left join orders o
on c.id = o.customerid
where o.customerid is null;
