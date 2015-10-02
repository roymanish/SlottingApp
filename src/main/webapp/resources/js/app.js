'use strict';

/* App Module */

angular.module('home', []);
var slottingApp = angular.module('SlottingApp', ['ngRoute', 'ngCookies', 'home']);

slottingApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/home', {
                    templateUrl: 'resources/modules/home/home.html',
                    controller: 'SlotController'
                }).
                otherwise({
                    redirectTo: '/home'
                });
    }]);

slottingApp.factory("ConfigFactory",function($rootScope){

  return{
    getSlots: function(){
      var ref = JSON.parse('{"totalRemaining": 120,"slots":[{"id": "1","itemCount": 80,"slotDate": "12/02/1987","slotTime": "09:00am-11:00am","booked":true},{"id": "2","itemCount": 80,"slotDate": "12/02/1987","slotTime": "11:00am-01:00pm","booked":true},{"id": "3","itemCount": 40,"slotDate": "12/02/1987","slotTime": "02:00pm-04:00pm","booked":false},{"id": "4","itemCount": 0,"slotDate": "12/02/1987","slotTime": "04:00pm-06:00pm","booked":false}]}');
      return ref;
    },
  }
  
});