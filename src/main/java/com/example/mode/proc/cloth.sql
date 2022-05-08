create procedure getClothes()
begin
    select cl.id, cl.name,  cl.weight,  cl.price,  cl.length from cloth cl;
end;

create procedure addCloth(n varchar(50), w int, p int, l int)
begin
    insert into cloth(name, weight,price,length) values (n, w,p,l);
end;

create procedure deleteCloth(i int)
begin
    delete from cloth where id=i;
end;

create procedure getCloth(i int)
begin
    select cl.id, cl.name,  cl.weight,  cl.price,  cl.length from cloth cl where id=i;
end;

create procedure updateCloth(i int,l int)
begin
    update cloth set length = l where id = i;
end;