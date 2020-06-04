package fr.afcepf.al34.nomads.service.impl.logs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.service.LoggerService;
import fr.afcepf.al34.nomads.ws.dto.logs.LogRequestDto;

@Service
public class LoggerServiceImpl implements LoggerService{
	
	@Value(value = "${nomads-api.logs-database-url}")
	String url;
	
	@Override
	public void logIntoMongo(Object t,String methode) {

		String className = "null";
		String classSimpleName = "null";
		if (t != null) {
			className = t.getClass().getName();
			classSimpleName = t.getClass().getSimpleName();
		}
		
		LogRequestDto log=new LogRequestDto(methode,className, classSimpleName,t);
		LogThread logThread=new LogThread(url,log);
		logThread.start();

	}
	
}
