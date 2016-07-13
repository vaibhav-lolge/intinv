<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iNTiNV</title>
<link rel="stylesheet" href="resources/style.css" type="text/css"/>
<link rel="stylesheet" href="resources/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="resources/blue.css" type="text/css"/>
<link rel="stylesheet" href="resources/_all-skins.min.css" type="text/css"/>
<link rel="stylesheet" href="resources/jquery-jvectormap-1.2.2.css" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="resources/jQuery/jQuery-2.2.0.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/icheck.min.js"></script>
<script src="resources/js/jquery.sparkline.min.js"></script>
<script src="resources/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="resources/js/jquery-jvectormap-world-mill-en.js"></script>
<script src="resources/js/jquery.knob.js"></script>
<script src="resources/js/jquery.slimscroll.min.js"></script>
<script src="resources/js/fastclick.js"></script>
<script src="resources/js/app.min.js"></script>
<script src="resources/js/demo.js"></script>
<script src="resources/js/dashboard.js"></script>

<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>

</head>

<body class="hold-transition skin-blue sidebar-mini">
 <div class="wrapper">
  <header class="main-header">
  	<%@include file="includes/header.jsp" %>
  </header>
  <%@include file="includes/sideMenu.jsp" %>
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="row">
      	 <div class="col-xs-12">
           <div class="box box-primary">
           
            <div class="box-header with-border">
              <h3 class="box-title">List of Available Categories</h3>
            </div>
	        <c:if test="${not empty categoryList}">
		            <table class="table table-hover">
			           <tr>
			           	<th>Category Identifier</th>
			           	<th>Category Name</th>
			           	<th>Category Description</th>
			           	<th>Active / inactive</th>
				       </tr>
				       <c:forEach var="category" items="${categoryList}">
					       <tr>
				           	<td>${category.categoryIdentifier}</td>
				           	<td>${category.categoryName}</td>
				           	<td>${category.categoryDesc}</td>
				           	<td>
				           		<c:if test="${category.active == 0}">
				                  	Inactive
				                 </c:if>
			                     <c:if test="${category.active == 1}">
				                  	Active
				                 </c:if>	
							</td>
					       </tr>
				       </c:forEach>
			        </table>
	           </c:if>
	           <c:if test="${empty categoryList}">
	            	NO categories 
	           </c:if>
          </div>
        </div>
      </div>  
	</section>
  </div>
 </div>
</body>
</html>