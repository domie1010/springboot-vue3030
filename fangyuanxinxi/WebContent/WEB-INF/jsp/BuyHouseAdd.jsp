<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
   String path = request.getContextPath();
   String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href=" css/css/background/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="css/css/background/css/select.css" rel="stylesheet"
	type="text/css" />
<link href="js/js/background/js/laydate/need/laydate.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="js/js/background/js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/js/background/js/jquery.js"></script>
<script type="text/javascript"
	src="js/js/background/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="js/js/background/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="js/js/background/editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>

<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 250			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>


	<div class="formbody">


		<div id="usual1" class="usual">

			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">发布信息</a></li>
				</ul>
			</div>

			<div id="tab1" class="tabson">

				<div class="formtext">
					Hi，<b>${sessionScope['Admin']['userName']}</b>，欢迎您使用信息编辑功能！
				</div>

				<!-- form表单 -->

				<form action="house/informationAdd" method="POST" enctype="multipart/form-data"
					onsubmit="return checkSubmit();">
					<input type="hidden" name="user_id" value="${sessionScope['Admin']['id'] }">
					<input type="hidden" name="typee" value="1">
					<ul class="forminfo">
						<li><label>房屋名称<b>*</b></label><input id="name" 
							name="name" type="text" class="dfinput" placeholder="请填写房屋名称"
							style="width: 518px;" /></li>
						<li><label>房屋地址<b>*</b></label><input id="address" 
							name="address" type="text" class="dfinput" placeholder="请填写房屋地址"
							style="width: 518px;" /></li>
						<li><label>房屋大小<b>*</b></label><input id="size" 
							name="size" type="text" class="dfinput" placeholder="请填写房屋大小"
							style="width: 518px;" /></li>
						<li><label>户主<b>*</b></label><input id="owner" 
							name="owner" type="text" class="dfinput" placeholder="请填写户主"
							style="width: 518px;" /></li>
						<li><label>所属楼盘<b>*</b></label><div class="vocation">
							<select name="base_id" class="select3">
								<c:forEach items="${houseBaseList }" var="houseBase">
									<option value="${houseBase['id'] }">${houseBase['name'] }</option>
								</c:forEach>
							</select></div>
						</li>
						<li><label>价格<b>*</b></label><input id="price" 
							name="price" type="text" class="dfinput" placeholder="请填写价格"
							style="width: 518px;" /></li>
						<li><label>详情<b>*</b></label><textarea name="remark" id="content7"></textarea></li>
						<li><label>上传照片<b>*</b></label><input type="file" id="file" name="file"></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="添加信息" /></li>
					</ul>

				</form>
			</div>

		</div>

		<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>

		<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>





	</div>


</body>
<script type="text/javascript"> 
var birth = {
		  elem: '#birth',
		  format: 'YYYY-MM-DD',
		  min: '1900-01-01', //设定最小日期为当前日期
		  max: '2099-06-16', //最大日期
		  istime: true,
		  istoday: false,
		  choose: function(datas){
		     end.min = datas; //开始日选好后，重置结束日的最小日期
		     end.start = datas //将结束日的初始值设定为开始日
		  }
		};
		laydate(birth);
    var checkSubmitFlg = false; 
    function checkSubmit() { 
      if (checkSubmitFlg == true) { 
         return false; 
      } 
      var name = $("#name").val();
      var address = $("#address").val();
      var price = $("#price").val();
      var owner = $("#owner").val();
      var size = $("#size").val();
      var file = $("#file").val();
		if(!$.trim(name)){
			alert('请输入房屋名称!');
			return false;
		}
		if(!$.trim(address)){
			alert('请输入房屋地址!');
			return false;
		}
		if(!$.trim(size)){
			alert('请输入房屋大小!');
			return false;
		}
		if(!$.trim(price)){
			alert('请输入房屋价格!');
			return false;
		}
		if(!$.trim(owner)){
			alert('请输入户主!');
			return false;
		}
		if(!$.trim(file)){
			alert('请上传照片!');
			return false;
		}
      checkSubmitFlg = true;
      return true; 
   } 
   document.ondblclick = function docondblclick() { 
    window.event.returnValue = false; 
   } 
   document.onclick = function doconclick() { 
       if (checkSubmitFlg) { 
         window.event.returnValue = false; 
       } 
   } 
</script>
</html>
