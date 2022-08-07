package pl.coderslab.books;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
