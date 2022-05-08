package com.example.mode.db;

import com.example.mode.db.Mapper.DealMapper;
import com.example.mode.db.Mapper.ModelMapper;
import com.example.mode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class DealData {
    private Date dateStart;
    private Date dateCloth;
    private Date dateEnd;
    private boolean done;
    private Cloth cloth;
    private Client client;
    private Master master;
    private Model model;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DealData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Deal> index() {
        return jdbcTemplate.query("{call getDeals()}", new DealMapper());
    }

    public void save(Deal deal) {
        jdbcTemplate.update("{call addDeal(?,?,?,?,?,?,?,?)}",
                deal.getDateStart(), deal.getDateCloth(), deal.getDateEnd(), deal.isDone(), deal.getCloth().getId(), deal.getClient().getId(), deal.getMaster().getId(),
                deal.getModel().getId());
    }

    public Deal show(int id) {
        return jdbcTemplate.queryForObject("{call getDeal(?)}", new Object[]{id}, new DealMapper());
    }

    public void update(Deal deal) {
        jdbcTemplate.update("call updateDeal(?,?,?,?)",deal.getId(), deal.isDone(), deal.getDateCloth(),deal.getDateEnd());
    }
}