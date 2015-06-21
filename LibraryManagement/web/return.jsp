<%-- 
    Document   : return
    Created on : Jun 21, 2015, 10:22:01 AM
    Author     : sony
--%>


<%@ page import="java.util.*" %>

<html>
<body>
	<% // get the list of advise from request
	List<String> listOfreturn = (List<String>)request.getAttribute("bookService"); 
	
	/**
	 * get the iterator
	 */
	Iterator<String> iter = listOfreturn.iterator();
	String str = null;
	
	while(iter.hasNext()) {
		
		/**
		 * get the advise
		 */
		str = iter.next();
		
		out.println("<br>deliver "+str);
	}
	
	%>
</body>
</html>