package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping("/add")
        public String save(Student student, Model model) {
        model.addAttribute("student", student);
        return "student/save";
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return Arrays.asList("TV watching", "Sleeping all day", "Be strong like a jam", "Looking for dwarfs", "Programming");
    }

    @ModelAttribute("programmingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList("Database and SQL", "Object-oriented programming (OOP) languages", "Web development", "Patience", "Data structures and algorithms");
    }

}
