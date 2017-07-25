package org.fsd.com.dao;

import org.fsd.com.entity.Partner;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerMapper {
	public Partner selectByPrimaryKey(String primaryKey);
}
