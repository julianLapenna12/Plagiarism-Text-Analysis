
package cpen221.mp1.cryptanalysis;

public class ComplexNumber {
    //TODO add method Javadocs
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

    public void add(ComplexNumber other) {
        re += other.re();
        im += other.im();
    }

    public void multiply(ComplexNumber other) {
        double reNew;
        double imNew;
        reNew = re * other.re() - (im * other.im());
        imNew = re * other.im() + other.re() * im;
        re =  reNew;
        im = imNew;
    }

    public double amp(){
        return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));
    }

    public String toString() {
        String rep = re + " i" + im;
        return rep;
    }

    public double re() {
        return re;
    }

    public double im() {
        return im;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof ComplexNumber)){
            return false;
        }
        ComplexNumber otherCom = (ComplexNumber) other;
        // have the same real and imaginary parts
        return (re == otherCom.re() && im == otherCom.im());
    }

    public int hashCode() {
        return (int)(2* re + im);
    }

}
