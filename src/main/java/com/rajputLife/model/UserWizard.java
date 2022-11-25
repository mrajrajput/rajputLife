package com.rajputLife.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Future;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

public class UserWizard implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	private boolean skip;

	@Future
	private LocalDate date2;

	private LocalDate date6;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void save() {
		FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onDateSelect(SelectEvent<LocalDate> event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", event.getObject().format(formatter)));
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
//        if (skip) {
//            skip = false; //reset in case user goes back
//            return "confirm";
//        }
//        else {
//            return event.getNewStep();
//        }

		return event.getNewStep();
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