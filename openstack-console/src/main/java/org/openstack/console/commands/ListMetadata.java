package org.openstack.console.commands;

import java.util.HashMap;

import org.kohsuke.args4j.Argument;
import org.openstack.client.ComputeService;
import org.openstack.console.model.InstanceName;
import org.openstack.model.compute.NovaServer;

public class ListMetadata extends OpenstackCliCommandRunnerBase {
	@Argument(index = 0)
	public InstanceName instanceName;

	public ListMetadata() {
		super("list", "instancemetadata");
	}

	@Override
	public Object runCommand() throws Exception {
		ComputeService compute = getContext().getComputeClient();

		String instanceId = instanceName.findInstanceId(getContext());

		NovaServer server = compute.getPublicEndpoint().servers().server(instanceId).get(new HashMap<String, Object>());
		return server.getMetadata().getItems();
	}

}