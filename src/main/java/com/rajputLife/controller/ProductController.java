package com.rajputLife.controller;

import com.rajputLife.model.Product;
import com.rajputLife.repository.ProductRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.constraints.Future;

//@Service
@Controller(value = "productController")
@Scope(value = "request")
@Component(value = "productController")
@ELBeanName(value = "productController")
@Join(path = "/product", to = "/product/product-form.jsf")
public class ProductController {
	
	@Future
    private LocalDate date2;
    
    private LocalDate date6;

	private ProductRepository productRepository;

	@Inject
	public ProductController(ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	
	 public void onDateSelect(SelectEvent<LocalDate> event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", event.getObject().format(formatter)));
    }

	private Product product = new Product();

	public String save() {
		productRepository.save(product);
		product = new Product();
		return "/product/product-list.xhtml?faces-redirect=true";
	}

//	@RequestMapping(value = "/list")
//	@PreAuthorize("hasAuthority('User')")
	public String getSave() {
//		productRepository.save(product);
//		product = new Product();
		return "/product/product-list.xhtml?faces-redirect=true";
	}

	public String getLetsDoIt(){
		return "/logout";
	}


	public Product getProduct() {
		return product;
	}

	public LocalDate getDate2() {
		return date2;
	}

	public void setDate2(LocalDate date2) {
		this.date2 = date2;
	}

	public LocalDate getDate6() {
		return date6;
	}

	public void setDate6(LocalDate date6) {
		this.date6 = date6;
	}
}
