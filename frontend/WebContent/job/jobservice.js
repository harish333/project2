app.factory('jobservice',function($http)
{
	console.log('entering jobservice')
	var jobservice=this;
	var BASE_URL ="http://localhost:8081/proj2backend"    
		
	jobservice.saveJob=function(job)
	{
		return $http.post(BASE_URL + "/postJob" , job)
		.then(function(response){
			console.log('job service sucess')
			console.log(response.status)
			console.log(response.headers.location)
			return response.status
		},function(response){
			console.log('job service failure')
			console.log(response.status)
			return response.status
		})
	}
	
	jobservice.getAllJobs=function(){
		
		return $http.get(BASE_URL + "/getAllJobs")
		
		/*.then(function(response){
			//response is an object returened from the back end
			//data,status,headers,statustext
			//data-list of person
			console.log('entering service sucess')
			console.log(response.data)
			console.log(response.status)
			return response.data
		},
		function(response)
		{
			console.log('entering service failure')
			console.log(response.data)
			return response.data
		})*/
		
	}
	
	jobservice.getJobDetail=function(jobId){
		return $http.get(BASE_URL + "/getJobDetail/"+jobId)
	}
	
	
	return jobservice;
})


/*app.factory('jobservice',function($http){
	var jobservice=this;
	var BASE_URL ="http://localhost:8081/proj2backend/Job"
	jobservice.saveJob=function(job){
		return $http.post(BASE_URL + "/postJob" , job)
		.then(function(response){
			console.log('job service success')
			console.log(response.status)
			console.log(response.headers.location)
			return response.status
		},function(response){
			console.log('job service failure')
			console.log(response.status)
			return response.status
		})
	};
	
	
	jobservice.getAllJobs=function(){
		return $http.get(BASE_URL + "/getAllJobs");
	};
	return jobservice;
})*/