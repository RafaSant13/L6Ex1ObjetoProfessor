package com.example.l6ex1objetoprofessor.model;

public class ProfessorTitular extends Professor{//Mantive estrutura das classes apesar de somente o metódo ser relvante para o exercício

    private int anosInstituicao;
    private double salario;

    public ProfessorTitular() {
        super();
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcSalario(int valor1, double valor2) {
        double incremento = (valor1/5)*0.05;
        return valor2 * (1 + incremento);
    }

}


