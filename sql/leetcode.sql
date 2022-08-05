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
