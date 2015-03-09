//
define(function(require,exports){
	require("jquery");
	var loadTopicTags= function(param,callback){
		$.ajax(
            {
              url:"/topic/tags.action", 
              type: "POST", 
              data: JSON.stringify(param),
              success: function(data){
              				if(data.success&&data.value){
              					callback(null,data.value);
              				}
              			}, 
              dataType: "json",
              contentType: "application/json"
            } );  
	};
	exports.loadTopicTags=loadTopicTags;
});