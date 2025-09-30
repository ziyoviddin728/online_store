package com.ziyoviddin.online_store.domain.product.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity = 0;

    @CreationTimestamp
    @Column(name = "created_on", updatable = false)
    private Instant createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private Instant lastUpdatedOn;
}
