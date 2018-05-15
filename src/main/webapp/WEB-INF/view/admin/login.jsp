<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/15
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Login Form Template</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500"/>
    <link rel="stylesheet" href="http://localhost:8089/assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="http://localhost:8089/assets/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="http://localhost:8089/assets/css/form-elements.css"/>
    <link rel="stylesheet" href="http://localhost:8089/assets/css/style.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"/></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"/></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="http://localhost:8089/assets/ico/favicon.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://localhost:8089/assets/ico/apple-touch-icon-144-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://localhost:8089/assets/ico/apple-touch-icon-114-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://localhost:8089/assets/ico/apple-touch-icon-72-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" href="http://localhost:8089/assets/ico/apple-touch-icon-57-precomposed.png"/>

</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>lili商城</strong> 后台登录</h1>
                    <div class="description">

                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">

                            <p>Enter your username and password to log on:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/admin/loginDo" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">账号</label>
                                <input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码</label>
                                <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <input type="submit" class="btn">登录</input>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>



<!-- Javascript -->
<script src="http://localhost:8089/assets/js/jquery-1.11.1.min.js"/>
<script src="http://localhost:8089/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="http://localhost:8089/assets/js/jquery.backstretch.min.js"></script>
<script src="http://localhost:8089/assets/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="http://localhost:8089/assets/js/placeholder.js"></script>
<![endif]-->

</body>
</html>
