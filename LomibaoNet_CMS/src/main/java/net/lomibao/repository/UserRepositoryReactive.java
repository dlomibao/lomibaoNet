package net.lomibao.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import net.lomibao.entity.User;

import javax.transaction.Transactional;

@Transactional
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepositoryReactive extends ReactiveStreamsCrudRepository<User,String> {
}
