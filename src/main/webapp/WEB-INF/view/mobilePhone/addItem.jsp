<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/4/30
  Time: 23:07
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
                        <h4 class="panel-title">添加商品</h4>
                    </div>

                </div>
                <!-- End .panel -->


                <form:form commandName="Item"  action="saveItem" method="post" class="form-horizontal" enctype="multipart/form-data">>
                    <fieldset>
                        <div id="legend" class="">
                            <legend class="">添加商品</legend>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label" >标题</label>
                            <div class="controls">
                                <form:errors path="title" />
                                <form:input path="title" id="title" class="input-xlarge"/>
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label" >买点</label>
                            <div class="controls">
                                <form:errors path="sellPoint" />
                                <form:input path="sellPoint" id="sellPoint" class="input-xlarge"/>
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label" >价格</label>
                            <div class="controls">
                                <form:errors path="price" />
                                <form:input path="price" id="price" class="input-xlarge"/>
                                <p class="help-block"></p>
                            </div>
                        </div>

                        <div class="control-group">

                            <!-- Text input-->
                            <label class="control-label" >数量</label>
                            <div class="controls">
                                <form:errors path="num" />
                                <form:input path="num" id="num" class="input-xlarge"/>
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">图片上传</label>
                            <div class="controls">
                                <input type="file" name="images[0]">
                            </div>
                        </div>
                        <div class="control-group">

                            <!-- Select Basic -->
                            <label class="control-label">选择种类</label>
                            <div class="controls">
                                <form:select path="cid" items="${list}" itemValue="id" itemLabel="name">

                                </form:select>
                            </div>

                        </div>

                        <div class="control-group">
                            <input type="submit" value="Submit" />
                        </div>
                    </fieldset>
                </form:form>
            </div>
            <!-- col-lg-12 end here -->
        </div>

    </div>
    <!-- End .content-wrapper -->
    <div class="clearfix"></div>
    </div>

</body>
</html>