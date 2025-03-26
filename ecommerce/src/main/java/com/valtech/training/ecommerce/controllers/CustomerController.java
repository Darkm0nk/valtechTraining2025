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

import com.valtech.training.ecommerce.entities.Customer.CustStatus;
import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.services.CustomerService;
import com.valtech.training.ecommerce.services.ItemService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.vos.CustomerVO;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.LineItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;
import com.valtech.training.ecommerce.vos.addItemVO;

@Controller
@SessionAttributes(names = {"lineitems"})
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/custRegister")
	public String addCustomer(@ModelAttribute CustomerVO customerVO, Model model) {
		customerVO.setCustStatus("ENABLE");
		customerService.addCustomer(customerVO);
		model.addAttribute("customer",customerVO);
		return "order";
		
	}
	
	@GetMapping("/custRegister")
	public String regCustomer() {
		return "custRegister";
	}
	
	@GetMapping("/order")
	public String order(@ModelAttribute ItemVO itemVO , Model model) {
		model.addAttribute("items",itemService.getAllItems());
		return "order";
	}
	
	@PostMapping("/order")
	public String createList(@ModelAttribute LineItemVO lineItemVO, Model model) {
		
		List<LineItemVO> lineItems = (List<LineItemVO>) model.getAttribute("lineitems");

		
		if(lineItems==null) lineItems = new ArrayList<LineItemVO>();
		
//			LineItems items = lineItemVO.to(itemService.getItem(Long.parseLong(lineItemVO.id()) ))
			lineItems.add(lineItemVO);
			System.out.println("items::: " + model.addAttribute(model.getAttribute("items")));
			model.addAttribute("itemIds",lineItems);
		
		
//		model.addAttribute(model.getAttribute("items"));
		return "redirect:/order";
	}
	
	@PostMapping("/orderItem")
	public String createOrder(@ModelAttribute OrderVO orderVO, Model model) {
		orderVO.setStatus("ORDERED");
		orderVO.setCustId(1);
		orderService.OrderProcess(orderVO, (List<LineItemVO>)model.getAttribute("lineitems"));
		return "orderItems";
		
	}
	
	@PostMapping("/item")
	public String addItem(@ModelAttribute ItemVO itemVO, Model model) {
		itemVO.setCurrQuantity(itemVO.getMaxQuantity());
		itemService.addOrUpdateItem(itemVO);
		model.addAttribute("item",itemVO);
		return "order";
	}
	
	@GetMapping("/item")
	public String addCustomer() {
		return "item";
	}
	
}
