/* 
 *  Document   : orderNotesModal_controller.js
 *  Created on : Mai 30, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('orderNotesModalController', ['$scope', '$uibModalInstance', 'orderId', 'orderNotesService',  function ($scope, $uibModalInstance, orderId, orderNotesService) {

    var self = this;
    $scope.gridOrderNotes = {};
     
        self.fetchAllOrderNotesService = function () {
            orderNotesService.OrderNotes().query({idCod: orderId}).$promise.then(function (result) {
                $scope.gridOrderNotes = result;
            });
        };

            $scope.auto_grow = function (element) {
                element.style.height = (element.scrollHeight)+"px";
            };

        self.fetchAllOrderNotesService();
        
        $scope.deleteNote = function (row) {
            alert(row.id);
        };
        $scope.addNewNote = function () {
            alert('New Note!!!');
        };

   
  $scope.ok = function () {
    $uibModalInstance.close($scope.selected.item);
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };
  
}]);


