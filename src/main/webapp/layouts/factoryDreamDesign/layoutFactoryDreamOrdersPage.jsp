<%-- 
    Document   : layoutFactoryDreamOrdersPage
    Created on : Apr 14, 2016, 3:48:55 PM
    Author     : Mihail.Cepraga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="" />
        <meta name="description" content="login page">
        <meta name="author" content="">
        
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- UI-Grid Core CSS -->
        <link href="css/cssGrid/ui-grid.min.css" rel="styleSheet">
        
        <!-- main CSS -->
        <link href="css/main.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="js/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="js/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->


    </head>
    <body>
        <tiles:insertAttribute name="body"/>
    </body>
</html>
