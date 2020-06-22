package ru.itis.userscrud.dao;

import org.springframework.stereotype.Repository;
import ru.itis.userscrud.models.User;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface JpaUserRepository extends CrudRepository<User, Integer> {

}
