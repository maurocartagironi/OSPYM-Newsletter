<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/OSDEPYM/resources/core/css/newsletter/newsletter.css" />
		<script type="text/javascript" src="/OSDEPYM/resources/core/js/newsletter/newsletter.js"></script>
	</head>
	<body>
	    <div class="newsletter-form">
		    <div>
		    	<form name="newsletterForm">		    	
			    	<label for="name">Nombre</label>
			        <input type="text" name="name"></input>
			        <label for="email">Email</label>
			        <input type="email" name="email" />
		        </form>
		    </div>
	        <div>
		        <div id="loading" class="lds-ring">
		        	<div>
		        	</div>
		        	<div>
		        	</div>
		        	<div>
		        	</div>
		        	<div>
		        	</div>
	        	</div>
	        	<div id="ok" class="check-and-error-mark">
				    <div class="checkmark-stem"></div>
				    <div class="checkmark-kick"></div>
				</div>
				<div id="error" class="check-and-error-mark">
				    <div class="error-stem"></div>
				    <div class="error-kick"></div>
				</div>
			</div>			
	   	</div>  
	   	<div>
        	<button onclick="submit()">Suscribirme</button>
       	</div>
	</body>
</html>