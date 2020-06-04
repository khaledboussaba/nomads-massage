package fr.afcepf.al34.nomads.web.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.global.mock.TourneeMock;


public class Agenda {
	private String nom;
	
	private List<TourneeMock> tourners = new ArrayList<TourneeMock>();
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<TourneeMock> getTourners() {
//		System.out.println("tourners="+tourners);
		return tourners;
	}

	private String[] fakeLieu= {
			"Bar à Thym",
			"L'anvers du décor",
			"Chez Ta Mère",
			"La Couleur de la Culotte",
			"Code Bar",
			"Poële deux carottes",
			"Les fleurs du malt",
			"Zanzybar",
			"Nul bar ailleurs",
			"Le Progress Bar",
			"Le Nid-bar",
			"Le Joe Bar"
	};
	
	public Agenda(String nom) {
		super();
		setNom(nom);
		/*
		long millisLong=0;
		double millisDouble=0;
		Date date=null;
		Tourner tourner=null;
		Calendar cal = Calendar.getInstance();
		 
		for(int i=0;i<Math.floor(Math.random()*5)+5;i++) {
			if(i%3==0) {
				millisLong=System.currentTimeMillis();
				millisDouble = Math.floor(Math.random()*(double)millisLong); 
				date = new Date((long)millisDouble);
				cal.setTime(date);
			}else {
				cal.set(Calendar.HOUR_OF_DAY, (int)Math.floor(Math.random()*24));
				date = cal.getTime();
			}
			tourner=new Tourner("IDTOURNER"+1, date,date , fakeLieu[(int)Math.floor(Math.random()*fakeLieu.length)]);
			tourners.add(tourner);
		}
		
		Collections.sort(tourners);
		*/
	}
	
	public void setLieuxTournees(List<LieuTournee> lieuxTournees) {

		TourneeMock tourner=null;
//		System.out.println("lieuxTournees.size="+lieuxTournees.size());
		for(LieuTournee lt:lieuxTournees) {
			
			
			//lt.getTournee().getHeureDebut().setHours(lt.getTournee().getHeureDebut().getHours());
			//lt.getTournee().getHeureDebut().setMinutes(lt.getTournee().getHeureDebut().getMinutes());
//			Date dateFin=lt.getTournee().getDate();
//			dateFin.setHours(lt.getTournee().getHeureFin().getHours());
//			dateFin.setMinutes(lt.getTournee().getHeureFin().getMinutes());
			
			
			tourner=new TourneeMock("IDTOURNER_"+lt.getId(),
								lt.getTournee().getDate() ,
								lt.getTournee().getHeureDebut(),
								lt.getTournee().getHeureFin() , 
								lt.getLieu().getNom());
			tourners.add(tourner);
			
		}
		Collections.sort(tourners,Collections.reverseOrder());
		
//		System.out.println("tourners="+tourners);
		
		
	}
	
	
}
