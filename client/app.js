var app = angular.module("dmApp", []);

app.controller('MainController', ['$scope', '$http', function($scope,$http) {

    const reasonTemplate = {
        reasonID: null,
        mapID: null,
        strength: null,
        order: null,
        isBlue: null,
        content: null,
        linked: null,
        evidences: [],
        expanded: false
    };

    const evidenceTemplate = {
        evidenceID: null,
        supports: true,
        evidenceContent: null,
        warrantContent: null
    };

    //Adds only a visibility field for evidences
    function prepInitialVisibility(storedMap) {
        $scope.mapState = storedMap;
        _.forEach($scope.mapState.reasons, function(value) {
            value.expanded = true;
        });
        console.log("Sample data prepared for display.");
    };

    $scope.mapState = {};

    $scope.initialize = function() {

        //get the sample data via http get
        $http.get('prototypeMap.json')
        .then(function buildInitialState(response) {
            prepInitialVisibility(response.data);      
        }, function notifyInitialStateFailure(response) {
            console.log(response);
        });
    };

    $scope.addReason = function(isBlue) {
        var newReason = _.cloneDeep(reasonTemplate);
        var biggest = _.maxBy($scope.mapState.reasons, 'reasonID');
        newReason.reasonID = biggest.reasonID++;
        newReason.mapID = $scope.mapState.mapID;
        newReason.strength = 3;
        //find new order var for the new reason TODO
        newReason.order = null;
        newReason.isBlue = isBlue;
        newReason.content = "";

        //finally, push the new reason into the map state
        console.log(newReason);
        $scope.mapState.reasons.push(newReason);
    };

    $scope.removeReason = function(reason) {
        _.remove($scope.mapState.reasons, function(item) {
            return item.reasonID == reason.reasonID;
        });
    };

    $scope.addEvidence = function() {
        console.log("adding evidence");
    };

    $scope.removeEvidence = function() {
        console.log("removing evidence");
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

    $scope.increaseStrength = function(reason) {
        if (reason.strength < 5) {
            reason.strength++;
        };
    };

    $scope.decreaseStrength = function(reason) {
        if (reason.strength > 1) {
            reason.strength--;
        };
    };

    $scope.toggleSupport = function(evidence) {
        evidence.supports = !evidence.supports;
    };

    $scope.toggleEvidenceVisibility = function(reason) {
        reason.expanded = !reason.expanded;
    };
    
}]);