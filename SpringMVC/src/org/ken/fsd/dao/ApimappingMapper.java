package org.ken.fsd.dao;

import org.ken.fsd.entity.Apimapping;
import org.springframework.stereotype.Repository;

@Repository
public interface ApimappingMapper {

    Apimapping selectByPrimaryKey(String id);
    /**
     * 查询api名称
     * @param apiid
     * @return
     * 2017-1-19 下午03:00:06
     */
    Apimapping queryByApiId(String apiid);
}