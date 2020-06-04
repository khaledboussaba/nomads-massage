package fr.afcepf.al34.nomads.service.impl.account;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dto.CommandeDto;
import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.dto.TournerBuyDto;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.service.delegate.MasseurServiceDelegate;
import fr.afcepf.al34.nomads.service.impl.GenericDelegateImpl;
import fr.afcepf.al34.nomads.service.impl.UtilisateurServiceDelegateImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Service
@Getter @Setter @NoArgsConstructor
public class MasseurServiceDelegateImpl  extends GenericDelegateImpl implements MasseurServiceDelegate  {

	
	public Masseur saveOrModifyUser(Masseur utilisateur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (Masseur) dto.getValue();
	}

	public List<Masseur> getAllUsers(TypeUtilisateur type) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, type));
		return (List<Masseur>) dto.getValue();
	}

	public boolean userNotExisting(String login) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, login));
		return (boolean) dto.getValue();
	}
	
	/*
	 * Author Sami
	 */
	public boolean registerUser(Masseur utilisateur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (boolean) dto.getValue();
	}

	/*
	 * @author: Khaled
	 */
	@Override
	public List<Masseur> recupererTousLesMasseur() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Masseur>) dto.getValue();
	}

	/*
	 * @author: Khaled
	 */
	@Override
	public Masseur recupererLeMasseur(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, id));
		return (Masseur) dto.getValue();
	}
	/*
	 * @author: Khaled
	 */
	@Override
	public Masseur mettreAjourMasseur(Masseur masseur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, masseur));
		return (Masseur) dto.getValue();
	}

	public TournerBuyDto buyTournee(TournerBuyDto tbdto) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, tbdto));
		return (TournerBuyDto) dto.getValue();
	}

	public CommandeDto enregistrerCommande(CommandeDto cdto) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, cdto));
		return (CommandeDto) dto.getValue();
	}
	
}