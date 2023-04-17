package com.example.dataaccessobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public Service(Repository repository) {
        this.repository = repository;
    }

//    public String getProductName(String name) {
//        name = name.toLowerCase();
//        List<String> orders = jdbcTemplate.query(repository.getMyScript(),
//                (rs, rowNum) -> rs.getString("product_name"), name);
//        return orders.toString();
//    }

    public String getProductName(String name) {
        name = name.toLowerCase();
        Map<String, Object> args = new HashMap<>();
        args.put("name", name);
        List<String> orders = namedParameterJdbcTemplate.query(repository.getMyScript(),
                args, (rs, rowNum) -> rs.getString("product_name"));
        return orders.toString();
    }

}
