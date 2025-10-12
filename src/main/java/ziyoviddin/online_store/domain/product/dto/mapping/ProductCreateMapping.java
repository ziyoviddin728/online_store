package ziyoviddin.online_store.domain.product.dto.mapping;


import org.mapstruct.Mapper;
import ziyoviddin.online_store.domain.product.dto.ProductCreateDTO;
import ziyoviddin.online_store.domain.product.entitiy.Product;

@Mapper(componentModel = "spring")
public interface ProductCreateMapping {
    Product toEntity(ProductCreateDTO productCreateDto);
}
