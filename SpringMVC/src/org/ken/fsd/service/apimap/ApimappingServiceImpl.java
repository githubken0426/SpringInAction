package org.ken.fsd.service.apimap;

import org.ken.fsd.dao.ApimappingMapper;
import org.ken.fsd.entity.Apimapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "apimappingService")
public class ApimappingServiceImpl implements ApimappingService {
	@Autowired
	private ApimappingMapper dao;

	
	@Override
	public Apimapping selectByPrimaryKey(String id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}


	@Override
	public Apimapping queryByApiId(String apiid) {
		return dao.queryByApiId(apiid);
	}
}
