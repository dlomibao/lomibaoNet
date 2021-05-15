package net.lomibao.service;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.data.repository.CrudRepository;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
public abstract class CrudService<R extends CrudRepository<E, I>,E,I>{

    public R crudRepository;

    public CrudService(CrudRepository<E,I> crudRepository){
        this.crudRepository= (R) crudRepository;
    }


    @NonNull
    public <S extends E> S save( @Valid @NotNull S entity) {
        return crudRepository.save(entity);
    }

    @NonNull
    public <S extends E> S update( @Valid @NotNull S entity) {
        return crudRepository.update(entity);
    }

    @NonNull
    public <S extends E> Iterable<S> saveAll( @Valid @NotNull Iterable<S> entities) {
        return crudRepository.saveAll(entities);
    }

    @NonNull
    public Optional<E> findById( @NotNull I i) {
        return crudRepository.findById(i);
    }

    public boolean existsById( @NotNull I i) {
        return crudRepository.existsById(i);
    }

    @NonNull
    public Iterable<E> findAll() {
        return crudRepository.findAll();
    }

    public long count() {
        return crudRepository.count();
    }

    public void deleteById( @NotNull I i) {
        crudRepository.deleteById(i);
    }

    public void delete( @NotNull E entity) {
        crudRepository.delete(entity);
    }

    public void deleteAll( @NotNull Iterable<? extends E> entities) {
        crudRepository.deleteAll(entities);
    }

    public void deleteAll() {
        crudRepository.deleteAll();
    }
}
