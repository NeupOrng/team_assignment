<%--<%@page import="Student" %>--%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="AddARecord" method="post">
            id: <input type="text" name="id"><br>
            name: <input type="text" name="name"><br>
            age: <input type="text" name="age"><br>
            <input type="submit">
            <% 
                Student s = new Student();
                if(request.getAttribute("function")== null){
                    
                }else if(request.getAttribute("function").equals("InsertOneRecord")){
                    
                }

            %>
            
        </form>
        <form action="readARecord" method="post">
            id: <input type="text" name="id"><br>
            <input type="submit">

            <% 
                if(request.getAttribute("function")== null){
                    
                }else if(request.getAttribute("function").equals("InsertOneRecord")){
                    out.println();
                }

            %>
            
        </form>
    </body>
</html>
