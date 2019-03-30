package lengthprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration serviceRegistration;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Length lengthService = new LengthImplementation();
		serviceRegistration = context.registerService(Length.class.getName(), lengthService, null);
		System.out.println("Length provider started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		serviceRegistration.unregister();
		System.out.println("Length provider stopped");
	}

}
