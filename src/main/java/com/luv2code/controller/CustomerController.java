package com.luv2code.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.entity.Customer;
import com.luv2code.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.listCustomers();
		model.addAttribute("customers", customers);

		return "list-customers";
	}
	
	@RequestMapping(path = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@RequestMapping(path = "/showFormForUpdate", method = RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@RequestMapping(path = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
							BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "customer-form";
		} else {
			customerService.saveCustomer(customer);
			return "redirect:/customer/list";
		}
	}
	
	@RequestMapping(path = "/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	@RequestMapping(path = "/searchCustomer", method = RequestMethod.GET)
	public String searchCustomer(@RequestParam("searchName") String searchName, Model model) {
		List<Customer> customers = customerService.searchCustomers(searchName);
		model.addAttribute("customers", customers);

		return "list-customers";
	}

}
