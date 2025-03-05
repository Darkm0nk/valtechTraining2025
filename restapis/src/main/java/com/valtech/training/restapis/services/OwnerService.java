package com.valtech.training.restapis.services;

import java.util.List;
import java.util.Set;

import com.valtech.training.restapis.vos.OwnerVO;

public interface OwnerService {

	OwnerVO createOwner(OwnerVO o);

	OwnerVO updateOwner(OwnerVO o, long id);

	OwnerVO getOwner(long id);

	List<OwnerVO> getOwners();

	OwnerVO addWatchesToOwner(long id, List<Long> watches);
	


}