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

import com.rentacar.utils.Constantes;

/**
 * Clase configurar la conexion con el servidor KIE
 * 
 * @author David Parra
 *
 */
public class SetupProcessManagement {

	private static final MarshallingFormat FORMAT = MarshallingFormat.JSON;

	private static KieServicesConfiguration conf;
	private KieServicesClient kieServicesClient;
	private ProcessServicesClient processClient;
	private UserTaskServicesClient taskServicesClient;

	public SetupProcessManagement(String user, String password) {
		conf = KieServicesFactory.newRestConfiguration(Constantes.URL_SERVER_KIE, user, password);
		conf.setMarshallingFormat(FORMAT);
		kieServicesClient = KieServicesFactory.newKieServicesClient(conf);
		processClient = kieServicesClient.getServicesClient(ProcessServicesClient.class);
		taskServicesClient = kieServicesClient.getServicesClient(UserTaskServicesClient.class);
	}

	public ProcessServicesClient getProcessClient() {
		return this.processClient;
	}

	public UserTaskServicesClient getUserTaskClient() {
		return this.taskServicesClient;
	}

}
