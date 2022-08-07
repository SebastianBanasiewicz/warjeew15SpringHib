package pl.coderslab.books;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(min = 5)
    private String title;
//    @Range(min = 1, max = 10)
    private int rating;
    @NotBlank
    @Length(max = 600)
    private String description;
//    @Min(2)
    @Column(name = "pages")
    private Integer pages;

//    @NotNull
    @ManyToOne
    private Publisher publisher;

//    @NotEmpty
    @ManyToMany
    private List<Author> authors;

    @ManyToOne
    private Category category;

}
