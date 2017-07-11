package org.ken.fsd.dao;

import org.ken.fsd.entity.Partner;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerMapper {

    Partner selectByPrimaryKey(String id);
    /**
     * 通过合作伙伴key查询
     * @param partnerid
     * @return
     * 2017-1-19 下午01:29:50
     */
    Partner selectByParenterId(String partnerid);
    
    
    public int insertPartner(Partner partner);
}