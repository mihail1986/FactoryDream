/* 
 *  Document   : orders_controller.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('ordersController', ['$scope', 'ordersService', 'modelService', 'colorService', 'typeService', 'diameterService', 'customerService', 'threadService', 'statusesService', 'uiGridConstants', function ($scope, ordersService, modelService, colorService, typeService, diameterService, customerService, threadService, statusesService, uiGridConstants) {

        var self = this;
        self.user_access;
        self.orders = [];
        $scope.myData = {};
        $scope.modulesValue = {};
        $scope.colorsValue = {};
        $scope.typesValue = {};
        $scope.diametersValue = {};
        $scope.customersValue = {};
        $scope.threadsValue = {};
        $scope.statusesValue = {};

        self.fetchAllModelsValue = function () {
            modelService.Models().query().$promise.then(function (result) {
                $scope.modulesValue = result;
            });
        };
        self.fetchAllColorsValue = function () {
            colorService.Colors().query().$promise.then(function (result) {
                $scope.colorsValue = result;
            });
        };
        self.fetchAllTypesValue = function () {
            typeService.Types().query().$promise.then(function (result) {
                $scope.typesValue = result;
            });
        };
        self.fetchAllDiametersValue = function () {
            diameterService.Diameters().query().$promise.then(function (result) {
                $scope.diametersValue = result;
            });
        };
        self.fetchAllCustomersValue = function () {
            customerService.Customers().query().$promise.then(function (result) {
                $scope.customersValue = result;
                console.log($scope.customersValue);
            });
        };
        self.fetchAllThreadsValue = function () {
            threadService.Threads().query().$promise.then(function (result) {
                $scope.threadsValue = result;
            });
        };
        self.fetchAllStatuses = function () {
            statusesService.Statuses().query({ cod: 4 }).$promise.then(function (result) {
                $scope.statusesValue = result;
                console.log($scope.statusesValue);
            });
        };
        

        self.fetchAllOrders = function () {
            ordersService.Orders().query().$promise.then(function (result) {
                self.user_access = result[0].userAccess;
                self.biuldData(result[1].orders);
                self.initOrderGridColumn(self.user_access);
            });
        };
        self.initOrderGridColumn = function (userAccess) {
            
            switch (userAccess) {
                case "full":
                    $scope.myData.columnDefs = self.fullAccess;
                    $scope.myData.columnDefs[1].editDropdownOptionsArray = $scope.statusesValue;
                    $scope.myData.columnDefs[1].filter.selectOptions = $scope.statusesValue;
                    $scope.myData.columnDefs[3].editDropdownOptionsArray = $scope.customersValue;
                    $scope.myData.columnDefs[3].filter.selectOptions = $scope.customersValue;
                    $scope.myData.columnDefs[7].editDropdownOptionsArray = $scope.modulesValue;
                    $scope.myData.columnDefs[7].filter.selectOptions = $scope.modulesValue;
                    $scope.myData.columnDefs[10].editDropdownOptionsArray = $scope.diametersValue;
                    $scope.myData.columnDefs[10].filter.selectOptions = $scope.diametersValue;
                    $scope.myData.columnDefs[11].editDropdownOptionsArray = $scope.typesValue;
                    $scope.myData.columnDefs[11].filter.selectOptions = $scope.typesValue;
                    $scope.myData.columnDefs[12].editDropdownOptionsArray = $scope.threadsValue;
                    $scope.myData.columnDefs[12].filter.selectOptions = $scope.threadsValue;
                    $scope.myData.columnDefs[13].editDropdownOptionsArray = $scope.colorsValue;
                    $scope.myData.columnDefs[13].filter.selectOptions = $scope.colorsValue;
                    $scope.myData.enableGridMenu = true;
                    $scope.myData.enableCellEditOnFocus = true;
                    $scope.myData.enableFiltering = true;
                    $scope.myData.exporterMenuPdf = false;
                    $scope.myData.exporterCsvFilename = 'myFile.csv';

                    break;
                case "update":
                    $scope.myData.columnDefs = self.fullAccess;
                    $scope.myData.columnDefs[3].editDropdownOptionsArray = $scope.customersValue;
                    
                    $scope.myData.columnDefs[7].editDropdownOptionsArray = $scope.modulesValue;
                    $scope.myData.columnDefs[10].editDropdownOptionsArray = $scope.diametersValue;
                    $scope.myData.columnDefs[11].editDropdownOptionsArray = $scope.typesValue;
                    $scope.myData.columnDefs[12].editDropdownOptionsArray = $scope.threadsValue;
                    $scope.myData.columnDefs[13].editDropdownOptionsArray = $scope.colorsValue;
                    $scope.myData.enableGridMenu = true;
                    $scope.myData.enableCellEditOnFocus = true;
                    $scope.myData.enableFiltering = true;
                    $scope.myData.exporterMenuPdf = false;
                    $scope.myData.exporterCsvFilename = 'myFile.csv';

                    break;
                case "insert":
                    $scope.myData.columnDefs = self.fullAccess;
                    $scope.myData.columnDefs[3].editDropdownOptionsArray = $scope.customersValue;
                    
                    $scope.myData.columnDefs[7].editDropdownOptionsArray = $scope.modulesValue;
                    $scope.myData.columnDefs[10].editDropdownOptionsArray = $scope.diametersValue;
                    $scope.myData.columnDefs[11].editDropdownOptionsArray = $scope.typesValue;
                    $scope.myData.columnDefs[12].editDropdownOptionsArray = $scope.threadsValue;
                    $scope.myData.columnDefs[13].editDropdownOptionsArray = $scope.colorsValue;
                    $scope.myData.enableGridMenu = true;
                    $scope.myData.enableCellEditOnFocus = true;
                    $scope.myData.enableFiltering = true;
                    $scope.myData.exporterMenuPdf = false;
                    $scope.myData.exporterCsvFilename = 'myFile.csv';

                    break;
                default:
                    $scope.myData.columnDefs = self.readOnlyAccess;
                    $scope.myData.enableCellEdit = false;
                    $scope.myData.enableFiltering = true;
                    $scope.myData.enableSelectAll = true;
                    $scope.myData.enableGridMenu = true;
                    $scope.myData.exporterMenuPdf = false;
                    break;

            }
//            if (userAccess === 'full') {
//                $scope.myData.columnDefs = self.fullAccess;
//                $scope.myData.columnDefs[3].editDropdownOptionsArray = $scope.customersValue;
//                $scope.myData.columnDefs[7].editDropdownOptionsArray = $scope.modulesValue;
//                $scope.myData.columnDefs[10].editDropdownOptionsArray = $scope.diametersValue;
//                $scope.myData.columnDefs[11].editDropdownOptionsArray = $scope.typesValue;
//                $scope.myData.columnDefs[12].editDropdownOptionsArray = $scope.threadsValue;
//                $scope.myData.columnDefs[13].editDropdownOptionsArray = $scope.colorsValue;        
//                $scope.myData.enableGridMenu = true;
//                $scope.myData.enableCellEditOnFocus = true;
//                $scope.myData.enableFiltering = true;
//                $scope.myData.exporterMenuPdf = false;
//                $scope.myData.exporterCsvFilename = 'myFile.csv';
//        $scope.myData = {
////        enableFiltering: true,
////        showGridFooter: true,
////        enableGridMenu: true,
////        enableSorting: true,
////        enableSelectAll: true,
////        exporterMenuPdf: false,
////        rowTemplate: rowTemplate(),
////        enableColumnResizing: true,
////        enableCellEditOnFocus: true,
////        modifierKeysToMultiSelectCells: true,
////        paginationPageSizes: [100,200,500,1000],
////        paginationPageSize: 100, 
//            columnDefs: self.fullAccess
////               [
////                {name: 'orderData', displayName: 'Data', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 90},
////                {name: 'customer', displayName: 'Client', enableColumnMenu: false, width: 150},
////                {name: 'Client Order id', displayName: 'Ordin Client', enableColumnMenu: false, /* visible: false, */ width: 150},
////                {name: 'Symbol', displayName: 'Symbol', enableColumnMenu: false, /* visible: false, */ width: 100},
////                {name: 'orderIdentifier', displayName: 'Ordin Id', enableColumnMenu: false, width: 80},
////                {name: 'model', displayName: 'Model', enableColumnMenu: false, width: 80
//////                    ,editableCellTemplate: 'ui-grid/dropdownEditor'
//////                    ,cellFilter: 'mapCustomersById'
//////                    ,editDropdownValueLabel: 'value'
//////                    ,editDropdownRowEntityOptionsArrayPath: 'modelsOptions'
////                },
////                {name: 'T', displayName: 'T', enableColumnMenu: false, width: 80},
////                {name: 'LB/FT', displayName: 'Lb/Ft', enableColumnMenu: false, width: 80},
////                {name: 'diameter', displayName: 'Diametru', enableColumnMenu: false, width: 80},
////                {name: 'type', displayName: 'Tipul', enableColumnMenu: false, width: 90},
////                {name: 'thread', displayName: 'Filet', enableColumnMenu: false, width: 150},
////                {name: 'color', displayName: 'Culoare', enableColumnMenu: false, width: 80},
////                {name: 'Vent Hole', displayName: 'Vent.mm', enableColumnMenu: false, width: 80},
////                {name: 'OD', displayName: 'OD.mm', enableColumnMenu: false, width: 80},
////                {name: 'Drift', displayName: 'Drift_mm', enableColumnMenu: false, width: 80},
////                {name: 'delivery', displayName: 'Consegna', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 90},
////                {name: 'quantity', displayName: 'Q-ty', enableColumnMenu: false, width: 80}
////            ]
////    exporterCsvFilename: 'myFile.csv'
//
//        };
//            } else if (userAccess === 'read') {
//                $scope.myData.columnDefs = self.readOnlyAccess;
//                $scope.myData.enableCellEdit = false;
//                $scope.myData.enableFiltering = true;
//                $scope.myData.enableSelectAll = true;
//                $scope.myData.enableGridMenu = true;
//                $scope.myData.exporterMenuPdf = false;
//                $scope.myData.exporterCsvFilename = 'myFile.csv';
//            }
        };

        $scope.showNotes = function (row) {
            alert(row.entity.orderNotes);
        };
        $scope.addNewOrder = function () {
            alert('New Order!!!');
        };

        $scope.statusNameClass = function (row) {
            if (row.entity.status === 'None') {
                return "text-muted text-center";
            } else {
                return "text-primary"; // Or even "", which won't add any additional classes to the element
            }
        };

        $scope.statusButtonClass = function (row) {
            if (row.entity.status === 1) {
                return "btn btn-default btn-xs";
            } else {
                return "btn btn-danger btn-xs"; // Or even "", which won't add any additional classes to the element
            }
        };

        self.fullAccess = [
            {name: 'orderNotes', displayName: 'Notes', pinnedLeft: true, enableCellEdit: false, enableColumnMenu: false, enableFiltering: false, cellTemplate: '<div class="ui-grid-cell-contents"><button class="btn btn-primary btn-xs" ng-click="grid.appScope.showNotes(row)"><span class="badge btn-xs">{{COL_FIELD}}</span> Notes</button></div>', width: 80},
            {name: 'status', displayName: 'Status', pinnedLeft: true, enableCellEdit: true, enableColumnMenu: false, width: 80
                ,filter:{type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.statusesValue:'Inactiv'"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'orderData', displayName: 'Data', type: 'date', pinnedLeft: true, cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 100},
            {name: 'customer', displayName: 'Client', enableColumnMenu: false, enablePinning: false, width: 150
                ,filter:{type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.customersValue:row.entity.customer"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'Client Order id', displayName: 'Ordin Client', enableColumnMenu: false, visible: false, width: 150},
            {name: 'Symbol', displayName: 'Symbol', enableColumnMenu: false, visible: false, width: 100},
            {name: 'orderIdentifier', displayName: 'Ordin Id', enableColumnMenu: false, width: 80},
            {name: 'model', displayName: 'Model', enableColumnMenu: false, width: 80
                ,filter:{type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.modulesValue:row.entity.model"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'T', displayName: 'T', enableColumnMenu: false, width: 80},
            {name: 'LB/FT', displayName: 'Lb/Ft', enableColumnMenu: false, width: 80},
            {name: 'diameter', displayName: 'Diametru', enableColumnMenu: false, width: 80
                ,filter:{type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.diametersValue:row.entity.diameter"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'type', displayName: 'Tipul', enableColumnMenu: false, width: 90
                ,filter:{type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.typesValue:row.entity.type"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'thread', displayName: 'Filet', enableColumnMenu: false, width: 150
                ,filter:{type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.threadsValue:row.entity.thread"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'color', displayName: 'Culoare', enableColumnMenu: false, width: 80
                ,filter:{type: uiGridConstants.filter.SELECT}
                , editType: 'dropdown'
                , editableCellTemplate: 'ui-grid/dropdownEditor'
                , cellFilter: "griddropdown:grid.appScope.colorsValue:row.entity.color"
                , editDropdownIdLabel: 'value'
                , editDropdownValueLabel: 'label'
            },
            {name: 'Vent Hole', displayName: 'Vent.mm', enableColumnMenu: false, width: 80},
            {name: 'OD', displayName: 'OD.mm', enableColumnMenu: false, width: 80},
            {name: 'Drift', displayName: 'Drift_mm', enableColumnMenu: false, width: 80},
            {name: 'delivery', displayName: 'Consegna', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 100},
            {name: 'quantity', displayName: 'Q-ty', enableColumnMenu: false, width: 80}
        ];

        self.readOnlyAccess = [
            {name: 'orderNotes', displayName: 'Notes', pinnedLeft: true, enableColumnMenu: false, enableFiltering: false, cellTemplate: '<div class="ui-grid-cell-contents"><button class="btn btn-primary btn-xs" ng-click="grid.appScope.showNotes(row)"><span class="badge btn-xs">{{COL_FIELD}}</span> Notes</button></div>', width: 80},
            {name: 'status', displayName: 'Status', pinnedLeft: true, enableColumnMenu: false, cellTemplate: '<div class="ui-grid-cell-contents" ng-class="grid.appScope.statusNameClass(row)" >{{COL_FIELD}}</div>', width: 80},
            {name: 'orderData', displayName: 'Data', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 90},
            {name: 'customer', displayName: 'Client', enableColumnMenu: false, width: 150},
            {name: 'Client Order id', displayName: 'Ordin Client', enableColumnMenu: false, visible: false, width: 150},
            {name: 'Symbol', displayName: 'Symbol', enableColumnMenu: false, visible: false, width: 100},
            {name: 'orderIdentifier', displayName: 'Ordin Id', enableColumnMenu: false, width: 80},
            {name: 'model', displayName: 'Model', enableColumnMenu: false, width: 80},
            {name: 'T', displayName: 'T', enableColumnMenu: false, width: 80},
            {name: 'LB/FT', displayName: 'Lb/Ft', enableColumnMenu: false, width: 90},
            {name: 'diameter', displayName: 'Diametru', enableColumnMenu: false, width: 80},
            {name: 'type', displayName: 'Tipul', enableColumnMenu: false, width: 90},
            {name: 'thread', displayName: 'Filet', enableColumnMenu: false, width: 150},
            {name: 'color', displayName: 'Culoare', enableColumnMenu: false, width: 80},
            {name: 'Vent Hole', displayName: 'Vent.mm', enableColumnMenu: false, width: 80},
            {name: 'OD', displayName: 'OD.mm', enableColumnMenu: false, width: 80},
            {name: 'Drift', displayName: 'Drift_mm', enableColumnMenu: false, width: 80},
            {name: 'delivery', displayName: 'Consegna', type: 'date', cellFilter: 'date:"dd.MM.yyyy"', enableColumnMenu: false, width: 90},
            {name: 'quantity', displayName: 'Q-ty', enableColumnMenu: false, width: 80}
        ];
        $scope.saveRow = function (rowEntity) {
            // create a fake promise - normally you'd use the promise returned by $http or $resource
            var promise = ordersService.Orders().update(self.packingData(rowEntity)).$promise;
            $scope.gridApi.rowEdit.setSavePromise(rowEntity, promise);
        };
        $scope.myData.onRegisterApi = function (gridApi) {
            //set gridApi on scope
            $scope.gridApi = gridApi;
            gridApi.rowEdit.on.saveRow($scope, $scope.saveRow);
        };
        self.initOrdersGrid = function () {
            self.fetchAllModelsValue();
            self.fetchAllColorsValue();
            self.fetchAllTypesValue();
            self.fetchAllDiametersValue();
            self.fetchAllCustomersValue();
            self.fetchAllThreadsValue();
            self.fetchAllStatuses();
            self.fetchAllOrders();
            $scope.myData.data = self.orders;
        };
        self.checkAccess = function (userAccess) {
            console.log(userAccess);
        };
        self.initOrdersGrid();
//        self.fetchAllOrders = function () {
//            ordersService.fetchAllOrders()
//                    .then(
//                            function (response) {
//                                $scope.status = response.status;
//                                data_source = response.data;
//                                user_access = data_source.users;
//                                $scope.statusText = response.statusText;
//                                console.log("Status Code: " + $scope.status + "  " + $scope.statusText + " " + user_access);
//                                console.log(data_source);
//                                self.biuldData(data_source.orders);
//                                self.checkAccess(response.data.users);
//                                $scope.myData.data = self.orders;
//                            },
//                            function (errResponse) {
//                                $scope.myData.data = errResponse.data || "Request failed";
//                                $scope.status = errResponse.status;
//                            }
//                    );
//        };

        self.biuldData = function (OrderSourceData) {

            for (i = 0; i < OrderSourceData.length; i++) {

                var parameters = {};
                for (j = 0; j < OrderSourceData[i].orderParameterses.length; j++) {
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
                parameters.orderNotes = OrderSourceData[i].orderNotes;
                self.orders.push(parameters);
            }

        };
        self.packingData = function (row) {
            var orderKeys = Object.keys(row);
            var order = {};
            order.orderParameterses = new Array();
            for (var i = 0; i < orderKeys.length; i++) {

                switch (orderKeys[i])
                {
                    case '$$hashKey':
                        break;
                    case 'id':
                        order["id"] = row[orderKeys[i]];
                        break;
                    case 'customer':
                        order["customer"] = row[orderKeys[i]];
                        break;
                    case 'color':
                        order["color"] = row[orderKeys[i]];
                        break;
                    case 'diameter':
                        order["diameter"] = row[orderKeys[i]];
                        break;
                    case 'delivery':
                        order["delivery"] = row[orderKeys[i]];
                        break;
                    case 'model':
                        order["model"] = row[orderKeys[i]];
                        break;
                    case 'orderData':
                        order["orderData"] = row[orderKeys[i]];
                        break;
                    case 'orderIdentifier':
                        order["orderIdentifier"] = row[orderKeys[i]];
                        break;
                    case 'model':
                        order["model"] = row[orderKeys[i]];
                        break;
                    case 'status':
                        order["status"] = row[orderKeys[i]];
                        break;
                    case 'thread':
                        order["thread"] = row[orderKeys[i]];
                        break;
                    case 'type':
                        order["type"] = parseInt(row[orderKeys[i]]);
                        break;
                    case 'quantity':
                        order["quantity"] = row[orderKeys[i]];
                        break;
                    case 'orderNotes':
                        order["orderNotes"] = row[orderKeys[i]];
                        break;
                    default:
                        order.orderParameterses.push({"paramName": orderKeys[i], "paramValue": row[orderKeys[i]]});
                }
            }
            ;
            console.log(row);
            console.log(order);
            return order;
        };
    }]).filter('griddropdown', function () {

    return function (input, map, initial) {
        if (typeof map !== "undefined") {
            for (var i = 0; i < map.length; i++) {
                if (map[i]['value'] === input) {
                    return map[i]['label'];
                }
            }
        } else if (initial) {
            return initial;
        }
        return input;
    };
}).filter('statusdropdown', function () {

    return function (input, map, initial) {
        if (typeof map !== "undefined") {
            for (var i = 0; i < map.length; i++) {
                if (map[i]['value'] === input) {
                    return map[i]['label'];
                }
            }
        } else if (initial === 1) {
            return "None";
        }
        return input;
    };
}).directive('myCustomDropdown', function() {
  return {
    template: '<select class="form-control input-sm"  style="padding-right: 0px; padding-left: 0px;" ng-model="colFilter.term" ng-options="option.id as option.value for option in colFilter.options"></select>'
  };
});