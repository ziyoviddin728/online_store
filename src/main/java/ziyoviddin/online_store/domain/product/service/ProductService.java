package ziyoviddin.online_store.domain.product.service;

import ziyoviddin.online_store.domain.product.dto.ProductCreateDTO;
import ziyoviddin.online_store.domain.product.dto.ProductDTO;
import ziyoviddin.online_store.domain.product.dto.ProductPartialUpdateDTO;
import ziyoviddin.online_store.domain.product.dto.ProductUpdateDTO;
import ziyoviddin.online_store.domain.product.entitiy.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> productList();

    ProductDTO getProductById(Long id);
    ProductDTO getProductByName(String name);

    ProductDTO createProduct(ProductCreateDTO productCreateDTO);
    ProductDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO);

    ProductDTO partialUpdateProduct(Long Id, ProductPartialUpdateDTO productPartialUpdateDTO);

    String deleteProduct(Long id);
}
