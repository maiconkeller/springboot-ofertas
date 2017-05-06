package com.mobwink.percentoff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mobwink.percentoff.model.Product;
import com.mobwink.percentoff.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("{identifier}")
	public ModelAndView findAll(@PathVariable("identifier") String identifier){
		ModelAndView mv = new ModelAndView("/products/list");
		mv.addObject("products", this.updateProductList(service.findAll(), identifier));
		return mv;
	}
	
	/*@GetMapping("{identifier}/ofertas/{id}")
	public ModelAndView get(@PathVariable("identifier") String identifier, @PathVariable("id") Product product){
		ModelAndView mv = new ModelAndView("products/product");
		mv.addObject(product);
		return mv;
	}*/
	
	
	// HELPERS
	
	private List<Product> updateProductList(List<Product> list, String identifier){
		for (Product product : list) {
			product.setIdentifier(identifier);
		}
		return list;
	}
	
}
