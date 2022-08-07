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


-- https://leetcode.com/problems/calculate-special-bonus/
-- 1873. Calculate Special Bonus

select employee_id, 
if(employee_id % 2 = 1 and name not like "M%", salary, 0) as bonus 
from employees 
order by employee_id;


-- https://leetcode.com/problems/swap-salary/solution/
-- 627. Swap Salary

-- using case-when-else
update salary
set
    sex = case sex
        when "m" then "f"
        else "m"
    end;
    
-- using if
update salary
set sex = if(sex = "m", "f", "m");


-- https://leetcode.com/problems/delete-duplicate-emails/solution/
-- 196. Delete Duplicate Emails

-- using from
delete p1 from person p1,
    person p2
where 
    p1.email = p2.email and p1.id > p2.id;
    
-- using equivalent from join
delete p1 from person p1
join person p2
on p1.email = p2.email
where p1.id > p2.id;


-- https://leetcode.com/problems/fix-names-in-a-table/
-- 1667. Fix Names in a Table

select user_id, 
concat(upper(substr(name,1,1)), lower(substr(name,2))) as name
from users
order by user_id;
