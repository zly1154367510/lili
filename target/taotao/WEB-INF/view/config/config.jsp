<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/14
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .row{
            position: absolute;
            left:15%;
        }
    </style>
</head>
<body>
    <jsp:include page="../static/public/public.jsp"/>
    <div class="row">
    <div class="col-lg-12">

    </div>
    </div>
    <div class="row" align="left">
        <div class = "col-lg-12">
            <!-- col-lg-12 start here -->
            <div class="panel panel-default plain toggle panelClose panelRefresh">
                <!-- Start .panel -->
                <div class="panel-heading white-bg">
                    <h4 class="panel-title">添加广告</h4>
                </div>

            </div>
            <!-- End .panel -->


            <form  action="editConfigDo" method="post" class="form-horizontal" enctype="multipart/form-data">
                <fieldset>
                    <div id="legend" class="">
                        <legend class="">参数设置</legend>
                    </div>
                    <input type="hidden" value="${listLen}" name="paramNum">
                    <c:forEach items="${list}" var="item">
                        <div class="control-group">
                            <!-- Text input-->
                            <label class="control-label" >标题</label>
                            <div class="controls">
                                ${item.configName}:
                                <input path="title" name="${item.id}" value="${item.configValue}" id="title" class="input-xlarge"/>
                                <p class="help-block"></p>
                            </div>
                        </div>
                    </c:forEach>


                    <div class="control-group">
                        <input type="submit" value="Submit" />
                    </div>
                </fieldset>
            </form>
        </div>
        <!-- col-lg-12 end here -->


    </div>
</body>
</html>
