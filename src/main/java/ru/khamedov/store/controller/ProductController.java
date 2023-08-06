package ru.khamedov.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import ru.khamedov.store.service.ProductService;
import ru.khamedov.store.model.Product;

import javax.annotation.Resource;

@Controller
public class ProductController {

	@Resource
	private ProductService productService;

	@GetMapping("/view/product/{id}")
	public String getProduct(@PathVariable(required = false) Long id, Model model) {
		Product product=null;
		try {
			product= productService.getProduct( id);
		}catch (HttpClientErrorException ex){
			model.addAttribute("id",id);
			return "error404";
		}
		model.addAttribute("name",product.getName());
		model.addAttribute("cost",product.getCost());
		model.addAttribute("count",product.getCount());
		return "product";
	}
}
