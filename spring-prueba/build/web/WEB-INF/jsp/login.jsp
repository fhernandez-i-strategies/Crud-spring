<%-- 
    Document   : Login
    Created on : 04-24-2020, 03:59:24 PM
    Copyrigth  : I-Strategies
    Author     : Edgard Palacios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <!-- css de Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- css de Bootstrap -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css"/>
        <title>I-Strategies | Inicio de Sesion</title>
    </head>
    <body style="background:linear-gradient(25deg, white,#A5E1F5,#46CAF4);">
          <center>
        <!-- Body -->
        <br />
              <br />
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-8 mt-5">
                    <br>
                    <div class="card">
                        <div class="card-body">
                        
                        
                        
                        
                        <img src="Recursos/logo.jpg" width="340" height="340" alt="logo"/>

                        
                    
                        </div>
                    </div>
                </div>

                <!-- tabla de Personas -->
                <div class="col-md-4 mt-5">
                    <div class="card">
                        <div class="card-body">
                            <div class="card">
                    <div class="card-body">
                        
                        <h1 class="h3 text-center">Inicio de Sesion</h1>
                        <hr>
                        <div class="clear-fix"></div>
                        
                        
                        <!-- Formulario de Persona -->
                        <form:form modelAttribute="usuario" autocomplete="off">
                            <form:hidden path="idUsuario"/>
                            
                            <div class="row mt-1">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Usuario</label>
                                        <form:input path="user" required="true" cssClass="form-control" placeholder="Usuario..." maxlength="12"/>
                                    </div>
                                </div>
                             </div>
                                    
                            <div class="row mt-1">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Password</label>
                                        <form:input type="password" path="pass" cssClass="form-control" placeholder="Password..."/>
                                    </div>
                                </div>
                             </div>
                                    <hr>
                                    <h5 class="text-center" style="color:red;">${mensaje}</h5>
                                    <hr>
                                    
                                           <%
                                            if(request.getAttribute("msj")!=null)
                                                {
                                             %>

                                             <script>
                                                 $(document).ready(function(e)
                                                 {
                                                    swal.fire("<%= request.getAttribute("Error:") %>","<%= request.getAttribute("msj") %>","error"); 
                                                 });
                                             </script>
                                             <%
                                                 }
                                            %>
                                    
                            <div class="row">
                                <div class="col-md-12">
                                    <input type="submit" name="botton" value="Iniciar Sesion" class="btn btn-outline-primary btn-block form-control"/>
                                </div>
                            </div>
                        </form:form>
                        <!-- Formulario de Persona -->
                        
                        
                    </div>
                </div>
                        </div>
                    </div>
                </div>
                <!-- tabla de Personas -->
            </div>
        </div>
              <div class="container mt-5">
                  <div class="row">
                      <div class="col-md-12 mt-5">
                          <hr>
                          <hr>
                      </div>
                  </div>
              </div>
              <br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br>
            <br><br>
    </body>
</html>