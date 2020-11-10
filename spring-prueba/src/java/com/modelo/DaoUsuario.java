
package com.modelo;

import com.conexion.Conexion;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Nombre de la Clase: DaoUsuario
 * Fecha: 21/04/2020
 * Version: 1.0
 * Copyrigth: I-Strategies
 * @author Edgard Palacios
 */

public class DaoUsuario {
    
    
  //Instancia de Conexion  
  Conexion con = new Conexion();
  
  //Instancia de JdbcTemplate
  JdbcTemplate jdbc = new JdbcTemplate((DataSource)this.con.conectar());
  
  
  //Metodo para Comprobar Existencia
  public boolean login(Usuario u) {
    try {
      String sql = "select COUNT(*) from usuario WHERE nombreUsuario=? and password=?";
      int res = ((Integer)this.jdbc.queryForObject(sql, new Object[] { u.getUser(), u.getPass() }, Integer.class)).intValue();
      if (res > 0){
        return true; 
      }else{
          return false;
      }
        
      
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } 
  }
  
  //Metodo para Validar Usuario
  public boolean validarUsuario(String nombreUsuario) {
    try {
      int res = (this.jdbc.queryForObject("select COUNT(*) from usuario WHERE nombreUsuario=?", new Object[] { nombreUsuario }, Integer.class));
      if (res > 0){
        return true; 
      }else{
          return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } 
  }
  
  
  //Validar Numero de Caracteres
  public int validarNumCaracteres(String nombreUsuario) {
    try {
      int res = (this.jdbc.queryForObject("SELECT length(?)", new Object[] { nombreUsuario }, Integer.class));
    return res;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    } 
  }
   

    public boolean validarTxtUsuario(String username) {
        try {
            int res = this.jdbc.queryForObject(" SELECT (?) REGEXP '^[A-Za-z0-9]'", new Object[]{username}, Integer.class);
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
       public boolean validarPassword(String password) {
        try {
            int res = this.jdbc.queryForObject("SELECT (?) REGEXP '^[0-9]+$'", new Object[]{password}, Integer.class);
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
