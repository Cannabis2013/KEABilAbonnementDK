package com.example.keabilabonnement.services.db;

import com.example.keabilabonnement.contracts.db.DbStatement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class DbPreparedStatement_imp_1 implements DbStatement {
    @Override
    public PreparedStatement get(String sql){
        var con = DbConnection.getInstance(url,username,password).get();
        if(con == null)
            return null;
        try {
            return con.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
}
