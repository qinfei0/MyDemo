<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>WebSocket 客户端</title>
</head>

<body>
<div>
    <div style="border: 1px red solid; width: 100px; height: 100px">页面刷新</div>
</div>
<script src="jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    var socket;
    if(typeof(WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    }else{
        console.log("您的浏览器支持WebSocket");

        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        socket = new WebSocket("ws://localhost:8080/websocket");
        //打开事件
        socket.onopen = function() {
            console.log("Socket 已打开");
        };
        //获得消息事件
        socket.onmessage = function(msg) {
            console.log(msg.data);
            //发现消息进入    调后台获取
            //getCallingList();
        };
        //关闭事件
        socket.onclose = function() {
            console.log("Socket已关闭");
        };
        //发生了错误事件
        socket.onerror = function() {
            alert("Socket发生了错误");
        }

        //关闭连接
        function closeWebSocket() {
            socket.close();
        }

        //发送消息
        function send() {
            var message = document.getElementById('text').value;
            socket.send(message);
        }
    }
</script>
</body>

</html>
