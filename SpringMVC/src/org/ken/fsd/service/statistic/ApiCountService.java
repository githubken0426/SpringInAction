package org.ken.fsd.service.statistic;

import org.ken.fsd.entity.ApiCount;

public interface ApiCountService {

	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public ApiCount selectByPrimaryKey(String id) throws Exception;

	 /**
     * 插入数据
     * @param count
     * @return
     * 2017-1-20 下午01:38:59
     */
    int insert(ApiCount count);
	
}
