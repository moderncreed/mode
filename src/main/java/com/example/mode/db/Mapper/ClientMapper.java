package com.example.mode.db.Mapper;

import com.example.mode.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt("c.id"));
        client.setName(rs.getString("c.name"));
        client.setSurname(rs.getString("c.surname"));
        return client;
    }
}
