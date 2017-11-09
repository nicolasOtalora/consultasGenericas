<%-- 
    Document   : index
    Created on : 11/03/2017, 03:11:18 PM
    Author     : PC USUARIO
--%>
<%@page import="javax.swing.JOptionPane"%>
<%--@page import="Imagenes.*"--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Base de Datos - ExpoTurismo</title>

    </head>
    <body>
        <div>
            <div class="col3">&nbsp;</div>
            <div class="col3 titulo"><h3>Ingresar Datos</h3></div>
            <div class="col3 logo"><image src="logo_pagina.png"/></div>
            <div class="usuario">
                <form action="RegistrarVendedorServlet" method="POST">
                    Nombre: <input type="text" name="nombre"/></br></br>
                    Password: <input type="password" name="pass"/></br></br>
                    <input type="submit" value="Ingresar"/>
                </form>
                <form action="RegistrarVendedorServlet" method="Get">
                    <h3>Listar</h3>
                    Nombre atributo: <input type="text" name="nombAtr"/></br></br>
                    Valor : <input type="text" name="valor"/></br></br>
                    <input type="submit" value="Listar"/>

                </form>


            </div>
            <div class="clearfix"></div>
        </div>


    </body>
</html>
