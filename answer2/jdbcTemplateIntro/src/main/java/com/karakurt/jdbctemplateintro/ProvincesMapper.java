package com.karakurt.jdbctemplateintro;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProvincesMapper implements RowMapper<Provinces> {
    public Provinces mapRow(ResultSet rs, int rowNum) throws SQLException {
        Provinces province = new Provinces();
        province.setId(rs.getLong("id"));
        province.setUId(rs.getString("u_id"));
        province.setNumberPlate(rs.getString("number_plate"));
        province.setName(rs.getString("name"));
        province.setCityOrNot(rs.getBoolean("city_or_not"));
        return province;
    }
}
