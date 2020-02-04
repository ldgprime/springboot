<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 페이지</title>
</head>
<body>
<form>
<label>아이디: </label>
<input id="username" type="text" />
<label>비밀번호: </label>
<input id="password" type="password" />
<label>이메일: </label>
<input id="email" type="email" />
</form>
<button id="mem_insert_button" type="button" on>회원가입</button>






<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$('#mem_insert_button').on('click',function(){
		let username = $('#username').val();
		let password = $('#password').val();
		let email = $('#email').val();

		var mem_data = {
        	username:username,
        	password:password,
        	email:email
	    }

	    $.ajax({
		    type:'POST',
			url:'/mem/api/join',
		    data:JSON.stringify(mem_data),
		    contentType:'application/json; charset=utf-8',
		    dataType:'json'		    
		}).done(function(result){
			if(result.msg === "ok"){
				alert("회원가입이 완료되었습니다.");
				location.href="/mem";
			}else if(result === "fail"){
				alert("회원가입이 실패하였습니다.")
			}
	    }).fail(function(){
	    	console.log("실패");
			console.log(result);
		    alert('서버오류')
		})
				
	})
		
		





</script>





</body>
</html>