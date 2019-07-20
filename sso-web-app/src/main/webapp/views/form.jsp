<form action="add" method="post"
		class="form-horizontal">
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
				<button class="btn btn-primary" type="submit">Add</button>
			</div>
			
		</form>