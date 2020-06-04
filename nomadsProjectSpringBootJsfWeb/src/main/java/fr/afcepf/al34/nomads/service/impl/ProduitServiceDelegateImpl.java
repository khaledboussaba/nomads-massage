package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.service.delegate.ProduitServiceDelegate;

@Service
public class ProduitServiceDelegateImpl  extends GenericDelegateImpl implements ProduitServiceDelegate  {
	
	
	

	@Override
	public List<Produit> recupererLaListeDesTshirt() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Produit>) dto.getValue();
	}

	@Override
	public List<Produit> recupererLaListeDesPacks() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Produit>) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeTshirtDisponile() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeTPEdisponile() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreFormulesPacks() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeChaisesdisponile() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public List<Produit> recupererLaListeDesTPE() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Produit>) dto.getValue();
	}

	@Override
	public List<Produit> recupererLaListeDesChaises() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Produit>) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeBarActifs() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeBarEnAttente() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeBarInactifs() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeMasseursActifs() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeMasseursInactifs() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenir() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtComplete() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtSemiComplete() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtVide() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Long) dto.getValue();
	}

	@Override
	public List<Lieu> recupererLaListeDesBarsEnAttente() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Lieu>) dto.getValue();
	}

	@Override
	public List<Tournee> recupererLaListeDeToutesLesTournnesAVenir() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Tournee>) dto.getValue();
	}

}
