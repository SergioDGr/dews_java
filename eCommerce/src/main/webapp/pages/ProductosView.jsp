<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="productos" class="container">
	<div class="row">
		<c:forEach var="p" items="${productos}">
			<div class="col-3 p-2">
		  		<div class="card">
					<img src="${p.imagen}" class="card-img-top" alt="${p.imagen}">
				  	<div class="card-body">
				    	<h5 class="card-title">${p.nombre}</h5>
				    	<p class="card-text">${p.descripcion}</p>
				    	<div class="d-grid gap-2">
							<button class="btn btn-primary" type="button">Comprar</button>
						</div>
					</div>
				</div>
		  	</div>
		</c:forEach>
	</div>
</div>