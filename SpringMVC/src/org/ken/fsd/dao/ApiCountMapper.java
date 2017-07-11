package org.ken.fsd.dao;

import org.ken.fsd.entity.ApiCount;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiCountMapper {
	
    ApiCount selectByPrimaryKey(String id);
    /**
     * 插入数据
     * @param count
     * @return
     * 2017-1-20 下午01:38:59
     */
    int insert(ApiCount count);
}