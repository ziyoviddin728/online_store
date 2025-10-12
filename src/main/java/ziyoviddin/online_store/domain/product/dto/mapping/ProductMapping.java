package ziyoviddin.online_store.domain.product.dto.mapping;


import org.mapstruct.Mapper;
import ziyoviddin.online_store.domain.product.dto.ProductDTO;
import ziyoviddin.online_store.domain.product.entitiy.Product;

@Mapper(componentModel = "spring")
public interface ProductMapping {
    ProductDTO toDto(Product product);
}
