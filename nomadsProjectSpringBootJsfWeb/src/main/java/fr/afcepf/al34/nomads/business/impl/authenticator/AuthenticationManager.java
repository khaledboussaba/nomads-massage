package fr.afcepf.al34.nomads.business.impl.authenticator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.afcepf.al34.nomads.entities.Credentials;



@Service
public class AuthenticationManager{

	private static final int SALT_LENGHT = 6;
	private static final int RANDOM_LENGHT_MIN = '0';
	private static final int RANDOM_LENGHT_MAX = 'z';
	
	// 0..9A..Za..z
	private static Random random = new Random();
	
	
	private static String createSalt() {
		String salt = "";
		for (int i = 0; i < SALT_LENGHT; i++ ) {
			int rndNumber = RANDOM_LENGHT_MIN +  random.nextInt(RANDOM_LENGHT_MAX - RANDOM_LENGHT_MIN);
			char c = (char) rndNumber; 
			salt += c; 			
		}
	
	return salt;
	}
	
	public static void initialiseCredentials(String clearPassword, Credentials credentials) throws Exception {
		
		String salt = createSalt();
		String saltedPassword = clearPassword + salt;
		credentials.setSalt(salt);
		
		String hashedPassword = hashPassword(saltedPassword);
		
        credentials.setHashedPassword(hashedPassword);
        

	}
	
	private static String hashPassword(String password) throws Exception {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("Echec du hashage du mot de passe", e);
		}
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
        
	}
	
	public static boolean authenticate(String clearPassword, Credentials credentials) throws Exception {
		
		String saltedPassword = clearPassword + credentials.getSalt();
		String hashedPassword = hashPassword(saltedPassword);
		
		
		return hashedPassword.equals(credentials.getHashedPassword());
	}

	
}
