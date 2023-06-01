package com.example.demo3.entity;

import com.example.demo3.Validator.annotation.ValidCategoryId;
import jakarta.persistence.*;
import com.example.demo3.Validator.annotation.ValidUserId;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Table(name = "book")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")

    private @NotEmpty(message = "Title must not be empty") @Size(max = 50, min = 1, message = "Title must be less than 50 characters") String title;

    @Column(name = "author")
    private String author;

    @Column(name = "price")

    private @NotNull(message = "Price is required") Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;


   /* private Long id;
    private String title;
    private String author;
    private Double price;
    private String category;

    public  Book(){

    }
    public Book(Long id, String title, String author, Double price, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }*/
}
