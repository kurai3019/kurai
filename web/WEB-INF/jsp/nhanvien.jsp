<%-- 
    Document   : table
    Created on : Apr 3, 2018, 6:25:16 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .modal-header, h4, .close {
      background-color: #5cb85c;
      color:white !important;
      text-align: center;
      font-size: 30px;
  }
  .modal-content{      margin-top: 220px;
                      width: 800px;
}
  .modal-footer {
      background-color: #f9f9f9;
  }
  .form-group {width:  345px; margin-left: 50px;}
  .cot2{float:left}
  
  </style>
    
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Quản lý nhân sự - PS05549</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">
            <base href="${pageContext.servletContext.contextPath}/">
            
    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="../../assets/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
    <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
    <link rel="stylesheet" href="assets/scss/style.css">
    
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

</head>
<body>
  <!-- Trigger the modal with a button -->
<script>
function myFunction() {
    var x = document.getElementById("myDate").value;
    document.getElementById("demo").innerHTML = x;
}
</script>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog" >
      <div class="modal-dialog" >
    
      <!-- Modal content-->
      <div class="modal-content row" id="main" style="  margin-left: -40px;                     width: 900px;" >
        <div class="modal-header" style="padding:20px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px ;">
            <form action="student99/btnInsert3.html" method="post" enctype="multipart/form-data" >
                  <div class="row">

            <div class="form-group">
                <label for="usrname"><span class="glyphicon glyphicon-user"></span> ID nhân viên </label> <b style="color:red">(*)</b>
              <input name="id"  class="form-control" id="my1" placeholder="Nhập mã nhân viên" />
            </div>
                       
                     
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Tên nhân viên</label> <b style="color:red">(*)</b>
              <input name="name"  class="form-control" id="my2" placeholder="Nhập tên nhân viên"/>
            </div>
             
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Giới tính</label><b style="color:red">(*)</b><br>
              <input style="margin-left: 110px;" type="radio" name="gender" value="1" checked=""> Nam
                <input style="margin-left: 10px;" type="radio" name="gender" value="0"> Nữ<br>
            </div>
                      
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Ngày sinh</label><b style="color:red">(*)</b>
              <input name="birthday" type="date" class="form-control" id="myDate" value="1998-01-03" min="1950-01-01" max="2017-01-1" placeholder="Nhập ngày sinh"/>
            </div> 
              <div style="width:740px " class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Hình</label>
              <input  		type="file" name="image" class="form-control" id="my2" onchange="readURL(this);" /><br>
          <img style="margin-left: 300px" id="blah" width="130px" height="168px" src="images/NoneIMG.png" />

            </div> 

    <div class="w-100"></div>

                
              <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Email</label><b style="color:red">(*)</b>
              <input name="email"  class="form-control" id="my2" placeholder="Nhập Email"/>
            </div> 
              <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Số điện thoại</label>
              <input name="phone"  class="form-control" id="my2" placeholder="Nhập SĐT"/>
            </div>
              <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Lương</label><b style="color:red">(*)</b>
              <input name="salary"  class="form-control" id="my2" placeholder="Nhập lương"/>
            </div> 
          
              <div class="form-group">
                  
                  <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Mã phòng ban</label><b style="color:red">(*)</b><br>
<select style="width: 345px ; height: 34px" name="departid" 
                itemLabel="name" itemValue="id">
                                <c:forEach var="rows" items="${listDeparts}">
                             <option value="${rows.id}">${rows.id}</option>
                         
                                                                </c:forEach>   

