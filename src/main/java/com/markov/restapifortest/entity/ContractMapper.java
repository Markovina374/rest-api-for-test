package com.markov.restapifortest.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractMapper implements RowMapper<Contract> {
    @Override
    public Contract mapRow(ResultSet resultSet, int i) throws SQLException {
        Contract contract = new Contract();
        contract.setId(resultSet.getInt("id"));
        contract.setDate(resultSet.getDate("date").toLocalDate());
        contract.setDateOfLastUpdate(resultSet.getDate("date_of_last_update").toLocalDate());
        contract.setDescription(resultSet.getString("description"));
        return contract;
    }
}
