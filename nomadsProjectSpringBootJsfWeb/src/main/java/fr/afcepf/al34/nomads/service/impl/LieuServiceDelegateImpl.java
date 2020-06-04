package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.service.delegate.LieuServiceDelegate;

@Service
public class LieuServiceDelegateImpl  extends GenericDelegateImpl implements LieuServiceDelegate  {

	
	

	@Override
	public Lieu recupererLieuParSonId(Long idLieu) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, idLieu));
		return (Lieu) dto.getValue();
	}

	@Override
	public Lieu mettreAjourLieu(Lieu lieu) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, lieu));
		return (Lieu) dto.getValue();
	}


	@Override
	public List<Lieu> recupererLieuxCommanditaire(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, id));
		return (List<Lieu>) dto.getValue();
	}

	@Override
	public Lieu ajouterUnNouveauLieu(Lieu nouveauLlieu) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, nouveauLlieu));
		return (Lieu) dto.getValue();
	}

	@Override
	public List<Lieu> recupererLieuxActifCommanditaire(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, id));
		return (List<Lieu>) dto.getValue();
	}

}
