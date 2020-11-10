
package com.controlador;

import com.modelo.DaoUsuario;
import com.modelo.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Nombre de la Clase: ProcesarUsuario
 * Fecha: 21/04/2020
 * Version: 1.0
 * Copyrigth: I-Strategies
 * @author Edgard Palacios
 */

public class ProcesarUsuario {
    
    DaoUsuario dao = new DaoUsuario();
    
    @RequestMapping("usuario.htm")
    public String login(Model m, HttpServletRequest request) {
        HttpSession ses = (HttpSession)request.getSession();
        if(ses.getAttribute("user")!=null){
            return "redirect:/index.htm";
        }else {
            m.addAttribute(new Usuario());
            return "login";
        } 
    }
    
    @RequestMapping(value = "usuario.htm", method = RequestMethod.POST)
    public String validar(
            @ModelAttribute("usuario") Usuario u,
            HttpServletRequest request,
            Model m) {
        
            String msj="";
          
            if(dao.validarNumCaracteres(u.getUser())<6){
                msj = "Error: Pocos Caracteres para Usuario";
            }
            else if(dao.validarNumCaracteres(u.getUser())>12){
                msj = "Error: Demasiados Caracteres para Usuario";
            }
            else{
                
                 if(dao.validarTxtUsuario(u.getUser()))
          {
            if(dao.validarPassword(u.getPass()))
          {
                if(dao.validarUsuario(u.getUser())){
                if(dao.login(u)){
                    msj = "Loggeado correctamente";
                   HttpSession ses = request.getSession(true);
                   ses.setAttribute("user", u.getUser());
                   return "redirect:/index.htm";
                }else {
                   msj = "Error: Usuario o Contraseña Incorrecto";
               }
            }else {
                msj = "Error: Usuario Incorrecto";
            }
   
            }
            else{
                msj = "Error: Contraseña solo deben ser Numeros";
            }
          }
          else
          {
              msj = "Error: Usuario solo deben ser Alfanumerico";
          }
            }
            
            
         
            
        
          request.setAttribute("msj", msj);
          
          m.addAttribute("mensaje", msj);
            m.addAttribute("usuario", new Usuario());
        return "login";
    }
    
        
    @RequestMapping(value = "usuarioEnd.htm", method = RequestMethod.GET)
    public String salir(HttpServletRequest request) {
         HttpSession ses = (HttpSession)request.getSession();
        ses.invalidate();
        return "redirect:/usuario.htm";
    }
    
}
