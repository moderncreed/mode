package com.example.mode.db;

import com.example.mode.db.Mapper.ClothMapper;
import com.example.mode.db.Mapper.ModelMapper;
import com.example.mode.model.Cloth;
import com.example.mode.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ModelData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Model> index() {
        return jdbcTemplate.query("{call getModels()}", new ModelMapper());
    }

    public void save(Model model) {
        jdbcTemplate.update("{call addModel(?,?,?,?)}", model.getName(),model.getCloth().getId(),model.getPrice(),model.getLength());
    }

    public void delete (int id) {
        jdbcTemplate.update("{call deleteModel(?)}", id);
    }

    public Model show(int id) {
        return jdbcTemplate.queryForObject("{call getModel(?)}", new Object[]{id}, new ModelMapper());
    }

    public void update(int id, int l) {
        jdbcTemplate.update("{call updateCloth(?,?)}", id, l);
    }
}
