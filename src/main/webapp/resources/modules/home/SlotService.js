'use strict';

angular.module('home')

        .factory('SlotService',
                ['$http', '$cookieStore', '$rootScope', '$timeout',
                    function($http, $cookieStore, $rootScope, $timeout) {
                        var service = {};

                        service.bookSlot = function(slot, callback) {

                            $http.post('http://localhost:8080/slotting/bookslot', slot)
                                    .success(function(response) {
                                        callback(response);
                                    });
                        };
                        
                        service.getAllSlotsForDate = function(slotDate,callback) {
                            
                            $http.post('http://localhost:8080/slotting/getAllSlotsForDate', slotDate)
                                    .success(function(response) {
                                        callback(response);
                                    }).error(function(response){
                                        callback(response);
                                    });
                        };
                        
                        service.getAllOrderNames = function(callback) {
                            
                            $http.get('http://localhost:8080/slotting/getAllOrderNames')
                                    .success(function(response) {
                                        callback(response);
                                    }).error(function(response){
                                        callback(response);
                                    });
                        };
                        
                        service.getAllSlotsForOrderName = function(orderName,callback) {
                            
                            $http.post('http://localhost:8080/slotting/getAllSlotsForOrderName',orderName)
                                    .success(function(response) {
                                        callback(response);
                                    }).error(function(response){
                                        callback(response);
                                    });
                        };
                        return service;
                    }]);