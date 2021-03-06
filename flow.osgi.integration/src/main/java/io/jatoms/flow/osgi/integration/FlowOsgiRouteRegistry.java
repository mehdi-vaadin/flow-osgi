package io.jatoms.flow.osgi.integration;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import com.vaadin.flow.server.startup.RouteRegistry;
import static io.jatoms.flow.osgi.integration.FlowOsgiConstants.*;

@Component(service = RouteRegistry.class)
public class FlowOsgiRouteRegistry extends RouteRegistry {
	
	@Reference(
			target="(" + Annotation + "=" + Route + ")", 
			cardinality=ReferenceCardinality.MULTIPLE, 
			policy=ReferencePolicy.DYNAMIC,
			policyOption=ReferencePolicyOption.GREEDY)
	void addRoute(Class route) {
		// TODO: add route to navigation targets, maybe switch to vaadin 13 or snapshot version as 12 does not support dynamic routes?
	}
	
	void removeRoute(Class route) {
	}
	
	@Reference(target="(" + Annotation + "=" + RouteAlias + ")", 
			cardinality=ReferenceCardinality.MULTIPLE,
			policy=ReferencePolicy.DYNAMIC,
			policyOption=ReferencePolicyOption.GREEDY)
	void addRouteAlias(Class route) {
		// TODO: add route to navigation targets, maybe switch to vaadin 13 or snapshot version as 12 does not support dynamic routes?
	}
	
	void removeRouteAlias(Class route) {
	}
	
	// we can add here anything else that needs to be tracked... e.g., ErrorPages ?

}
