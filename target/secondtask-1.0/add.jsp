<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 22.10.2016
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editing or Adding</title>
    <link rel="stylesheet" href="resources/main.css" type="text/css">
</head>
<body>
<form action="add" method="post">

    <table class="table">
        <caption>${caption} </caption>
        <tr>
            <th>Fruit name:</th>
            <th>
                <label for="name">
                <input type="text" id="name" value="${fruit.name}" name="fruit" />
            </label> </th>
        </tr>
        <tr>
            <th>Fruit color:</th>
            <th>
                <label for="color">
                    <input type="text" id="color" value="${fruit.color}" name="color" />
            </label> </th>
        </tr>
        <tr>
            <th>Calories:</th>
            <th>
                <label for="calories">
                    <input type="text" id="calories" onkeyup="return proverka(this);" value="${fruit.calories}" name="calories" />
                    <script>
                        function proverka(input) {
                            ch = input.value.replace(/[^\d,.]/g, '');
                            document.getElementById('calories').onkeypress = function (e) {
                                if (this.value.indexOf(".") != '-1' || this.value.indexOf(",") != '-1') {
                                    return !(/[.,]/.test(String.fromCharCode(e.charCode)));
                                }
                            }
                            input.value = ch;
                        }
                    </script>
                </label> </th>
        </tr>
        <tr class="bot">
            <th></th>
            <th><input type="submit" value="Save" class="sub"/></th>
        </tr>

        <input type="hidden" name="id" value="${fruit.id}" />
    </table>


</form>
</body>
</html>
