/* 
 *  Document   : orderNotesModal_controller.js
 *  Created on : Iun 03, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('addNewOrderModalController', ['$scope', '$uibModalInstance', 'orderModules', 'orderColors', 'orderTypes', 'orderDiameters', 'orderCustomers', 'orderThreads', function ($scope, $uibModalInstance, orderModules, orderColors, orderTypes, orderDiameters, orderCustomers, orderThreads) {

        var self = this;
        $scope.newOrderCustomer = orderCustomers;
        $scope.neworderModules = orderModules;
        $scope.neworderColors = orderColors;
        $scope.neworderTypes = orderTypes;
        $scope.neworderDiameters = orderDiameters;
        $scope.neworderThreads = orderThreads;
        

        $scope.closeModal = function () {
            $uibModalInstance.close('close');
        };

    }]);