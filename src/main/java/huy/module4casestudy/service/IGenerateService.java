package huy.module4casestudy.service;

import huy.module4casestudy.model.Coach;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);


    Coach save(T object);

    void deleteById(Long id);

}
