<%-- 
    Document   : bodyOrdersHome
    Created on : Apr 14, 2016, 3:53:39 PM
    Author     : Mihail.Cepraga
--%>

<div ng-app="ordersApp" ng-controller="ordersController" >

    <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-header">
        <h3 class="modal-title">Notes</h3>
        </div>
        <div class="modal-body">
          
 <table class="table table-bordered table-striped">
    
    <thead>
      <tr>
        <th>Parameter</th>
        <th>Note</th>
      </tr>
    </thead>
    
    <tbody>
      <tr ng-repeat="note in gridOrderNotes | orderBy:'nameGroups'">
        <td>{{ note.nameGroups }}</td>
        <td><p>
            <p><span class="text-muted" >{{ note.firstName }}</span> 
            <button type="button" class="btn btn-xs btn-danger">
                <i class="glyphicon glyphicon-remove" aria-hidden="true">
                </i>
            </button>
            <button type="button" class="btn btn-xs btn-primary">
                <i class="glyphicon glyphicon-edit" aria-hidden="true"> 
                </i>
            </button></p>
                <input type="text" class="form-control" value="{{ note.note }}">
                </p>
            </td>
      </tr>
    </tbody>
    
  </table>
        
        
        </div>
        <div class="modal-footer">
        <button class="btn btn-primary" type="button" ng-click="ok()">OK</button>
        <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
        </div>
    </script>    

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
                    <button type="button" id="addData" class="btn btn-info pull-right" ng-click="addNewOrder()"><span class="glyphicon glyphicon-plus"></span> Add New Order</button>
                </div>
                <div class="tablecontainer">

                    <div>
                        <div id="grid" ui-grid="myData" ui-grid-edit ui-grid-row-edit ui-grid-pinning ui-grid-selection ui-grid-exporter ui-grid-cellNav class="grid"></div>
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
<script src="js/scripts/controllers/orders_controller.js"></script>