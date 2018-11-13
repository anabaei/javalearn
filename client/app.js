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
        reasonID: null,
        supports: true,
        evidenceContent: null,
        warrantContent: null
    };

    $scope.countBlueReasons = function() {
        var count = 0;
        _.forEach($scope.mapState.reasons, function(reason) {
            if (reason.isBlue) {
                count++;
            }
        });
        return count;
    };

    $scope.countYellowReasons = function() {
        var count = 0;
        _.forEach($scope.mapState.reasons, function(reason) {
            if (!reason.isBlue) {
                count++;
            }
        });
        return count;
    };

    $scope.undoStack = [];
    $scope.redoStack = [];

    function storeMapState() {
        $scope.undoStack.push(_.cloneDeep($scope.mapState));
        redoStack = [];
    };

    $scope.redo = function() {
        if($scope.redoStack.length > 0) {
            $scope.undoStack.push(_.cloneDeep($scope.mapState));
            $scope.mapState = $scope.redoStack.pop();
        }
    };

    $scope.undo = function() {
        if($scope.undoStack.length > 0) {
            $scope.redoStack.push(_.cloneDeep($scope.mapState));
            $scope.mapState = $scope.undoStack.pop();
        }
    };

    $scope.mapState = {};

    $scope.initialize = function() {

        //get the sample data via http get
        $http.get('prototypeMap.json')
        .then(function buildInitialState(response) {
            $scope.mapState = response.data;     
        }, function notifyInitialStateFailure(response) {
            console.log(response);
        });
    };

    $scope.addReason = function(isBlue) {

        storeMapState();

        var newReason = _.cloneDeep(reasonTemplate);
        var newID;
        var newOrder;

        if ($scope.mapState.reasons.length == 0) {
            newID = 0;
            newOrder = 0;
        }
        else {
            var maxReason = _.maxBy($scope.mapState.reasons, 'reasonID');
            newID = maxReason.reasonID + 1;

            if (isBlue) {
                newOrder = $scope.countBlueReasons();
            }
            else {
                newOrder = $scope.countYellowReasons();
            }
        }

        newReason.reasonID = newID;
        newReason.order = newOrder;

        newReason.mapID = $scope.mapState.mapID;
        newReason.strength = 3;
        newReason.isBlue = isBlue;
        newReason.content = "";

        $scope.mapState.reasons.push(newReason);
    };

    $scope.removeReason = function(reason) {

        storeMapState();

        _.remove($scope.mapState.reasons, function(item) {
            return item.reasonID == reason.reasonID;
        });
    };

    $scope.addEvidence = function(reason) {

        storeMapState();

        var newEvidence = _.cloneDeep(evidenceTemplate);
        var newID;

        if (reason.evidences.length == 0) {
            newID = 0;
        }
        else {
            var maxEvidence = _.maxBy(reason.evidences, 'evidenceID');
            newID = maxEvidence.evidenceID + 1;
        }

        newEvidence.evidenceID = newID;
        newEvidence.reasonID = reason.reasonID;
        newEvidence.evidenceContent = "";
        newEvidence.warrantContent = "";

        console.log(newEvidence);
        reason.evidences.push(newEvidence);
    };

    $scope.removeEvidence = function(reason,evidence) {

        storeMapState();

        _.remove(reason.evidences, function(item) {
            return item.evidenceID == evidence.evidenceID;
        });
    };

    $scope.moveUp = function(reason) {
        if (reason.order != 0 && reason.isBlue && $scope.countBlueReasons() > 1) {

            storeMapState();

            //find the blue candidate to move down
            var swapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.order == reason.order - 1 && item.isBlue);
            });
            var swapHolder = reason.order;
            reason.order = swapTarget.order;
            swapTarget.order = swapHolder;
        }
        else if (reason.order != 0 && !reason.isBlue && $scope.countYellowReasons() > 0) {

            storeMapState();

            //find the yellow candidate to move down
            var swapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.order == reason.order - 1 && !item.isBlue);
            });
            var swapHolder = reason.order;
            reason.order = swapTarget.order;
            swapTarget.order = swapHolder;
        }
        else {
            console.log("Cannot move up, already at top.")
        }
    };

    $scope.moveDown = function(reason) {
        if (reason.order != $scope.countBlueReasons()-1 && reason.isBlue && $scope.countBlueReasons() > 1) {
            
            storeMapState();
            
            //find the blue candidate to move up
            var swapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.order == reason.order + 1 && item.isBlue);
            });
            var swapHolder = reason.order;
            reason.order = swapTarget.order;
            swapTarget.order = swapHolder;
        }
        else if (reason.order != $scope.countYellowReasons()-1 && !reason.isBlue && $scope.countYellowReasons() > 1) {
            
            storeMapState();
            
            //find the yellow candidate to move down
            var swapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.order == reason.order + 1 && !item.isBlue);
            });
            var swapHolder = reason.order;
            reason.order = swapTarget.order;
            swapTarget.order = swapHolder;
        }
        else {
            console.log("Cannot move down, already at bottom.")
        }
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

    $scope.submit = function() {
        console.log("submit function");
    };

    $scope.download = function() {
        console.log("download function");
    };

    $scope.linkArguments = function() {

        //TODO remember to store the map state here

        console.log("link function for arguments");
    };

    $scope.increaseStrength = function(reason) {
        if (reason.strength < 5) {

            storeMapState();

            reason.strength++;
        };
    };

    $scope.decreaseStrength = function(reason) {
        if (reason.strength > 1) {

            storeMapState();

            reason.strength--;
        };
    };

    $scope.toggleSupport = function(evidence) {

        storeMapState();

        evidence.supports = !evidence.supports;
    };

    $scope.toggleEvidenceVisibility = function(reason) {

        storeMapState();

        reason.expanded = !reason.expanded;
    };
    
}]);