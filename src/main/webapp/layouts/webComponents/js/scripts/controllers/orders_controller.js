/* 
 *  Document   : orders_controller.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */
/* global $scope, statusText, myData */

angular.module('ordersApp').controller('ordersController', ['$scope', 'ordersService', 'modelService', function ($scope, ordersService, modelService) {

        var self = this;
        var data_source;
        var user_access;
        self.modelsNameDropdown;
//        self.parameters = {};
        self.orders = [];

        
        self.fetchAllModelsValue = function(){
            modelService.fetchAllModelsValue()
                    .then(
                            function (response) {
                                self.modelsNameDropdown = angular.copy(response.data);
//                                for(i=0; i < response.data.length; i++ ){
//                                    self.modelsNameDropdown.push({"id":response.data[i].id , "value":response.data[i].value});
//                                }
                                console.log(self.modelsNameDropdown);
                            },
                            function (errResponse) {
                                console.log( errResponse.data || "Request failed");
                                $scope.status = errResponse.status;
                            }
                    );            
        };

        self.fetchAllModelsValue();

        $scope.myData = {
//        enableFiltering: true,
//        showGridFooter: true,
//        enableGridMenu: true,
//        enableSorting: true,
//        enableSelectAll: true,
//        exporterMenuPdf: false,
//        rowTemplate: rowTemplate(),
//        enableColumnResizing: true,
//        enableCellEditOnFocus: true,
//        modifierKeysToMultiSelectCells: true,
//        paginationPageSizes: [100,200,500,1000],
//        paginationPageSize: 100, 
            columnDefs: [
                {name: 'orderData', displayName: 'Data', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 90},
                {name: 'customer', displayName: 'Client', enableColumnMenu: false, editableCellTemplate: 'ui-grid/dropdownEditor', width: 150,       
                    cellFilter: 'mapCustomersById', 
                    editDropdownValueLabel: 'value', 
//                    editDropdownOptionsArray: [{ id: 1, value: 'male' }, { id: 2, value: 'female' }]
                  editDropdownRowEntityOptionsArrayPath: 'modelsOptions'  
                },
                {name: 'Client Order id', displayName: 'Ordin Client', enableColumnMenu: false,/* visible: false, */ width: 150},
                {name: 'Symbol', displayName: 'Symbol', enableColumnMenu: false, /* visible: false, */ width: 100},
                {name: 'orderIdentifier', displayName: 'Ordin Id', enableColumnMenu: false, width: 80},
                {name: 'model', displayName: 'Model', enableColumnMenu: false, width: 80},
                {name: 'T', displayName: 'T', enableColumnMenu: false, width: 80},
                {name: 'LB/FT', displayName: 'Lb/Ft', enableColumnMenu: false, width: 80},
                {name: 'diameter', displayName: 'Diametru', enableColumnMenu: false, width: 80},
                {name: 'type', displayName: 'Tipul', enableColumnMenu: false, width: 90},
                {name: 'thread', displayName: 'Filet', enableColumnMenu: false, width: 150},
                {name: 'color', displayName: 'Culoare', enableColumnMenu: false, width: 80},
                {name: 'Vent Hole', displayName: 'Vent.mm', enableColumnMenu: false, width: 80},
                {name: 'OD', displayName: 'OD.mm', enableColumnMenu: false, width: 80},
                {name: 'Drift', displayName: 'Drift_mm', enableColumnMenu: false, width: 80},
                {name: 'delivery', displayName: 'Consegna', type: 'date', cellFilter: 'date:\'dd.MM.yyyy\'', enableColumnMenu: false, width: 90},
                {name: 'quantity', displayName: 'Q-ty', enableColumnMenu: false, width: 80}
            ]
//    exporterCsvFilename: 'myFile.csv'

        };


        $scope.myData.onRegisterApi = function (gridApi) {
            //set gridApi on scope
            $scope.gridApi = gridApi;
            gridApi.edit.on.afterCellEdit($scope, function (rowEntity) {

                rowEntity.modelsOptions = self.modelsNameDropdown;

            });
        };

        self.fetchAllOrders = function () {
            ordersService.fetchAllOrders()
                    .then(
                            function (response) {
                                $scope.status = response.status;
                                data_source = response.data;
                                user_access = data_source.users;
                                $scope.statusText = response.statusText;
                                console.log("Status Code: " + $scope.status + "  " + $scope.statusText + " " + user_access);
                                console.log(data_source);
                                self.biuldData(data_source.orders);
                                self.checkAccess(response.data.users);
                                console.log(self.orders);                              
                                $scope.myData.data = self.orders;
                            },
                            function (errResponse) {
                                $scope.myData.data = errResponse.data || "Request failed";
                                $scope.status = errResponse.status;
                            }
                    );
        };

        self.fetchAllOrders();
        
        self.checkAccess = function(userAccess){
            console.log(userAccess);
            
        };
        

        
        self.biuldData = function(OrderSourceData){
            
            for (i = 0; i < OrderSourceData.length; i++){
 
                var parameters = {};
                
                for(j = 0; j < OrderSourceData[i].orderParameterses.length; j++){
                  parameters[OrderSourceData[i].orderParameterses[j].paramName] = OrderSourceData[i].orderParameterses[j].paramValue;
                }
                
                parameters.id = OrderSourceData[i].id;
                parameters.orderData = OrderSourceData[i].orderData;
                parameters.customer = OrderSourceData[i].customer;
                parameters.model = OrderSourceData[i].model;
                parameters.type = OrderSourceData[i].type;
                parameters.diameter = OrderSourceData[i].diameter;
                parameters.thread = OrderSourceData[i].thread;
                parameters.color = OrderSourceData[i].color;
                parameters.orderIdentifier = OrderSourceData[i].orderIdentifier;
                parameters.quantity = OrderSourceData[i].quantity;
                parameters.delivery = OrderSourceData[i].delivery;
                parameters.status = OrderSourceData[i].status;
                self.orders.push(parameters);
            }           
            
        };
        
         
         
           
        
    }]).filter('mapCustomersById',[ 'modelService', function( modelService ) {
        
        var self = this;
        var modelsHash = [];
        modelService.fetchAllModelsValue()
                    .then(
                            function (response) {
                                for(i = 0; i < response.data.length; i++){
                                    modelsHash[response.data[i].id] = response.data[i].value;
////                                    self.genderHash.push(response.data[i].id, response.data[i].value);
                                };
//                                console.log(self.modelsHash);
                            },
                            function (errResponse) {
                                console.log( errResponse.data || "Request failed");
                                //$scope.status = errResponse.status;
                            }
                    );
//        
//        self.fetchAllModelsValue();

//    var modelsHash = {
//        1: "PRO-T",
//        2: "PRO-C"
//      };
     
      return function(input) {
        if (!input){
          return '';
        } else {
//          console.log(modelsHash);
          return modelsHash[input];
        }
      };
    }]);


/*
 $http.get('/FactoryDream/rest/orders')
 .then(function(response) {
 $scope.status = response.status;
 $scope.myData.data = response.data;
 $scope.statusText = response.statusText;
 console.log("Status Code: "+$scope.status+"  "+$scope.statusText);
 console.log($scope.myData);
 }, function(response) {
 $scope.myData.data = response.data || "Request failed";
 $scope.status = response.status;
 });  
 */

/*
 angular.module('ordersApp').controller('ordersController', ['$scope', 'ordersService', function ($scope, ordersService) {
 
 var self = this;
 self.order = {id: null, customerName: '', colorName: '', modelName: ''};
 $scope.orders = [];
 
 self.fetchAllOrders = function () {
 ordersService.fetchAllOrders()
 .then(
 function (data) {
 $scope.orders = data;
 },
 function (errResponse) {
 console.error('Error while fetching Currencies');
 }
 );
 };
 
 
 $scope.edit = function(id){
 console.log('id to be edited', id);
 for(var i = 0; i < $scope.orders.length; i++){
 if($scope.orders[i].id === id) {
 self.order = angular.copy($scope.orders[i]);
 ordersService.createOrder(self.order);
 break;
 }
 }
 };
 self.fetchAllOrders();
 }]);
 
 */