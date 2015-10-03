'use strict';

angular.module('home')

        .controller('SlotController',
                ['$scope', '$rootScope', '$location', 'SlotService', 'ConfigFactory',
                    function($scope, $rootScope, $location, SlotService, ConfigFactory) {

                        $scope.slotsSelected = new Array();

                        $scope.bookSlot = function() {
                            $scope.dataLoading = true;
                            $scope.createSolts();
                            var slots = JSON.stringify($scope.slotsSelected);
                            SlotService.bookSlot(slots, function(response) {
                                if (response) {
                                    $scope.dataLoading = true;
                                    $scope.success = 'Slots Booked Successfully!'
                                    $scope.dataLoading = false;
                                } else {
                                    $scope.error = 'Failed to book slots!';
                                    $scope.dataLoading = false;
                                }
                                $scope.slotsSelected.length = 0;
                                $scope.enableBookBtn = false;
                            });
                        };
                        $scope.createSolts = function(){
                          
                            for(var i=0;i<$scope.slots.length;i++){
                                var slot = $scope.slots[i];
                                if(slot.checked){
                                    
                                    var itemCount = slot.itemCount + slot.valueAdjusted;
                                    var slotFinal = {
                                        id : slot.id,
                                        slotTime : slot.slotTime,
                                        slotDate : slot.slotDate,
                                        itemCount : itemCount,
                                        orderName : $scope.orderName
                                    };
                                    $scope.slotsSelected.push(slotFinal);
                                }
                            }
                        };

                        $scope.loadSlots = function() {

                            $scope.itemRemaining = $scope.itemCount;
                            SlotService.getAllSlotsForDate($scope.slotDate, function(response) {
                                if (response) {
                                    $scope.slots = response;
                                    //$scope.itemsRemaining = slotData.totalRemaining;
                                } else {
                                    $scope.error = "Failed to load slots!";
                                    $scope.dataLoading = false;
                                }
                            });
                        };
                        
                        $scope.getAllOrderNames = function(){
                            
                            SlotService.getAllOrderNames(function(response) {
                                if (response) {
                                    $scope.orders = response;
                                    //$scope.itemsRemaining = slotData.totalRemaining;
                                } else {                                    
                                    $scope.error = response.message;
                                }
                            });
                        };
                        
                        $scope.getAllSlotsForOrderName = function(){
                            
                            SlotService.getAllSlotsForOrderName($scope.ordrNm, function(response) {
                                if (response) {
                                    $scope.slotsForOrder = response;
                                    //$scope.itemsRemaining = slotData.totalRemaining;
                                } else {                                    
                                    $scope.error = response.message;
                                }
                            });
                        };

                        $scope.calRemainingItem = function(inputSlot) {

                            if (inputSlot.checked) {
                                $scope.itemRemaining = $scope.itemRemaining + inputSlot.valueAdjusted;
                                inputSlot.checked = false;
                            }
                            else {
                                inputSlot.valueAdjusted = Math.min($scope.itemRemaining, 80, 80 - inputSlot.itemCount);
                                $scope.itemRemaining = $scope.itemRemaining - inputSlot.valueAdjusted;
                                inputSlot.checked = true;
                            }
                            if ($scope.itemRemaining == 0)
                                $scope.enableBookBtn = true;

                        };
                    }]);
                    