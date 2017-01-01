app.factory('FriendService',function($http){
	var BASE_URL="http://localhost:8081/proj2backend"
	var friendservice=this;
	
	friendservice.getAllFriends=function(){
		console.log('service --- friendRequest');
		return $http.get(BASE_URL + "/getAllFriends");
	}
	friendservice.pendingRequest=function(){
		console.log('service --- pending request');
		return $http.get(BASE_URL + "/pendingRequest")
	}
	friendservice.updateFriendRequest=function(friendStatus,fromId){
		console.log('service - update friend request')
		return $http.put(BASE_URL + "/updateFriendRequest/" + friendStatus +"/"+fromId)
	}
	return friendService;
})