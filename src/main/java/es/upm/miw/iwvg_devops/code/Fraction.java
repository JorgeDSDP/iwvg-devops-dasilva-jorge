package es.upm.miw.iwvg_devops.code;

import java.util.*;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return numerator < denominator;
    }

    public boolean isImproper() {
        return numerator > denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        return numerator * fraction.getDenominator() == denominator * fraction.getNumerator();
    }

    public Fraction add(Fraction fraction) {
        int lcm = leastCommonMultiple(denominator, fraction.getDenominator());
        int sumNominator = (lcm / denominator * numerator) + (lcm / fraction.getDenominator() * fraction.getNumerator());
        return new Fraction(sumNominator, lcm);
    }

    public Fraction multiply(Fraction fraction) {
        int multiplyNumerator;
        int multiplyDenominator;

        multiplyNumerator = fraction.getNumerator() * numerator;
        multiplyDenominator = fraction.getDenominator() * denominator;
        return new Fraction(multiplyNumerator, multiplyDenominator);
    }

    public Fraction divide(Fraction fraction) {
        return multiply(invertFraction(fraction));
    }

    private Fraction invertFraction(Fraction fraction) {
        return new Fraction(fraction.getDenominator(), fraction.getNumerator());
    }

    private int leastCommonMultiple(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        List<Integer> absoluteNumbersSorted = Arrays.asList(Math.abs(number1), Math.abs(number2));
        Collections.sort(absoluteNumbersSorted);

        int lcm = absoluteNumbersSorted.get(absoluteNumbersSorted.size() - 1);

        while (lcm % absoluteNumbersSorted.get(0) != 0) {
            lcm += absoluteNumbersSorted.get(absoluteNumbersSorted.size() - 1);
        }
        return lcm;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + numerator;
        result = 31 * result + denominator;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fraction fraction = (Fraction) obj;
        return Objects.equals(numerator, fraction.getNumerator())
                && Objects.equals(denominator, fraction.getDenominator());
    }
}
