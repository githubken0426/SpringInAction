package org.ken.fsd.service.partner;

import org.ken.fsd.dao.PartnerMapper;
import org.ken.fsd.entity.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "partnerService")
public class PartnerServiceImpl implements PartnerService {
	@Autowired
	private PartnerMapper dao;

	@Override
	public Partner selectByPrimaryKey(String id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public Partner selectByParenterId(String partnerid) {
		return dao.selectByParenterId(partnerid);
	}

	@Override
	public int insertPartner(Partner partner) {
		return dao.insertPartner(partner);
	}


}
