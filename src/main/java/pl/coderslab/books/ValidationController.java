package pl.coderslab.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/validate")
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping
    public String validate(Model model) {
        Book book = new Book();
        Set<ConstraintViolation<Book>> validationResult = validator.validate(book);
        model.addAttribute("violations", validationResult);

        if (!validationResult.isEmpty()) {
            validationResult.forEach(violation -> {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            });
        }
        return "validate";
    }
}
