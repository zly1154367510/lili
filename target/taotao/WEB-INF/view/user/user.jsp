<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/15
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .banUserForm{
            position: absolute;
            top: 30%;
            left: 30%;
            background-color: #00B0E8;
            display: none;

        }

    </style>
</head>
<body>
<jsp:include page="../static/public/public.jsp"/>

<div id="content">
    <!-- Start .content-wrapper -->


    <div class="row">
        <div class="col-lg-12">
            <!-- col-lg-12 start here -->
            <div class="panel panel-default plain toggle panelClose panelRefresh">
                <!-- Start .panel -->
                <div class="panel-heading white-bg">
                    <h4 class="panel-title">Data table</h4>
                    <h6>一共有${pages}页</h6>
                    当前在${page}页 可以在→选择跳转页面
                </div>
                <div class="panel-body">
                    <table class="table display" id="datatable">
                        <thead>
                        <tr>
                            <th>选择</th>
                            <th>id</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>手机号码</th>
                            <th>email</th>
                            <th>加入时间</th>
                            <th>更新时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>
                                        <input type="checkbox" value="${item.id}" name="itemId"></td>
                                    <td>${item.id}</td>
                                    <td>${item.username}</td>
                                    <td>${item.password}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.email}</td>
                                    <td>${item.created}</td>
                                    <td>${item.updated}</td>
                                    <td class="banBtn" onclick="clickBtn(${item.id})"><a >禁止登陆</a></td>
                                </tr>
                            </c:forEach>
                            <div class="banUserForm">
                                <p><h3>封禁原因</h3></p>
                                <div align="right" ><button onclick="this.hide()">关闭</button></div>
                                    <input type="hidden" name="userId" id="userHidden"/>
                                    <textarea name="banReason" id="reasonText"></textarea>
                                    <input type="button" value="提交" onclick="subReason()"/>
                            </div>

                        </tbody>

                        <tfoot>
                        <tr>
                            <th>id</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>手机号码</th>
                            <th>email</th>
                            <th>加入时间</th>
                            <th>更新时间</th>
                            <th>操作</th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
            <!-- End .panel -->
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="http://localhost:8089/userList?page=${previousPage}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li>
                        <a href="http://localhost:8089/userList?page=${nextPage}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li>
                        <form action="http://localhost:8089/userList" method="get">
                            <div class="input-group" width="20%">
                                <input type="text" class="form-control" name="page" width="20%" placeholder="Search for...">
                                <span class="input-group-btn">
                                            <input class="btn btn-default" type="submit">跳转</input>
                                        </span>
                            </div>
                        </form>

                    </li>
                </ul>
            </nav>
        </div>
        <!-- col-lg-12 end here -->
    </div>


</div>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
//   $(document).ready(function(){
//       function disForm(userid){
//           $(".banBtn").bind("click",{id:id},function(e){
//               alert("点到了")
//               $("#userHidden").val(e.data.id)
//           })
//
//           var form = $(".banUserForm")
//           form.toggle()
//
//       }
//   })
    function clickBtn(e){
        $(".banUserForm").show();
        $("#userHidden").val(e)
    }
    function subReason() {
        var reason = $("#reasonText").val();
        var userId = $("#userHidden").val();
        $.ajax({
            url:"http://localhost:8089/banUser",
            data:{
                "reason":reason,
                "userId":userId
            },
            type:"POST",
            success:function(data){
                if(data != undefined){
                    alert("成功封禁"+userId);
                    location.reload([])
                }
            }
        })
    }
</script>
<!-- End .content-wrapper -->
</body>
</html>
