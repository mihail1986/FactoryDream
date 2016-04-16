/* 
 *  Document   : orders_controller.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

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

