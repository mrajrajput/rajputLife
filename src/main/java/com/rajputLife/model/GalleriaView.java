package com.rajputLife.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.model.ResponsiveOption;
import org.primefaces.pandora.domain.Photo;
import org.primefaces.pandora.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope (value = "session")
@Component (value = "galleriaView")
@ELBeanName(value = "galleriaView")
//@Join(path = "/list", to = "/product/product-list.jsf")
public class GalleriaView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Photo> photos;

    private List<ResponsiveOption> responsiveOptions1; 

    private int activeIndex = 0;
    
    private String color = "green";

    @Autowired
    private PhotoService service;

//    @Autowired
    public GalleriaView(PhotoService service) {
    	service = new PhotoService();
	}
    
    @Autowired
    public GalleriaView() {
    	this(new PhotoService());
	}

    @PostConstruct
    public void init() {
        photos = service.getPhotos();

        responsiveOptions1 = new ArrayList<>();
        responsiveOptions1.add(new ResponsiveOption("1024px", 5));
        responsiveOptions1.add(new ResponsiveOption("768px", 3));
        responsiveOptions1.add(new ResponsiveOption("560px", 1)); 
    }

    public void changeActiveIndex() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.activeIndex = Integer.valueOf(params.get("index"));
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public List<ResponsiveOption> getResponsiveOptions1() {
        return responsiveOptions1;
    }
 
    public int getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    public void setService(PhotoService service) {
        this.service = service;
    }

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}