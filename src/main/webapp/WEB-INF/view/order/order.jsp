<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/18
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>订单</title>
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
                    <br>
                    <form action="/getOrder">
                        输入用户名搜索订单:<input name="username" type="text"/>
                        <br>
                        <input type="submit" value="搜索">
                    </form>
                </div>
                <div class="panel-body">
                    <table class="table display" id="datatable">
                        <thead>
                        <tr>
                            <th>选择</th>
                            <th>id</th>
                            <th>金额</th>
                            <th>创建时间</th>
                            <th>用户</th>
                            <th>收货地点</th>
                            <th>收货人姓名</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody>
                        <form action="/delItemDo">
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>
                                        <input type="checkbox" value="${item.id}" name="itemId"></td>
                                    <td>${item.id}</td>
                                    <td>${item.payment}</td>
                                    <td>${item.createTime}</td>
                                    <td>${item.uId}</td>

                                    <td>${item.address}</td>
                                    <td>${item.name}</td>
                                    <td><a>修改</a><a>删除</a></td>
                                </tr>
                            </c:forEach>

                            <tr>
                                <td><input  class="btn" type="submit" value="删除"></td>
                            </tr>
                        </form>
                        </tbody>


                    </table>
                </div>
            </div>
            <!-- End .panel -->
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="http://localhost:8089/getOrder?page=${previousPage}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li>
                        <a href="http://localhost:8089/getOrder?page=${nextPage}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li>
                        <form action="http://localhost:8089/item" method="get">
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
<!-- End .content-wrapper -->

</body>
</html>
