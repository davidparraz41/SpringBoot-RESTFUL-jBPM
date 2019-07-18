/**
 * 
 */
package com.rentacar.process;

import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;
import org.kie.server.client.UserTaskServicesClient;

/**
 * Clase tipo singleton para configurar la conexion con el servidor KIE
 * 
 * @author David Parra
 *
 */
public class SetupProcessManagement {

	private static SetupProcessManagement instance = null;
	// REST API base URL, credentials, and marshalling format
	private static final String URL = "http://localhost:8080/kie-server/services/rest/server";
	private static final String USER = "kieserver";
	private static final String PASSWORD = "kieserver";

	private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;

	private static KieServicesConfiguration conf;

	
	private static KieServicesClient kieServicesClient;

	private static ProcessServicesClient processClient;
	private static UserTaskServicesClient userTaskClient;

	private void initializeKieServerClient() {
		conf = KieServicesFactory.newRestConfiguration(URL, USER, PASSWORD);
		conf.setMarshallingFormat(FORMAT);
		kieServicesClient = KieServicesFactory.newKieServicesClient(conf);
		initializeJbpmServiceClients();
	}

	private void initializeJbpmServiceClients() {
		processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
		userTaskClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
	}

	public ProcessServicesClient getProcessClient() {
		return processClient;
	}

	public UserTaskServicesClient getUserTaskClient() {
		return userTaskClient;
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
