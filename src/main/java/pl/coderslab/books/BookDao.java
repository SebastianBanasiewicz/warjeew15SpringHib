package pl.coderslab.books;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {


    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.rating = :rating")
                .setParameter("rating", rating)
                .getResultList();
    }

    public List<Book> findBookWithPublishers() {
        return entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher")
                .getResultList();
    }

    public List<Book> findBooksWithPublisher(List<Publisher> publishers) {
        return entityManager
                .createQuery("SELECT b FROM Book b WHERE b.publisher in :publishers")
                .setParameter("publishers", publishers)
                .getResultList();

    }

    public List<Book> findBooksWithAuthor(Author author) {
        return entityManager
                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors " +
                        "WHERE :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }

}