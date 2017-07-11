package org.ken.fsd.service.statistic;

import org.ken.fsd.dao.ApiCountMapper;
import org.ken.fsd.entity.ApiCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "apiCountService")
public class ApiCountServiceImpl implements ApiCountService {
	@Autowired
	private ApiCountMapper dao;
	
	@Override
	public ApiCount selectByPrimaryKey(String id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int insert(ApiCount count) {
		return dao.insert(count);
	}

}
