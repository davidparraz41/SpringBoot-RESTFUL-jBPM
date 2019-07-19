/**
 * 
 */
package com.rentacar.process;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.JobServicesClient;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.UserTaskServicesClient;

import com.rentacar.utils.Constantes;

/**
 * Clase tipo singleton para configurar la conexion con el servidor KIE
 * 
 * @author David Parra
 *
 */
public class SetupProcessManagement {

	private static SetupProcessManagement instance = null;

	private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;

	private static KieServicesConfiguration conf;

	private static KieServicesClient kieServicesClient;

	private static ProcessServicesClient processClient;
	private static JobServicesClient jobServicesClient;

	private void initializeKieServerClient() {
		conf = KieServicesFactory.newRestConfiguration(Constantes.URL_SERVER_KIE, Constantes.USER_SERVER_KIE,
				Constantes.PASSWORD_SERVER_KIE);
		conf.setMarshallingFormat(FORMAT);
		kieServicesClient = KieServicesFactory.newKieServicesClient(conf);
		initializeJbpmServiceClients();
	}

	private void initializeJbpmServiceClients() {
		processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
		jobServicesClient = kieServicesClient.getServicesClient(JobServicesClient.class);
	}

	public ProcessServicesClient getProcessClient() {
		return processClient;
	}

	public UserTaskServicesClient getUserTaskClient(String user, String password) {
		conf = KieServicesFactory.newRestConfiguration(Constantes.URL_SERVER_KIE, user, password);
		conf.setMarshallingFormat(FORMAT);
		kieServicesClient = KieServicesFactory.newKieServicesClient(conf);
		return kieServicesClient.getServicesClient(UserTaskServicesClient.class);
	}

	public static JobServicesClient getJobServicesClient() {
		return jobServicesClient;
	}

	private SetupProcessManagement() {
	}

	/**
	 * Inicializa los clientes para la comunicacion con el servidor KIE
	 * 
	 * @return
	 */
	public static SetupProcessManagement getInstance() {
		if (instance == null) {
			instance = new SetupProcessManagement();
			instance.initializeKieServerClient();
			instance.initializeJbpmServiceClients();
		}
		return instance;
	}

}
