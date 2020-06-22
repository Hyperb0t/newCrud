package ru.itis.userscrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.userscrud.models.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component(value = "UserRepoJdbcTemplateImpl")
public class UserRepoJdbcTemplateImpl implements UserRepository {

    private static final String SQL_SELECT_BY_ID = "select * from \"User\" where id = ?";

    private static final String SQL_SELECT_ALL = "select * from \"User\"";

    private static final String SQL_INSERT = "insert into \"User\"(email, password, country, gender, birthday)" +
            "values (?,?,?,?,?)";

    private static final String SQL_DELETE_BY_ID = "delete from \"User\" where id = ?";

    private static final String SQL_UPDATE = "update \"User\" " +
            "set email = ?, password = ?, country = ?, gender = ?, birthday = ? " +
            "where id = ?";

    private static final String SQL_SELECT_BY_ATTRIBUTES = "select * from \"User\" ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (row, rowNumber) ->
            User.builder()
                    .id(row.getInt("id"))
                    .email(row.getString("email"))
                    .password(row.getString("password"))
                    .country(row.getString("country"))
                    .gender(row.getString("gender").charAt(0))
                    .birthday(row.getDate("birthday").toLocalDate())
                    .build();


    @Override
    public Optional<User> find(Integer id) {
        try {
            User user = jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, userRowMapper);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    @Override
    public User save(User entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        int result = jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection
                    .prepareStatement(SQL_INSERT, new String[]{"id"});
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getCountry());
            statement.setString(4, entity.getGender().toString());
            statement.setDate(5, Date.valueOf(entity.getBirthday()));
            return statement;
        }, keyHolder);
        entity.setId((Integer)keyHolder.getKey());
        if(result > 0) {
            return entity;
        }
        else
            return null;
    }

    @Override
    public boolean delete(Integer id) {
        return jdbcTemplate.update(SQL_DELETE_BY_ID, new Object[]{id}) == 1;
    }

    @Override
    public boolean update(User entity) {
        Object[] args = new Object[]{entity.getEmail(), entity.getPassword(), entity.getCountry(), entity.getGender(),
        entity.getBirthday(), entity.getId()};
        return jdbcTemplate.update(SQL_UPDATE) == 1;
    }
}
