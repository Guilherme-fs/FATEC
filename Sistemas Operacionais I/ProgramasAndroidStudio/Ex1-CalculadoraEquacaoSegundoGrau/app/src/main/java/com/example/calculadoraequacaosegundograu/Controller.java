package com.example.calculadoraequacaosegundograu;


public class Controller {
    public double a;
    public double b;
    public double c;
    public double delta;

    public Controller(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double calcularx1(){
        return ((-(b) + Math.sqrt(delta)) / 2 * a);
    }
    public double calcularx2(){
        return ((-(b) - Math.sqrt(delta)) / 2 * a);
    }
    public double calcularDelta(){
        delta = (b * b) + (-4 * (a * c));
        return delta;
    }

}


