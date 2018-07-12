<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="./resources/css/custom.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css">
	</head>
	<body>
		<header>
      		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      			<div class="col-md-1"></div>
        		<a class="navbar-brand" href="#">LabSec Challenge</a>
		        <div class="collapse navbar-collapse" id="navbarCollapse">
		          <ul class="navbar-nav ml-auto">
		            <li class="nav-item active">
		              <a class="nav-link" href="https://goo.gl/R9EqMa" target="_blank"> <i class="fas fa-id-card"></i>  Juan David Mendez</a>
		            </li>
		          </ul>
		        </div>
		        
		      </nav>
    	</header>
    	
		<br>
		
		<div class="container form-group col-md-9">		
			<h2>LabSec Challenge</h2>
			<p>Select a file to upload to the REST endpoint and wait the answer</p>
			<br>
			<div class="custom-file col-md-8">
				<input type="file" class="custom-file-input" name="upload_file" id="customFile" lang="en"/>
				<label class="custom-file-label" for="customFile">Choose file</label>
			</div>
			<br>
			<br>
			<div>
				<button type="button" class="btn btn-dark" id="btnSendFile">Send file</button>
			</div>		
		</div>
		
		<footer class="footer">
      		<div class="container">
        		<span class="text-muted"> &copy; Federal University of Santa Catarina - LABSEC</span>
      		</div>
    	</footer>
		
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>	
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
		<script src="./resources/js/MainScript.js"></script>
	</body>
</html>