</select>


              </div> 
        <div style="width: 740px " class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Ghi chú</label>
              <input name="notes"  class="form-control" id="my2" placeholder="Nhập ghi chú"/>
            </div> 
              <button style="height:  50px; width: 740px; margin-left: 50px" type="submit" class="btn btn-success btn-block " ><span class="glyphicon glyphicon-plus"></span> Thêm</button>
          </form>
            
            
            
   
            
            
            
            
            
            
                                       </div>

            
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
   </div>
   </div> 
  
  
    <div class="modal fade" id="myModal2" role="dialog" >
      <div class="modal-dialog" >
    
      <!-- Modal content-->
      <div class="modal-content row" id="main" style="  margin-left: -40px;                     width: 900px;" >
        <div class="modal-header" style="padding:20px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px ;">
            <form action="student99/btnUpdate3.html" method="post" enctype="multipart/form-data" >
                  <div class="row">

            <div class="form-group">
                <label for="usrname"><span class="glyphicon glyphicon-user"></span> ID nhân viên </label> <b style="color:red">(*)</b>
                <input name="id"  class="form-control" id="my1" value="${id}" placeholder="Nhập mã nhân viên" readonly="true"/>
            </div>
                       
                     
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Tên nhân viên</label> <b style="color:red">(*)</b>
              <input name="name"  value="${name}" class="form-control" id="my2" placeholder="Nhập tên nhân viên"/>
            </div>
             
            <div class="form-group">
                
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Giới tính</label><b style="color:red">(*)</b><br>
              <input style="margin-left: 110px;" type="radio" name="gender" value="1" ${nam} > Nam
                <input style="margin-left: 10px;" type="radio" name="gender" value="0" ${nu}> Nữ<br>
            </div>
                      
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Ngày sinh</label><b style="color:red">(*)</b>
              <input name="birthday" type="date" class="form-control" id="myDate" value="1998-01-03" min="1950-01-01" max="2017-01-1" placeholder="Nhập ngày sinh"/>
            </div> 
              <div style="width:740px " class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Hình</label>
            
              <input type="file" name="image" class="form-control" accept="image/*" onchange="loadFile(event)"><br>
<img style="margin-left: 300px" width="130px" height="168px"src="${photo}" id="output"/>
            </div> 

    <div class="w-100"></div>

                
              <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Email</label><b style="color:red">(*)</b>
              <input name="email" value="${email}" class="form-control" id="my2" placeholder="Nhập Email"/>
            </div> 
              <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Số điện thoại</label>
              <input name="phone" value="${phone}" class="form-control" id="my2" placeholder="Nhập SĐT"/>
            </div>
              <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Lương</label><b style="color:red">(*)</b>
              <input name="salary" value="${salary}" class="form-control" id="my2" placeholder="Nhập lương"/>
            </div> 
          
              <div class="form-group">
                  <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Mã phòng ban</label><b style="color:red">(*)</b><br>
<select style="width: 345px ; height: 34px" name="departid" 
                itemLabel="name" itemValue="id"> 
    
                                 <option value="${departid}">${departid}</option>

                               <c:forEach var="rows" items="${listDeparts}">
                             <option value="${rows.id}">${rows.id}</option>
                         
                                                                </c:forEach>   

</select>


              </div> 
        <div style="width: 740px " class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Ghi chú</label>
              <input name="notes"  class="form-control" id="my2" value="${notes}" placeholder="Nhập ghi chú"/>
            </div> 
              <button style="height:  50px; width: 740px; margin-left: 50px" type="submit" class="btn btn-success btn-block " ><span class="glyphicon glyphicon-plus"></span> Sửa</button>
          </form>
            
            
            
   
            
            
            
            
            
            
                                       </div>

            
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
   </div>
   </div> 
  
  

 
            
            
 <div class="modal fade" id="myModal3" role="dialog" >
      <div class="modal-dialog" >
    
      <!-- Modal content-->
      <div class="modal-content row" id="main" style="  margin-left: -40px;                     width: 900px;" >
        <div class="modal-header" style="padding:20px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px ;">
            <form  method="post" action="student99/danhgia.html" >
                <label style="margin-left: 250px" for="usrname"></span> Khen thưởng nhân viên: <b style="color:red">${name}</b> </label>
                                                <br>                                                <br>
                                        <input type="hidden" name="email" value="${email}"/>
                  <input type="hidden" name="id" value="${id}"/>
                  <input type="hidden" name="name" value="${name}"/>

                <div class="row">

            <div class="form-group">
                <label for="usrname"><span class="fa fa-smile-o	"></span> Lý do khen thưởng: </label>
                <select name="lydo1" class="form-control">
                    <option value="">Lý do khác</option>
                    <option value="Có thành tích tốt">Có thành tích tốt</option>
                    <option value="Siêng năng, chăm chỉ">Siêng năng, chăm chỉ</option>
                    <option value="Làm tốt việc được giao">Làm tốt việc được giao</option>
                    <option value="Có biểu hiện tốt">Có biểu hiện tốt</option>
                    
                    
                </select>
            </div>
                       
                     
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Ngày khen thưởng: </label> 
                           <input  name="ngay" type="date" class="form-control" id="myDate" value=${date} min="1950-01-01" max="2017-01-1" placeholder="Nhập ngày sinh"/>

            </div>
              <input style="margin-left: 49px;width: 742px" name="lydo2"   class="form-control" id="my2" placeholder="Nhập lý do khác"/>

           
            
                                       </div>
                  <div style="margin-left: 38px" class="form-group">
                  <input id="testName2" type="hidden" name="check" value="aaa"/>

                      <input id="testName" type="checkbox" name="check" value="co" checked="">   Gửi mail đánh giá cho nhân viên này<br>
            </div>


            
        </div>
        <div class="modal-footer">
            <button style=" width: 68px;" type="submit" class="btn btn-success btn-block " onclick="
                    
                    
                    if(document.getElementById('testName').checked) {
    document.getElementById('testName2').disabled = true;
}
                    
                    
                    
                    "><span class="fa fa-thumbs-up"></span> Đồng ý</button>

          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
   </div></form>

   </div>             

 
