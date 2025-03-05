package com.valtech.training.restapis.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.restapis.services.OwnerService;
import com.valtech.training.restapis.services.WatchService;
import com.valtech.training.restapis.vos.OwnerVO;
import com.valtech.training.restapis.vos.WatchVO;
@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

//	@GetMapping("/watches/{brand}")
//	public List<WatchVO> getWatchesByBrand(@PathVariable(name = "brand") String brand){
//		return watchService.getWatchesByBrand(brand);
//	}
	
	@PutMapping("/{id}/watches")
	public OwnerVO updateWatches(@PathVariable(name = "id") long id, @RequestBody List<Long> watches) {
		return ownerService.addWatchesToOwner(id,watches);
	}
	
	@GetMapping("/{id}")
	public OwnerVO getOwner(@PathVariable(name = "id") long id) {
		return ownerService.getOwner(id);
	}
	
	@GetMapping("/")
	public List<OwnerVO> getOwners(){
			return ownerService.getOwners();
	}
	
	@PostMapping("/")
	public OwnerVO createOwner(@RequestBody OwnerVO ownerVO) {
		return ownerService.createOwner(ownerVO);
	}
	
	@PutMapping("/")
	public OwnerVO updateOwner(@PathVariable(name = "id") long id ,@RequestBody OwnerVO ownerVO) {
		return ownerService.updateOwner(ownerVO, id);
	}
}
