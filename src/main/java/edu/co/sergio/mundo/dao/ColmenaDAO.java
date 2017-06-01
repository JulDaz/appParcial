/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Colmena;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author JulDa
 */
public class ColmenaDAO implements IBaseDatos<Colmena> {

    @Override
    public List<Colmena> findAll() {
        List<Colmena> colmenas= null;
	    String query = "select panalesAlimento, count(*) as total from VisitaTecnica group by panalesAlimento;";
	    Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ColmenaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int alimento=0;
	    int total = 0;
	
	    while (rs.next()){
	    	if(colmenas == null){
	    		colmenas= new ArrayList<Colmena>();
	    	}
	      
	        Colmena registro= new Colmena();
	        alimento= rs.getInt("panalesAlimento");
	        registro.setPanalesAlimento(alimento);
	        
	        total = rs.getInt("total");
	        registro.setTotal(total); 
	        
	        colmenas.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de Departamentos");
			e.printStackTrace();
		}
	    
	    return colmenas;
    }

    @Override
    public boolean insert(Colmena t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Colmena t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Colmena t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
