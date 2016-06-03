<%-- 
    Document   : bodyOrdersHome
    Created on : Apr 14, 2016, 3:53:39 PM
    Author     : Mihail.Cepraga
--%>

<div ng-app="ordersApp" ng-controller="ordersController" >

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li><a href="#"><span class="glyphicon glyphicon-user"></span> User Name</a></li>
        <li><a href="FactoryDream/logout">Logout <span class="glyphicon glyphicon-log-out"></span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
        </div>
    </nav>
    <!--    <div class="jumbotron">
            <div class="container">
                <h1>Here you can found all our orders!!!</h1>
            </div>
        </div>-->
    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Orders </span>
                    <button type="button" ng-model="orderAddFlag" ng-hide="orderAddFlag" id="addData" class="btn btn-info pull-right" ng-click="openOrderAddModalWindow('lg')"><span class="glyphicon glyphicon-plus"></span> Add New Order</button>
                </div>
                <div class="tablecontainer">

                    <div>
                        <div id="grid" ui-grid="ordersGridData" ui-grid-edit ui-grid-row-edit ui-grid-pinning ui-grid-selection ui-grid-exporter ui-grid-cellNav class="grid"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/angular.1.4.9/angular.min.js"></script>
<script src="js/angular.1.4.9/angular-resource.min.js"></script>
<script src="js/angular.1.4.9/angular-touch.min.js"></script>
<script src="js/angular.1.4.9/angular-animate.min.js"></script>
<script src="js/angular.1.4.9/angular-route.min.js"></script>
<script src="js/ui-bootstrap-tpls-1.2.3.min.js"></script>
<script src="js/uiGridv3.1.1/grunt-scripts/csv.js"></script>
<script src="js/uiGridv3.1.1/grunt-scripts/vfs_fonts.js"></script>
<script src="js/uiGridv3.1.1/ui-grid.min.js"></script>
<script src="js/scripts/apps/orders_app.js"></script>
<script src="js/scripts/services/orders_service.js"></script>
<script src="js/scripts/services/model_service.js"></script>
<script src="js/scripts/services/color_service.js"></script>
<script src="js/scripts/services/type_service.js"></script>
<script src="js/scripts/services/diameter_service.js"></script>
<script src="js/scripts/services/customer_service.js"></script>
<script src="js/scripts/services/thread_service.js"></script>
<script src="js/scripts/services/status_service.js"></script>
<script src="js/scripts/services/orderNotes_service.js"></script>
<script src="js/scripts/controllers/orderNotesModal_controller.js"></script>
<script src="js/scripts/controllers/addNewOrderModal_controller.js"></script>
<script src="js/scripts/directives/orderNotes_directives.js"></script>
<script src="js/scripts/controllers/orders_controller.js"></script>