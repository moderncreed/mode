package com.example.mode.db.Mapper;

import com.example.mode.model.Cloth;
import com.example.mode.model.Model;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelMapper implements RowMapper<Model> {
    @Override
    public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
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
        return model;
    }
}
