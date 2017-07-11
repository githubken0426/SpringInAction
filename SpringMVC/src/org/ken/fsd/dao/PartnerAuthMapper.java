package org.ken.fsd.dao;

import java.util.List;

import org.ken.fsd.entity.PartnerAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerAuthMapper {
    
    PartnerAuth selectByPrimaryKey(String id);

    /**
     * 通过合作伙伴id获取api权限
     * @param partnerid
     * @return
     * 2017-1-19 下午01:58:16
     */
    List<String> selectAuthByParenterId(String partnerid);
}