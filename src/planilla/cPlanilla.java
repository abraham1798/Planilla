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
public class cPlanilla {
    
//atributos
    private cEmpleado objEmpleado[];
    private int contador;
    //constructor
    public cPlanilla(int n) {
        objEmpleado=new cEmpleado[n];
        //
        objEmpleado[0]=new cEmpleado();
        objEmpleado[0].setCodigo(6);
        objEmpleado[0].setNombres("JUAN");
        objEmpleado[0].setHoras(4);
        objEmpleado[0].setPago_hora(1300.0);
        objEmpleado[1]=new cEmpleado();
        objEmpleado[1].setCodigo(3);
        objEmpleado[1].setNombres("LUIS");
        objEmpleado[1].setHoras(4);
        objEmpleado[1].setPago_hora(1500.0);
        objEmpleado[2]=new cEmpleado();
        objEmpleado[2].setCodigo(7);
        objEmpleado[2].setNombres("Pedro");
        objEmpleado[2].setHoras(5);
        objEmpleado[2].setPago_hora(1300.0);
        objEmpleado[3]=new cEmpleado();
        objEmpleado[3].setCodigo(1);
        objEmpleado[3].setNombres("Maria");
        objEmpleado[3].setHoras(5);
        objEmpleado[3].setPago_hora(1800.0);
        //
        contador=4;
    }
    //operaciones
    public void agregar_empleado(int codigo,String nombres,int horas,Double pago_hora){
        int flag=0;
        for(int i=0;i<contador;i++){
            if(codigo==objEmpleado[i].getCodigo()){
                flag=1;
            }
        }
        if(flag==0){
            if(contador<objEmpleado.length){
                objEmpleado[contador]=new cEmpleado();
                objEmpleado[contador].setCodigo(codigo);
                objEmpleado[contador].setNombres(nombres);
                objEmpleado[contador].setHoras(horas);
                objEmpleado[contador].setPago_hora(pago_hora);
                contador++;
            }
            else{
                System.out.println("NO SE PUEDE AGREGAR EMPLEADO...VECTOR LLENO!!!");
            }
        }
        else{
            System.out.println("EL CODIGO INGRESADO ES REPETIDO...!!!");
        }
    }
    public String listar_empleados(){
        String lista="LISTA DE EMPLEADOS\n";
        for(int i=0;i<contador;i++){
            lista+=(i+1)+".-"+"\t"+objEmpleado[i].getCodigo()+"\t"+objEmpleado[i].getNombres()+"\t"+objEmpleado[i].calcular_sueldo()+"\n";
        }
        return lista;
    }
    public void buscar_empleado(int codigo)
    {
        int posicion=-1;
        for(int i=0;i<contador;i++){
        if(codigo==objEmpleado[i].getCodigo())
                posicion=i;
        }
        if(posicion!=-1){
            System.out.println("EL EMPLEADO DE CODIGO: "+codigo+" ES "+ objEmpleado[posicion].getNombres());
        }
        else{
            System.out.println("EL EMPLEADO DE CODIGO: "+codigo+" NO EXISTE");
        }
    }
    public void buscar_empleado(String nombres){
        int posicion=-1;
        for(int i=0;i<contador;i++){
            if(nombres.equals(objEmpleado[i].getNombres()))
                posicion=i;
        }
        if(posicion!=-1){
            System.out.println("EL EMPLEADO DE NOMBRE: "+nombres+" TIENE EL CODIGO "+objEmpleado[posicion].getCodigo());
        }
        else{
            System.out.println("EL EMPLEADO DE NOMBRE: "+nombres+" NO EXISTE");
        }
    }
    public void ordenar_codigo(){
        for (int i=0; i<contador-1; i++){
            for (int j=i+1;j<contador; j++){
                if(objEmpleado[i].getCodigo() > objEmpleado[j].getCodigo()){
                    cEmpleado temp=objEmpleado[i];
                    objEmpleado[i]=objEmpleado[j];
                    objEmpleado[j]=temp;
                }
            }
        }
    }
    public void ordenar_nombres(){
        for (int i=0; i<contador-1; i++){
            for (int j=i+1; j<contador; j++){
                if(objEmpleado[i].getNombres().compareTo(objEmpleado[j].getNombres())>1){
                    cEmpleado temp=objEmpleado[i];
                    objEmpleado[i]=objEmpleado[j];
                    objEmpleado[j]=temp;
                }
            }
        }
    }
    public void modificar_pago(int codigo, double pago){
        int index;
        index=encontrar_empleado(codigo);
        if (index==-1){
            System.out.println("EL EMPLEADO DE CODIGO: "+codigo+" NO EXISTE");
        }
        else{
            objEmpleado[index].setPago_hora(pago);
        }
    }
    public int encontrar_empleado(int codigo)
    {
        int posicion=-1;
        for(int i=0;i<contador;i++){
            if(codigo == objEmpleado[i].getCodigo()){
                posicion=i;
            }
        }
        return posicion;
    }
    public void eliminar_empleado(int codigo){
        int index;
        index=encontrar_empleado(codigo);
        if(index==-1){
            System.out.println("EL EMPLEADO DE CODIGO: "+codigo+" NO EXISTE");
        }
        else{
            for(int i=index;i<contador;i++){
                objEmpleado[i]=objEmpleado[i+1];
            }
            contador--;
        }
    }
    public String mejor_pagado(){
        String lista="EMPLEADO MEJOR PAGADO\n";
        int index=0;
        Double maxpago=0.0;
        for(int i=0;i<contador;i++){
            if(maxpago<objEmpleado[i].calcular_sueldo()){
                index=i;maxpago=objEmpleado[i].calcular_sueldo();
            }
        }
        lista+=objEmpleado[index].getCodigo()+"\t"+objEmpleado[index].getNombres()+"\t"+objEmpleado[index].calcular_sueldo()+"\n";
        return lista;
    }
}
