/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadosbdooneodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Jairo
 */
public class borrarBDOO {
    public static void main(String[] args) {
        try{
            //Get connection with the database
            //Creamos una conexion con la base de datos
            ODB odb = ODBFactory.open("C:\\Users\\Jairo\\Desktop\\gestionLaboral1819");
            //Create the queary with criteria
            //Creamos la condicion
            ICriterion condicion = Where.lt("salario", 1500);
            IQuery query = new CriteriaQuery(Empleados.class, condicion);
            
            //Catch the employees
            //Capturamos los empleados
            Objects<Empleados> listaEmp = odb.getObjects(query);
            Empleados empActual;
            
            //Get the employees who comply the criteria
            //Recorremos la lista de Empleados que cumplen la condicion
            while(listaEmp.hasNext()){
                //Inicializamos los objetos
                empActual = listaEmp.next();
                //Borramos los objetos
                odb.delete(empActual);
            }
            //Close the flow
            //Cerramos la conexion
            odb.close();
            System.out.println("Los elementos se han borrado con éxito.");
        }catch(Exception e){
            System.out.println("No se han podido borrar los elementos de la base de datos.");
        }
    }
    
}
