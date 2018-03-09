explain select c.customer_id,count(o.order_id) as total_orders
from
customers as c
left join orders as o
on c.customer_id=o.customer_id
where c.city='HangZhou'
group by c.customer_id
Having count(o.order_id)>0
order by total_orders desc;

select c.customer_id,o.order_id
from
customers as c
left join orders as o
on c.customer_id=o.customer_id
where c.city='HangZhou'
group by c.customer_id
Having count(o.order_id)>0
order by customer_id desc;


select * from customers cross join orders;
select * from customers natural join orders;
select * from customers left outer join orders on customers.customer_id=orders.customer_id;//outer关键字可以省略
select * from customers right outer join orders on customers.customer_id=orders.customer_id;
select * from customers full outer join orders on customers.customer_id=orders.customer_id;//出错