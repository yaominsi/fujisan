
define(function(require,exports){
	function loadOrder() {
    	push_div('left_bar_order');
		$('#div_my_order').html($('#tpl_order_list').html());
		$('#more_orders').attr('pageNo',0);
		$('#more_orders').click(loadOrder2);
		$.ajax(
            {
              url:"/order/0/listFromMe.action", 
              type: "POST", 
              data: null,
              success: function(data){
      				if(data.success&&data.value&&data.value.content){
      					$(data.value.content).each(function(){
      						var str = nano($('#tpl_order_detail').html(),this);
      						$(str).appendTo($('#ul_order_list'));
      					});
      					//初始化
      					$('#ul_order_list li').click(
      						function(){
      							//active_detail($(this).attr('val'));
      						}
      					);
      				}
      			}, 
              dataType: "json",
              contentType: "application/json"
            } );  
		
	};
	function loadOrder2() {
		var pageNo=$('#more_orders').attr('pageNo');
		$.ajax(
            {
              url:"/order/"+pageNo+"/listFromMe.action", 
              type: "POST", 
              data: null,
              success: function(data){
      				if(data.success&&data.value&&data.value.content){
      					$(data.value.content).each(function(){
      						var str = nano($('#tpl_order_detail').html(),this);
      						$(str).appendTo($('#ul_order_list'));
      						$('#more_orders').attr('pageNo',eval(pageNo)+1);
      					});
      					//初始化
      					$('#ul_order_list li').click(
      						function(){
      							//active_detail($(this).attr('val'));
      						}
      					);
      				}else{
      					alert('就这么多了');
      				}
      			}, 
              dataType: "json",
              contentType: "application/json"
            } );  
		
	};
	function createOrder(lightUpId,seeds){
		if(!lightUpId){
			//请选择要参与的活动
			return false;
		}
		if(!seeds){
			seeds=1;
		}
		var flag=confirm("要参与吗？");
		if(!flag) return false;
		//{lightUpId:lightUpId,seeds:seeds},
		$.ajax(
	            {
	              url:"/order/create.action", 
	              type: "POST", 
	              data: JSON.stringify( {lightUpId:lightUpId,seeds:seeds}),
	              success: function(data){
	              				if(data.success&&data.value&&data.value.content){
	              					alert(data.desc);
	              				}else{
	              					alert(data.desc);
	              				}
	              			}, 
	              dataType: "json",
	              contentType: "application/json"
	        } 
	    );  
	};
	function disposeOrder(orderId,status){
		$.ajax(
		    {
		      url:"/order/"+orderId+"/"+status+".action", 
		      type: "POST", 
		      data: null, 
		      success: function(data){
		      	if(data.success){
		      		//隐藏操作
		      		$('#span_order_opt_'+orderId).hide();
		      	}else{
		      		alert(data.desc);
		      	}
		      }, 
		      dataType: "json",
		      contentType: "application/json"
	    }); 

	};
	function bind(){
		$('#btn_load_order').click(loadOrder);
		window.createOrder=createOrder;
		window.disposeOrder=disposeOrder;
	}
	exports.bind=bind;
});