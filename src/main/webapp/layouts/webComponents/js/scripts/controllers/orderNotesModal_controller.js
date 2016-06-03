/* 
 *  Document   : orderNotesModal_controller.js
 *  Created on : Mai 30, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').controller('orderNotesModalController', ['$scope', '$uibModalInstance', 'orderId', 'userStatus', 'orderNotesService', function ($scope, $uibModalInstance, orderId, userStatus, orderNotesService) {

        var self = this;
        self.orderId = orderId;
        self.userStatus = userStatus;
        
        $scope.gridOrderNotes = {};
        $scope.addNoteButtonFlag = true;
        $scope.addNoteFormFlag = false;
        $scope.deleteNoteFlag = false;
        $scope.editNoteFlag = false;
        $scope.newNote = {};
        $scope.noteGroups;
        
        switch (self.userStatus) {
                case "full":
                    $scope.addNoteButtonFlag = true;
                    $scope.deleteNoteFlag = true;
                  break;
                case "insert":
                    $scope.addNoteButtonFlag = true;
                    $scope.deleteNoteFlag = false;
                  break;
                default:
                    $scope.addNoteButtonFlag = false;
                    $scope.deleteNoteFlag = false;
                  break;
            };

        self.fetchAllOrderNotesService = function () {

            $scope.gridOrderNotes = orderNotesService.OrderNotes().query({idCod: self.orderId});
        };

        self.fetchAllOrderNotesService();

        $scope.deleteNote = function (row) {
            orderNotesService.OrderNotes().remove({note: row.id}).$promise.then(function () {
                console.info("Note with id = " + row.id + " was deleted");
            });

        };

        $scope.updateNote = function (row) {
                  
            
//             orderNotesService.noteUpdate(self.buildNoteDataToUpdate(row));
            orderNotesService.OrderNotes().update(self.buildNoteDataToUpdate(row));
        };
        
        $scope.showNoteFrom = function () {
            $scope.addNoteButtonFlag = false;
            $scope.editNoteFlag = true;
            $scope.addNoteFormFlag = true;

            console.info("showNoteFrom");
        };

        $scope.addNewNote = function () {
            $scope.addNoteButtonFlag = true;
            $scope.addNoteFormFlag = false;
            $scope.editNoteFlag = false;
            console.info("addNewNote");
        };

        $scope.closeModal = function () {
            $uibModalInstance.close('close');
        };

        self.buildNoteDataToUpdate = function (note) {
            
            var noteToUpdate = {};
            
            console.info(note);
            
            noteToUpdate.noteId = note.id;
            noteToUpdate.noteConntent = note.note;
            
            console.info(noteToUpdate);
            return noteToUpdate;
        };

        self.removeItem = function (index, row) {

            delete row[index];

            console.info(row);

            return row;

        };

    }]);