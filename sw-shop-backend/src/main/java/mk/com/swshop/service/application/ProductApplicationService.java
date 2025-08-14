package mk.com.swshop.service.application;

import mk.com.swshop.dto.create.CreateProductDto;
import mk.com.swshop.dto.display.DisplayProductDto;
import mk.com.swshop.model.enums.Category;

import java.util.List;
import java.util.Optional;

public interface ProductApplicationService {

    List<DisplayProductDto> findAll();

    DisplayProductDto create(CreateProductDto createProductDto);

    Optional<DisplayProductDto> edit(Long id, CreateProductDto createProductDto);

    DisplayProductDto delete(Long id);

    DisplayProductDto findById(Long id);

    List<DisplayProductDto> findByCategoryId(Category category);

}
