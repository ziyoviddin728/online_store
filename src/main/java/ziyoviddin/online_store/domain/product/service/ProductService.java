package ziyoviddin.online_store.domain.product.service;

import ziyoviddin.online_store.domain.product.entitiy.Product;

public interface ProductService {
    Product saveProduct(Product product);

    Product updateProduct(Product product);

    Product findByNameProduct(String name);

    void deleteProduct(Long id);
}
