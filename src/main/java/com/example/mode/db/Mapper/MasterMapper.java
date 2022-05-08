package com.example.mode.db.Mapper;

import com.example.mode.model.Client;
import com.example.mode.model.Master;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MasterMapper implements RowMapper<Master> {
    @Override
    public Master mapRow(ResultSet rs, int rowNum) throws SQLException {
        Master master = new Master();
        master.setId(rs.getInt("m.id"));
        master.setName(rs.getString("m.name"));
        master.setSurname(rs.getString("m.surname"));
        return master;
    }
}
