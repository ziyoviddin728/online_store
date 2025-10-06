package ziyoviddin.online_store.domain.product.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ziyoviddin.online_store.domain.product.entitiy.Product;
import ziyoviddin.online_store.domain.product.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByNameProduct(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
