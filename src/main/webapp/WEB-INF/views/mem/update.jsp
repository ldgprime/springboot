<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 페이지</title>
</head>
<body>
<table border="/">
<tr>
<th>username</th>
<th>password</th>
<th>email</th>
<th>createdate</th>
</tr>
<tr>

<td><input type="text" value="${mem.username }" readonly="readonly" /></td>
<td><input id="password" type="password" value="${mem.password}" /></td>
<td><input id="email" type="email" value="${mem.email}"  /></td>
<td><input type="text" value="${mem.createdate }" readonly="readonly" /></td>
</tr>
</table>
<input id="id" type="hidden" value="${mem.id }" readonly="readonly" />



<br/>
<br/>
<br/>
<br/>

<button id="mem_update_button" on>회원수정</button>
<button id="mem_delete_button" on>삭제</button> <br/>





<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

	$('#mem_update_button').on('click',function(){
		let password = $('#password').val();
		let email = $('#email').val();
		let id = $('#id').val();
		
		let mem_data = {
			password: password,
			email : email,
			id : id				
		}


//		$.ajax().sessice().fail() 두방법 다 허용함
		$.ajax({
			type:'PUT',
			url:'/mem/api/update',
			data:JSON.stringify(mem_data),
			contentType:'application/json; charset=utf-8',
			dataType:'text'// 역직렬화 때 json으로 바꿈
				//ResponseEntity<String>가 오브젝트 따라서 jakson이 json으로	
			}).done(function(result){
				if(result === "ok"){
				alert("회원정보가 수정되었습니다.");
				location.href="/mem";
				}else if(result === "fail"){
					alert("회원정보이 수정실패하였습니다.")
				}				
			}).fail(function(result){
				console.log("실패");
				console.log(result);
				alert('서버오류');
									
		    });


		
	})
	
	
	$('#mem_delete_button').on('click',function(){
	
		let id = $('#id').val();
		
		let mem_data = {
			id : id				
		}


//		$.ajax().sessice().fail() 두방법 다 허용함
		$.ajax({
			type:'DELETE',
			url:'/mem/api/delete',
			data:JSON.stringify(mem_data),
			contentType:'application/json; charset=utf-8',
			dataType:'text'// 역직렬화 때 json으로 바꿈
				//ResponseEntity<String>가 오브젝트 따라서 jakson이 json으로	
			}).done(function(result){
				if(result === "ok"){
				alert("회원삭제가 완료되었습니다.");
				location.href="/mem";
				}else if(result === "fail"){
					alert("회원삭제가 실패하였습니다.")
				}				
			}).fail(function(result){
				console.log("실패");
				console.log(result);
				alert('서버오류');
									
		    });


		
	})



</script>





</body>
</html>