<aside class="main-sidebar">
    <section class="sidebar">
      <div class="user-panel" style="height:40px;">
        <div class="pull-left info">
          <p>${loggedInUser}</p>        
        </div>
      </div>
      
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Smart Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <li class="active treeview">
          <a href="dashboard">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span></i>
          </a>
        </li>
        
        <li class="treeview">
          <a href="userControl">
            <i class="fa fa-users"></i> <span>User Control - ADMIN</span>
          </a>          
        </li>            
        
        <li>
          <a href="#">
            <i class="fa fa-th"></i> <span>Manage Inventory</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i> Categories
            	<i class="fa fa-angle-left pull-right"></i>
            	</a>
            	 <ul class="treeview-menu">
		            <li><a href="categories"><i class="fa fa-circle-o"></i>Add Categories</a></li>
		            <li><a href="categoriesList"><i class="fa fa-circle-o"></i>List Categories</a></li>
		            <li><a href="searchCategory"><i class="fa fa-circle-o"></i>Edit Categories</a></li>
		         </ul>
            </li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Sub-Categories</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Items</a></li>
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-check-square-o"></i>
            <span>Manage Requisition</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-cog"></i> <span>Automation Control</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-table"></i> <span>Reports</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        
        <li>
          <a href="#">
            <i class="fa  fa-pie-chart"></i> <span>Charts & Graphs</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>