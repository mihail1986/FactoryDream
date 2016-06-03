/* 
 *  Document   : orderNotesModal_controller.js
 *  Created on : Iun 03, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('addNewOrderModalController', ['$scope', '$uibModalInstance', 'orderModules', 'orderColors', 'orderTypes', 'orderDiameters', 'orderCustomers', 'orderThreads', 'orderParameters', function ($scope, $uibModalInstance, orderId, userStatus, orderModules, orderColors, orderTypes, orderDiameters, orderCustomers, orderThreads, orderParameters) {

        var self = this;
//        self.orderId = orderId;
//        self.userStatus = userStatus;
        $scope.newOrderCustomer = orderCustomers;
        
        console.info(angular.toJson(orderModules)); 
        console.info(angular.toJson(orderColors));
        console.info(angular.toJson(orderTypes));
        console.info(angular.toJson(orderDiameters));
        console.info(angular.toJson(orderCustomers));
        console.info(angular.toJson(orderThreads));
        console.info(angular.toJson(orderParameters));


        $scope.closeModal = function () {
            $uibModalInstance.close('close');
        };

    }]);