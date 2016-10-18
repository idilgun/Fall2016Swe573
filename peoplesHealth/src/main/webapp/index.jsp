<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<h2>Fall2016Swe573</h2>
	<h4>Semester project on nutrition tracking for Bogazici University
		SWE 573</h4>
	<p>This project is most generally a web application where users can
		get information about what they eat. The higest level requirement is
		the user of the web application should to be insipired to undertake a
		healtier life style.</p>

	<form id="signUpForm" class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Email:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="signUp_email"
					placeholder="Enter email">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="pwd">Password:</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="signUp_password"
					placeholder="Enter password">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="name">Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="signUp_name"
					placeholder="Enter name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="dateOfBirth">Date of Birth:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="signUp_dateOfBirth"
					placeholder="Enter date of birth">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button id="signUp_submitButton" type="submit" class="btn btn-default">Submit</button>
			</div>
		</div>
	</form>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>

	<script>
		
		
		$('#signUp_submitButton').on("click", function() {

		    var postObj = {};
		    postObj.email = document.getElementById('signUp_email').value
		    postObj.password = document.getElementById('signUp_password').value
		    postObj.gender = "F";
		    postObj.dateOfBirth = document.getElementById('signUp_dateOfBirth').value
		    postObj.name = document.getElementById('signUp_name').value
		    console.log(postObj);
		    
		    
			    $.ajax({
			        url: '../peoplesHealth/newUser',
			        type: 'post',
			        dataType: 'json',
			        data: JSON.stringify(postObj),
			        contentType: 'application/json; charset=utf-8',
			        success: function(data) {
			        	console.log(data);
			                 },
			    	error: function(data) {
			    		console.log(data);
			    	}
			    });
		});
	</script>

</body>
</html>
