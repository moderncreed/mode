create procedure addDeal(ds date,dc date,de date,d bit, ic int,iclient int,im int, imod int)
begin
    insert into deal(id_client, id_master, id_model, id_cloth, date_start, date_cloth, date_end, done) VALUES
        (iclient,im,imod,ic,ds,dc,de,d);
end;

create procedure getDeals()
begin
    select d.id, mode.id, mode.name, mode.id_cloth, mode.length, mode.price,
           c.id, c.name, c.surname, m.id, m.name, m.surname, cl.id, cl.name, cl.weight, cl.price, cl.length, mode.id, mode.name, mode.id_cloth, mode.length, mode.price,
           d.id_client, d.id_master, d.id_model, d.id_cloth, d.date_start, d.date_cloth, d.date_end, d.done from deal d
    join client c on c.id = d.id_client join cloth cl on cl.id = d.id_cloth
        join master m on m.id = d.id_master join model mode on mode.id = d.id_model;
end;

create procedure updateDeal(i int, d bit, dc date,de date)
begin
    update deal set done = d, date_cloth = dc, date_end = de where id = i;
end;

create procedure getDeal(i int)
begin
    select d.id, mode.id, mode.name, mode.id_cloth, mode.length, mode.price,
           c.id, c.name, c.surname, m.id, m.name, m.surname, cl.id, cl.name, cl.weight, cl.price, cl.length, mode.id, mode.name, mode.id_cloth, mode.length, mode.price,
           d.id_client, d.id_master, d.id_model, d.id_cloth, d.date_start, d.date_cloth, d.date_end, d.done from deal d
           join client c on c.id = d.id_client join cloth cl on cl.id = d.id_cloth
           join master m on m.id = d.id_master join model mode on mode.id = d.id_model where d.id=i;
end;