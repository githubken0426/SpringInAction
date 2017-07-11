package org.ken.fsd.service.auth;

import java.util.List;

import org.ken.fsd.entity.PartnerAuth;


public interface PartnerAuthService {
	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public PartnerAuth selectByPrimaryKey(String id) throws Exception;

	/**
     * 通过合作伙伴id获取api权限
     * @param partnerid
     * @return
     * 2017-1-19 下午01:58:16
     */
    List<String> selectAuthByParenterId(String partnerid);
	
}
