package pl.coderslab.person;

import org.springframework.stereotype.Repository;
import pl.coderslab.books.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }

    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p FROM Person p").getResultList();
    }
}
