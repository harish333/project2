var app=angular.module("myApp",['ngRoute'])
app.config(function($routeProvider){
	console.log('entering configuration')
	$routeProvider
	.when('/login',{
		controller:'usercontroller',
		templateUrl:'user/login.html'
	})
	.when('/register',{
		controller:'usercontroller',
		templateUrl:'user/register.html'
	})
	.when('/listOfUsers',{
		controller:'usercontroller',
		templateUrl:'user/listOfUsers.html'
	})
	.when('/home',{
		templateUrl:'home/home.html'
	})
	.when('/postJob',{
		controller:'jobcontroller',
		templateUrl:'job/createjob.html'
	})
	.when('/getAllJobs',{
		controller:'jobcontroller',
		templateUrl:'job/jobTitles.html'
	})
	.when('/uploadPicture',{
		controller:'usercontroller',
		templateUrl:'user/fileUpload.html'
	})
	.when('/friendsList',{
		controller:'FriendController',
		templateUrl:'friend/listOfFriends.html'
	})
	.when('/pendingRequest',{
		controller:'FriendController',
		templateUrl:'friend/pendingRequest.html'
		
	})
	.when('/getAllUsers',{
		controller:'UserController',
		templateUrl:'user/listOfUsers1.html'
		
	})
})