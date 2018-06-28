<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<script src="<c:url value='/static/js/jquery-3.3.1.min.js' />"></script>
<script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
</head>

<body>
<div class="container mar-top-20">
	<div class="row ">
		<div class="col-md-offset-2 col-md-8 well">
			<div class="lead">User Registration Form</div>
			<form:form method="POST" modelAttribute="product"
				class="form-horizontal" enctype="multipart/form-data">
				<form:input type="hidden" path="productId" id="productId" />

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="productName">Product
							Name</label>
						<div class="col-md-7">
							<form:input type="text" path="productName" id="productName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="productName" class="help-inline" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="prize">Prize</label>
						<div class="col-md-7">
							<form:input type="text" path="prize" id="prize"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="prize" class="help-inline" />
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="quantity">Quantity</label>
						<div class="col-md-7">
							<form:input type="text" path="quantity" id="quantity"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="quantity" class="help-inline" />
							</div>
						</div>
					</div>
				</div>				
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-lable" for="imagePath">Image</label>
						<div class="col-md-7">
							<div class="col-md-6 pad-left-0">
								<input type="file" name="file" onChange="readURL(this);" />
							</div>
							<div class="col-md-6 ">
								<c:choose>
									<c:when test="${edit}">
										<form:input type="hidden" path="profile" id="profile"
											class="form-control input-sm" />
										<img id="img"
											src="<c:url value='/static/images/product/'/>${product.imagePath}"
											alt="your image" />
									</c:when>
									<c:otherwise>
										<form:input type="hidden" path="imagePath" id="imagePath"
											class="form-control input-sm" />
										<img id="img" src="#" />
										<div class="has-error">
											<form:errors path="imagePath" class="help-inline" />
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-actions floatRight">
						<c:choose>
							<c:when test="${edit}">
								<input type="submit" value="Update"
									class="btn btn-primary btn-sm" /> or <a
									href="<c:url value='/list-product' />">Cancel</a>
							</c:when>
							<c:otherwise>
								<input type="submit" value="Register"
									class="btn btn-primary btn-sm" /> or <a
									href="<c:url value='/list-product' />">Cancel</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
<script type="text/javascript">
	function readURL(input) {
		var ext = input.files[0]['name'].substring(
				input.files[0]['name'].lastIndexOf('.') + 1).toLowerCase();
		if (input.files
				&& input.files[0]
				&& (ext == "gif" || ext == "png" || ext == "jpeg" || ext == "jpg")) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#img').attr('src', e.target.result);
				$('#profile').val(input.files[0]['name']);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</body>
</html>