package org.ken.fsd.dao;

import org.ken.fsd.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    Product selectByPrimaryKey(String id);
    Product selectByProductId(String productId);
}