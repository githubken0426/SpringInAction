package org.ken.fsd.service.partner;

import org.ken.fsd.entity.Partner;

public interface PartnerService {
	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public Partner selectByPrimaryKey(String id) throws Exception;

	 /**
     * 通过合作伙伴key查询
     * @param partnerid
     * @return
     * 2017-1-19 下午01:29:50
     */
    Partner selectByParenterId(String partnerid);
    
    int insertPartner(Partner partner);
}
