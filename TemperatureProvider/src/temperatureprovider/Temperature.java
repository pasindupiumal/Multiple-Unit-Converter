package temperatureprovider;

public interface Temperature {

	public double CelsiusToFahrenheit(double amount);
	public double FahrenheitToCelsius(double amount);
	public double CelsiusToKelvin(double amount);
	public double KelvinToCelsius(double amount);
	public double KelvinToFahrenheit(double amount);
	public double FahrenheitToKelvin(double amount);
}
