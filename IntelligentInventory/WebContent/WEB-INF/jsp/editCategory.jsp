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
              <h3 class="box-title">Search a category to edit</h3>
            </div>
            
            <span style="color:RED;padding-left:10px;">${searchedCategoryError}</span>
            
            <form role="form" action="searchCategory" method="post">
              <div class="box-body">
                <div class="form-group">
                  <label>Category Identifier</label>
                  <input type="text" id="categoryIdentifier" name="categoryIdentifier" class="form-control" placeholder="E.g.: HW01">
                </div>
              </div>
              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Search Category</button>
              </div>
            </form>
	        
          </div>
        </div>
      </div>  
      
       <div class="row">
      	 <div class="col-xs-12">
           <div class="box box-primary">
           
            <div class="box-header with-border">
              <h3 class="box-title">Edit Category</h3>
            </div>
            
            <span style="color:RED;padding-left:10px;">${categorySaveError}</span>
            <span style="color:GREEN;padding-left:10px;">${categorySaveSuccess}</span> <br>
            <c:if test="${not empty categoryNameValidation}">
            	<span style="color:#551A8B;padding-left:30px;"><i class="fa fa-check"></i>${categoryNameValidation}</span><br>
            </c:if>
            <c:if test="${not empty categoryDescValidation}">
            	<span style="color:#551A8B;padding-left:30px;"><i class="fa fa-check"></i>${categoryDescValidation}</span><br>
            </c:if>
            <c:if test="${not empty categoryActivateValidation}">
            	<span style="color:#551A8B;padding-left:30px;"><i class="fa fa-check"></i>${categoryActivateValidation}</span>
            </c:if>
            <c:if test="${not empty searchedCategory}">
	            <form role="form" action="editCategory" method="post">
	              <div class="box-body">
	              	<div class="form-group">
	                  <label>Category Identifier: </label> <br>
	                  <input type="text" id="categoryIdentifier" name="categoryIdentifier" disabled="" class="form-control" value="${searchedCategory.categoryIdentifier}">
	                  &nbsp;<small style="color:RED">*You cannot edit the category identifier</small>
	                </div>
	                
	                <div class="form-group">
	                  <label>Category Name</label>
	                  <input type="text" id="categoryName" name="categoryName" class="form-control" placeholder="${searchedCategory.categoryName}">
	                </div>
	                <div class="form-group">
	                  <label>Category Description</label>
	                  <textarea class="form-control" id="categoryDesc" name="categoryDesc" rows="3" placeholder="${searchedCategory.categoryDesc}"></textarea>
	                </div>
	                <div class="form-group">
	                  <div class="radio">
	                    <label>
	                      <input type="radio" name="activateOption" id="optionsRadios1" value="1" 
	                      	<c:if test="${searchedCategory.active == 1}">
	                      		checked
	                      	</c:if>	                      
	                      >
	                      Active
	                    </label>
	                  </div>
	                  <div class="radio">
	                    <label>
	                      <input type="radio" name="activateOption" id="optionsRadios2" value="0"
	                      <c:if test="${searchedCategory.active == 0}">
	                      		checked
	                      </c:if>	 
	                      >
	                      In-Active
	                    </label>
	                  </div>
	                </div>
	              </div>
	              <div class="box-footer">
	                <button type="submit" class="btn btn-primary">Save Category</button>
	              </div>
	            </form>
	        </c:if>
          </div>
        </div>
      </div> 
	</section>
  </div>
 </div>
</body>
</html>