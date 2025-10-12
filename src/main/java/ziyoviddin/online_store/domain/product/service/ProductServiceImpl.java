package ziyoviddin.online_store.domain.product.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ziyoviddin.online_store.domain.product.dto.ProductCreateDTO;
import ziyoviddin.online_store.domain.product.dto.ProductDTO;
import ziyoviddin.online_store.domain.product.dto.ProductPartialUpdateDTO;
import ziyoviddin.online_store.domain.product.dto.ProductUpdateDTO;
import ziyoviddin.online_store.domain.product.dto.mapping.ProductCreateMapping;
import ziyoviddin.online_store.domain.product.dto.mapping.ProductMapping;
import ziyoviddin.online_store.domain.product.entitiy.Product;
import ziyoviddin.online_store.domain.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapping productMapping;
    private final ProductCreateMapping productCreateMapping;

    @Override
    public List<ProductDTO> productList() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();

        for (Product product : productList) {
            ProductDTO productDTO = productMapping.toDto(product);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapping::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public ProductDTO getProductByName(String name) {
        Product product = productRepository.findByName(name);
        return productMapping.toDto(product);
    }

    @Override
    public ProductDTO createProduct(ProductCreateDTO productCreateDto) {
        Product product = productCreateMapping.toEntity(productCreateDto);
        Product saveProduct = productRepository.save(product);
        return productMapping.toDto(saveProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO) {
        Product existingProduct  = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(productUpdateDTO.getName());
        existingProduct.setDescription(productUpdateDTO.getDescription());
        existingProduct.setPrice(productUpdateDTO.getPrice());
        existingProduct.setQuantity(productUpdateDTO.getQuantity());
        productRepository.save(existingProduct);

        return productMapping.toDto(existingProduct);
    }


    @Override
    public ProductDTO partialUpdateProduct(Long id, ProductPartialUpdateDTO productPartialUpdateDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: \" + id"));

        if (productPartialUpdateDTO.getName() != null) {
            existingProduct.setName(productPartialUpdateDTO.getName());
        }
        if (productPartialUpdateDTO.getDescription() != null) {
            existingProduct.setDescription(productPartialUpdateDTO.getDescription());
        }
        if (productPartialUpdateDTO.getPrice() != null) {
            existingProduct.setPrice(productPartialUpdateDTO.getPrice());
        }
        if (productPartialUpdateDTO.getQuantity() != null) {
            existingProduct.setQuantity(productPartialUpdateDTO.getQuantity());
        }
        productRepository.save(existingProduct);

        return productMapping.toDto(existingProduct);
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product deleted!";
    }
}
