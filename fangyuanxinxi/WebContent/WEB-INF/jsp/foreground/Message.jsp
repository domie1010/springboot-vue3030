<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	 /*
    @Author:Jaylan Zhou
    @Date:
    @projectName:
    @TEL:13166803607
    @QQ:764540631
    */

	/*
	    全路径,形式如下:
	    request.getScheme():获取http协议
	    request.getServerName():获取本地服务器名
	    request.getServerPort():获取服务器端口号
	    path:访问路径
	*/
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
<script type=text/javascript src="js/js/foreground/jquery.min.js"></script>
<title>健康检测系统</title>
</head>
<body>
	<form action="message/informationAddFore" method="post">
	留言内容:<br/>
	<textarea rows="20" cols="200" name="message" id="text" disabled="disabled">${message['message'] }</textarea>
	回复内容:<br/>
	<textarea rows="20" cols="200" name="message" id="text" disabled="disabled">${message['reply_message'] }</textarea>
	</form>
</body>
<script type="text/javascript">
	function check(){
	var text = $("#text").val();
	if(text==null||text==''){
		alert("请输入发布留言!")
		return false();
	}
	return true;
	}
</script>
</html> 