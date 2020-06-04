package fr.afcepf.al34.nomads.business.impl.authenticator;

public enum AppRole 
{
	VISITEUR("VISITEUR"), 
	MASSEUR("MASSEUR"), 
	COMMANDITAIRE("COMMANDITAIRE"), 
	ADMIN("ADMIN");
	private String role;
	 
	AppRole(String role) {
        this.role = role;
    }
 
	public String getInitialInsertStringRole() {
		return role;
	}
	
    public String getRoleString() {
        return "ROLE_"+role;
    }
}