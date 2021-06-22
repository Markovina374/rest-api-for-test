package com.markov.restapifortest.controller;

import com.markov.restapifortest.entity.Contract;
import com.markov.restapifortest.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/contracts")
public class ContractController {
    @Autowired
    private final ContractRepository contractRepository;

    public ContractController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }
    @GetMapping
    public List<Contract> allContracts(){
        return contractRepository.findAll();
    }
    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return contractRepository.save(contract);
    }

    @GetMapping("{id}")
    public Contract getOne(@PathVariable("id") int id) {
        return contractRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id) {
        return contractRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public Contract updateContract(@PathVariable("id") int id,
                                   @RequestBody Contract contract) {
        return contractRepository.update(id, contract);


    }

}
