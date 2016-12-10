<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.table {
	width: 100%;
}

th {
	height: 50px;
	text-align: left;
}

th, td {
	border-bottom: 1px solid #ddd;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

.button {
	-webkit-appearance: button;
	-moz-appearance: button;
	appearance: button;
	text-decoration: none;
	color: initial;
	float: right;
	margin-top: 50px;
	margin-right: 50px;
	padding: 5px;
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>


	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Products</h3>
			</div>



			<div class="panel-body">
				<table class="table">
					<tr>
						<!-- <th>ID</th> -->
						<th>Item</th>
						<th>Quantity</th>
						<th>Unit Price</th>

					</tr>
					<c:forEach var="cart" items="${carts}">
						<tr>

							<td>${cart.product.name}</td>
							<td>${cart.quantity}</td>
							<td>${cart.product.price}</td>



						</tr>


					</c:forEach>

					<tr>
						<th>Total</th>
						<th></th>
						<th>${totalPrice}</th>
					</tr>

				</table>



			</div>
			<form action="/card/form" class="button">
				<input type="submit" value="Checkout" />
			</form>

			<form action="/deleteCart" class="button">
				<input type="submit" value="Clear Cart" />
			</form>


		</div>
	</div>


</body>
</html>