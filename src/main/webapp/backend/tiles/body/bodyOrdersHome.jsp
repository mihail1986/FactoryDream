<%-- 
    Document   : bodyOrdersHome
    Created on : Apr 14, 2016, 3:53:39 PM
    Author     : Mihail.Cepraga
--%>

<div ng-app="ordersApp" ng-controller="ordersController" >


    <div class="jumbotron">
        <div class="container">
            <h1>Here you can found all our orders!!!</h1>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Orders </span></div>
                <div class="tablecontainer">

                    <div>
                        <div id="grid" ui-grid="myData" ui-grid-edit class="grid"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/angular.1.4.9/angular.min.js"></script>
<script src="js/angular.1.4.9/angular-touch.min.js"></script>
<script src="js/angular.1.4.9/angular-animate.min.js"></script>
<script src="js/uiGridv3.1.1/grunt-scripts/csv.js"></script>
<script src="js/uiGridv3.1.1/grunt-scripts/vfs_fonts.js"></script>
<script src="js/uiGridv3.1.1/ui-grid.min.js"></script>
<script src="js/scripts/apps/orders_app.js"></script>
<script src="js/scripts/services/orders_service.js"></script>
<script src="js/scripts/services/model_service.js"></script>
<script src="js/scripts/controllers/orders_controller.js"></script>