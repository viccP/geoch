<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/ace/css/bootstrap.css" />
<link href="<%=request.getContextPath()%>/pages/css/play.css" rel="stylesheet">

<!-- 加载资源js -->
<link href="<%=request.getContextPath()%>/resource/jplayer/css/player.css" rel="stylesheet" type="text/css" />

<script src="<%=request.getContextPath()%>/resource/jplayer/jquery-1.9.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resource/common/base.js"></script>
<script src="<%=request.getContextPath()%>/resource/jplayer/jquery.jplayer.js"></script>
<script src="<%=request.getContextPath()%>/resource/jplayer/jplayer.cleanskin.js"></script>
<script src="<%=request.getContextPath()%>/resource/ace/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/pages/js/play.js"></script>

<title>主页</title>
</head>
<body>
	<div class="panel panel-primary">
		<div class="panel-body">
			<h3 class="video_name">  </h3>
			<div class="row play-bg">
				<div class="col-md-12 player-container clear-margin-padding" id="playerContainer">
					<div id="uniquePlayer-1" class="webPlayer light clear-margin-padding">
						<div id="uniqueContainer-1" class="videoPlayer clear-margin-padding"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>