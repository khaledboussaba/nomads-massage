package fr.afcepf.al34.rest.logs;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Value;

import fr.afcepf.al34.rest.logs.dto.LogRequestDto;


public class EntityListener {
	
	@Value(value = "${nomads-api.logs-database-url}")
	String url;
	
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
	
	@PrePersist
	void onPrePersist(Object t) {
		logIntoMongo(t,"onPrePersist");
	}

	@PostPersist
	void onPostPersist(Object t) {
		logIntoMongo(t,"onPostPersist");
	}

	@PostLoad
	void onPostLoad(Object t) {
		logIntoMongo(t,"onPostLoad");
	}

	@PreUpdate
	void onPreUpdate(Object t) {
		logIntoMongo(t,"onPreUpdate");
	}

	@PostUpdate
	void onPostUpdate(Object t) {
		logIntoMongo(t,"onPostUpdate");
	}

	@PreRemove
	void onPreRemove(Object t) {
		logIntoMongo(t,"onPreRemove");
	}

	@PostRemove
	void onPostRemove(Object t) {
		logIntoMongo(t,"onPostRemove");
	}
	
}
