package mk.com.swshop.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.com.swshop.model.enums.Category;
import mk.com.swshop.model.enums.Color;
import mk.com.swshop.model.enums.Size;

import java.util.List;
import java.util.Map;

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

    @ElementCollection(targetClass = Size.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "size")
    private List<Size> sizes;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Enumerated(EnumType.STRING)
    private Category category;

    // Quantity по големина
    @ElementCollection
    @CollectionTable(name = "product_quantity", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "size")
    @Column(name = "quantity")
    private Map<Size, Integer> quantityBySize;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> images;

    public Product(
            String name,
            String description,
            Integer price,
            List<Size> sizes,
            Color color,
            Category category,
            Map<Size, Integer> quantityBySize
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.sizes = sizes;
        this.color = color;
        this.category = category;
        this.quantityBySize = quantityBySize;
    }

}
