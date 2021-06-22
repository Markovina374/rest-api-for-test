package com.markov.restapifortest.repository;


import com.markov.restapifortest.entity.Contract;
import com.markov.restapifortest.entity.ContractMapper;
import com.markov.restapifortest.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepository implements CRUDRepository<Contract> {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public ContractRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /**
     * Метод возвращает список всех объектов
     *
     * @return - список
     */
    @Override
    public List<Contract> findAll() {
        return jdbcTemplate.query("SELECT * FROM contract",
                new Object[]{}, new ContractMapper());
    }

    /**
     * Метод ищет объект по идентификационному номеру
     *
     * @param id - идентификационный номер
     * @return - найденный объект
     */
    @Override
    public Contract findById(long id) {
        return jdbcTemplate.query("SELECT * FROM contract WHERE id = ?",
                new Object[]{id}, new ContractMapper())
                .stream()
                .findAny()
                .orElseThrow(NotFoundException::new);
    }

    /**
     * Метод удаления объекта
     *
     * @param id - идентификационный номер
     * @return - сообщение
     */
    @Override
    public String deleteById(long id) {
        if (jdbcTemplate.update("DELETE FROM contract WHERE id = ?", id) == 1) {
            return "Contract with this id = " + id + " deleted!";
        } else {
            return "Contract with this id = " + id + " was not found";
        }
    }

    /**
     * Метод сохранения объекта
     *
     * @param contract - новый объект
     * @return - вновь сохраненный объект
     */
    @Override
    public Contract save(Contract contract) {
        jdbcTemplate.update("INSERT INTO contract VALUES(?,?,?,?)",
                contract.getId(),
                contract.getDate(),
                contract.getDateOfLastUpdate(),
                contract.getDescription());
        return contract;
    }

    /**
     * Метод обновляет объект
     *
     * @param id     - идентификационный номер объекта который хотим обновить
     * @param contract - объект на который меняем
     * @return - обновленный объект
     */
    @Override
    public Contract update(int id, Contract contract) {
        contract.setId(id);
        jdbcTemplate.update("UPDATE cost SET date = ?, date_of_last_update = ?, description = ? WHERE id = ?",
                contract.getDate(), contract.getDateOfLastUpdate(),
                contract.getDescription(), id);
        return contract;
    }
}
