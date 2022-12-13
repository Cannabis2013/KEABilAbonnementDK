package com.example.keabilabonnement.repository.mysql.inspection;

import com.example.keabilabonnement.services.db.DBConnection;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class DbInspectionRemover {


    /*

        Author: Nikki Deleuran

    */

    public boolean remove(String id) {

        try {
            deleteAssociatedDamages(id);
            deleteDamageReport(id);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    private void deleteAssociatedDamages(String id) throws SQLException {

        String sql = """
                DELETE FROM damage
                WHERE DamageReportId=?;
                """;

        try {
            PreparedStatement statement = DBConnection.statement(sql);
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public boolean deleteDamageById(String id) {
        try {
            deleteDamage(id);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    private void deleteDamage(String id) throws SQLException {
        String sql = """
                DELETE FROM damage
                WHERE id=?;
                """;
        try {
            PreparedStatement statement = DBConnection.statement(sql);
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    private void deleteDamageReport(String id) throws SQLException {

        String sql = """
                DELETE FROM damagereport
                WHERE Id=?;
                """;

        try {
            PreparedStatement statement = DBConnection.statement(sql);
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
