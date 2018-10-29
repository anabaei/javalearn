var app = angular.module("dmApp", []);

app.controller('MainController', ['$scope', function($scope) {
    
    const evidenceTemplate = {
        id: null,
        supports: true,
        evidenceText: "",
        warrantText: ""
    };

    const reasonTemplate = {
        id: null,
        linkID: null,
        reasonText: "",
        strength: 1,
        evidences: []
    };

    const mapTemplate = {
        id: null,
        ownerID: null,
        assignment: "",
        topic: "",
        stanceBlue: "",
        blueReasons: [],
        stanceYellow: "",
        yellowReasons: [],
        conclusion: ""
    };

    $scope.mapState = {};

    $scope.prebuild = function() {

        //Instantiate a new map
        $scope.mapState = _.cloneDeep(mapTemplate);
        $scope.mapState.assignment = "Assignment 1";
        $scope.mapState.topic = "Are dialectical maps an effective teaching tool?";
        $scope.mapState.stanceBlue = "Pro/Agree";
        $scope.mapState.stanceYellow = "Con/Disagree";
        $scope.mapState.conclusion = "Lorem ipsums lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems lorems";

        var firstReason = _.cloneDeep(reasonTemplate);
        firstReason.id = 0;

        var secondReason = _.cloneDeep(reasonTemplate);
        secondReason.id = 1;
        
        $scope.mapState.blueReasons.push(firstReason);
        $scope.mapState.yellowReasons.push(secondReason);

        $scope.logMapState();
    };

    $scope.logMapState = function() {
        console.log($scope.mapState);
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