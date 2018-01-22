package com.baobaotao.dao;

import com.baobaotao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Map;

/**
 * @author Static
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password) {
        String sqlStr = "SELECT count(1) as cnt from t_user where user_name = ? and password=?";
        Map<String, Object> result = jdbcTemplate.queryForMap(sqlStr, new Object[]{userName, password});
        if (result == null || result.isEmpty()) {
            return 0;
        }
        return Integer.valueOf(result.get("cnt") + "");
    }

    public User findUserByUserName(String userName) {
        String sqlStr = "Select user_id,user_name,credits from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setCredits(rs.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user) {
        String sqlStr = "Update t_user set last_visit=?,last_ip=?,credits=? where user_id = ?";
        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
        throw new RuntimeException("测试回滚");
    }

    public int insert(final String userName, final String password) {
        final String sql = "INSERT into t_user(user_name,password) values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, userName);
                ps.setObject(2, password);
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
}