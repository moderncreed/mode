package com.example.mode.db;

import com.example.mode.db.Mapper.ClientMapper;
import com.example.mode.db.Mapper.DealMapper;
import com.example.mode.db.Mapper.MasterMapper;
import com.example.mode.model.Client;
import com.example.mode.model.Deal;
import com.example.mode.model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MasterData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MasterData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Master> index() {
        return jdbcTemplate.query("call getMasters()", new MasterMapper());
    }

    public void save(Master master) {
        jdbcTemplate.update("{call addMaster(?,?)}", master.getName(),master.getSurname());
    }

    public void delete (int id) {
        jdbcTemplate.update("{call deleteMaster(?)}", id);
    }

    public Master show(int id) {
        return jdbcTemplate.queryForObject("{call getMaster(?)}", new Object[]{id}, new MasterMapper());
    }

    public List<Deal> showByMaster(int id) {
        return jdbcTemplate.query("{call getDealsByMaster(?)}", new DealMapper(), id);
    }
    public int count(int id) {
        return jdbcTemplate.queryForObject("{call countMaster(?)}", int.class, id);
    }
}
