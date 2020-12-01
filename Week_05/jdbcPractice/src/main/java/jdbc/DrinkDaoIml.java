package jdbc;

import entity.Drink;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class DrinkDaoIml implements DrinkDao {
    @Override
    public int insertDrink(Drink drink) {
        String insertSql = "insert into drink_list(name,price,toast) values(？,？,？)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            try {
                preparedStatement.setString(1, drink.getName());
                preparedStatement.setString(2, drink.getToast());
                preparedStatement.setDouble(3, drink.getPrice());
                log.info("insert new drink success");
                return preparedStatement.executeUpdate();
            } catch (SQLException exception) {
                log.error("insert new drink error");
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    log.error("insert failed rollback");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Drink queryDrinkByName(String name) {
        String selectSql = "select name,toast,price from drink_list where name=?";
        ResultSet rs = null;
        Drink drink = new Drink();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            try {
                preparedStatement.setString(1, name);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    drink.setPrice(rs.getDouble("price"));
                    drink.setToast(rs.getString("toast"));
                }
                log.info("query drink by name=[{}] success",name);
            } catch (SQLException e) {
                log.error("query drink by name failed", e);
            }
        } catch (SQLException ex) {
            log.error("execution sql error", ex);
        }
        return drink;
    }

    @Override
    public int updateDrink(Drink drink) {
        String updateSql = "update drink_list set toast=?,price=? where name=?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            try {
                preparedStatement.setString(1, drink.getToast());
                preparedStatement.setDouble(2, drink.getPrice());
                preparedStatement.setString(3, drink.getName());

                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                log.error("update drink failed", e);
            }
        } catch (SQLException e) {
            log.error("execution update sql failed", e);
        }
        return 0;
    }

    @Override
    public int deleteDrinkByName(String name) {
        String deleteSql = "delete from drink_list where name=?";
        try(Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)){
            preparedStatement.setString(1,name);
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            log.error("execution delete drink failed");
        }
        return 0;
    }

}

