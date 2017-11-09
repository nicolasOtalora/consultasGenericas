/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conexion;
import vo.Vendedores;

public class Tx<T> {

    T t;
    private Connection conexion;

    public Tx(T t) {
        this.t=t;
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean insertar(T vendedor) throws IllegalArgumentException, IllegalAccessException {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = createStatement(vendedor);
            //2. Crear el PreparedStament
            Statement statement=conexion.createStatement();
            //-----------------------------------
//            statement.setString(1, vendedor.getNombre());
//            statement.setString(2, vendedor.getPassword());

            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute(consulta);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    public ArrayList<T> select(T t, String nombre,String valor){
       //1.Consulta
       ArrayList<T> respuesta = new ArrayList<T>();
       String consulta =createSelectStatement(t, nombre,valor);
        try {
            //----------------------------
            //Statement
            Statement statement =
                    this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado = 
                    statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while(resultado.next()){
                respuesta.add((T) resultado);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
    }
    
    public String createStatement(T t) throws IllegalArgumentException, IllegalAccessException {
        String atr="";
        String sign="";
        String atrValue="";

        Field[] f = t.getClass().getDeclaredFields();
        for (int i = 0; i < f.length; i++) {
            System.out.println(f[i].getName() + ": " + f[i].get(t));
            System.out.println(t.getClass().getSimpleName());
            atr +=f[i].getName();
            atrValue+="'"+f[i].get(t)+"'";
            if(i!=f.length-1){
                atr+=",";
                atrValue+=",";
            }
            
        }
        
        String st = "insert into "+t.getClass().getSimpleName()+" values"+"("+atrValue+")";
        System.out.println("sssttttttt"+st);
        return st;
          
    }
    public String createSelectStatement(T t,String nombre,String valor){
        String st = "select * from "+t.getClass().getSimpleName()+"where '"+nombre+"' = '"+valor+"'";
        System.out.println("Consulta select:  "+st);
        return st;
    }

}
