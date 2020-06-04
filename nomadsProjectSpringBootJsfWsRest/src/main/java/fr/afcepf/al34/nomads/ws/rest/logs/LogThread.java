package fr.afcepf.al34.nomads.ws.rest.logs;

import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.nomads.ws.dto.logs.LogRequestDto;
import fr.afcepf.al34.nomads.ws.dto.logs.LogResponseDto;



public class LogThread extends Thread {

	protected String logUrl;
	
	int trying=10;
	LogRequestDto logRequestDto;
	LogResponseDto logResponseDto = null;
	private RestTemplate restTemplate = new RestTemplate();

	public LogThread(String url,LogRequestDto logRequestDto) {
		super();
		
		logUrl=url;
		this.logRequestDto = logRequestDto;
	}

	@Override
	public void run() {
		try {
			int tries = 1;
			//System.out.println("trying to connect : "+logUrl+" tries:"+tries);
			while (logResponseDto == null || !logResponseDto.isLogOk()) {
				logResponseDto = restTemplate.postForObject(logUrl, logRequestDto, LogResponseDto.class);

				try {
					Thread.sleep(1000*tries);
				} catch (InterruptedException e) {
					System.err.println("Cannot Log database infos after Thread.Sleep interrupted! error="+e.getMessage());
					return;
				}

				if (++tries >= trying) {
					System.err.println("Cannot Log database infos after "+trying+" tries!");
					return;
				}
			}
		} catch (Exception e) {
			System.err.println("Cannot Log database infos! error="+e.getMessage());
		}

	}
}
