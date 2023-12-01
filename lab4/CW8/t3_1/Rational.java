/**
 * CW8
 * Lab4 Rational realization for t3_1 performance.
 * Run file t3_1.java to check the result.
 * @author Yaroslav Yanhol
 */
package lab4.CW8.t3_1;

import java.util.Scanner;

/**
 * Custom exception for handling invalid denominator values.
 */
class RationalError extends ArithmeticException {
    private final int denominator;

    public RationalError(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "Invalid denominator value for the fraction: " + denominator;
    }
}

/**
 * Custom exception for handling invalid input values in arithmetic operations.
 */
class RationalValueError extends Exception {
    private final String input;
    private final String methodName;

    public RationalValueError(String input, String methodName) {
        this.input = input;
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return "Invalid input data \"" + input + "\" used in arithmetic operator " + methodName + "!";
    }
}

/**
 * Represents a rational number with numerator and denominator.
 */
class Rational {

    private int numerator;
    private int denominator;

    /**
     * Default constructor, initializes the fraction to 1/1.
     */
    public Rational() {
        this(1, 1);
    }

    /**
     * Copy constructor.
     */
    public Rational(Rational other) {
        this(other.numerator, other.denominator);
    }

    /**
     * Parameterized constructor.
     */
    public Rational(int numerator, int denominator) {
        try {
            if (denominator == 0) {
                throw new RationalError(denominator);
            } else {
                this.numerator = numerator;
                this.denominator = denominator;
            }

            validateRational();

        } catch (RationalError e) {
            throw e;
        }
    }

    /**
     * Constructor for whole numbers.
     */
    public Rational(int numerator) {
        this(numerator, 1);
    }

    /**
     * Constructor for parsing a string representation of a fraction.
     */
    public Rational(String fractionStr) {
        String[] parts = fractionStr.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = parts.length > 1 ? Integer.parseInt(parts[1]) : 1;
        this.numerator = numerator;
        this.denominator = denominator;
        validateRational();
    }

    private boolean validateRational() throws RationalError {
        try {
            simplify();
            return this.numerator != this.denominator && this.denominator != 1 && this.numerator != 0;
        } catch (RationalError e) {
            throw e;
        }
    }

    private void simplify() {
        if (this.denominator == this.numerator) {
            this.numerator /= this.numerator;
            this.denominator /= this.denominator;
        } else {
            int div = gcd(this.numerator, this.denominator);
            if (this.denominator / div < 0) {
                div = -div;
            }
            this.numerator /= div;
            this.denominator /= div;
        }
    }

    private int gcd(int m, int n) {
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }

    private int lcm(int m, int n) {
        return (m * n) / gcd(m, n);
    }

    /**
     * Reads a rational number from the keyboard.
     */
    public void keyboardInput(Scanner userInput) {
        System.out.print("Enter a fraction in the form \"n/d\": ");
        String input = userInput.nextLine();
        stringInput(input);
    }

    /**
     * Parses a string representation of a fraction.
     */
    public void stringInput(String inputStr) {
        String input = inputStr;
        if (input.contains("/")) {
            String[] parts = input.split("/");
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            String cleanedInput = input.trim();
            int dotIndex = cleanedInput.indexOf('.');
            if (dotIndex >= 0) {
                int denominator = (int) Math.pow(10, cleanedInput.length() - dotIndex - 1);
                int numerator = Integer.parseInt(cleanedInput.substring(0, dotIndex) + cleanedInput.substring(dotIndex + 1));
                this.numerator = numerator;
                this.denominator = denominator;
            } else {
                int numerator = Integer.parseInt(input);
                int denominator = 1;
                this.numerator = numerator;
                this.denominator = denominator;
            }
        }
        validateRational();
    }

    @Override
    public String toString() {
        if (validateRational()) {
            return numerator + "/" + denominator;
        } else {
            return String.valueOf(numerator);
        }
    }

    /**
     * Returns the absolute value of the fraction.
     */
    public Rational abs() {
        this.numerator = Math.abs(this.numerator);
        return this;
    }

    /**
     * Negates the fraction.
     */
    public Rational neg() {
        this.numerator = -Math.abs(this.numerator);
        return this;
    }

    /**
     * Adds two rational numbers.
     */
    public Rational add(Rational other) throws RationalValueError {
        try {
            if (other instanceof Rational) {
                int lcm = lcm(this.denominator, other.denominator);
                return new Rational(this.numerator * (lcm / this.denominator) + other.numerator * (lcm / other.denominator), lcm);
            } else {
                throw new RationalValueError(other.toString(), "add");
            }
        } catch (RationalError e) {
            throw new RationalValueError(other.toString(), "add");
        }
    }

