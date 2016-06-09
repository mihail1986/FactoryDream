/* 
 *  Document   : orderNotesModal_controller.js
 *  Created on : Iun 03, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('addNewOrderModalController', ['$scope', '$uibModalInstance', 'orderModules', 'orderColors', 'orderTypes', 'orderDiameters', 'orderCustomers', 'orderThreads', 'orderParametersNamesService', function ($scope, $uibModalInstance, orderModules, orderColors, orderTypes, orderDiameters, orderCustomers, orderThreads, orderParametersNamesService) {

        var self = this;
        
        self.params = orderParametersNamesService.OrderParametersNames().get();
        
        $scope.newOrderCustomer = orderCustomers;
        $scope.neworderModules = orderModules;
        $scope.neworderColors = orderColors;
        $scope.neworderTypes = orderTypes;
        $scope.neworderDiameters = orderDiameters;
        $scope.neworderThreads = orderThreads;
        $scope.orderParameters = orderParametersNamesService.OrderParametersNames().get();
        $scope.newOrderParameter;
        $scope.newOrderParameters = [];
        $scope.newOrder = {};
        $scope.newOrder.orderParameters = [];

        self.fetchAllOrderParametersValues = function(){
            $scope.orderParameters = angular.copy(self.params);
        };

        $scope.addParameter = function (paramId, paramLabel, indexparam) {
            $scope.newOrderParameters.push({id: paramId, label: paramLabel, value: $scope.newOrderParameter.value});
            $scope.newOrder.orderParameters.push({"paramName": paramLabel, "paramValue": $scope.newOrderParameter.value});
            $scope.orderParameters.splice(indexparam, 1);
            $scope.newOrderParameter.value = '';
        };

        $scope.addNewOrderFormSubmit = function (isValid) {

            self.packingDataForSending($scope.newOrder);

            // check to make sure the form is completely valid
            if (isValid) {
                alert('our form is amazing');
            }

        };

        $scope.resetAddNewOrderForm = function () {
            
            self.fetchAllOrderParametersValues();
            $scope.newOrder = {};
            $scope.newOrderParameters = [];
            $scope.orderParameters = angular.copy(self.params);
            $scope.newOrder.orderParameters = [];
        };

        $scope.openDataPicker = function () {
            $scope.orderDataPopup.opened = true;
        };

        $scope.orderDataPopup = function () {
            opened: false;
        };

        $scope.closeModal = function () {
            $uibModalInstance.close('close');
        };

        self.packingDataForSending = function (order) {
            var orderKeys = Object.keys(order);
            var newOrderToAdd = {};
            newOrderToAdd.orderParameterses = new Array();
            for (var i = 0; i < orderKeys.length; i++) {

                switch (orderKeys[i])
                {
                    case '$$hashKey':
                        break;
                    case 'id':
                        newOrderToAdd["id"] = order[orderKeys[i]];
                        break;
                    case 'customer':
                        newOrderToAdd["customer"] = order[orderKeys[i]];
                        break;
                    case 'color':
                        newOrderToAdd["color"] = order[orderKeys[i]];
                        break;
                    case 'diameter':
                        newOrderToAdd["diameter"] = order[orderKeys[i]];
                        break;
                    case 'delivery':
                        newOrderToAdd["delivery"] = order[orderKeys[i]];
                        break;
                    case 'model':
                        newOrderToAdd["model"] = order[orderKeys[i]];
                        break;
                    case 'orderData':
                        newOrderToAdd["orderData"] = order[orderKeys[i]];
                        break;
                    case 'orderIdentifier':
                        newOrderToAdd["orderIdentifier"] = order[orderKeys[i]];
                        break;
                    case 'model':
                        newOrderToAdd["model"] = order[orderKeys[i]];
                        break;
                    case 'status':
                        newOrderToAdd["status"] = order[orderKeys[i]];
                        break;
                    case 'thread':
                        newOrderToAdd["thread"] = order[orderKeys[i]];
                        break;
                    case 'type':
                        newOrderToAdd["type"] = parseInt(order[orderKeys[i]]);
                        break;
                    case 'quantity':
                        newOrderToAdd["quantity"] = order[orderKeys[i]];
                        break;
                    case 'orderNotes':
                        newOrderToAdd["orderNotes"] = order[orderKeys[i]];
                        break;
                    default:
                        newOrderToAdd.orderParameterses.push({"paramName": orderKeys[i], "paramValue": order[orderKeys[i]]});
                }
            }
            ;
            console.log(order);
            return newOrderToAdd;
        };

    }]);