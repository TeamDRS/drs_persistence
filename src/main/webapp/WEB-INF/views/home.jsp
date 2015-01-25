<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- http://stackoverflow.com/questions/4853397/in-spring-mvc-headers-x-requested-withxmlhttprequest-in-request-mapping-no -->
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript">
	    function crunchifyAjax() {
	        $.ajax({
	            url : 'ajaxtest.html',
	            success : function(data) {
	                $('#result').html(data);
	            }
	        });
    	}
	</script>

	Willkommen bei Compare!!!!! 
	
	<a></a>
	
</body>
</html>