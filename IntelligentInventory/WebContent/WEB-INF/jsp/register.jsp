<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>iNTiNV</title>
<link rel="stylesheet" href="resources/style.css" type="text/css"/>
<link rel="stylesheet" href="resources/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="resources/blue.css" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<script src="resources/jQuery/jQuery-2.2.0.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/icheck.min.js"></script>

<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>
<br>
  <div style="text-align: center;"><a href="index.jsp"><img align="middle" src="resources/images/Logo4_blue.png" height="150" width="300"/></a></div>
  
<div class="register-box">
  <div class="register-logo">
    <a href="welcome"><b>iNTELLIGENT</b>iNVENTORY</a>
  </div>
  <span style="color:RED">${registerError}</span>
  <div class="register-box-body">
    <p class="login-box-msg">Register a new membership</p>

    <form action="register" method="post">
      <div class="form-group has-feedback">
        <input type="text" id="name" name="name" class="form-control" placeholder="Full name">
      </div>
      <div class="form-group has-feedback">
        <input type="text" id="identifier" name="identifier" class="form-control" placeholder="Identifier">
      </div>
      <div class="form-group has-feedback">
        <input type="password" id="password" name="password" class="form-control" placeholder="Password">
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Retype password">
      </div>
      <div class="form-group">
       
       <form:select  class="form-control" id="role" path="user_roles" name= "role">
       	   <form:option value="NONE" label="Select role" />
           <form:options items="${user_roles}" itemValue="id" itemLabel="role_name"/>
       </form:select >
      </div>
      
      <div class="row">
        <div class="col-xs-12">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
      </div>
    </form>
	<br>
    <a href="login" class="text-center">Already a member? Click here to login.</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->
</body>
</html>
