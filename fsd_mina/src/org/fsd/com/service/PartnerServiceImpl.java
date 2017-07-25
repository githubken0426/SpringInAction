package org.fsd.com.service;

import org.fsd.com.dao.PartnerMapper;
import org.fsd.com.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="productService")
public class PartnerServiceImpl implements PartnerService {
	@Autowired
	private PartnerMapper partnerDao;

	@Override
	public Partner selectByPrimaryKey(String primaryKey) {
		return partnerDao.selectByPrimaryKey(primaryKey);
	}
	
	

}
