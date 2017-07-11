package org.ken.fsd.service.auth;

import java.util.List;

import org.ken.fsd.dao.PartnerAuthMapper;
import org.ken.fsd.entity.PartnerAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "partnerAuthService")
public class PartnerAuthServiceImpl implements PartnerAuthService {
	@Autowired
	private PartnerAuthMapper dao;

	@Override
	public PartnerAuth selectByPrimaryKey(String id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<String> selectAuthByParenterId(String partnerid) {
		return dao.selectAuthByParenterId(partnerid);
	}

}
