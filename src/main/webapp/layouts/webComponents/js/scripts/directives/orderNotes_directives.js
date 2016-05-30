/* 
 *  Document   : orderNotes_directives.js
 *  Created on : Mai 30, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').directive("orderNotes", function() {
    return {
        templateUrl: function(elem, attr){
        return 'js/scripts/templates/orderNotes-'+attr.type+'.html';
        }
    };
});