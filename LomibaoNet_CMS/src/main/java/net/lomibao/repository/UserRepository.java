package net.lomibao.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import net.lomibao.entity.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepository extends CrudRepository<net.lomibao.entity.User,String> {
    Optional<User> findFirstByRole(String role);
}