<div class="modal fade" id="myModal4" role="dialog" >
      <div class="modal-dialog" >
    
      <!-- Modal content-->
      <div class="modal-content row" id="main" style="  margin-left: -40px;                     width: 900px;" >
        <div class="modal-header" style="padding:20px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px ;">
            <form  method="post" action="student99/danhgia2.html" >
                <label style="margin-left: 250px" for="usrname"></span> Khiển trách nhân viên: <b style="color:red">${name}</b> </label>
                                                <br>                                                <br>
                                        <input type="hidden" name="email" value="${email}"/>
                  <input type="hidden" name="id" value="${id}"/>
                  <input type="hidden" name="name" value="${name}"/>

                <div class="row">

            <div class="form-group">
                <label for="usrname"><span class="fa fa-smile-o	"></span> Lý do khiển trách: </label>
                <select name="lydo1" class="form-control">
                    <option value="">Lý do khác</option>
                    <option value="Đi trễ">Đi trễ</option>
                    <option value="Thái độ không tốt">Thái độ không tốt</option>
                    <option value="Không hoàn thành tốt việc được giao">Không hoàn thành tốt việc được giao</option>
                    <option value="Gây mất trật tự">Gây mất trật tự</option>
                    
                    
                </select>
            </div>
                       
                     
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-pencil"></span> Ngày khiển trách: </label> 
                 <input  name="ngay" type="date" class="form-control" id="myDate" value=${date} min="1950-01-01" max="2017-01-1" placeholder="Nhập ngày sinh"/>

            </div>
              <input style="margin-left: 49px;width: 742px" name="lydo2"   class="form-control" id="my2" placeholder="Nhập lý do khác"/>
             
           
            
                                       </div>
                  <div style="margin-left: 38px" class="form-group">
                  <input id="testNamee2" type="hidden" name="check2" value="aaa"/>

                      <input id="testNamee" type="checkbox" name="check2" value="co" checked="">   Gửi mail khiển trách cho nhân viên này<br>
            </div>


            
        </div>
        <div class="modal-footer">
            <button style=" width: 68px;" type="submit" class="btn btn-success btn-block " onclick="
                    
                    
                    if(document.getElementById('testNamee').checked) {
    document.getElementById('testNamee2').disabled = true;
}
                    
                    
                    
                    "><span class="fa fa-thumbs-up"></span> Đồng ý</button>

          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        </div>
      </div>
   </div></form>

   </div>             
                  
                  
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();

       
            
        
    });
    

    
    
    
   $(".myBtn2").click(function(){
        $("#myModal2").modal();

    });   

      $(".myBtn3").click(function(){
        $("#myModal3").modal();

    });      

     $(".myBtn4").click(function(){
        $("#myModal4").modal();

    });        
        
});

function readURL(input) {

  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      $('#blah').attr('src', e.target.result);
    }
    
    reader.readAsDataURL(input.files[0]);
  }
}
function readURL2(input) {

  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      $('#blah2').attr('src', e.target.result);
    }
    
    reader.readAsDataURL(input.files[0]);
  }
}
$("#image").change(function() {
  readURL(this);
});
  var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
  };


</script>

<c:if test="${messa == 1}">
    <script>
            $("#myModal2").modal();
            
</script>
</c:if>
<c:if test="${danhgia == 1}">
    <script>
            $("#myModal3").modal();
            
</script>
</c:if>

<c:if test="${danhgia2 == 1}">
    <script>
            $("#myModal4").modal();
            
