<%@ include file="header.jsp" %>

<div class="animated bounceInDown" style="font-size:32pt; font-family:arial; color:#990000; font-weight:bold">Document Comparison Service</div>

</p>&nbsp;</p>&nbsp;</p>

<table width="600" cellspacing="0" cellpadding="7" border="0">
	<tr>
		<td valign="top">

			<form bgcolor="white" method="POST" enctype="multipart/form-data" action="/MainMenu">
				<fieldset>
					<legend><h3>Specify Details For Comparing</h3></legend>
					<b>This form will compare your document to others on the server</b><br>
					<b>Document Title :</b><br>
					<input name="txtTitle" type="text" size="50"/>
					<p/>
					<input type="file" name="txtDocument"/>
					<center><input type="submit" value="Compare Document"></center>
				</fieldset>							
			</form>	
			
			<form bgcolor="white" method="POST" enctype="multipart/form-data" action="/LookupMenu">
				<fieldset>
					<legend><h3>Specify Details For Adding</h3></legend>
					<b>This form will add your document to server</b><br>
					<b>Document Title :</b><br>
					<input name="newTitle" type="text" size="50"/>
					<p/>
					<input type="file" name="newDocument"/>
					<center><input type="submit" value="Compare Document"></center>
				</fieldset>							
			</form>	

		</td>
	</tr>
</table>
<%@ include file="footer.jsp" %>
