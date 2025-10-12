package ziyoviddin.online_store.domain.product.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ziyoviddin.online_store.domain.product.dto.ProductCreateDTO;
import ziyoviddin.online_store.domain.product.dto.ProductDTO;
import ziyoviddin.online_store.domain.product.dto.ProductPartialUpdateDTO;
import ziyoviddin.online_store.domain.product.dto.ProductUpdateDTO;
import ziyoviddin.online_store.domain.product.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getProducts() {
        return productService.productList();
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product")
    public ProductDTO searchProduct(@RequestParam("name") String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/create_product")
    public ProductDTO createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        return productService.createProduct(productCreateDTO);
    }

    @PutMapping("/update_product/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        return productService.updateProduct(id, productUpdateDTO);
    }

    @PatchMapping("/partial_update_product/{id}")
    public ProductDTO partialUpdateProduct(@PathVariable Long id, @RequestBody ProductPartialUpdateDTO productPartialUpdateDTO) {
        return productService.partialUpdateProduct(id, productPartialUpdateDTO);
    }

    @DeleteMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
