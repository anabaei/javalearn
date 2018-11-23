var app = angular.module("dmApp", ['angular.filter']);

(function(main, $) {
  
    "use strict";
    
    main
      .directive("textarea", function() {
        return {
          restrict: "E",
          require: "ngModel",
          link: AutogrowLink
        };
      });
      
    function AutogrowLink(scope, element, attributes) {
      if (!element.hasClass("autogrow")) {
        // no autogrow for you today
        return;
      }
  
      // get possible minimum height style
      var minHeight = parseInt(window.getComputedStyle(element[0]).getPropertyValue("min-height")) || 0;
  
      // prevent newlines in textbox
      element.on("keydown", function(evt) {
        if (evt.which === 13)
        {
          evt.preventDefault();
        }
      }
      );
    
      
      element.on("input" , function(evt) {
        element.css({
          paddingTop: 0,
          height: 0,
          minHeight: 0
        });
        
        var contentHeight = this.scrollHeight;
        var borderHeight = this.offsetHeight;
  
        element.css({
          //paddingTop: ~~Math.max(0, minHeight - contentHeight) / 2 + "px",
          paddingTop: "1vw",
          paddingBottom: "1vw",
          minHeight: null, // remove property
          height: contentHeight + borderHeight + "px" // because we're using border-box
        });
      });
  
      // watch model changes from the outside to adjust height
      scope.$watch(attributes.ngModel, trigger);
      
      // set initial size
      trigger();
      
      function trigger() {
        setTimeout(element.triggerHandler.bind(element, "input"), 1);
      }
    }
    
  })(app, angular.element);

