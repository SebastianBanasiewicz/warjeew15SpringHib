package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.books.Book;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {


//    #Zadanie 1

    @Query("SELECT b FROM Book b WHERE b.category.name = :category")
    Set<Book> findByCategoryName(@Param("category") String categoryName);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findByTitle(String title);

//    #Zadanie 2

    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN :from AND :to")
    List<Book> findByRating(@Param("from") int from,
                            @Param("to") int to);



}
