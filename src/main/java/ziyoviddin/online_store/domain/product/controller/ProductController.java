package ziyoviddin.online_store.domain.product.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ziyoviddin.online_store.domain.product.entitiy.Product;
import ziyoviddin.online_store.domain.product.service.ProductService;

@RestController
@RequestMapping("api/v1/products/")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create_product")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }


    @GetMapping
    public String hello() {
        return "hello";
    }
}
