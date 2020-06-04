package fr.afcepf.al34.nomads.ws.dto.logs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class LogRequestDto {
	String methode;
	String className;
	String classSimpleName;
	Object object;
	
	public LogRequestDto(String methode, String className, String classSimpleName, Object object) {
		super();
		this.methode = methode;
		this.className = className;
		this.classSimpleName = classSimpleName;
		this.object = object;
	}

}
