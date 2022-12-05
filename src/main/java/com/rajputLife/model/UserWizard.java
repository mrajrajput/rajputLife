package com.rajputLife.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rajputLife.entity.FamilyMember;

@Scope (value = "session")
@Component (value = "userWizard")
@ELBeanName(value = "userWizard")
public class UserWizard implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	private boolean skip;

//	@Future
	private LocalDate date2;

	private LocalDate date6;
	
	@Autowired
    public UserWizard() {
		user = new User();
		familyMemberList = new ArrayList<FamilyMember>();
	}

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
        if (skip) {
            skip = false; //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
	}
	
	public String personToAdd;
	public List<FamilyMember> familyMemberList;
	
	public void selectFamilyMember(SelectEvent<?> event) {
		FamilyMember familyMember = new FamilyMember();
		familyMember.setType((String) event.getObject());
		personToAdd =  (String) event.getObject();
		
		//		familyMember.setType((String) event.getNewValue());
		//		personToAdd =  (String) event.getNewValue();
		//	    System.out.println("New value: " + event.getNewValue());
	    
	    System.out.println("New value: " + event.getObject());
	}
	
	public void saveFamilyMember(Object type) {
		System.out.println("Saving father");
		//TODO write code to save in DB first
		
		FamilyMember familyMember = new FamilyMember();
		familyMember.setType((String) type);
		familyMember.setFullName("test FullName");
		familyMember.setGotra("Gothra");
		familyMember.setMarried(true);
		familyMember.setVillage("Test Village");
		familyMemberList.add(familyMember);
		
		/* Faces Message Pop-up */
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Family Member Added: ", familyMember.getFullName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void deleteFamilyMember(Object type, Object name) {
		//TODO write code to save in DB first
		
		Iterator<FamilyMember> itr = familyMemberList.iterator();
        while (itr.hasNext()) {
        	FamilyMember fm = itr.next();
			if (fm.getType() == (String) type && fm.getFullName() == (String) name) {
                itr.remove();
                break;
            }
        }
        
        /* Faces Message Pop-up */
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, (String) type+" removed.", (String) name);
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onRowEdit(RowEditEvent<Product> event) {
        FacesMessage msg = new FacesMessage("Product Edited", String.valueOf(event.getObject() ));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Product> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject() ));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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

	public String getOnFlowProcess() {
		return "";
	}

	public void setOnFlowProcess(String onFlowProcess) {
	}
	
	public String getOnDateSelect() {
		return "";
	}

	public void setOnDateSelect(String onDateSelect) {
	}

	public String getPersonToAdd() {
		return personToAdd;
	}

	public void setPersonToAdd(String personToAdd) {
		this.personToAdd = personToAdd;
	}

	public List<FamilyMember> getFamilyMemberList() {
		return familyMemberList;
	}

	public void setFamilyMemberList(List<FamilyMember> familyMemberList) {
		this.familyMemberList = familyMemberList;
	}
}