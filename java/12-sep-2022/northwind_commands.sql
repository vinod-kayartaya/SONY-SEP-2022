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
    o.order_id,
    o.order_date,
    c.company_name,
    c.contact_name,
    c.contact_title,
    c.city,
    concat_ws(
        ' ',
        e.title_of_courtesy,
        e.last_name,
        e.first_name
    ) as employee_name
from customers c
    join orders o on o.customer_id = c.customer_id
    join employees e on o.employee_id = e.employee_id
where shipped_date is null;

select
    o.order_id,
    o.order_date,
    c.company_name,
    c.contact_name,
    c.contact_title,
    c.city,
    concat_ws(
        ' ',
        e.title_of_courtesy,
        e.last_name,
        e.first_name
    ) as employee_name,
    sh.company_name as shipping_company
from customers c
    join orders o on o.customer_id = c.customer_id
    join employees e on o.employee_id = e.employee_id
    join shippers sh on o.ship_via = sh.shipper_id
where shipped_date is null;

select
    emp.employee_id,
    concat_ws(
        ' ',
        emp.title_of_courtesy,
        emp.first_name,
        emp.last_name
    ) as employee,
    concat_ws(
        ' ',
        mgr.title_of_courtesy,
        mgr.first_name,
        mgr.last_name
    ) as manager
from employees emp
    left join employees mgr on emp.reports_to = mgr.employee_id;

select *
from products
where unit_price < (
        select unit_price
        from products
        where product_id = 36
    );

select avg(unit_price) from products;

select *
from products
where unit_price > (
        select
            avg(unit_price)
        from products
    );

select *
from products p1
where unit_price >= (
        select
            avg(unit_price)
        from products p2
        where
            p2.category_id = p1.category_id
    );

select
    category_id,
    avg(unit_price)
from products
group by category_id;