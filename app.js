var app=angular.module('CAPTRSModule',[]);

app.controller('LoginController',['$scope', '$http', '$log', '$window',  function($scope,$http,$log, $window){

	$log.info(" inside LoginController ");
	$scope.validateUser=function(){
		$log.info("username:"+$scope.username);
		$log.info("password:"+$scope.password);
		//localhost:9080/CAPTRS/validateUser?userName=latika&password=latika
		
		$http({
			method : "post",
			url : "http://localhost:9091/CAPTRS/validateUser",
			params: {
		    	userName: $scope.username,
		    	password:$scope.password
		    }
		})
		.then(function(response) {
			var check =response.data.loginStatus;
			$log.info($scope.response);
			//$console.log("Before redirection");
			if(check)	{
			$window.location.href="/CAPTRS/home.html";
			}
			else
			{
			$log.info("Inside wrong username and password");
			alert("Enter correct username and password");
			}
			//$console.log("After redirection");
			
		});	
		
	}
}]
);


app.controller('StockController',['$scope', '$http', '$log', '$window',  function($scope,$http,$log, $window){

	$log.info(" inside StockController ");
	$scope.getTop5Stocks=function(){
		//$log.info("cap value:"+$scope.Large Cap);
		//localhost:9080/CAPTRS/validateUser?userName=latika&password=latika
		
		$http({
			method : "get",
			url : "http://localhost:9091/CAPTRS/getTop5Stocks",
			params: {
		    	//userName: $scope.username,
		    	//password:$scope.password
		    }
		})
		.then(function(response) {
			//var check =response.data.loginStatus;
			$log.info("Inside then function");
			//$console.log("Before redirection");
			if(check)	{
			$window.location.href="/CAPTRS/home.html";
			}
			
			//$console.log("After redirection");
			
		});	
		
	}
}]
);





function TestController($scope) {
    $scope.setChoiceForQuestion = function (q, c) {
        angular.forEach(q.choices, function (c) {
            c.isUserAnswer = false;
        });
        
        c.isUserAnswer = true;
    };
    $scope.question1 = {
        questionText: "This is a test question.",
        choices: [{
                id: 1,
                text: "Choice 1",
                isUserAnswer: "false"
            }, {
                id: 2,
                text: "Choice 2",
                isUserAnswer: "true"
            }, {
                id: 3,
                text: "Choice 3",
                isUserAnswer: "false"
            }]
    };   
    
    $scope.question2 = {
        questionText: "This is a test question.",
        choices: [{
            id: 1,
            text: "Choice 1",
            isUserAnswer: false
        }, {
            id: 2,
            text: "Choice 2",
            isUserAnswer: true
        }, {
            id: 3,
            text: "Choice 3",
            isUserAnswer: false
        }]
    };   
}