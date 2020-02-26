package io.himoura.interview.testdome;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
    	
    	double common = (Math.sqrt(b*b -4*a*c)) / (2*a);
    	System.out.println(common);
    	
    	Roots result = new Roots((-b/(2*a))+common, (-b/(2*a))-common);
    	return result;
    }
    
    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {         
        this.x1 = x1;
        this.x2 = x2;
    }
}
