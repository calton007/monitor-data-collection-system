<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>监测信息获取系统</title>

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="boxed-view">

<section>
    <div class="container">
        <!-- left side start-->
        <div class="left-side">

            <!--logo and iconic logo start-->
            <div class="logo">
            <a href="getByUserId.action"><img src="images/logo_icon.png" alt=""></a>
            
            <span><font color=white size=3><b>监测信息获取系统</b></font> </span>
           
        </div>
            <!--logo and iconic logo end-->


            <div class="left-side-inner">

               <!--sidebar nav start-->
                <ul class="nav nav-pills nav-stacked custom-nav">
                    <li><a href="getByUserId.action"><i class="fa fa-home"></i> <span>主页</span></a></li>
                    <li><a href="updateProj.action"><i class="fa fa-laptop"></i> <span>评价项目</span></a>
                    </li>
                    <li><a href=""><i class="fa fa-book"></i> <span>监测任务</span></a>
                    </li>                    
					<li><a href="profile.jsp"><i class="fa fa-user"></i> <span>账户信息</span></a>
					</li>
                    <li><a href="login.jsp"><i class="fa fa-sign-in"></i> <span>退出</span></a></li>

                </ul>
                <!--sidebar nav end-->

            </div>
        </div>
        <!-- left side end-->

        <!-- main content start-->
        <div class="main-content" >

            <!-- header section start-->
            <div class="header-section">

            <!--toggle button start-->
            <a class="toggle-btn"><i class="fa fa-bars"></i></a>
            <!--toggle button end-->

           

            <!--notification menu start -->
            <div class="menu-right">
                <ul class="notification-menu"> 
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <img src="images/photos/user1.png" alt="" />
                            <s:property value="#session.user.employType"/>
                            <s:property value="#session.user.employName"/>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                            <li><a href="profile.jsp"><i class="fa fa-user"></i> 账户信息</a></li>
                            <li><a href="index.jsp"><i class="fa fa-sign-out"></i> 退出</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <!--notification menu end -->

            </div>
            <!-- header section end-->

            <!-- page heading start-->
                 <!-- page heading start-->
        <div class="page-heading">
            <h3>
                账户信息
            </h3>
                       
        </div>
        <!-- page heading end-->

       <div class="wrapper">

            <div class="row">
            	<div class="col-md-2">
            	</div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel">
                                <div class="panel-body">
                                    <div class="profile-pic text-center">
                                        <img alt="" src="images/photos/user1.png">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="panel">
                                <div class="panel-body">
                                    <ul class="p-info">
                                        <li>
                                            <div class="title">员工号</div>
                                            <s:property value="#session.user.employNumber"/>
                                        </li>
                                        <li>
                                            <div class="title">姓名</div>
                                            <s:property value="#session.user.employName"/>
                                        </li>
                                        <li>
                                            <div class="title">职务</div>
                                            <s:property value="#session.user.employType"/>
                                        </li>
                                        <li>
                                            <div class="title">性别</div>
                                            <s:property value="#session.user.sex"/>
                                        </li>
                                        <li>
                                            <div class="title">等级</div>
                                            <s:property value="#session.user.level"/>
                                        </li>
                                        
                                        <li>
                                            <div class="title">部门</div>
                                            <s:property value="#session.user.department"/>
                                        </li>
                                        <li>
                                            <div class="title">小组</div>
                                            <s:property value="#session.user.group"/>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
					</div>
				</div>
			</div>
		</div>


        <!--body wrapper end-->

            <!--footer section start-->
            <footer >
                2016 &copy; 监测信息获取系统   by  李观波
            </footer>
            <!--footer section end-->


        </div>
        <!-- main content end-->
    </div>
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

</body>
</html>

