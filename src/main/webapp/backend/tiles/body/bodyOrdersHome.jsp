<%-- 
    Document   : bodyOrdersHome
    Created on : Apr 14, 2016, 3:53:39 PM
    Author     : Mihail.Cepraga
--%>

<div ng-app="ordersApp" ng-controller="ordersController">

    <div class="jumbotron">
        <div class="container">
            <h1>Hear you found all our orders!!!</h1>
            <div class="row">
                <div class="col-lg-12">
                    <code>{{orders}}</code>                    
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Orders </span></div>
                <div class="tablecontainer">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID.</th>
                                <th>customerName</th>
                                <th>colorName</th>
                                <th>modelName</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="u in orders">
                                <td><span ng-bind="u.id"></span></td>
                                <td><span ng-bind="u.customerName"></span></td>
                                <td><span ng-bind="u.colorName"></span></td>
                                <td><span ng-bind="u.modelName"></span></td>
                                <td>
                               <button type="button" ng-click="edit(u.id)" class="btn btn-success custom-width">Edit</button>  
                               <!--<button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>-->
                               </td> 
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/angular/angular.min.js"></script>
<script src="js/scripts/apps/orders_app.js"></script>
<script src="js/scripts/services/orders_service.js"></script>
<script src="js/scripts/controllers/orders_controller.js"></script>