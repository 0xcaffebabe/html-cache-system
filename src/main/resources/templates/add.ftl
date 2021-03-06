<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="user-scalable=no, width=device-width, minimum-scale=1, maximum-scale=1">

<title>添加item</title>

	<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://www.layuicdn.com/layui-v2.5.6/css/layui.css" rel="stylesheet">
<link href="css/home.css" rel="stylesheet">
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
		<h2>添加item</h2>
		商品名称 <input type="text" id="title">
		<div id="editor" style="padding: 20px"></div>
		<button id="submit">提交</button>

		</p>
		<div style="text-align: -webkit-center;">

		</div>

	</div>


	<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
	<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="https://www.layuicdn.com/layui-v2.5.6/layui.js"></script>
	<script src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
	<script src="https://cdn.bootcdn.net/ajax/libs/axios/0.20.0-0/axios.js"></script>
	<script>
		let E = window.wangEditor
		let editor2 = new E('#editor')
		editor2.create()
		console.log(editor2)
		let title = document.querySelector('#title').value
		document.querySelector("#submit").onclick = function(){
			axios.post(`/item?title=${title}`,{
				data: editor2.txt.html()
			})
		}
	</script>
</body>

</html>