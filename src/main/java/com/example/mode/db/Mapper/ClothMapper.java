package com.example.mode.db.Mapper;

import com.example.mode.model.Cloth;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClothMapper implements RowMapper<Cloth> {
    @Override
    public Cloth mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cloth cloth = new Cloth();
        cloth.setId(rs.getInt("cl.id"));
        cloth.setName(rs.getString("cl.name"));
        cloth.setWeight(rs.getInt("cl.weight"));
        cloth.setPrice(rs.getInt("cl.price"));
        cloth.setLength(rs.getInt("cl.length"));
        return cloth;
    }
}
