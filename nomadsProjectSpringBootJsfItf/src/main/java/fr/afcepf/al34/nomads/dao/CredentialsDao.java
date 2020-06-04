package fr.afcepf.al34.nomads.dao;

import fr.afcepf.al34.nomads.entities.Credentials;

public interface CredentialsDao {
	public Credentials getCredentialsByLogin(String login);

}
