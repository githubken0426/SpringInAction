package org.ken.fsd.service.apimap;

import org.ken.fsd.entity.Apimapping;

public interface ApimappingService {


	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public Apimapping selectByPrimaryKey(String id) throws Exception;

	 /**
     * 查询api名称
     * @param apiid
     * @return
     * 2017-1-19 下午03:00:06
     */
    Apimapping queryByApiId(String apiid);
	
}