</script>
</c:if>



    
        <!-- Left Panel -->

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="student99/index.html"><img src="images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="student99/index.html"> <i class="menu-icon fa fa-dashboard"></i>Trang chủ </a>
                    </li>
                    <h3 class="menu-title">UI elements</h3><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="ui-buttons.html">Buttons</a></li>
                            <li><i class="fa fa-id-badge"></i><a href="ui-badges.html">Badges</a></li>
                            <li><i class="fa fa-bars"></i><a href="ui-tabs.html">Tabs</a></li>
                            <li><i class="fa fa-share-square-o"></i><a href="ui-social-buttons.html">Social Buttons</a></li>
                            <li><i class="fa fa-id-card-o"></i><a href="ui-cards.html">Cards</a></li>
                            <li><i class="fa fa-exclamation-triangle"></i><a href="ui-alerts.html">Alerts</a></li>
                            <li><i class="fa fa-spinner"></i><a href="ui-progressbar.html">Progress Bars</a></li>
                            <li><i class="fa fa-fire"></i><a href="ui-modals.html">Modals</a></li>
                            <li><i class="fa fa-book"></i><a href="ui-switches.html">Switches</a></li>
                            <li><i class="fa fa-th"></i><a href="ui-grids.html">Grids</a></li>
                            <li><i class="fa fa-file-word-o"></i><a href="ui-typgraphy.html">Typography</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children active dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Bảng</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="student99/showall2.html">Quản lý phòng ban</a></li>
                            <li><i class="fa fa-table"></i><a href="student99/showall3.html">Quản lý nhân viên</a></li>
                            <li><i class="fa fa-table"></i><a href="student99/diem.html">Điểm</a></li>                      </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="forms-basic.html">Basic Form</a></li>
                            <li><i class="menu-icon fa fa-th"></i><a href="forms-advanced.html">Advanced Form</a></li>
                        </ul>
                    </li>


                    <li class="menu-item-has-children dropdown">
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="font-fontawesome.html">Font Awesome</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="font-themify.html">Themefy Icons</a></li>
                        </ul>
                    </li>
                    <li>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-line-chart"></i><a href="charts-chartjs.html">Chart JS</a></li>
                            <li><i class="menu-icon fa fa-area-chart"></i><a href="charts-flot.html">Flot Chart</a></li>
                            <li><i class="menu-icon fa fa-pie-chart"></i><a href="charts-peity.html">Peity Chart</a></li>
                        </ul>
                    </li>

                    <li class="menu-item-has-children dropdown">
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-map-o"></i><a href="maps-gmap.html">Google Maps</a></li>
                            <li><i class="menu-icon fa fa-street-view"></i><a href="maps-vector.html">Vector Maps</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="page-login.html">Login</a></li>
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="page-register.html">Register</a></li>
                            <li><i class="menu-icon fa fa-paper-plane"></i><a href="pages-forget.html">Forget Pass</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->

    <!-- Left Panel -->

    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <header id="header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

     


                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="user-area dropdown float-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                        </a>

                        <div class="user-menu dropdown-menu">
                                <a class="nav-link" href="#"><i class="fa fa- user"></i>My Profile</a>

                                <a class="nav-link" href="#"><i class="fa fa- user"></i>Notifications <span class="count">13</span></a>

                                <a class="nav-link" href="#"><i class="fa fa -cog"></i>Settings</a>

                                <a class="nav-link" href="#"><i class="fa fa-power -off"></i>Logout</a>
                        </div>
                    </div>

                    <div class="language-select dropdown" id="language-select">
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown"  id="language" aria-haspopup="true" aria-expanded="true">
                            <i class="flag-icon flag-icon-vn"></i>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="language" >
                            <div class="dropdown-item">
                                <span class="flag-icon flag-icon-fr"></span>
                            </div>
                            <div class="dropdown-item">
                                <i class="flag-icon flag-icon-es"></i>
                            </div>
                            <div class="dropdown-item">
                                <i class="flag-icon flag-icon-us"></i>
                            </div>
                            <div class="dropdown-item">
                                <i class="flag-icon flag-icon-it"></i>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </header><!-- /header -->
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Quản lý phòng ban</h1>
                        
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="page-header float-right">
                    <div class="page-title">
                        <ol class="breadcrumb text-right">
                            <li><a href="#">Trang chủ</a></li>
                            <li><a href="#">Bảng</a></li>
                            <li class="active">Phòng ban</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Phòng ban</strong>
                            
                        </div>
                        <div class="card-body">
                    <table id="bootstrap-data-table" class="table table-striped table-bordered">
                        <b style="margin-left:50px ;color:red"> ${uid}</b>
                        
                      <button type="button" style="font-size: 20px; margin-left: 1100px" class="btn btn-default btn-lg" onclick="document.getElementById('my1').value = ''; document.getElementById('my2').value = ''" id="myBtn"><span class="glyphicon glyphicon-plus">    </span>  Thêm mới</button>
                      <hr>
                        <thead>
                        
                      <tr>
                        <th style="width: 5px">ID</th>
                        <th>Tên nhân viên</th>
                        <th style="width: 5px">Giới tính</th>
                        <th>Ngày sinh</th>
                        <th>Hình ảnh</th>
                        <th>Mail</th>
                        <th>SĐT</th>
                        <th>Lương</th>
                        <th style="width: 100px">Ghi chú</th>
                        <th>Mã phòng ban</th>

                          <th>Chức năng</th>

               
                      </tr>
                    </thead>
                    <tbody>
                                <c:forEach var="rows" items="${listStaffs}">
            <form action="student99/delete2.html">
     
                      <tr>
                <td>${rows.id}</td>
                <td>${rows.name}</td>
                <td>${rows.gender?"Nam":"Nữ"}</td>
                <td>${rows.birthday}</td>
                <td>	<img src="${rows.photo}"  width="140px" height="168px"> </td>
                <td>${rows.email}</td>
                <td>${rows.phone}</td>
                <td>${rows.salary}</td>
                <td>${rows.notes}</td>
                <td>${rows.departid}</td>
                

                <c:url var="edit3" value="student99/edit3.html">

                    <c:param name="txtID" value="${rows.id}"/>
                    <c:param name="txtName" value="${rows.name}"/>
                    <c:param name="txtgender" value="${rows.gender}"/> 
                    <c:param name="txtbirthday" value="${rows.birthday}"/>   
                    <c:param name="txtphoto" value="${rows.photo}"/>   
                    <c:param name="txtemail" value="${rows.email}"/>                       
                    <c:param name="txtphone" value="${rows.phone}"/>   
                    <c:param name="txtsalary" value="${rows.salary}"/>   
                    <c:param name="txtnotes" value="${rows.notes}"/>   
                    <c:param name="txtdepartid" value="${rows.departid}"/>   
                    
                    
                 </c:url>
                <c:url var="goidanhgia" value="student99/goidanhgia.html">

                    <c:param name="txtID" value="${rows.id}"/>
                    <c:param name="txtName" value="${rows.name}"/>                       
  
                    <c:param name="txtemail" value="${rows.email}"/>                       

                    
                    
                 </c:url>                
                
           <c:url var="goidanhgia2" value="student99/goidanhgia2.html">

                    <c:param name="txtID" value="${rows.id}"/>
                    <c:param name="txtName" value="${rows.name}"/>                       
  
                    <c:param name="txtemail" value="${rows.email}"/>                       

                    
                    
                 </c:url>                 
                
                                    <c:url var="delete3" value="student99/delete3.html">
        <c:param name="txtID" value="${rows.id}"/>
                    <c:param name="txtName" value="${rows.name}"/>
                </c:url>                

                <td> <!-- <a class="myBtn btn btn-success btn-xs" ><i class="fa fa-check"></i></a> -->  
                    
               <a  class="myBtn2 btn btn-primary btn-xs" href="${edit3}" ><i class="fa fa-pencil"></i></a>   

         <input type="hidden" name="txtID" value="${rows.id}"/>
                  <input type="hidden" name="txtName" value="${rows.name}"/>

                  <a class="btn btn-danger btn-xs" href="${delete3}"><i class="fa fa-trash-o "></i></a>   <br><br><br>
                                                <a style="color: white; width: 55px; font-size: 24px" class="btn myBtn3 btn-success btn-xs" href="${goidanhgia}"><i class="fa fa-smile-o"></i></a>   
                                                <a style="color: white; width: 55px;font-size: 24px" class="btn myBtn4  btn-warning btn-xs" href="${goidanhgia2}" ><i class="fa fa-frown-o	"></i></a>   

                       
                </td >
            </tr>
                    </form>
        </c:forEach>   
                    </tbody>
                  </table>
                            
                        </div>
                    </div>
                </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->


    </div><!-- /#right-panel -->

    <!-- Right Panel -->


    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>


    <script src="assets/js/lib/data-table/datatables.min.js"></script>
    
    
    <script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
    <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
    <script src="assets/js/lib/data-table/jszip.min.js"></script>
    <script src="assets/js/lib/data-table/pdfmake.min.js"></script>
    <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
    <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
    
    <script src="assets/js/lib/data-table/datatables-init.js"></script>


    <script type="text/javascript">
        $(document).ready(function() {
          $('#bootstrap-data-table-export').DataTable();
        } );
    </script>


</body>
</html>
