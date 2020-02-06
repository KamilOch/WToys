package com.toys.wtoys.toy;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "toys", collectionResourceRel = "toys")
public interface ToyEntityRepository extends PagingAndSortingRepository<ToyEntity, Long> {

    List<ToyEntity> findAll();

}
