package com.valtech.training.leave.vos;

import java.awt.Label;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.commons.LeaveType;
import com.valtech.training.leave.entities.Leave;
public record LeaveVO(long id, String fromDate, String toDate, String leaveType , String leaveStatus, String reason, String comments, long employeeId) {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	 
	public void updateTo(Leave leave){
		LocalDate from = LocalDate.parse(fromDate,formatter);
		LocalDate to = LocalDate.parse(toDate,formatter);
		LeaveType lType = LeaveType.valueOf(leaveType);
		LeaveStatus lStatus = LeaveStatus.valueOf(leaveStatus); 
		leave.setFromDate(from);
		leave.setToDate(to);
		leave.setLeaveType(lType);
		leave.setLeaveStatus(lStatus);
		leave.setReson(reason);
		leave.setComments(comments);
	}
	
	public Leave to() {
		LocalDate from = LocalDate.parse(fromDate,formatter);
		LocalDate to = LocalDate.parse(toDate,formatter);
		LeaveType lType = LeaveType.valueOf(leaveType);
		LeaveStatus lStatus = LeaveStatus.valueOf(leaveStatus);
		System.out.println("Leave VO = "+this);
		return new Leave(id,from,to , lType, lStatus, reason, comments,employeeId);
				
	}
	public static List<LeaveVO> from(List<Leave> leaves){
		return leaves.stream().map(l -> from(l)).collect(Collectors.toList());
	}
	
	public static LeaveVO from(Leave l) {
		String from = l.getFromDate().format(formatter);
		String to = l.getToDate().format(formatter);
		String lType = l.getLeaveType().name();
		String lStatus = l.getLeaveStatus().name();
		return new LeaveVO(l.getId(),from, to, lType, lStatus, l.getReson(), l.getComments(), l.getEmployeeId());
	}
}
