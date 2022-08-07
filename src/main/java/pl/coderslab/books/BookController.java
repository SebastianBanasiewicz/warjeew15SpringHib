package pl.coderslab.books;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookRepository bookRepository;


    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/create")
    @ResponseBody
    public String saveBook() {
       Book build = Book.builder()
                .title("Potężny developer")
                .rating(10)
                .description("Potężna dawka wiedzy")
                .build();

        bookDao.save(build);

        Book byId = bookDao.findById(build.getId());
        System.out.println(byId.getTitle());

        byId.setTitle("Mierny developer");
        bookDao.update(byId);

        bookDao.delete(byId);

        return "OK";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable("id") Long id) {
        Book byId = bookDao.findById(id);
        System.out.println(byId.getTitle());
        return "OK";
    }

    @GetMapping("/update/{id}/{rating}")  // przykładowo jak chcemy edytować np. rating
    @ResponseBody
    public String update(@PathVariable Long id, @PathVariable int rating) {
        Book byId = bookDao.findById(id);
        byId.setRating(rating);
        bookDao.update(byId);
        return "OK";
    }

    @GetMapping("/save-publisher-book")
    @ResponseBody
    public String savePublisherAndBook() {

        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.create(publisher);
        Book book = new Book();
        book.setTitle("Some title");
        book.setPublisher(publisher);
        bookDao.save(book);
        return "";
    }

    @GetMapping("/save-authors-book")
    @ResponseBody
    public String saveAuthorsAndBook() {

        List<Author> authorList = new ArrayList<>();

        Author author1 = new Author();
        author1.setFirstName("Jan");
        author1.setLastName("Kowalski");
        authorDao.create(author1);
        authorList.add(author1);

        Author author2 = new Author();
        author2.setFirstName("Janek");
        author2.setLastName("Nowak");
        authorDao.create(author2);
        authorList.add(author2);

        Book book = new Book();
        book.setTitle("New JAVA Book");
        book.setAuthors(authorList);
        bookDao.save(book);
        return "OK";
    }

    @GetMapping("/book-rating")
    @ResponseBody
    public String bookRating(@RequestParam int rating) {
        bookDao.findAllByRating(rating)
                .forEach(b -> System.out.println(b.getTitle()));
        return "test-rating";
    }

    @GetMapping("/book-publishers")
    @ResponseBody
    public String bookWithPublishers() {
        bookDao.findBookWithPublishers()
                .forEach(b -> System.out.println(b.getTitle()));

        return "test-publishers";
    }

    @GetMapping("/book-authors")
    @ResponseBody
    public String bookWithAuthors(@RequestParam Long authorId) {
        bookDao.findBooksWithAuthor(authorDao.findById(authorId))
                .forEach(b -> System.out.println(b.getTitle()));
        return "test-authors";
    }

}
