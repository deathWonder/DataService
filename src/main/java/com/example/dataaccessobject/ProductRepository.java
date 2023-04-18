package com.example.dataaccessobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String myScript;

    @Autowired
    public ProductRepository(NamedParameterJdbcTemplate parameter) {
        this.myScript = read();
        namedParameterJdbcTemplate = parameter;
    }

    private static String read() {
        try (InputStream is = new ClassPathResource("myScript.sql").getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getMyScript() {
        return myScript;
    }

    public String getProductName(String name) {
        name = name.toLowerCase();
        Map<String, Object> args = new HashMap<>();
        args.put("name", name);
        List<String> orders = namedParameterJdbcTemplate.query(getMyScript(),
                args, (rs, rowNum) -> rs.getString("product_name"));
        return orders.toString();
    }
}
