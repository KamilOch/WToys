package com.toys.wtoys.toy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ToyService {

    private ToyEntityRepository repository;

    @Autowired
    public ToyService(ToyEntityRepository repository) {
        this.repository = repository;
    }

    public List<ToyEntity> getAllToys() {
        return repository.findAll().stream()
              //  .map(it-> ToyEntity.builder().id(it.getId()).toyName(it.getToyName()).build()).collect(Collectors.toList());
                .map(it-> new ToyEntity(it.getId(),it.getToyName())).collect(Collectors.toList());
    }
}
