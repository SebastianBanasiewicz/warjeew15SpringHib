package pl.coderslab.books;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/springData/book")
@RequiredArgsConstructor
@Transactional
public class SpringDataBookController {

    private final BookRepository bookRepository;

    @GetMapping("/category")
    public String getBookByCategory(@RequestParam(value = "category", required = false) Optional<String> categoryName ) {

        return categoryName
                .map(bookRepository::findByCategoryName)
                .map(Set::toString)
                .orElse("Brak");

    }

    @GetMapping("/title")
    public String getBookByTitle(@RequestParam("query") String query) {
        return bookRepository.findByTitle(query).toString();
    }

    @GetMapping("/rating")
    public String getBookByRating(@RequestParam("from") int from,
                                  @RequestParam("to") int to) {

        return bookRepository.findByRating(from, to).toString();
    }


}
