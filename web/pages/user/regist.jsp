<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
		<%@ include file="/pages/common/head.jsp"%>
		<script type="text/javascript">
			// 页面加载完成之后
			$(function()
			{

                var $ObjFunction = function ()
                {
                    var usernamePatt=/^\w{5,12}$/;
					var passwordPatt=/^\w{5,12}$/;
					var emailPatt=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;

                    //註冊動作
					//1.註冊帳號:必須由英文和數字或底線的組合,長度必須在5~12字母
					//alert($("#username").val());
					var name=$("#username").val();
                    var password=$("#password").val();
                    var repassword=$("#repwd").val();
					var email=$("#email").val();
					if(!usernamePatt.test(name))
					{
                        $("span:eq(1)").text("帳號格式不正確");
                        return false;
                    }
                    //2.用戶密碼:必須由英文和數字或底線的組合,長度必須在5~12字母
                    if(!passwordPatt.test(password))
                    {
                        $("span:eq(1)").text("密碼格式不正確");
                        return false;
                    }
					//3.確認密碼:必須要和用戶密碼一致
					if(password!=repassword)
                    {
                        $("span:eq(1)").text("密碼不一致");
                        return false;
                    }
                    //4.電子郵件:符合郵件的規則
                    if(!emailPatt.test(email))
					{
                        $("span:eq(1)").text("email格式不正確");
                        return false;
					}

                    $("span:eq(1)").text("");
                    return false;
                }
			});

		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="registerServlet" method="post">
									<label>用戶名稱：</label>
									<input class="itxt" type="text" placeholder="請輸入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用戶密碼：</label>
									<input class="itxt" type="password" placeholder="請輸入密碼"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>確認密碼：</label>
									<input class="itxt" type="password" placeholder="確認密碼"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>電子郵件：</label>
									<input class="itxt" type="text" placeholder="請輸入電子郵件地址"
										   autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>驗證碼：</label>
									<input class="itxt" type="text" name="code" style="width: 150px;" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="註冊" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/common/footer.jsp"%>
	</body>
</html>