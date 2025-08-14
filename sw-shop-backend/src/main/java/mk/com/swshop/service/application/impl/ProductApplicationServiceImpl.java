package mk.com.swshop.service.application.impl;

import mk.com.swshop.dto.create.CreateProductDto;
import mk.com.swshop.dto.display.DisplayProductDto;
import mk.com.swshop.service.application.ProductApplicationService;
import mk.com.swshop.service.domain.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    private final ProductService productService;

    public ProductApplicationServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<DisplayProductDto> findAll() {
        return DisplayProductDto.from(productService.findAll());
    }

    @Override
    public DisplayProductDto create(CreateProductDto createProductDto) {
        return DisplayProductDto.from(productService.save(createProductDto.toProduct()));
    }

    @Override
    public Optional<DisplayProductDto> edit(Long id, CreateProductDto createProductDto) {
        return productService.update(id, createProductDto.toProduct())
                .map(DisplayProductDto::from);
    }

    @Override
    public DisplayProductDto delete(Long id) {
        return DisplayProductDto.from(productService.findById(id).orElseThrow());
    }

    @Override
    public DisplayProductDto findById(Long id) {
        return DisplayProductDto.from(productService.findById(id).orElseThrow());
    }
}
