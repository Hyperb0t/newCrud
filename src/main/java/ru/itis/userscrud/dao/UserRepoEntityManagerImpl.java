package ru.itis.userscrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.userscrud.models.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component(value = "UserRepoEntityManagerImpl")
public class UserRepoEntityManagerImpl implements UserRepository {

    @Autowired
            @Qualifier("myEntityManager")
    EntityManager em;

    @Override
    public Optional<User> find(Integer id) {
        User user = em.find(User.class, id);
        em.detach(user);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        CriteriaQuery<User> q = em.getCriteriaBuilder().createQuery(User.class);
        q.select(q.from(User.class));
        return em.createQuery(q).getResultList();
    }

    @Override
    public User save(User entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.flush();
        em.getTransaction().commit();
        return entity;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        em.remove(em.find(User.class, id));
        em.flush();
        return true;
        //sad((
    }

    @Override
    @Transactional
    public boolean update(User entity) {
        em.persist(entity);
        em.flush();
        return true;
    }
}
