var app = angular.module("dmApp", []);

app.controller('MainController', ['$scope', '$http', function($scope,$http) {

    $scope.mapState = {};

    $scope.possibleStrengthValues = [1,2,3,4,5];

    $scope.initialize = function() {

        //get the sample data via http get
        $http.get('prototypeMap.json')
        .then(function buildInitialState(response) {
            $scope.mapState = response.data;
            console.log("Sample data loaded");
        }, function notifyInitialStateFailure(response) {
            console.log(response);
        });
    };

    $scope.blueFilter = function(item) {
        return item.isBlue;
    };

    $scope.yellowFilter = function(item) {
        return !item.isBlue;
    };

    $scope.blueToggle = true;
    $scope.yellowToggle = false;

    $scope.blueSupports = true;
    $scope.yellowSupports = true;

    $scope.logMapState = function() {
        console.log($scope.mapState);
    };

    $scope.redo = function() {
        console.log("Redo function");
    };

    $scope.submit = function() {
        console.log("submit function");
    };

    $scope.undo = function() {
        console.log("undo function");
    };

    $scope.download = function() {
        console.log("download function");
    };

    $scope.linkArguments = function() {
        console.log("link function for arguments");
    };

    $scope.toggleSupportBlue = function() {
        $scope.blueSupports = !$scope.blueSupports;
    };

    $scope.toggleSupportYellow = function() {
        $scope.yellowSupports = !$scope.yellowSupports;
    }
    
}]);