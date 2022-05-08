package com.example.mode.db;

import com.example.mode.db.Mapper.ClientMapper;
import com.example.mode.db.Mapper.DealMapper;
import com.example.mode.model.Client;
import com.example.mode.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> index() {
        return jdbcTemplate.query("call getClients()", new ClientMapper());
    }

    public void save(Client client) {
        jdbcTemplate.update("{call addClient(?,?)}", client.getName(),client.getSurname());
    }

    public void delete (int id) {
        jdbcTemplate.update("{call deleteClient(?)}", id);
    }

    public Client show(int id) {
        return jdbcTemplate.queryForObject("{call getClient(?)}", new Object[]{id}, new ClientMapper());
    }

    public List<Deal> showByClient(int id) {
        return jdbcTemplate.query("{call getDealsByClient(?)}", new DealMapper(), id);
    }

    public int count(int id) {
        return jdbcTemplate.queryForObject("{call countCLient(?)}", int.class, id);
    }
}
