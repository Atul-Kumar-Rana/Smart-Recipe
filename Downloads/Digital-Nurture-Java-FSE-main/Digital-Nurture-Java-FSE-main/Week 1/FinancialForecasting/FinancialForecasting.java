public class FinancialForecasting {
    public static double projectPopulation(double initialPopulation, double growthFactor, int periods) {
        if (periods == 0) {
            return initialPopulation;
        }
        return projectPopulation(initialPopulation * (1 + growthFactor), growthFactor, periods - 1);
    }
}
