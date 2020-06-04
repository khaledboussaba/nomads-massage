package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.entities.LieuTournee;
import lombok.Getter;
import lombok.Setter;


@ManagedBean("mbAgenda")
@SessionScope
@Getter @Setter
public class AgendaManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7045167294960012762L;

	private Map<String, Agenda> agendaList = new HashMap<String, Agenda>();

	@Autowired
	private GlobalMangedBean globalMangedBean;
	
	private List<LieuTournee> lieuxTournees= new ArrayList<LieuTournee>();
	
	public AgendaManager() {
		super();
		//agendaList.put("now", new Agenda("now"));
		//agendaList.put("thisEvening", new Agenda("thisEvening"));
	}

	
	
	public String getAgendaDescription(String name) {
		//TODO : put desc into Agenda from database ??? (pas sur)
		String description = "";
		switch (name) {
		case "now1":
			description = "Maintenant";
			break;
		case "thisEvening":
			description = "Ce soir";
			break;

		default:
			description = "Tout";
			break;
		}
		return description;
	}

	public Agenda getAgenda(String nom) {
		lieuxTournees=globalMangedBean.getLieuxTournees();
		
//		System.out.println("SASASA="+lieuxTournees);
//		System.out.println("SASASA="+lieuxTournees.get(0).getClass());
//		System.out.println("SASASA="+lieuxTournees.getClass());
		
//		System.out.println("getAgenda name="+nom);
		
		Agenda a = new Agenda("now1");
		
		a.setLieuxTournees(lieuxTournees);
		agendaList.put("now1" ,a);
		
		return agendaList.get("now1");
	}
}
