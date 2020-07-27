<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="user-scalable=no, width=device-width, minimum-scale=1, maximum-scale=1">

<title>静态文件列表</title>

	<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://www.layuicdn.com/layui-v2.5.6/css/layui.css" rel="stylesheet">
<link href="./css/home.css" rel="stylesheet">
<style type="text/css">
.wa {
	width: 100%;
}
</style>

</head>

<body>
	<header id="header">
		<div>
			<a href="" class="download1"> <span
						class="glyphicon glyphicon-plus-sign"></span> <br>发布item
			</a> <a href="/list" class="download1"> <span
						class="glyphicon glyphicon-folder-open"></span> <br>静态文件列表
			</a><a href="https://mashibing.com/#" class="home"> </a> <a href="#"
																		class="api"> <span class="glyphicon  glyphicon-ok-sign"></span>
				<br>文件检查
			</a> <a class="demo" href="#"> <span
						class="glyphicon glyphicon-floppy-disk"></span> <br>系统设置
			</a> <a class="demo" href="#"> <span
						class="glyphicon glyphicon glyphicon-tasks"></span> <br>系统状态
			</a>
		</div>
	</header>

	<div class="content why-hilo">

		<table class="table">
			<tr>
				<td>ID</td>
				<td>标题</td>
			</tr>
			<#list items as item>
				<tr>
					<td>${item.id}</td>
					<td>${item.title}</td>
					<td>
						<button class="btn" onclick="location.href = 'view?id=${item.id}'">动态预览</button>
						<button class="btn" onclick="location.href='//127.0.0.1:9090/${item.id}.html'">查看静态文件</button>
						<button class="btn" onclick="generateHtml(${item.id})">生成静态文件</button>
					</td>
				</tr>
			</#list>
		</table>
		</p>
		<div style="text-align: -webkit-center;">

		</div>

	</div>


	<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
	<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://www.layuicdn.com/layui-v2.5.6/layui.js"></script>
	<script src="https://cdn.bootcdn.net/ajax/libs/axios/0.20.0-0/axios.js"></script>
	<script>
		function generateHtml(id){
			axios.post('generate/'+id)
			.then(res =>{
				alert(res.data);
			})
		}
	</script>
</body>

</html>