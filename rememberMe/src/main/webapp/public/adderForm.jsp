<form class="form-horizontal" action="add" method="post">
			<div class="form-group">
			<label>First No.</label>
			<input type="text" class="form-control" name="num1">
			</div>
			<div class="form-group">
			<label>Second No.</label>
			<input type="text" class="form-control" name="num2">
			<input type="hidden" 
			name="${_csrf.parameterName}" 
			value="${_csrf.token}"/>
			</div>
			<div class="form-group">
			<button type="submit" class="btn btn-primary">
			Add
			</button>
			</div>
</form>

<form class="form-horizontal" action="/logout" method="post">
			
			<input type="hidden" 
			name="${_csrf.parameterName}" 
			value="${_csrf.token}"/>
			<div class="form-group">
			<button type="submit" class="btn btn-primary">
			Logout
			</button>
			</div>
</form>


