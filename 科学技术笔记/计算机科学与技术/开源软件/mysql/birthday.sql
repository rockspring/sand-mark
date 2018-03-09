select 
name,
birthday,
today, 
date_add(birthday,interval diff year) as cur,
date_add(birthday,interval diff+1 year) as next 
from 
(	select concat(last_name,' ',first_name) as name,
	birth_date as birthday,
	(year(now())-year(birth_date)) as diff,
	now()  as today 
	from 
	employees
) as a;

select
name,
birthday,
today,
date_add(cur,interval if(day(birthday)=29 && day(cur)=28,1,0) day) as cur,
date_add(next,interval if(day(birthday)=29 && day(next)=28,1,0) day) as next
from
(
	select 
	name,
	birthday,
	today, 
	date_add(birthday,interval diff year) as cur,
	date_add(birthday,interval diff+1 year) as next 
	from 
	(	
		select concat(last_name,' ',first_name) as name,
		birth_date as birthday,
		(year(now())-year(birth_date)) as diff,
		now()  as today 
		from 
		employees
	) as a
) as b;

select
name,
birthday,
today,
