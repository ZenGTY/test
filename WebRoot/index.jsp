<%--
  Created by IntelliJ IDEA.
  User: pismery
  Date: 2017-10-23
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
     <h1>主页</h1>
  </body>
  <script type="text/javascript" src="./lib/jquery-1.10.2/jquery.min.js"></script>
  <script>
    var paramInfo = {
      clientId : 1,
      status : 1,
      sum : 450,
      projects : "[{projectId : 2,number : 10,deadline : \"2017-12-10 10:10:10\",extroInfo : \"额外信息\"}" +
      ",{projectId : 1,number : 20,deadline : \"2017-12-10 10:10:12\",extroInfo : \"额外信息2\"}]",
    };
    
    $.ajax({
          data : paramInfo,
          url : "./billController/addTreatmentBill",
          type : "POST",
          success : function(response) {
            var responseJson = JSON.parse(response);
            console.log(responseJson);
          }
        }
    );

  </script>
</html>
