package com.example.mode.db.Mapper;

import com.example.mode.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DealMapper implements RowMapper<Deal> {
    @Override
    public Deal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Deal deal = new Deal();
        Cloth cloth = new Cloth();
        cloth.setId(rs.getInt("cl.id"));
        cloth.setName(rs.getString("cl.name"));
        cloth.setWeight(rs.getInt("cl.weight"));
        cloth.setPrice(rs.getInt("cl.price"));
        cloth.setLength(rs.getInt("cl.length"));
        Model model = new Model();
        model.setId(rs.getInt("mode.id"));
        model.setName(rs.getString("mode.name"));
        model.setLength(rs.getInt("mode.length"));
        model.setPrice(rs.getInt("mode.price"));
        model.setCloth(cloth);
        Client client = new Client();
        client.setId(rs.getInt("c.id"));
        client.setName(rs.getString("c.name"));
        client.setSurname(rs.getString("c.surname"));
        Master master = new Master();
        master.setId(rs.getInt("m.id"));
        master.setName(rs.getString("m.name"));
        master.setSurname(rs.getString("m.surname"));
        deal.setClient(client);
        deal.setMaster(master);
        deal.setModel(model);
        deal.setCloth(cloth);
        deal.setDateStart(rs.getDate("d.date_start"));
        deal.setDateCloth(rs.getDate("d.date_cloth"));
        deal.setDateEnd(rs.getDate("d.date_end"));
        deal.setDone(rs.getBoolean("d.done"));
        deal.setId(rs.getInt("d.id"));
        return deal;
    }
}
