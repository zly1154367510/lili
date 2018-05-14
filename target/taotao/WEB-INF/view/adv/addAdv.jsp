<%--
  Created by IntelliJ IDEA.
  User: zly11
  Date: 2018/5/12
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>添加广告</title>
</head>
<body>
    <jsp:include page="../static/public/public.jsp"/>
    <div class="row">
        <div class="col-lg-12">

        </div>
    </div>


        <!-- Start .content-wrapper -->


        <div class="row">
            <div class = "col-lg-12">
                <!-- col-lg-12 start here -->
                <div class="panel panel-default plain toggle panelClose panelRefresh">
                    <!-- Start .panel -->
                    <div class="panel-heading white-bg">
                        <h4 class="panel-title">添加广告</h4>
                    </div>

                </div>
                <!-- End .panel -->content


                <form:form commandName="content"  action="addAdvDo" method="post" class="form-horizontal" enctype="multipart/form-data">
                    <fieldset>
                        <div id="legend" class="">
                            <legend class="">添加广告</legend>
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
                            <label class="control-label" >点击跳转url</label>
                            <div class="controls">
                                <form:errors path="url" />
                                <form:input path="url" id="num" class="input-xlarge"/>
                                <p class="help-block"></p>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">图片上传</label>
                            <div class="controls">
                                <input type="file" name="images">
                            </div>
                        </div>
                        <div class="control-group">

                            <!-- Select Basic -->
                            <label class="control-label">广告位</label>
                            <div class="controls">
                                <form:select path="categoryId" items="${list}" itemValue="id" itemLabel="name">

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
    <!-- End .content-wrapper -->
    <div class="clearfix"></div>
</div>
</body>
</html>
