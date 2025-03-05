package com.valtech.training.restapis.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.repos.OwnerRepo;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.OwnerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private WatchRepo watchRepo;
	@Override
	public OwnerVO createOwner(OwnerVO o) {
		return OwnerVO.from(ownerRepo.save(o.toOwner()));
	}
	
	@Override
	public OwnerVO updateOwner(OwnerVO o , long id) {
		Owner o1 = ownerRepo.getReferenceById(id);
		o.updateOrderFromVO(o1);
		return OwnerVO.from(ownerRepo.save(o1));
	}
	
	@Override
	public OwnerVO getOwner(long id) {
		return OwnerVO.from(ownerRepo.getReferenceById(id)) ;
	}
	

	@Override
	public List<OwnerVO> getOwners(){
		return  OwnerVO.toOwnerVO(ownerRepo.findAll());
	}

	@Override
	public OwnerVO addWatchesToOwner(long id, List<Long> watches) {
		
		final Owner o = ownerRepo.getReferenceById(id);
		watches.stream().forEach(wid -> o.addWatch(watchRepo.getReferenceById(wid)));
		Owner o1 = ownerRepo.save(o);
		return OwnerVO.from(o1);
		}


}
