package mk.com.swshop.service.domain;
import mk.com.swshop.model.domain.Product;
import mk.com.swshop.model.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long id);

    Optional<Product> update(Long id, Product product);

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findByCategory(Category category);

    Product saveWithImages(Product product, List<MultipartFile> images) throws IOException;

}


