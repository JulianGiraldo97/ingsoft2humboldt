public class ClientApplication {
    public static void main(String[] args) {
        // Cliente de servicio de conversión de moneda
        CurrencyConversionService currencyService = new CurrencyConversionService();
        double amountInUSD = 100.0;
        double amountInEUR = currencyService.convertCurrency(amountInUSD, "USD", "EUR");
        System.out.println("100 USD es igual a " + amountInEUR + " EUR");

        // Cliente de servicio de pronóstico del tiempo
        WeatherForecastService weatherService = new WeatherForecastService();
        String city = "New York";
        String weatherForecast = weatherService.getWeatherForecast(city);
        System.out.println("El pronóstico del tiempo para " + city + " es " + weatherForecast);
    }
}
