<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<h1>Home에 오신 것을 환영합니다.</h1>

<!-- javascript:void(0) 하이퍼링크 무력화 -->

<a href="/home/hello?id=ssar">hello 페이지 이동-href</a> <br/>


<!-- delect 방식 호출 -->
<button id="hello-button">hello 페이지 이동-delect</button> <br/> 

<!-- post 방식 호출 -->
<form>
<input type="hidden" id="id" value="ssarpost">
</form>
<button id="hello-button-from">hello 페이지 이동-post</button> <br/>


<!-- update 방식 호출 -->
<form>
<input type="hidden" id="username" value="loveput">
<input type="hidden" id="phone" value="0102222">
</form>
<button id="hello-put-button">hello 페이지 이동-put</button> <br/>



<a href="/mem">회원정보게시판 이동</a> <br/>
<a href="/mem/join">회원가입게시판 이동</a> <br/>




<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	

/* $('#hello-href').on('click',function(){
//자바스크립트 오브젝트 {}이다 ajax()괄호안 오브젝트타입
	let id = 'ssar';
	
 	$.ajax({ get은 ajax를 사용 x
		type:'GET',
		url:'/home/hello?id='+id
		//get은 body data 사용 못함 get은 mime type필요없음		
		//data:		
		//content-type:'plain/text'
		//dataType 응답받을 타입을 적어야함 json  or text..... 전부 json으로 통일 보낼때도 받을때도
		//dataType:
		//.done 무조건 return 해줌 secsscce 성공해야 return	 
		// 응답이 필요없으면 done 안적어도 된다.
		}).done(function(result){
			location.href='hello.jsp'
			})
		.fail(function(result){
			alert("페이지를 이동할 수 없습니다!")
			}) ; 
}); */


//Delete 호출
$('#hello-button').on('click',function(){
	let data= {
	  id:'ssardelete'
	};
	
	$.ajax({
		type:'DELETE',
		url:'/home/hello',
		data:JSON.stringify(data),
		contentType:'application/json; charset=utf-8',
		dataType:'json'	
		}).done(function(result){
			if(result.statusCode == 200){
				alert("글이 삭제되었습니다.");
				location.href = '/home/hello';
			}
			
		}).fail(function(){
				alert('글 삭제가 실패하였습니다.')			
		});
});


//Post 호출
$('#hello-button-from').on('click',function(){
	//let id = $('#id').val();
	
	let data={
      id:$('#id').val()
      
	}
	
			
	$.ajax({
		type:'POST',
		url:'/home/hello',
		data:JSON.stringify(data),
		contentType:'application/json; charset=utf-8',
		dataType:'json'// 역직렬화 때 json으로 바꿈	
		}).done(function(result){
			if(result.statusCode == 200){
				alert("글이 작성되었습니다.");
				location.href = '/home/hello';
			}

			
		}).fail(function(){
				alert('글작성이 실패하였습니다.')			
	});
	
});


$('#hello-put-button').on('click',function(){
	//let id = $('#id').val();
	
	let data={
      username:$('#username').val(),
      phone:$('#phone').val()
	}

	
			
	$.ajax({
		type:'PUT',
		url:'/home/hello',
		data:JSON.stringify(data),
		contentType:'application/json; charset=utf-8',
		dataType:'json'// 역직렬화 때 json으로 바꿈	jackson-mapper알아서 자바스크립트로 변경
		}).done(function(result){
			if(result.statusCode == 200){
				alert("글이 수정되었습니다.");
				location.href = '/home/hello';
			}

			
		}).fail(function(){
				alert('글수정이 실패하였습니다.')			
	});
	
});











</script>

</body>
</html>



