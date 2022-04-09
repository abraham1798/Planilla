package planilla;

import java.util.Scanner;
public class Main {
    static cPlanilla objPlanilla=new cPlanilla(10);
    public static void ingreso_empleado(){
        Scanner br=new Scanner (System.in);
        int codigo,horas;
        String nombres;
        double pago_hora;
        System.out.print("INGRESE UN CODIGO:");
        codigo=br.nextInt();
        System.out.print("INGRESE UN NOMBRE:");
        nombres=br.next();
        System.out.print("INGRESE HORAS TRABAJADAS:");
        horas=br.nextInt();
        System.out.print("INGRESE EL PAGO POR HORA TRABAJADA:");
        pago_hora=br.nextDouble();
       
        objPlanilla.agregar_empleado(codigo, nombres, horas, pago_hora);
    }
    public static void mostrar_empleados(){
        System.out.println(objPlanilla.listar_empleados());
    }
     public static void busca_empleado_codigo(){
         Scanner br=new Scanner (System.in);
         int cod;
         System.out.print("INGRESE CODIGO DEL EMPLEADO A BUSCAR: ");
         cod=br.nextInt();
         objPlanilla.buscar_empleado(cod);
     }
     public static void busca_empleado_nombre(){
         Scanner br=new Scanner (System.in);
         String nomb;
         System.out.print("INGRESE NOMBRE DEL EMPLEADO A BUSCAR: ");
         nomb=br.next();
         objPlanilla.buscar_empleado(nomb);
     }
     public static void ordenar_empleado_codigo() {
        objPlanilla.ordenar_codigo();
    }
    public static void ordenar_empleado_nombre() {
        objPlanilla.ordenar_nombres();
    }
    public static void modificar_pago_horas() {
        int cod;
        Double pag;
        Scanner br=new Scanner (System.in);
        System.out.print("INGRESE CODIGO DEL EMPLEADO: ");
        cod=br.nextInt();
        System.out.print("INGRESE EL PAGO POR HORA: ");
        pag=br.nextDouble();
        objPlanilla.modificar_pago(cod, pag);
    }
    public static void eliminar_empleado() {
        int cod;
        Scanner br=new Scanner (System.in);
        System.out.print("INGRESE CODIGO DEL EMPLEADO: ");
        cod=br.nextInt();
        objPlanilla.eliminar_empleado(cod);
    }
    public static void mostrar_mayor_pago(){
        System.out.println(objPlanilla.mejor_pagado());
    }
    public static void main(String[] args) {
        Scanner br=new Scanner (System.in);
        int opcion;
        do{
            System.out.println("MENU DE OPCIONES:");
            System.out.println("1. INGRESO DE EMPLEADO");
            System.out.println("2. MOSTRAR EMPLEADOS");
            System.out.println("3. BUSCAR EMPLEADO POR CODIGO ");
            System.out.println("4. BUSCAR EMPLEADO POR NOMBRE ");
            System.out.println("5. ORDENAR EMPLEADO POR CODIGO ");
            System.out.println("6. ORDENAR EMPLEADO POR NOMBRES");
            System.out.println("7. MODIFICAR PAGO POR HORA");
            System.out.println("8. ELIMINAR EMPLEADO");
            System.out.println("9. MOSTRAR EMPLEADO CON MAYOR PAGO");
            System.out.println("10. SALIR");

            do{
                System.out.print("INGRESE UNA OPCION [1-10]:");
                opcion=br.nextInt();
            }while(opcion<1||opcion>10);
            switch(opcion){
                case 1:
                    ingreso_empleado();
                    break;
                case 2:
                    mostrar_empleados();
                    break;
                case 3:
                    busca_empleado_codigo();
                    break;
                case 4:
                    busca_empleado_nombre();
                    break;
                case 5:
                    ordenar_empleado_codigo();
                    break;
                case 6:
                    ordenar_empleado_nombre();
                    break;
                case 7:
                    modificar_pago_horas();
                    break;
                case 8:
                    eliminar_empleado();
                    break;
                case 9:
                    mostrar_mayor_pago();
                    break;
                case 10:
                    System.exit(0);
            }
        }while(opcion!=10);
    }
}