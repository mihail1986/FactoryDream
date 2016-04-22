/* 
 *  Document   : model_service.js
 *  Created on : Apr 22, 2016, 
 *  Author     : Mihail.Cepraga
 */


'use strict';
 
angular.module('ordersApp').factory('modelService', ['$http', '$q', function($http, $q){
 
    return {
         
            fetchAllModels: function() {
                    return $http.get('/FactoryDream/rest/models')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            fetchAllModelsValue: function() {
                    return $http.get('/FactoryDream/rest/valueModels')
                            .then(
                                    function(response){
                                        return response;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            createUser: function(user){
                    return $http.post('http://localhost:8080/Spring4MVCAngularJSExample/user/', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateUser: function(user, id){
                    return $http.put('http://localhost:8080/Spring4MVCAngularJSExample/user/'+id, user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteUser: function(id){
                    return $http.delete('http://localhost:8080/Spring4MVCAngularJSExample/user/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting user');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);