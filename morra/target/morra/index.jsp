<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>登陆</title>
    <style>
        #bk{
            height: 200px;
            width: 400px;
            margin: auto;
            margin-top: 200px;
        }
        #bt{
            height: 36px;
            width: 193px;
            margin: auto;
        }
        input{
            height: 40px;
            width: 200px;
        }
        #tk{
            height: 90px;
            width: 200px;
            margin: auto;
        }
        #tk div{
            margin-top: 5px;
        }
        #dl a{
            text-decoration: blink;

        }
    </style>
</head>
<body>
<div id="bk">
    <div id="bt">
        <h2>欢迎来到猜拳游戏</h2>
    </div>

    <form action="/user/login" method="post">
        <div id="tk">
            <div>
                <input type="text" placeholder="用户名" name="uname">
            </div>

            <div>
                <input type="password" placeholder="密码" name="password">
            </div>
        </div>
        <div id="dl">
            <a href="game.jsp">登陆</a>
        </div>
        <div id="zc">
            <a href="login.jsp">注册</a>
        </div>
    </form>
</div>

</body>

</html>
