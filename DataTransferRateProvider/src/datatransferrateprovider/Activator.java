package datatransferrateprovider;

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
		DataRateService dtrService = new DataRateImpl();
		serviceRegistration = context.registerService(DataRateService.class.getName(), dtrService, null);
		System.out.println("Data Transfer Rate provider started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		serviceRegistration.unregister();
		System.out.println("Data Transfer Rate provider stopped");
	}

}
