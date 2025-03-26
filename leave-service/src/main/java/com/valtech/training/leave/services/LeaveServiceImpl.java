package com.valtech.training.leave.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.controllers.approveLeaveVo;
import com.valtech.training.leave.entities.Leave;
import com.valtech.training.leave.entities.LeaveMaster;
import com.valtech.training.leave.repos.LeaveMasterRepo;
import com.valtech.training.leave.repos.LeaveRepo;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveMasterRepo leaveMasterRepo;
	
	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	EmployeeClient employeeclient;
	
	@Override
	public LeaveVO approveLeave(approveLeaveVo vo) {
		System.out.println("Approve Leave = "+vo);
		Leave leave = leaveRepo.getReferenceById(vo.leaveId());
//We have to call EmployeeMicroService to understand the manager
		System.out.println("LeVE = "+leave);
		System.out.println("-------------"+leave.getEmployeeId());
		long manager = employeeclient.getEmployeeAsManager(leave.getEmployeeId()).managerId();  //get from empService
		if(manager == vo.manager()) {
			LeaveMaster lm = leaveMasterRepo.findByEmployeeId(leave.getEmployeeId());
			lm.takeLeaves(leave);
			leaveMasterRepo.save(lm);
			leave.approveLeave(lm, manager);
			leave.updateLeave(vo.comments());
		}else {
			leave.updateLeave("You are not the Manager to approve");
		}
		
		
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}
	
	public LeaveVO applyLeave(LeaveVO vo) {
		Leave leave = vo.to();
		System.out.println("Leave = "+leave);
		leave.setLeaveStatus(LeaveStatus.APPLIED);
		leave.checkLeaveApplicationAndUpdateStatus(leaveMasterRepo.findByEmployeeId(vo.employeeId()));
		System.out.println("After Check Leave = "+leave);
		leaveRepo.save(leave);
		System.out.println("Leave After Save = "+leave);
		//Send Notification to Manager
		return LeaveVO.from(leave);
	}
	
	@Override
	public List<LeaveVO> getLeavesByEmployee(long emp){
		return LeaveVO.from(leaveRepo.findAllByEmployeeId(emp)) ;
	}
	
	@Override
	public LeaveVO saveOrUpdateLeave(LeaveVO vo) {
		Leave leave = vo.to();
		return LeaveVO.from(leaveRepo.save(leave));
	}
	
	@Override
	public LeaveVO getLeave(long id) {
		return LeaveVO.from(leaveRepo.getReferenceById(id));
	}
	
	@Override
	public List<LeaveVO> getAllLeaves(){
		return leaveRepo.findAll().stream().map(l->LeaveVO.from(l)).collect(Collectors.toList());
	}
	
	@Override
	public List<LeaveMasterVO> getAllLeaveMaster(){
		return leaveMasterRepo.findAll().stream().map(lm->LeaveMasterVO.from(lm)).collect(Collectors.toList());
	}
	
	@Override
	public LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo) {
		LeaveMaster lm = vo.to();
		lm = leaveMasterRepo.save(lm);
		return LeaveMasterVO.from(lm);
	}
	
	@Override
	public LeaveMasterVO getLeaveMaster(long employeeId) {
		LeaveMaster lm = leaveMasterRepo.findByEmployeeId(employeeId);
		return LeaveMasterVO.from(lm);
	}

	@Override
	public LeaveVO update(LeaveVO vo, long id) {
		Leave leave = leaveRepo.getReferenceById(id);
		vo.updateTo(leave);
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}

	@Override
	public EmployeeVO getManager(long employeeId) {
		return employeeclient.getEmployeeAsManager(employeeId);

	}


}
