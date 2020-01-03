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
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Jairo
 */
public class consultarBDOO {
    public static void main(String[] args) {
        try{
            //Get connection with the database
            //Creamos una conexion con la base de datos
            ODB odb = ODBFactory.open("C:\\Users\\Jairo\\Desktop\\gestionLaboral1819");

            //Query all the information in the table Empleados
            //Consultar todos los datos de la tabla Empleados
            IQuery query = new CriteriaQuery(Empleados.class);
            //Save the information obtained in a list of objects
            //Realizamos la consulta y almacenamos la informacion en una lista
            Objects<Empleados> listaEmp = odb.getObjects(query);
            Empleados empActual;
            
            //Show the information inside the list
            //Recorremos la lista de objetos para mostrar su información
            while(listaEmp.hasNext()){
                empActual = listaEmp.next();
                System.out.println("codEmpleado: "+empActual.getCodEmpleado()
                                    +" Nombre: "+empActual.getNombre()
                                    +" Apellidos: "+empActual.getApellidos()
                                    +" Puesto: "+empActual.getPuesto()
                                    +" Salario: "+empActual.getSalario());
            }
            //Close the flow
            //Cerramos el flujo
            odb.close();
        }catch(Exception e){
            System.out.println("No ha podido realizarse la consulta");
        }
    }
}