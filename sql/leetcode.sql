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


-- https://leetcode.com/problems/group-sold-products-by-the-date/
-- 1484. Group Sold Products By The Date

select sell_date, 
count(distinct product) as num_sold,
group_concat(distinct product order by product asc separator ",") as products -- separator default value is ","
from activities
group by sell_date
order by sell_date;


-- https://leetcode.com/problems/patients-with-a-condition/
-- 1527. Patients With a Condition

select * from patients
where conditions like "% DIAB1%" or
    conditions like "DIAB1%";


-- https://leetcode.com/problems/employees-with-missing-information/
-- 1965. Employees With Missing Information

-- Note: full outer join doesn't in MySQL

-- 'using' keyword
select employee_id from employees
left join salaries
using (employee_id)
where salary is null
union
select employee_id from employees
right join salaries
using (employee_id)
where name is null
order by employee_id;

-- 'on' keyword
select e.employee_id from employees e
left join salaries s
on e.employee_id = s.employee_id
where s.salary is null
union
select s.employee_id from employees e
right join salaries s
on e.employee_id = s.employee_id
where e.name is null
order by employee_id;


-- https://leetcode.com/problems/rearrange-products-table/
-- 1795. Rearrange Products Table

-- Using union
select product_id, 'store1' as store, store1 as price from products where store1 is not null
union
select product_id, 'store2' as store, store2 as price from products where store2 is not null
union
select product_id, 'store3' as store, store3 as price from products where store3 is not null
order by 1,2 asc;
