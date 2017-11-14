package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;
import vo.Vendedores;

public class VendedorDAO {

    private Tx tx;

    public VendedorDAO() {
        this.tx = new Tx(new Vendedores());
    }

    public boolean insertar(Vendedores vendedor) throws IllegalArgumentException, IllegalAccessException {
        boolean resultado = false;
        resultado = tx.insertar(vendedor);
        
        
        return resultado;
    }
    public ArrayList<Vendedores> listar (String nombre, String valor){
        
        ArrayList<Vendedores> vendedores = tx.select(nombre,valor);
        
        return vendedores;
        
    }
    

}
