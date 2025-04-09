package com.valtech.training.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.Customer.CustomerStatus;
import com.valtech.training.ecommerce.repos.CustomerRepo;
import com.valtech.training.ecommerce.services.CustomerService;
import com.valtech.training.ecommerce.services.ItemService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.vos.CustomerVO;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ItemService itemService; 
	
	@Autowired
	OrderService orderService;
//	public ModelAndView test() {
//		int x=0;
//		ModelAndView view = new ModelAndView(x == 0 ? "error" : "custRegister");//we can use this when we dont want to pass the model as args.
//		view.addObject("message","Pls use login dialog");
//		return view;
//	}
	
	@PostMapping("/register")
	public String addCustomer(@ModelAttribute CustomerVO customer,Model model) {
		model.addAttribute("customer",customer);
		customerService.addCustomer(customer);
		return "order";
	}
	
	@PostMapping("/item")
	public String addItems(@ModelAttribute ItemVO item,Model model) {
		item.setQty(item.getMaxQty());
		model.addAttribute("item",item);
		itemService.addOrUpdateItem(item);
		return "order";
	}
	
	
	@GetMapping("/item")
	public String itemPage() {
		return "items";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "custRegister";
	}
	
}
