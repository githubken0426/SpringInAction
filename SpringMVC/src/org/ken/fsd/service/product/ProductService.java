package org.ken.fsd.service.product;

import org.ken.fsd.entity.Product;

public interface ProductService {

	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public Product selectByPrimaryKey(String id) throws Exception;

	Product selectByProductId(String productId);
}
