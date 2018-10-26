var app = angular.module("dmApp", []);

app.controller('MainController', ['$scope', function($scope) {

    $scope.redo = function() {
        console.log("Redo function");
    };

    $scope.submit = function() {
        console.log("submit function");
    }

    $scope.undo = function() {
        console.log("undo function");
    }

    $scope.download = function() {
        console.log("download function");
    }
    
}]);