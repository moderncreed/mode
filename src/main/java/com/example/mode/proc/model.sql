create procedure getModels()
begin
    select mode.id, mode.name, mode.id_cloth, mode.length, mode.price, cl.id, cl.name,  cl.weight,  cl.price,  cl.length
    from cloth cl join model mode on cl.id = mode.id_cloth;
end;

create procedure addModel(n varchar(50), icl int, p int, l int)
begin
    insert into model(name, id_cloth, length, price) values (n, icl,l,p);
end;

create procedure deleteModel(i int)
begin
    delete from model where id=i;
end;

create procedure getModel(i int)
begin
    select mode.id, mode.name, mode.id_cloth, mode.length, mode.price, cl.id, cl.name,  cl.weight,  cl.price,  cl.length
    from cloth cl join model mode on cl.id = mode.id_cloth where mode.id=i;
end;
