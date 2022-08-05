package pl.coderslab.books;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create() {

        Publisher publisher = Publisher.builder()
                .name("Poligraf").build();

        publisherDao.create(publisher);
        return "OK";
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable Long id) {

        Publisher publisherById = publisherDao.find(id);

        System.out.println(publisherById.getName());
        return "OK";
    }

    @GetMapping("/update/{id}/{name}")
    @ResponseBody
    public String update(@PathVariable Long id, @PathVariable String name) {

        Publisher publisherById = publisherDao.find(id);
        publisherById.setName("Albatros");
        publisherDao.update(publisherById);
        return "OK";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {

        Publisher publisherById = publisherDao.find(id);
        publisherDao.delete(publisherById);
        return "OK";
    }
}
