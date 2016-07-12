
<!-- Logo -->
<a href="welcome" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
	<span class="logo-mini"><b>Int</b>Inv</span> <!-- logo for regular state and mobile devices -->
	<span class="logo-lg" style="font-size: 15px;"><b>iNTELLIGENT</b>iNVENTORY</span>
</a>
<!-- Header Navbar: style can be found in header.less -->
<nav class="navbar navbar-static-top">
	<!-- Sidebar toggle button-->
	<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
		role="button"> <span class="sr-only">Toggle navigation</span>
	</a>

	<div class="navbar-custom-menu">
		<ul class="nav navbar-nav">
			<li class="dropdown user user-menu"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <span
					class="hidden-xs">${loggedInUser}</span>
			</a>
				<ul class="dropdown-menu">
					<!-- User image -->
					<li class="user-header" style="height: 100px">
						<p>${loggedInUser}</p>
					</li>

					<!-- Menu Footer-->
					<li class="user-footer">
						<div class="pull-left">
							<a href="#" class="btn btn-default btn-flat">Edit</a>
						</div>
						<div class="pull-right">
							<a href="logout" class="btn btn-default btn-flat">Logout</a>
						</div>
					</li>
				</ul></li>

		</ul>
	</div>
</nav>