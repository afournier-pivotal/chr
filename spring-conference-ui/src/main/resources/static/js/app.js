var app = angular.module('springConf', ["ngRoute"]);
app.config(function myAppConfig($routeProvider) {

    $routeProvider.when('/', {
        templateUrl: 'partials/schedule.html',
        controller: 'ScheduleCtrl',
    }).when('/faqs', {
        templateUrl: 'partials/faqs.html',
        controller: 'FaqsCtrl'
    }).when('/speakers', {
        templateUrl: 'partials/speakers.html',
        controller: 'SpeakersCtrl'
    }).when('/location', {
        templateUrl: 'partials/location.html',
        controller: 'LocationCtrl'
    }).otherwise('/');

}).controller('navigation',
    function ($route) {

        var self = this;

        self.tab = function (route) {
            return $route.current && route === $route.current.controller;
        };

    }).controller('ScheduleCtrl', function ($route) {


}).controller('FaqsCtrl', function ($route) {
}).controller('SpeakersCtrl', function ($route) {
}).controller('LocationCtrl', function ($route) {
});