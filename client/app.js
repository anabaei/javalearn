var app = angular.module("dmApp", []);

app.controller('MainController', ['$scope', function($scope) {
    
    const reasonTemplate = {
        id: "",
        alignment: "",
        reasonText: "",
        strength: 0,
        evidences: []
    };

    $scope.mapState = {
        assignment: "Assignment 1",
        topic: "Are Dialectical maps an effective teaching tool?",
        ownerID: "jtoering",
        reasons: []
    };

    $scope.prebuild = function() {
        console.log("ng-init ran");
    };

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