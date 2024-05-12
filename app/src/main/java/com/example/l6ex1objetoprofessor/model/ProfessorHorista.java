package com.example.l6ex1objetoprofessor.model;

public class ProfessorHorista extends Professor {//Mantive estrutura das classes apesar de somente o metódo ser relvante para o exercício

    private int horasAula;
    private double valorHoraAula;

    public ProfessorHorista() {
        super();
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    @Override
    public double calcSalario(int valor1, double valor2) {
        return valor1 * valor2;
    }


}
