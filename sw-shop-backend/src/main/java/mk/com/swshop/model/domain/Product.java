package mk.com.swshop.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.com.swshop.model.enums.Category;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String size;
    private String color;
    private String image;
    @ManyToOne
    private User user;
    @Enumerated(value = EnumType.STRING)
    private Category category

}
