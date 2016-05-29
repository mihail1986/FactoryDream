/* 
 *  Document   : orderNotes_service.js
 *  Created on : Mai 26, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('orderNotesService', ['$resource', function ($resource) {

        return {
            OrderNotes: function () {
                return $resource("/FactoryDream/rest/orderNotes", {}, {
                    query: {method: "GET", isArray: true, url: "/FactoryDream/rest/orderNotes?orderId=:idCod"},
                    create: {method: "POST", url: "/FactoryDream/rest/orderNotes"},
                    get: {method: "GET", url: "/FactoryDream/rest/orderNotes"},
                    remove: {method: "DELETE", url: "/FactoryDream/rest/orderNotes"},
                    update: {method: "POST", url: "/FactoryDream/rest/orderNotes"}
                });
            }
        };
    }]);