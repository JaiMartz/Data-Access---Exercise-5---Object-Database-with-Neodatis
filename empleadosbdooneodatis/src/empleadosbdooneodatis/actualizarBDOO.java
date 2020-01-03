/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosbdooneodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import empleadosbdooneodatis.Empleados;
import org.neodatis.odb.Objects;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Jairo
 */
public class actualizarBDOO {
    public static void main(String[] args) {
        try{
            //Get connection with the database
            //Creamos una conexion con la base de datos
            ODB odb = ODBFactory.open("C:\\Users\\Jairo\\Desktop\\gestionLaboral1819");
            //Increment the salary in 100 for the employees whose salary is lesser than 1500
            //Aumentar en 100 el salario de los empleados cuyo salario sea inferior a 1500
            ICriterion condicion = Where.lt("salario", 1500);
            IQuery query = new CriteriaQuery(Empleados.class, condicion);
            //Catch the employees in a list
            //Capturamos los empleados en una lista
            Objects<Empleados> listaEmp = odb.getObjects(query);
            Empleados empActual;
            ////Go over the list
            //Recorremos la lista
            while(listaEmp.hasNext()){
                //Inizialice the object Empleados
                //Inicializamos el objeto Empleados
                empActual= listaEmp.next();
                //Increment the salary in 100
                //Aumento el salario en 100
                empActual.setSalario(empActual.getSalario()+100);
                //Save the new object
                //Guardo el objeto de nuevo
                odb.store(empActual);
            }
            //Close the flow
            //Cerramos flujo
            odb.close();
            System.out.println("La base de datos se ha actualizado con éxito.");
        }catch(Exception e){
            System.out.println("No ha podido actualizarse la base de datos");
        }
    }
}