    /**
     * Subtracts two rational numbers.
     */
    public Rational sub(Rational other) throws RationalValueError {
        try {
            if (other instanceof Rational) {
                int lcm = lcm(this.denominator, other.denominator);
                return new Rational(this.numerator * (lcm / this.denominator) - other.numerator * (lcm / other.denominator), lcm);
            } else {
                throw new RationalValueError(other.toString(), "sub");
            }
        } catch (RationalError e) {
            throw new RationalValueError(other.toString(), "sub");
        }
    }

    /**
     * Multiplies two rational numbers.
     */
    public Rational mul(Rational other) throws RationalValueError {
        try {
            if (other instanceof Rational) {
                return new Rational(this.numerator * other.numerator, this.denominator * other.denominator);
            } else {
                throw new RationalValueError(other.toString(), "mul");
            }
        } catch (RationalError e) {
            throw new RationalValueError(other.toString(), "mul");
        }
    }

    /**
     * Raises the fraction to the power of exp.
     */
    public Rational pow(int exp) throws RationalValueError {
        try {
            if (exp >= 0) {
                return new Rational((int) Math.pow(this.numerator, exp), (int) Math.pow(this.denominator, exp));
            } else {
                return new Rational((int) Math.pow(this.denominator, exp), (int) Math.pow(this.numerator, exp));
            }
        } catch (RationalError e) {
            throw new RationalValueError(String.valueOf(exp), "pow");
        }
    }

    /**
     * Divides two rational numbers.
     */
    public Rational div(Rational other) throws RationalValueError {
        try {
            if (other instanceof Rational) {
                return new Rational(this.numerator * other.denominator, this.denominator * other.numerator);
            } else {
                throw new RationalValueError(other.toString(), "div");
            }
        } catch (RationalError e) {
            throw new RationalValueError(other.toString(), "div");
        }
    }

    /**
     * Gets the numerator of the fraction.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Gets the denominator of the fraction.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Returns the fraction as a decimal.
     */
    public String call() {
        return String.valueOf((double) numerator / denominator);
    }

    /**
     * Creates an array of Rational objects with the specified size.
     *
     * @param size The size of the array to be created.
     * @return An array of Rational objects.
     */
    public static Rational[] createRationalArray(int size) {
        Rational[] rationals = new Rational[size];
        for (int i = 0; i < size; i++) {
            rationals[i] = new Rational();
        }
        return rationals;
    }

    
    /**
     * Main method for testing the Rational class.
     */
    public static void main(String[] args) {
        Rational fraction1 = new Rational(1, 3);
        Rational fraction2 = new Rational();
        String inputString = "-5/2";
        fraction2.stringInput(inputString);
        Rational resultFraction = null;
        try {
            resultFraction = fraction1.add(fraction2);
        } catch (RationalValueError e) {
            e.printStackTrace();
        }

        Rational copiedFraction = new Rational(fraction1);
        Rational divisionResult = null;
        try {
            divisionResult = copiedFraction.div(new Rational(3, 1));
        } catch (RationalValueError e) {
            e.printStackTrace();
        }

        System.out.println("Fraction created using standard constructor: " + fraction1);
        System.out.println("Fraction created from a string: " + fraction2);
        System.out.println("Sum of the first two fractions: " + resultFraction);
        System.out.println();
        System.out.println("Copy of the first fraction: " + copiedFraction);
        System.out.println("Quotient of the fourth fraction and three: " + divisionResult);
        System.out.println("Absolute value of fraction 2: " + fraction2.abs());
        try {
            System.out.println("Fraction 5 (quotient) raised to the power of 3: " + divisionResult.pow(3));
        } catch (RationalValueError e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Square brackets Test (3 fractions, numerator): " + resultFraction.getNumerator());
        System.out.println("Round brackets test (the same fraction): " + resultFraction.call());
        System.out.println();
        Rational userFraction = new Rational();
        Scanner userInput = new Scanner(System.in);
        userFraction.keyboardInput(userInput);
        userInput.close();
        System.out.println("User's fraction from the keyboard: " + userFraction);
        System.out.println("Negative user's fraction from the keyboard: " + userFraction.neg());
        System.out.println("Positive user's fraction from the keyboard: " + userFraction.abs());
    }

}
