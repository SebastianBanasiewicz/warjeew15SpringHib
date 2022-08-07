package pl.coderslab.books;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @PESEL
    private Integer pesel;
    @Email
    private String email;


}
