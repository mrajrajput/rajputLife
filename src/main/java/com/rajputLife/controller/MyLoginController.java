package com.rajputLife.controller;

import com.rajputLife.model.Product;
import com.rajputLife.repository.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;
import java.util.List;

@Controller(value = "myloginController")
@Scope(value = "session")
@Component(value = "myloginController")
@ELBeanName(value = "myloginController")
@Join(path = "/account", to = "/registered/product-list-forRegisteredUser.jsf")
public class MyLoginController {

 	private ProductRepository productRepository;

	private List<Product> products;

	@Inject
	public MyLoginController(ProductRepository productRepository){
		this.productRepository = productRepository;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		products = productRepository.findAll();
	}

	public List<Product> getProducts() {
		return products;
	}

	public String delete(Product product) {
		productRepository.delete(product);
		loadData();
		return null;
	}
}
