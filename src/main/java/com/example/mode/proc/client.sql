create procedure getClients()
begin
    select c.id, c.name, c.surname from client c;
end;

create procedure addClient(n varchar(50), s varchar(50))
begin
    insert into client(name, surname) values (n, s);
end;

create procedure deleteClient(i int)
begin
    delete from client where id=i;
end;

create procedure getClient(i int)
begin
    select c.id, c.name, c.surname from client c where id=i;
end;

create procedure getDealsByClient(i int)
begin
    select d.id, mode.id, mode.name, mode.id_cloth, mode.length, mode.price,
           c.id, c.name, c.surname, m.id, m.name, m.surname, cl.id, cl.name, cl.weight, cl.price, cl.length, mode.id, mode.name, mode.id_cloth, mode.length, mode.price,
           d.id_client, d.id_master, d.id_model, d.id_cloth, d.date_start, d.date_cloth, d.date_end, d.done from deal d
           join client c on c.id = d.id_client join cloth cl on cl.id = d.id_cloth
           join master m on m.id = d.id_master join model mode on mode.id = d.id_model where c.id=i;
end;

create procedure countClient(i int)
begin
    select count(*) from deal where id_client = i;
end;