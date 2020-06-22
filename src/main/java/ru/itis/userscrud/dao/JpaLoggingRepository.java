package ru.itis.userscrud.dao;

import org.springframework.stereotype.Repository;
import ru.itis.userscrud.models.Logging;

@Repository
public interface JpaLoggingRepository extends CrudRepository<Integer, Logging>{
}
