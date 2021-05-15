package net.lomibao.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;
import net.lomibao.entity.Category;

@JdbcRepository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
