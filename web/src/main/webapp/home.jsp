<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link href="static/css/main.css" type="text/css" rel="stylesheet">
<script src="static/sea-modules/sea.js"></script>
<style type="text/css">

</style>
</head>
<body>
<header id="header" class="header" data-log="navi">
<div class="header-inner">
      <h1 class="header-logo">
         <a href="/home">花田_中国唯一免费的大型恋爱交友社区</a>
      </h1>
      <ul class="header-navi">
         <li id="home">
            <a href="/home"><span>推荐</span></a>
         </li>
                   <li id="trend">
         <a href="/trend"><span>动态</span></a>
         </li>
                  <li>
            <a href="/search/user"><span>遇见</span></a>
         </li>
         <li>
            <a href="/park/topic"><span>搭讪广场</span></a>
                        <em class="icon-recomm header-park-recomm"></em>
                     </li>
                   <li class="current">
            <a href="/10242725"><span>个人主页</span></a>
         </li>
               </ul>
                      
               <div class="header-vip">
            <a href="/pay/services" target="_blank" data-log="openvip" class="header-vip-wrap"><span class="icon-vip-header"></span><span class="header-vip-service">服务</span></a>
            <em class="icon-hot"></em>
         </div>
            <div class="header-app">
         <a title="手机客户端下载" target="_blank" href="/app" class="header-app-btn">
            
            <span class="header-app-btn-lineL"></span>            <em class="icon-header-app"></em>
            <span class="header-app-btn-line"></span>
         </a>
      </div>
      <div class="header-info js-header-info">
         <div class="header-info-mess js-info-mess" id="newMessage">
            <span class="header-info-title js-title">
               <em class="icon-header-mess"></em>
            </span>
            <div class="header-info-list js-list">
               <ul>
                  <li class="js-message">
                     <a href="/messages">
                        <em class="js-item">0</em>
                        <span>查看私信</span>
                     </a>
                  </li>
                  <li class="js-digg">
                     <a href="/messages/like">
                        <em class="js-item">0</em>
                        <span>新增“赞”</span>
                     </a>
                  </li>
                  <li class="js-heed">
                     <a href="/messages/followers">
                        <em class="js-item">0</em>
                        <span>新增喜欢</span>
                     </a>
                  </li>
                  <li class="js-visitors">
                     <a href="/messages/visitor">
                        <em class="js-item">0</em>
                        <span>最近访客</span>
                     </a>
                  </li>
                  <li class="js-gift">
                     <a href="/messages/gift">
                        <em class="js-item">0</em>
                        <span>收到礼物</span>
                     </a>
                  </li>
                  <li class="line"></li>
                  <li class="js-fate">
                     <a href="/fate" class="link-red">
                        <em class="js-item">0</em>
                        <span>今日最荐</span>
                     </a>
                  </li>
                  <li class="js-admin">
                     <a href="/messages/dm/1398972104992685069">
                        <em class="js-item">0</em>
                        <span>系统通知</span>
                     </a>
                  </li>
                  <li class="js-park">
                     <a href="/messages/park">
                        <em class="js-item">0</em>
                        <span>话题消息</span>
                     </a>
                  </li>
                  <li class="js-dating">
                     <a href="/messages/dating">
                        <em class="js-item">0</em>
                        <span>约会消息</span>
                     </a>
                  </li>
                  <li class="lastLi js-all">
                     <a href="/messages">
                        <span>查看全部消息</span>
                     </a>
                  </li>
               </ul>
            </div>
            <div style="display: none;" data-show="0" class="header-info-list header-info-preview-list" id="newMessagePreview">
               <ul>
                  <li class="js-message">
                     <a href="/messages">
                        <em class="js-item">0</em>
                        <span>查看私信</span>
                     </a>
                  </li>
                  <li class="js-digg">
                     <a href="/messages/like">
                        <em class="js-item">0</em>
                        <span>新增“赞”</span>
                     </a>
                  </li>
                  <li class="js-heed">
                     <a href="/messages/followers">
                        <em class="js-item">0</em>
                        <span>新增喜欢</span>
                     </a>
                  </li>
                  <li class="js-visitors">
                     <a href="/messages/visitor">
                        <em class="js-item">0</em>
                        <span>最近访客</span>
                     </a>
                  </li>
                  <li class="js-gift">
                     <a href="/messages/gift">
                        <em class="js-item">0</em>
                        <span>收到礼物</span>
                     </a>
                  </li>
                  <li class="js-admin">
                     <a href="/messages/dm/1398972104992685069">
                        <em class="js-item">0</em>
                        <span>系统通知</span>
                     </a>
                  </li>
                  <li class="js-park">
                     <a href="/messages/park">
                        <em class="js-item">0</em>
                        <span>话题消息</span>
                     </a>
                  </li>
                  <li class="js-dating">
                     <a href="/messages/dating">
                        <em class="js-item">0</em>
                        <span>约会消息</span>
                     </a>
                  </li>
                  <li class="js-fate">
                     <a href="/fate">
                        <em class="js-item">0</em>
                        <span>今日最荐</span>
                     </a>
                  </li>
               </ul>
            </div>
         </div>
         <span class="header-info-line"></span>
         <div class="header-info-user js-info-user">
            <span class="header-info-title">
               <em class="icon-header-user"></em>
            </span>
            <div class="header-info-list header-info-setting-list">
               <ul>
                  <li><a href="/invite" class="invite-trigger"><span>邀好友赢会员</span><span class="icon-new" style="display: inline-block;"></span></a></li>
                  <li>
                     <a href="/settings/account"><span>帐号设置</span></a>
                  </li>
                  <li><a href="/pay/services"><span>会员服务中心</span></a></li>
                  <li><a href="/verified/name"><span>认证</span></a></li>
                  <li>
                     <a href="javascript:;" class="closeinfo-trigger"><span>关闭资料</span></a>
                  </li>
                  <li class="lastLi">
                                                               <a href="/logout?url=http://love.163.com/10242725?tab=qa" id="logOut"><span>退出</span></a>
                  </li>
               </ul>
            </div>
         </div>
      </div>
    </div>
</header>
	<div style="margin-top:54px;height:300px;border:1px solid #000;text-align:center;">
		就是这样
	</div>
	<div style="border:1px solid #000;text-align:center" id="div_active_types">
		
	</div>
	<div id="div_active_content">
		<div >我的标签:<span id="div_topic_tags"></span>
		<div>
			<span >我发起的</span>
			<span >我参与的</span>
			<span >我关注的</span>

		</div>
		<div >达人</div>
	</div>
</body>
<script type="text/javascript">
	seajs.config({
		base:"/",
		alias:{
			jquery:"static/sea-modules/jquery.min",
			active:"static/tpl/active",
			notify:"static/tpl/notify",
			scope:"static/tpl/scope",
			user:"static/tpl/user",
			tag:"static/tpl/tag",
			order:"static/tpl/order"
		}
	});
	seajs.use('active',function(active){
		active.loadActiveTypes(function(err,data){
			$(data).each(function(){
				$("<span style='width:100px;height:100px;display:inline-block;cursor:pointer'>"+this.name+"</span>").appendTo($("#div_active_types"));
			});
			$("<span style='width:100px;height:100px;display:inline-block;cursor:pointer'>定制</span>").appendTo($("#div_active_types"));
		});
	});
	seajs.use('tag',function(active){
		active.loadTopicTags({targetType:'topic',targetId:'54fc1ba1a826495e24ca2d71'},function(err,data){
			$(data).each(function(){
				$("<span style='padding:5px'>"+this.content+"</span>").appendTo($("#div_topic_tags"));
			});
			
		});
	});
</script>
</html>