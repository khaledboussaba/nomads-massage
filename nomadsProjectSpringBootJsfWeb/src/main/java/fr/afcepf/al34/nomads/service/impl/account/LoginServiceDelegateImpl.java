package fr.afcepf.al34.nomads.service.impl.account;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.delegate.LoginServiceDelegate;
import fr.afcepf.al34.nomads.service.impl.GenericDelegateImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter
@Setter
@NoArgsConstructor
public class LoginServiceDelegateImpl extends GenericDelegateImpl implements LoginServiceDelegate {

	@Override
	public boolean userNotExisting(String login) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl + "/" + methodName, false, login));
		return (boolean) dto.getValue();
	}

	@Override
	public synchronized boolean connexion() throws Exception {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl + "/" + methodName, false, null));
		return (boolean) dto.getValue();
	}

	public Utilisateur getUserByLogin() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl + "/" + methodName, false, null));
		return (Utilisateur) dto.getValue();
	}

	/*
	 * login from register page
	 */
	@Override
	public boolean userLogin(Utilisateur user) throws Exception {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl + "/" + methodName+"Utilisateur", false, user));
		return (boolean) dto.getValue();
	}

	/*
	 * Login from login page
	 */
	@Override
	public boolean userLogin(Credentials credentials) throws Exception {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(
				new GenericRequestDataDto(baseSuburl + "/" + methodName+"Credentials", false, credentials));
		return (boolean) dto.getValue();
	}

	@Override
	public Utilisateur getUserByCredentials(Credentials credentials) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(
				new GenericRequestDataDto(baseSuburl + "/" + methodName, false, credentials));

		return (Utilisateur) dto.getValue();
	}

	@Override
	public boolean isUniqueLogin(String login) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl + "/" + methodName, false, login));
		return (boolean) dto.getValue();
	}

	@Override
	public Utilisateur getUserByLogin(String login) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl + "/" + methodName, false, login));
		return (Utilisateur) dto.getValue();
	}

}
