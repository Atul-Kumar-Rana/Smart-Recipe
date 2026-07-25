public class FinancialForecastingTest {
    public static void main(String[] args) {
        double initialPopulation = 10000.0;
        double growthFactor = 0.08;
        int periods = 5;
        double projectedPopulation = FinancialForecasting.projectPopulation(initialPopulation, growthFactor, periods);
        System.out.println("Initial Population: " + initialPopulation);
        System.out.println("Growth Factor: " + (growthFactor * 100) + "%");
        System.out.println("Number of Periods: " + periods);
        System.out.printf("Projected Population: %.2f%n", projectedPopulation);
        System.out.println("\n--- Population Projections for different periods ---");
        for (int i = 1; i <= 10; i++) {
            double result = FinancialForecasting.projectPopulation(initialPopulation, growthFactor, i);
            System.out.printf("Period %2d: %.2f%n", i, result);
        }
    }
}
