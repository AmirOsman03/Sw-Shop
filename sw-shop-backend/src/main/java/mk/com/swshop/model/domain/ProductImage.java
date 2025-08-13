package mk.com.swshop.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_images")
@Data
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne
    private Product product;

}
