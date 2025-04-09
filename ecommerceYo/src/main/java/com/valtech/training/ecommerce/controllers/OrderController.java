package com.valtech.training.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.valtech.training.ecommerce.services.ItemService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.LineItemVO;
import com.valtech.training.ecommerce.vos.OrderItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;

@Controller
@SessionAttributes(names = {"itemIds","itemQty"})
public class OrderController {

	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ItemService itemService;
	
	
	@GetMapping("/order")
	public String orderPage(@ModelAttribute ItemVO item,Model model) {
		model.addAttribute("item",itemService.getAll());
		return "order";
	}
	
	@PostMapping("/order")
	public String createOrder(@ModelAttribute OrderVO vo,Model model) {
//		System.out.println(orderItemVO.getIds());
//		List<Long> ids = (List<Long>) model.getAttribute("itemIds");
//		List<Integer> qty = (List<Integer>) model.getAttribute("itemQty");
//		List<LineItemVO> lt = (List<LineItemVO>) model.getAttribute("lineItem");
		
//		if(ids == null) ids = new ArrayList<Long>();
//		if(qty == null) qty = new ArrayList<Integer>();
//		if(lt == null) lt = new ArrayList<LineItemVO>();
		
//		System.out.println("-----------"+orderItemVO.getIds());
//		ids.add(orderItemVO.getIds());
//		qty.add(orderItemVO.getQty());
//		lt.add(lineItemVO);
		
//		model.addAttribute("itemIds",ids);
//		model.addAttribute("itemQty",qty);
//		model.addAttribute("item",itemService.getAll());
		System.out.println("vo---------"+vo);
		orderService.createOrder(vo);
		return "order";
	}
	
	@PostMapping("/handleClick")
	public String handleClick(@RequestParam("userId") long userId,@ModelAttribute ItemVO item) {
		System.out.println("id "+userId+item.getQty());
		
		return "order";
	}
}
