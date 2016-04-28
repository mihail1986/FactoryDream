/* 
 *  Document   : orders_service.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

'use strict';

angular.module('ordersApp').factory('ordersService', ['$http', '$q', '$resource', function ($http, $q, $resource) {

        return {
            fetchAllOrders: function () {
                return $http.get('/FactoryDream/rest/orders')
                        .then(
                                function (response) {
                                    return response;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching ordersService Service');
                                    return $q.reject(errResponse);
                                }
                        );
            },            
            createOrder: function (order) {
                return $http.post('/FactoryDream/save/orders', order)
                        .then(
                                function (response) {
                                    console.log("save/orders/");
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while creating user');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            updateOrder: function (row) {
                var orderKeys = Object.keys(row);
                var order = {};
                order.orderParameterses = new Array();
                order.orderNotes = new Array();

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
                        default: order.orderParameterses.push({"paramName":orderKeys[i],"paramValue":row[orderKeys[i]]}); //orderParameterses[orderKeys[i]] = row[orderKeys[i]]; 
                    }
                };
                
                console.log(angular.toJson(order));
                
                return $http.post('/FactoryDream/save/orders', angular.toJson(order));
            }

        };
    }]);

/*
 angular.module('ordersApp').factory('ordersService', ['$http', '$q', function ($http, $q) {
 
 return {
 fetchAllOrders: function () {
 return $http.get('/rest/orders')
 .then(
 function (response) {
 return response.data;
 },
 function (errResponse) {
 console.error('Error while fetching users');
 return $q.reject(errResponse);
 }
 );
 },
 createOrder: function (order) {
 return $http.post('/save/orders', order)
 .then(
 function (response) {
 console.log("save/orders/");
 return response.data;
 },
 function (errResponse) {
 console.error('Error while creating user');
 return $q.reject(errResponse);
 }
 );
 },
 updateOrder: function (order, id) {
 return $http.put('save/orders/' + id, order)
 .then(
 function (response) {
 return response.data;
 },
 function (errResponse) {
 console.error('Error while updating user');
 return $q.reject(errResponse);
 }
 );
 },
 deleteOrder: function (id) {
 return $http.delete('delete/orders/' + id)
 .then(
 function (response) {
 return response.data;
 },
 function (errResponse) {
 console.error('Error while deleting user');
 return $q.reject(errResponse);
 }
 );
 }
 
 };
 
 }]);
 */