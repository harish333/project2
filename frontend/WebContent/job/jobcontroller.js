app.controller('jobcontroller',function($scope,$location,jobservice){
	$scope.jobs;
	$scope.job={jobTitle:'',jobDescription:'',skillsRequired:'',salary:'',location:''}
	$scope.saveJob=function(){
		console.log('entering save job in job controller')
		jobservice.saveJob($scope.job)
		.then(function(response){
			console.log('entered sucess job')
			console.log("job success" + response.status)
			console.log("successfully inserted job details");
			alert("Posted job successfully");
			$location.path('/home');
		},function(response){
			console.log('Entered failure job')
			console.log("failure " +response.status);
			console.log(response.data.message)
			$location.path('/postJob')
		})
	}
	
	
	function getAllJobs(){
		console.log('entering get All jobs')
		jobservice.getAllJobs()
		.then(function(response){
			console.log(response.status); //200
			$scope.jobs=response.data;  //List<Job>
			
		},function(response){
			console.log(response.status)
		})
	}
	getAllJobs();
})/*app.controller('jobcontroller',function($scope,$location,$routeParams,jobservice){
	$scope.job={jobTitle:'',jobDescription:'',skillsRequired:'',salary:'',location:''}
	$scope.jobs;
	$scope.showJobDetail=false
	$scope.saveJob=function(){
		console.log('entering save job in job controller')
		jobservice.saveJob($scope.job)
		.then(function(response){
			console.log("successfully inserted job details");
			alert("Posted job successfully");
			$location.path('/home');
		},function(response){
			console.log("entered failure job");
			console.log("failure " +response.status);
			if(response.status==401){
				$location.path('/login')
			}
			else{
			console.log(response.data.message)
			$location.path('/postJob')
			}
		})
	}
	
	function getAllJobs(){
	$scope.showJobDetail=false;
		console.log('entering get All jobs')
		jobservice.getAllJobs()
		.then(function(response){
			console.log(response.status); //200
			$scope.jobs=response.data;  //List<Job>			
		},function(response){
			console.log(response.status)
		})
	}
	getAllJobs();
	
	$scope.getJobDetail=function(jobId){
		//$scope.showJobDetail=true;
		jobservice.getJobDetail(jobId)
	.then(function(response){
		$scope.jobDetail=response.data; // single Job object
		console.log(response.status)
		
	},function(response){
		console.log(response.status)
	})
	}	
})*/