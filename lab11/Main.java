class Calculator {
    private String model;
    private String version;

    public Calculator(String model, String version) {
        this.model = model;
        this.version = version;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }

    public int calculate(int a, int b) {
        return a + b;
    }

    public int calculate(int a, int b, int c) {
        return a + b + c;
    }

    public double calculate(double a, double b) {
        return a + b;
    }

    public double calculate(int a, double b) {
        return a * b;
    }

    public String getDescription() {
        return "Обычный калькулятор";
    }
}

class ScientificCalculator extends Calculator {
    private String angleMode; 

    public ScientificCalculator(String model, String version, String angleMode) {
        super(model, version);
        this.angleMode = angleMode;
    }

    public String getAngleMode() {
        return angleMode;
    }

    @Override
    public String getDescription() {
        return "Научный калькулятор";
    }

    public double calculate(String operation, double a, double b) {
        switch (operation) {
            case "pow":
                return Math.pow(a, b);
            case "div":
                return b != 0 ? a / b : 0;
            case "sub":
                return a - b;
            default:
                return a + b;
        }
    }
}

class EngineeringCalculator extends Calculator {
    private int precision; 

    public EngineeringCalculator(String model, String version, int precision) {
        super(model, version);
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    @Override
    public String getDescription() {
        return "Инженерный калькулятор";
    }

    public int calculate(int a, int b, String operation) {
        switch (operation) {
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "%":
                return b != 0 ? a % b : 0;
            default:
                return a + b;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator basicCalc = new Calculator("Casio Basic", "1.0");
        ScientificCalculator sciCalc = new ScientificCalculator("Casio FX-991", "2.1", "DEG");
        EngineeringCalculator engCalc = new EngineeringCalculator("Texas TI-89", "3.0", 12);

        System.out.println("=== 1. Демонстрация статического полиморфизма (Перегрузка / Overloading) ===");
        System.out.println("calculate(int, int): 10 + 20 = " + basicCalc.calculate(10, 20));
        System.out.println("calculate(int, int, int): 10 + 20 + 30 = " + basicCalc.calculate(10, 20, 30));
        System.out.println("calculate(double, double): 4.5 + 3.2 = " + basicCalc.calculate(4.5, 3.2));
        System.out.println("calculate(int, double): 5 * 2.5 = " + basicCalc.calculate(5, 2.5));

        System.out.println("Scientific calculate(\"pow\", 2.0, 5.0): 2^5 = " + sciCalc.calculate("pow", 2.0, 5.0));
        System.out.println("Engineering calculate(15, 4, \"*\"): 15 * 4 = " + engCalc.calculate(15, 4, "*"));

        System.out.println("\n=== 2. Демонстрация динамического полиморфизма (Переопределение / Overriding) ===");
        Calculator[] calculators = { basicCalc, sciCalc, engCalc };

        for (Calculator calc : calculators) {
            System.out.println("Модель: " + calc.getModel() + " (v" + calc.getVersion() + ") -> " + calc.getDescription());

            if (calc instanceof ScientificCalculator) {
                ScientificCalculator sc = (ScientificCalculator) calc;
                System.out.println("  [Режим углов: " + sc.getAngleMode() + "] Деление 25.0 / 4.0 = " + sc.calculate("div", 25.0, 4.0));
            } else if (calc instanceof EngineeringCalculator) {
                EngineeringCalculator ec = (EngineeringCalculator) calc;
                System.out.println("  [Точность: " + ec.getPrecision() + " знаков] Остаток 17 % 5 = " + ec.calculate(17, 5, "%"));
            }
        }
    }
}