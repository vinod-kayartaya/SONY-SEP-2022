-- PROJECTION

select product_name, unit_price, units_in_stock from products;

-- SELECTION

select * from products where unit_price >= 50;

select * from products where unit_price>=20 and unit_price <=30;

select * from products where unit_price between 20 and 30;

select * from products where unit_price not between 20 and 30;

-- all the products supplied by supplier with ids: 1, 3, 17

select *
from products
where
    supplier_id = 1
    or supplier_id = 3
    or supplier_id = 17;

select *
from products
where supplier_id in (1, 3, 17)
select *
from products
where
    supplier_id not in (1, 3, 17)
select *
from suppliers
where region is null;

select * from suppliers where region is not null;

select * from products where discontinued = 1 and units_in_stock>0;

-- try with OR

select *
from products
where discontinued = 1
intersect
-- try with union as well
select *
from products
where units_in_stock > 0;

select *
from
    products as p,
    categories as c
where
    p.category_id = c.category_id;

select
    p.product_id,
    p.product_name,
    c.category_name,
    p.unit_price,
    s.company_name,
    s.contact_name
from products as p
    join categories as c on p.category_id = c.category_id
    join suppliers as s on p.supplier_id = s.supplier_id
where discontinued = 0;

select 
o.order_id, o.order_date, 
c.company_name, c.contact_name, c.contact_title, c.city,
concat_ws(' ', e.title_of_courtesy, e.last_name, e.first_name) as employee_name
from customers c
join orders o
on o.customer_id = c.customer_id
join employees e
on o.employee_id = e.employee_id;


