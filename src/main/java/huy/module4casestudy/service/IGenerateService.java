package huy.module4casestudy.service;

import huy.module4casestudy.model.Member;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T object);

    void deleteById(Long id);

}
