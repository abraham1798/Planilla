/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planilla;

/**
 *
 * @author abrah
 */
public class cEmpleado {
    private int codigo;
    private String nombres;
    private int horas;
    private Double pago_hora;
    public Double calcular_sueldo(){
        return(horas*pago_hora);
    }
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public int getHoras() {return horas;}
    public void setHoras(int horas) {this.horas = horas;}
    public String getNombres() {return nombres;}
    public void setNombres(String nombres) {this.nombres = nombres;}
    public Double getPago_hora() {return pago_hora;}
    public void setPago_hora(Double pago_hora) {this.pago_hora = pago_hora;}
}
