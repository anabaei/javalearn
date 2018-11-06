var app = angular.module("dmApp", []);

app.controller('MainController', ['$scope', '$http', function($scope,$http) {

    $scope.mapState = {};

    $scope.possibleStrengthValues = [1,2,3,4,5];

    //Adds only a visibility field for evidences
    function prepInitialVisibility(storedMap) {
        $scope.mapState = storedMap;
        _.forEach($scope.mapState.reasons, function(value) {
            value.expanded = true;
        });
        console.log("Sample data prepared for display.");
    };

    $scope.initialize = function() {

        //get the sample data via http get
        $http.get('prototypeMap.json')
        .then(function buildInitialState(response) {
            prepInitialVisibility(response.data);      
        }, function notifyInitialStateFailure(response) {
            console.log(response);
        });
    };

    $scope.blueFilter = function(item) {
        return item.isBlue === true;
    };

    $scope.yellowFilter = function(item) {
        return item.isBlue === false;
    };

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

    $scope.toggleSupport = function(evidence) {
        evidence.supports = !evidence.supports;
    };

    $scope.toggleEvidenceVisibility = function(reason) {
        reason.expanded = !reason.expanded;
    };
    
}]);