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

  <link href="js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
  <link href="js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
  <link rel="stylesheet" href="js/data-tables/DT_bootstrap.css" />

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  
  <script src="js/d3.v3.min.js"></script>
  <style>
body {
  font: 10px sans-serif;
}

.axis path,
.axis line {
  fill: none;
  stroke: #000;
  shape-rendering: crispEdges;
}

.x.axis path {
//  display: none;
}

.line {
  fill: none;
  stroke: steelblue;
  stroke-width: 1.5px;
}

</style>

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
                            <li><a href="login.jsp"><i class="fa fa-sign-out"></i> 退出</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <!--notification menu end -->

            </div>
            <!-- header section end-->

            <!-- page heading start-->
        <div class="page-heading">
            <h3>
                评价项目
                <s:a href="./queryproj.jsp">
            								 <button class="btn btn-primary">
                           					 	返回 
											 </button>
											  </s:a>
            </h3>
            
        </div>
        <!-- page heading end-->

        <div class="wrapper">
         <span><font color=black size=6>
			<center><s:property value="#session.datahead.MonitorItem"/>
        	<s:date name="#session.datahead.MonitorDateTime"  format="yyyy-MM-dd" nice="false"  /> 至
       		<s:date name="#session.dataend.MonitorDateTime"  format="yyyy-MM-dd" nice="false"  />
        	统计图</center>
        	</font> </span>
        	<chart>
        	</chart>
            
		</div>
		<!-- page heading start-->
        
        <!-- page heading end-->
        <script>

var margin = {top: 20, right: 80, bottom: 30, left: 50},
    width = 960 - margin.left - margin.right,
    height = 500 - margin.top - margin.bottom;

var parseDate = d3.time.format("%-m/%-d/%Y %-H:%M:%S").parse;

var x = d3.time.scale()
    .range([0, width]);

var y = d3.scale.linear()
    .range([height, 0]);

var color = d3.scale.category10();

var xAxis = d3.svg.axis()
    .scale(x)
    .orient("bottom");

var yAxis = d3.svg.axis()
    .scale(y)
    .orient("left");

var line = d3.svg.line()
    .interpolate("basis")
    .x(function(d) { return x(d.date); })
    .y(function(d) { return y(d.value); });

var svg = d3.select("chart").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
  .append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

d3.csv("test.csv", function(error, data) {
  if (error) throw error;

  data.forEach(function(d) {
    d.datetime = d.MonitorDate + " " + d.MonitorTime;
    console.log(d.datetime);
    d.MonitorDate = parseDate(d.datetime);
    console.log(d.datetime);
  });

  var cities = [
  {
    name: "数据",
    values: data.map(d => ({ date: d.MonitorDate, value: d.Data1}))
  },
  {
  	name: "平均值",
    values: data.map(d => ({ date: d.MonitorDate, value: d.Data2}))
  }
  ];
  console.log(cities);

  x.domain(d3.extent(data, function(d) { return d.MonitorDate; }));

  y.domain([
    d3.min(cities, function(c) { return d3.min(c.values, function(v) { return v.value; }); }),
    d3.max(cities, function(c) { return d3.max(c.values, function(v) { return v.value; }); })
  ]);

  svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis);

  svg.append("g")
      .attr("class", "y axis")
      .call(yAxis)
    .append("text")
      .attr("transform", "rotate(-90)")
      .attr("y", 6)
      .attr("dy", ".71em")
      .style("text-anchor", "end");

  var city = svg.selectAll(".city")
      .data(cities)
    .enter().append("g")
      .attr("class", "city");

  city.append("path")
      .attr("class", "line")
      .attr("d", function(d) { return line(d.values); })
      .style("stroke", function(d) { return color(d.name); });

  city.append("text")
      .datum(function(d) { return {name: d.name, value: d.values[d.values.length - 1]}; })
      .attr("transform", function(d) { return "translate(" + 
        x(d.value.date) + "," + y(d.value.value) + ")"; })
      .attr("x", 3)
      .attr("dy", ".35em")
      .text(function(d) { return d.name; });
});

</script>

        <!--body wrapper start-->
        <div class="wrapper">
        <div class="row">
        <div class="col-sm-12">
        <section class="panel">
        <header class="panel-heading">
            监测数据
           
        </header>
        <div class="panel-body">
        <div class="adv-table">
        <table  class="display table table-bordered table-striped" id="dynamic-table">
        <thead>
        <tr>
            <th>监测点名</th>
            <th>监测数据名</th>
            <th>监测时间</th>
            <th>监测数据</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#session.datalist" id="list">
        	<tr>
        		<td><s:property value="monitorName" /> </td>
        		<td><s:property value="monitorItem" /> </td>
        		<td>
        		<s:date name="monitorDateTime"  format="yyyy-MM-dd HH:mm:ss" nice="false"  />
        			
        			<s:property value="monitorTime" />        		
        		 </td>
        		<td><s:property value="data" /> </td>
        		
        	</tr>
        </s:iterator>
        </tbody>
        
        </table>
        </div>
        </div>
        </section>
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


</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<!--dynamic table-->
<script type="text/javascript" language="javascript" src="js/advanced-datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/data-tables/DT_bootstrap.js"></script>
<!--dynamic table initialization -->
<script src="js/dynamic_table_init.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>


</body>
</html>

