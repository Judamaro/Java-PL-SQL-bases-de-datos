/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Multa {

    private int idMulta;
    private String fechaPagoMulta;
    private String fechaGeneMulta;
    private int estadoMulta;
    private double valorMulta;
    private int idLectorf2;
    private int idPrestf1;

    public Multa() {
    }

    public Multa(int idMulta, String fechaPagoMulta, String fechaGeneMulta, int estadoMulta, double valorMulta, int idLectorf2, int idPrestf1) {
        this.idMulta = idMulta;
        this.fechaPagoMulta = fechaPagoMulta;
        this.fechaGeneMulta = fechaGeneMulta;
        this.estadoMulta = estadoMulta;
        this.valorMulta = valorMulta;
        this.idLectorf2 = idLectorf2;
        this.idPrestf1 = idPrestf1;
    }

    public Multa(String fechaPagoMulta, String fechaGeneMulta, int estadoMulta, double valorMulta, int idLectorf2, int idPrestf1) {
        this.fechaPagoMulta = fechaPagoMulta;
        this.fechaGeneMulta = fechaGeneMulta;
        this.estadoMulta = estadoMulta;
        this.valorMulta = valorMulta;
        this.idLectorf2 = idLectorf2;
        this.idPrestf1 = idPrestf1;
    }

    public int getIdPrestf1() {
        return idPrestf1;
    }

    public void setIdPrestf1(int idPrestf1) {
        this.idPrestf1 = idPrestf1;
    }

    public int getIdLectorf2() {
        return idLectorf2;
    }

    public void setIdLectorf2(int idLectorf2) {
        this.idLectorf2 = idLectorf2;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public int getEstadoMulta() {
        return estadoMulta;
    }

    public void setEstadoMulta(int estadoMulta) {
        this.estadoMulta = estadoMulta;
    }

    public String getFechaGeneMulta() {
        return fechaGeneMulta;
    }

    public void setFechaGeneMulta(String fechaGeneMulta) {
        this.fechaGeneMulta = fechaGeneMulta;
    }

    public String getFechaPagoMulta() {
        return fechaPagoMulta;
    }

    public void setFechaPagoMulta(String fechaPagoMulta) {
        this.fechaPagoMulta = fechaPagoMulta;
    }

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    @Override
    public String toString() {
        return "Multa{" + "idMulta=" + idMulta + ", fechaPagoMulta=" + fechaPagoMulta + ", fechaGeneMulta=" + fechaGeneMulta + ", estadoMulta=" + estadoMulta + ", valorMulta=" + valorMulta + ", idLectorf2=" + idLectorf2 + ", idPrestf1=" + idPrestf1 + '}';
    }

}
