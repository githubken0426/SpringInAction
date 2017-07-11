package org.ken.fsd.service.product;

import org.ken.fsd.dao.ProductMapper;
import org.ken.fsd.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper dao;

	@Override
	public Product selectByPrimaryKey(String id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public Product selectByProductId(String productId) {
		return dao.selectByProductId(productId);
	}

}
