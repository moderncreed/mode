package com.example.mode.db;


import com.example.mode.db.Mapper.ClientMapper;
import com.example.mode.db.Mapper.ClothMapper;
import com.example.mode.model.Client;
import com.example.mode.model.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClothData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClothData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cloth> index() {
        return jdbcTemplate.query("call getClothes()", new ClothMapper());
    }

    public void save(Cloth cloth) {
        jdbcTemplate.update("{call addCloth(?,?,?,?)}", cloth.getName(),cloth.getWeight(),cloth.getPrice(),cloth.getLength());
    }

    public void delete (int id) {
        jdbcTemplate.update("{call deleteCloth(?)}", id);
    }

    public Cloth show(int id) {
        return jdbcTemplate.queryForObject("{call getCloth(?)}", new Object[]{id}, new ClothMapper());
    }

    public void update(int id, int l) {
        jdbcTemplate.update("{call updateCloth(?,?)}", id, l);
    }
}
