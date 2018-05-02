<%-- 
    Document   : login
    Created on : Apr 3, 2018, 2:37:19 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sufee Admin - HTML5 Admin Template</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
    <link rel="stylesheet" href="assets/scss/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

</head>
<body class="bg-dark">
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script>
          $(function () {

    if (localStorage.chkbox && localStorage.chkbox != '') {
        $('#rememberChkBox').attr('checked', 'checked');
        $('#signinId').val(localStorage.username);
        $('#signinPwd').val(localStorage.pass);
    } else {
        $('#rememberChkBox').removeAttr('checked');
        $('#signinId').val('');
        $('#signinPwd').val('');
    }

    $('#Sign').click(function () {

        if ($('#rememberChkBox').is(':checked')) {
            // save username and password
            localStorage.username = $('#signinId').val();
            localStorage.pass = $('#signinPwd').val();
            localStorage.chkbox = $('#rememberChkBox').val();
        } else {
            localStorage.username = '';
            localStorage.pass = '';
            localStorage.chkbox = '';
        }
    });
    
    
});

        </script>
   <style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: #474e5d;
    padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
 
/* The Close Button (x) */
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    font-size: 40px;
    font-weight: bold;
    color: #f1f1f1;
}

.close:hover,
.close:focus {
    color: #f44336;
    cursor: pointer;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
<body>



<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="student99/quenmatkhau.html">
    <div class="container">
      <h1>Quên mật khẩu</h1>
      <p>Xin hãy nhập chính xác email của bạn</p>
      <hr>
      <label for="email" name="mail"><b>Email</b></label>
      <input type="text" placeholder="Enter Email" name="id" required>

   
      
   

      <p>Mã khôi phục sẽ được gửi về mail bạn <a href="#" style="color:dodgerblue">Tôi không nhận được mã</a>.</p>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Thoát</button>
        <button type="submit" name="quenmatkhau" class="signupbtn">Đồng ý</button>
      </div>
    </div>
  </form>
</div>
<div id="id02" class="modal">
  <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="/action_page.php">
    <div class="container">
      <h1>Mã xác nhận</h1>
      <p>Mã xác nhận sẽ được gửi về mail bạn trong giây lát</p>
      <hr>
      <label for="email"><b>Mã xác nhận</b></label>
      <input type="text" placeholder="Nhập mã xác nhận" name="email" required>

   
      
   

      <p>Mã khôi phục sẽ được gửi về mail bạn <a href="#" style="color:dodgerblue">Tôi không nhận được mã</a>.</p>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Thoát</button>
        <button type="submit" class="signupbtn">Đồng ý</button>
      </div>
    </div>
  </form>
</div>
  


<script>
// Get the modal
var modal = document.getElementById('id01');
var modal = document.getElementById('id02');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>    




        
        
  
   
      


    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content form-signin">
                <div class="login-logo">
                    <a href="index.html">
                        <img class="align-content" src="images/logo.png" alt="">
                    </a>
                </div>
                <div class="login-form"  >
                    
                    <form action="student99/login-user.html" method = "POST"  modelAttribute="message">
                        <div class="form-group" >
                            <label>Tên tài khoản</label>
		            <input type="text" id="signinId" class="input-block-level form-control" placeholder="Tên tài khoản" name="id" autofocus>
                        </div>
                        <div class="form-group">
                            <label>Mật khẩu</label>
		            <input type="password" id="signinPwd" class="input-block-level form-control" placeholder="Mật khẩu" name="password">
                        </div>
                        <div class="checkbox">
                <label class="checkbox">
                                <input id="rememberChkBox" value="remember-me" type="checkbox"> Lưu mật khẩu
                            </label>
                            <label class="pull-right">
                                               <a onclick="document.getElementById('id01').style.display='block'" class="btn  btn-xs">Quên mật khẩu?</a>
                            </label>

                        </div>
                        <button id="Sign" type="submit" class="btn btn-large btn-primary btn btn-success btn-flat m-b-30 m-t-30c"  >ĐĂNG NHẬP</button>
                        <div class="social-login-content">
                            <div class="social-button">
                                <button type="button" class="btn social facebook btn-flat btn-addon mb-3"><i class="ti-facebook"></i>ĐĂNG NHẬP VỚI FACBOOK</button>
                                <button type="button" class="btn social twitter btn-flat btn-addon mt-2"><i class="ti-twitter"></i>ĐĂNG NHẬP VỚI TWITTER</button>
                            </div>
                        </div>
                        <div class="register-link m-t-15 text-center">
                            <p>Không có tài khoản ? <a href="#"> Đăng ký</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>


</body>
</html>
