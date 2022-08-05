package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create() {

        Author newAuthor = Author.builder()
                .firstName("Adam")
                .lastName("Adamowski")
                .build();

        authorDao.create(newAuthor);
        return "OK";
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable Long id) {

        Author authorById = authorDao.findById(id);
        System.out.println(authorById.getFirstName());
        return "OK";
    }

    @GetMapping("/update/{id}/{firstName}") // przykładowo potrzebujemy zmienić imię autora
    @ResponseBody
    public String update(@PathVariable Long id, @PathVariable String firstName) {

        Author authorById = authorDao.findById(id);
        authorById.setFirstName(firstName);
        authorDao.update(authorById);
        return "OK";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {

        Author authorById = authorDao.findById(id);
        authorDao.delete(authorById);
        return "OK";
    }
}
