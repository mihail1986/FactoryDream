/* 
 *  Document   : orders_service.js
 *  Created on : Apr 15, 2016, 
 *  Author     : Mihail.Cepraga
 */

angular.module('ordersApp').factory('ordersService', ['$http', '$q', function ($http, $q) {

        return {
            fetchAllOrders: function () {
                return $http.get('rest/orders')
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
                return $http.post('save/orders/', order)
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
