/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosbdooneodatis;

import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author Jairo
 */
public class crearBDOO {
    public static void main(String[] args) {
        try{
            //Get connection with the database
            //Creamos conexion con la base de datos
            ODB odb = ODBFactory.open("C:\\Users\\Jairo\\Desktop\\gestionLaboral1819");
            //Creathe the object that will be contained in the database
            //Creamos los objetos para almacenar en la base de datos
            Empleados emp1 = new Empleados(1,"Juan", "Martín", "Administrativo", 1200);
            Empleados emp2 = new Empleados(2,"Ana", "Amezcua", "Programador Senior", 1500);
            Empleados emp3 = new Empleados(3,"Raúl", "Perez", "Programador Junior", 1400);
            Empleados emp4 = new Empleados(4,"Jairo", "Martínez", "Programador Junior", 1400);
            Empleados emp5 = new Empleados(5,"Celia", "Carrillo", "Jefe de equipo", 1800);
            
            //Almacenamos los objetos en un ArrayList
            ArrayList<Empleados> listaEmp = new ArrayList<Empleados>();
            listaEmp.add(emp1);
            listaEmp.add(emp2);
            listaEmp.add(emp3);
            listaEmp.add(emp4);
            listaEmp.add(emp5);
            
            //Recorremos los objetos y los almacenamos en la base de datos
            for(Empleados emp: listaEmp){
            odb.store(emp);
            }
            //Cerramos el flujo
            odb.close();
            
            System.out.println("La base de datos gestionLaboral1819 se ha creado con exito");
        }catch(Exception e){
             System.out.println("La base de datos no ha podido crearse");
             System.out.println(e.getMessage());
        }
    }
}
