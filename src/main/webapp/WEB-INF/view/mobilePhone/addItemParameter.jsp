<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/3
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加手机手机列表</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
    <script  type="text/javascript"  src="static/js/addItem.js"></script>

</head>
<body>
<jsp:include page="../static/public/public.jsp"/>
<div class="row">
    <div class="col-lg-12">

    </div>
</div>

<div id="content">
    <!-- Start .content-wrapper -->


    <div class="row">
        <div class = "col-lg-12">
            <!-- col-lg-12 start here -->
            <div class="panel panel-default plain toggle panelClose panelRefresh">
                <!-- Start .panel -->
                <div class="panel-heading white-bg">
                    <h4 class="panel-title">定制商品${item.title}参数</h4>
                </div>

            </div>
            <!-- End .panel -->


            <form action="addItemParameterDo" method="post">
                <fieldset>
                    <input type="hidden" value="${item.id}" name="itemId">
                    <div id="legend" class="">
                        <legend class="">正在定制${item.title}的参数</legend>
                    </div>

                    <div class="control-group">

                        <!-- Text input-->
                        <label class="control-label" >标题</label>
                        <div class="controls">

                            <p class="help-block"></p>
                        </div>
                    </div>
                    <c:forEach items="${groupList}" var="item">
                        <h2>${item.groupName}</h2>
                        <c:set value="${item.itemParanKeyList}" var="h"/>
                        <c:forEach items="${h}" var="item2">
                            <label class="control-label">${item2.paramName}</label>
                            <input type="hidden" value="${item2.id}" name="paranKey">
                            <c:set var="salary" scope="session" value="${3000}"/>
                            <c:forEach items="${paramValueList}" var="item3">
                                <c:choose>
                                    <c:when test="${item3.paramId==item2.id}">
                                        <input type="text" class="input-xlarge" name="paramValue" value="${item3.paramValue}" />
                                        ${item2.id}
                                        <c:set var="salary" scope="session" value="${1000}"/>
                                    </c:when>

                                </c:choose>
                            </c:forEach>
                            <c:if test="${salary > 2000}">
                                <input type="text" class="input-xlarge" name="paramValue"  />
                                <c:set var="salary" scope="session" value="${3000}"/>
                            </c:if>
                            <br>
                        </c:forEach>
                    </c:forEach>


                    <div class="control-group">
                        <input type="submit" value="Submit" />
                    </div>
                </fieldset>
            </form>
        </div>
        <!-- col-lg-12 end here -->
    </div>

</div>
<!-- End .content-wrapper -->
<div class="clearfix"></div>
</div>

</body>

</html>
