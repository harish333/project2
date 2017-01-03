app.factory('blogservice',function($http){
	var blogService=this;
	blogservice.addPost=function(blogPost){
		console.log('addpost in service')
		return $http.post("http://localhost:8081/proj2backend/blog",blogPost);
	}
	
	blogservice.getBlogPosts=function(){
		console.log('getBlogposts in service')
		return $http.get("http://localhost:8081/proj2backend/blog/list")
	}
	blogservice.getBlogDetail=function(id){
		console.log('getBlogDetails')
		return $http.get("http://localhost:8081/proj2backend/blog/get/"+ id)
	}
	
	blogservice.addComment=function(comment){
		return $http.post("http://localhost:8081/proj2backend/blog/comment",comment)
	}
	blogservice.getComments=function(blogId){
		console.log('getcomments -- service')
		return $http.get("http://localhost:8081/proj2backend/blog/getcomments/"+blogId)
	}
	return blogservice;
})