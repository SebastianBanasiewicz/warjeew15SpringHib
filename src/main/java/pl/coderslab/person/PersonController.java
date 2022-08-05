package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.books.Author;

@Controller
@RequestMapping("/person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }


    @GetMapping("/create")
    @ResponseBody
    public String create() {

        Person person = Person.builder()
                .login("Sebastian")
                .password("12345")
                .email("Sebastian@sebastian.pl")
                .build();

        personDao.save(person);
        return "OK";
    }

    @GetMapping("/create1")
    @ResponseBody
    public String createPersonDetails() {

        PersonDetails personDetails = PersonDetails.builder()
                .firstName("Sebastian")
                .lastName("Potężny")
                .city("Wrocław")
                .street("Kiełbaśnicza")
                .streetNumber(20)
                .build();

        personDetailsDao.save(personDetails);

        return "OK";
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public String read(@PathVariable Long id) {

        Person personById = personDao.findById(id);
        System.out.println(personById.getLogin());
        return "OK";
    }

    @GetMapping("/update/{id}/{email}")
    @ResponseBody
    public String update(@PathVariable Long id, @PathVariable String email) {

        Person personById = personDao.findById(id);
        personById.setEmail(email);
        personDao.update(personById);
        return "OK";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {

        Person personById = personDao.findById(id);
        personDao.delete(personById);
        return "OK";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons", personDao.findAll());
        return "person/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping("/add")
    public String save(Person person){
        personDao.save(person);
        return "redirect:/person/list";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam Long id) {
        personDao.delete(personDao.findById(id));
        return "redirect:/person/list";
    }


}
