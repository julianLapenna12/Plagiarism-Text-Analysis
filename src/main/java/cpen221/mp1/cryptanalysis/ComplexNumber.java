
package cpen221.mp1.cryptanalysis;

/**
 * Complex number is an implementation of complex numbers with addition and multiplication operations.
 * @Auther Joel Tsuchitori
 */
public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber(double real, double imaginary) {
        this.re = real;
        this.im = imaginary;
    }

    public ComplexNumber() {
        this.re = 0;
        this.im = 0;
    }

    public ComplexNumber(ComplexNumber seed) {
        this.re = seed.re();
        this.im = seed.im();
    }

    /**
     * add defines addition of two complex numbers,
     * mutating the value of the complex number from which the method was called.
     * @param other the other complex number with each the addition will be done with.
     */
    public void add(ComplexNumber other) {
        re += other.re();
        im += other.im();
    }

    /**
     * multiply degines multiplication of two complex numbers.
     * @param other the other number with which the the multiplication operation will be done with.
     */
    public void multiply(ComplexNumber other) {
        double reNew;
        double imNew;
        reNew = re * other.re() - (im * other.im());
        imNew = re * other.im() + other.re() * im;
        re =  reNew;
        im = imNew;
    }

    /**
     * amp gives the magnitude of the complex number, defined by:
     * sqrt(r^2 + i^2), where r is the real component and i is the complex
     * @return The amplitude of the complex number.
     */
    public double amp(){
        return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
    }

    /**
     * @return The string representation of the complex number.
     */
    public String toString() {
        String rep = re + " i" + im;
        return rep;
    }

    /**
     * @return the real component of the complex number
     */
    public double re() {
        return re;
    }

    /**
     * @return the imaginary component of the complex number
     */
    public double im() {
        return im;
    }

    /**
     * equals defines equality of two complex numbers.
     * @param other is the number with which equality will be checked.
     * @return a boolean value stating whether or not the input and complex number from this was called are equal.
     */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof ComplexNumber)){
            return false;
        }
        ComplexNumber otherCom = (ComplexNumber) other;
        // have the same real and imaginary parts
        return (re == otherCom.re() && im == otherCom.im());
    }

    /**
     * @return a hashcode value, consistent with equality.
     */
    public int hashCode() {
        return (int)(2* re + im);
    }

}
