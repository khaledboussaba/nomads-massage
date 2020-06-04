package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;

import fr.afcepf.al34.nomads.business.GlobalBusiness;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean("mbGlobal")
@ViewScoped
@Getter @Setter @NoArgsConstructor 
public class GlobalMangedBean implements Serializable {

	private static final long serialVersionUID = 4465548257475381502L;
	
	@Autowired
	private GlobalBusiness globalBusiness;
	
	private List<LieuTournee> lieuxTournees;
	
	public String getDateFormated(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("E dd-MM");  
	    String strDate= formatter.format(date);  
	    return strDate;
	}
	
	public String getTimeFormated(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");  
	    String strDate= formatter.format(date); 
	    return strDate;
	}
	
	private String dummyString1ForCB="Dupond";
	private String dummyString2ForCB="2345 2345 1234 1234";
	private String dummyString3ForCB="123";
	private Date dummyDate4ForCB=new Date();
	
	@PostConstruct
	public void initVars() {
		dummyDate4ForCB.setYear(120);
		//lieuxTournees=new ArrayList<LieuTournee>();
		lieuxTournees = globalBusiness.recupererLesLieuxEtLesTournees();
	}
}