app.controller('MainController', ['$scope', '$http', function($scope,$http) {

    const reasonTemplate = {
        reasonID: null,
        mapID: null,
        strength: null,
        order: null,
        isBlue: null,
        content: null,
        linkID: null,
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

    //keep track of when the text in an item changes
    var textStore = "";
    //keep a deep copy of the mapstate when comparing changes in text
    var stateStore = {};

    $scope.undoStack = [];
    $scope.redoStack = [];

    $scope.mapState = {};

    $scope.initialize = function() {

        
        //touch events via hammerjs
        var swipeArea = document.getElementById('scrollZone');
        var hammertime = new Hammer(swipeArea);
        hammertime.on('swipe', function(ev) {
            if (ev.direction == 2) {
                console.log("Sliding Right");
                slideRight();
            }
            else if (ev.direction == 4) {
                console.log("Sliding Left");
                slideLeft();
            }
            else {
                console.log("Detected up or down swipe");
            }
        });

        

        //Disable standard undo
        Mousetrap.bind(['command+z','ctrl+z'], function(e) {
            return false;
        });

        //Disable standard redo
        Mousetrap.bind(['command+y','ctrl+y'], function(e) {
            return false;
        });

        //get the sample data via http get
        $http.get('prototypeMap.json')
        .then(function buildInitialState(response) {
            $scope.mapState = response.data;     
        }, function notifyInitialStateFailure(response) {
            console.log(response);
        });
    };

    $scope.pullOriginalText = function(text) {
        //Keep a copy of the map state before the element is focused so we can store it later if needed
        stateStore = _.cloneDeep($scope.mapState);
        //Keep a copy of the specific element text for comparison purposes
        textStore = text;
    };

    $scope.compareNewText = function(text) {
        //if the text changed 
        if(text != textStore) {
            $scope.undoStack.push(_.cloneDeep(stateStore));
            $scope.redoStack = [];
        }

        //clear holder variables for the next use
        stateStore = {};
        textStore = "";
    };

    $scope.countBlueReasons = function() {
        var count = 0;
        _.forEach($scope.mapState.reasons, function(reason) {
            if (reason.isBlue && reason.order != null) {
                count++;
            }
        });
        return count;
    };

    $scope.countYellowReasons = function() {
        var count = 0;
        _.forEach($scope.mapState.reasons, function(reason) {
            if (!reason.isBlue && reason.order != null) {
                count++;
            }
        });
        return count;
    };

    $scope.countLinkedReasons = function() {
        var count = 0;
        _.forEach($scope.mapState.reasons, function(reason) {
            if (reason.linkID != null) {
                count++;
            }
        });
        return count/2;
    };

    $scope.moveLinkedReasonsDown = function(linkedReasonBlue, linkedReasonYellow) {
        
        if (linkedReasonBlue.linkID != $scope.countLinkedReasons()-1 && $scope.countLinkedReasons() > 1) {
            
            storeMapState();

            var linkedReasonID = linkedReasonBlue.linkID;

            //find the blue and yellow linked reasons with the linkID one less
            var blueSwapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.linkID == linkedReasonID + 1 && item.isBlue);
            });
            var yellowSwapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.linkID == linkedReasonID + 1 && !item.isBlue);
            });

            var swapLinkedReasonID = blueSwapTarget.linkID;

            //swap the linkIDs
            linkedReasonBlue.linkID = swapLinkedReasonID;
            linkedReasonYellow.linkID = swapLinkedReasonID;
            blueSwapTarget.linkID = linkedReasonID;
            yellowSwapTarget.linkID = linkedReasonID;

        }
        else {
            console.log("Cannot move down, already at bottom.");
        }
    };

    $scope.moveLinkedReasonsUp = function(linkedReasonBlue, linkedReasonYellow) {

        if (linkedReasonBlue.linkID != 0 && $scope.countLinkedReasons() > 1) {
            
            storeMapState();

            var linkedReasonID = linkedReasonBlue.linkID;

            //find the blue and yellow linked reasons with the linkID one more
            var blueSwapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.linkID == linkedReasonID - 1 && item.isBlue);
            });
            var yellowSwapTarget = _.find($scope.mapState.reasons, function(item) {
                return (item.linkID == linkedReasonID - 1 && !item.isBlue);
            });

            var swapLinkedReasonID = blueSwapTarget.linkID;

            //swap the linkIDs
            linkedReasonBlue.linkID = swapLinkedReasonID;
            linkedReasonYellow.linkID = swapLinkedReasonID;
            blueSwapTarget.linkID = linkedReasonID;
            yellowSwapTarget.linkID = linkedReasonID;

        }
        else {
            console.log("Cannot move up, already at top.");
        }
    };

    function storeMapState() {
        $scope.undoStack.push(_.cloneDeep($scope.mapState));
        $scope.redoStack = [];
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

        //decrement every other reason where order is not null and order was above the removed reason
        _.forEach($scope.mapState.reasons, function(item) {
            if(item.order && item.order > reason.order) {
                item.order--;   
            }
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
            
            //find the yellow candidate to move up
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
        return item.isBlue == true && item.order != null;
    };

    $scope.yellowFilter = function(item) {
        return item.isBlue == false && item.order != null;
    };

    $scope.linkedFilter = function(item) {
        return item.linkID != null;
    };

    $scope.logMapState = function() {
        console.log($scope.mapState);
    };

    $scope.submit = function() {
        console.log("submit function");
    };

    $scope.download = function() {
        //build the content TODO
        var mapString = "";

        //Question
        mapString += "Question: " + $scope.mapState.title + "\n\n";

        //Blue Argument heading
        mapString += $scope.mapState.thesisBlue + " Arguments:\n";
        
        //Repeat over the blue reasons and evidences
        _.forEach($scope.mapState.reasons, function(reason) {
            if (reason.isBlue) {
                mapString += "(" + reason.strength + ") " + reason.content + "\n";

                _.forEach(reason.evidences, function(evidence) {
                    var supString = evidence.supports ? "(Supports)" : "(Opposes)";

                    mapString += "\t" + supString + " " + evidence.evidenceContent + "\n";
                    if(evidence.warrantContent != "") {
                        mapString += "\t\t" + evidence.warrantContent + "\n";
                    }
                });

                mapString += "\n";
            }
        });

        mapString += $scope.mapState.thesisYellow + " Arguments:\n";

        //Repeat over the yellow reasons and evidences
        _.forEach($scope.mapState.reasons, function(reason) {
            if (!reason.isBlue) {
                mapString += "(" + reason.strength + ") " + reason.content + "\n";

                _.forEach(reason.evidences, function(evidence) {
                    var supString = evidence.supports ? "(Supports)" : "(Opposes)";

                    mapString += "\t" + supString + " " + evidence.evidenceContent + "\n";
                    if(evidence.warrantContent != "") {
                        mapString += "\t\t" + evidence.warrantContent + "\n";
                    }
                });

                mapString += "\n";
            }
        });

        mapString += "Conclusion: " + $scope.mapState.conclusion + "\n";

        var link = document.createElement('a');
        link.download = "DM-" + $scope.mapState.mapID + ".txt";
        var blob = new Blob([mapString], {type: 'text/plain'});
        link.href = window.URL.createObjectURL(blob);

        //trigger the download
        link.click();
    };

    $scope.unlinkArguments = function(linkedBlueReason,linkedYellowReason) {
        
        storeMapState();

        //arbitrary
        var sharedLinkID = linkedBlueReason.linkID;

        //adjust rest of the linkIDs downward if they are greater
        _.forEach($scope.mapState.reasons, function(reason) {
            if (reason.linkID != null && reason.linkID > sharedLinkID) {
                reason.linkID--;
            }
        });

        //acquire new order for the now unlinked reasons, place at bottom
        var newBlueID = $scope.countBlueReasons();
        var newYellowID = $scope.countYellowReasons();

        //clear linkIDs
        linkedBlueReason.linkID = null;
        linkedYellowReason.linkID = null;

        //assign the orders we found before
        linkedBlueReason.order = newBlueID;
        linkedYellowReason.order = newYellowID;
    };

    $scope.linkArguments = function() {

        //find order 0 for linking, blue
        var blueReason = _.find($scope.mapState.reasons, {'order': 0, 'isBlue': true});
        //find order 0 for linking, yellow
        var yellowReason = _.find($scope.mapState.reasons, {'order': 0, 'isBlue': false});

        if (blueReason && yellowReason) {

            storeMapState();

            //remove order of reasons that were found
            blueReason.order = null;
            yellowReason.order = null;

            //decrement every other reason where order is not null
            _.forEach($scope.mapState.reasons, function(reason) {
                if(reason.order) {
                    reason.order--;
                }
            });

            //look for existing linkIDs and find the largest one, assign 0 if none exist
            var existingLinkedReason = _.maxBy($scope.mapState.reasons, 'linkID');
            var newLinkID;
            if (existingLinkedReason) {
                newLinkID = existingLinkedReason.linkID + 1;
            }
            else {
                newLinkID = 0;
            }

            //give the new reasons a linkID
            blueReason.linkID = newLinkID;
            yellowReason.linkID = newLinkID;

        }

        else {
            console.log("Unable to find candidates to link.");
        }
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

    slideLeft = function() {
        document.querySelector('div.scrollWrap').scrollLeft = 0;
    };

    slideRight = function() {
        document.querySelector('div.scrollWrap').scrollLeft = 5000;
    };
    
}]);