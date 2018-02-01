<%--
  Created by IntelliJ IDEA.
  User: hanchao
  Date: 2018/1/31
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍管理</title>
    <style type="text/css">
        div{margin: 5px 5px; }
        .div-left {float: left;margin: 5px 5px;border:1px solid #96c2f1; background:#eff7ff;}
        .div-text-center {text-align:center; border:1px solid #96c2f1; background:#eff7ff;width: 300px;}
        textarea{border:1px solid #9bdf70;background:#f0fbeb}
    </style>
</head>
<body>
<div class="div-left div-text-center">
    <textarea id="show" style="width: 300px;height: 500px;"></textarea>
</div>
<div class="div-left">
    <div class="div-text-center">
        <label>书籍主键：</label><input type="text" id="id" name="id"/><hr/>
        <label>书籍编号：</label><input type="text" id="number" name="number"/><hr/>
        <label>书籍名称：</label><input type="text" id="name" name="name"/><hr/>
        <label>书籍价格：</label><input type="text" id="price" name="price"/><hr/>
        <label>是否旧书：</label><input type="text" id="old" name="old"/><hr/>
        <label>是否汉化：</label><input type="text" id="chinese" name="chinese"/><hr/>
    </div>
    <div>
        <input type="button" value="selectBookWithIf" onclick="book('if')"/><hr/>
        <input type="button" value="selectBookWithWhere" onclick="book('where')"/>
        <input type="button" value="selectBookWithTrim" onclick="book('trim/where')"/><hr/>
        <input type="button" value="selectBookWithChoose" onclick="book('choose')"/><hr/>
        <input type="button" value="selectBookWithForEach" onclick="books('foreach')"/><hr/>
        <input type="button" value="selectBookWithForBind" onclick="book('bind')"/><hr/>
        <input type="button" value="updateBookWithSet" onclick="book('set')"/>
        <input type="button" value="updateBookWithTrim" onclick="book('trim/set')"/><hr/>
    </div>
</div>
</body>
<script type="text/javascript" src="../static/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    function book(url_suffix) {
        $.ajax({
            type:'POST',
            url:'/book/' + url_suffix,
            data:JSON.stringify({
                id:$('#id').val(),
                number:$('#number').val(),
                name:$('#name').val(),
                price:$('#price').val(),
                old:$('#old').val(),
                chinese:$('#chinese').val()
            }),
            contentType:'application/json;charset=utf-8',
            success:function (data) {
                console.log(data);
                var html = "url:/book/" + url_suffix + "\nresult:\n" + JSON.stringify(data,null,4);
                $("#show").html(html)
            },
            error:function (data) {
                alert(data.method);
            }
        });
    }

    function books(url_suffix) {
        $.ajax({
            type:'POST',
            url:'/book/' + url_suffix,
            contentType:'application/json;charset=utf-8',
            success:function (data) {
                console.log(data);
                var html = "url:/book/" + url_suffix + "\nresult:\n" + JSON.stringify(data,null,4);
                $("#show").html(html)
            },
            error:function (data) {
                alert(data.method);
            }
        });
    }
</script>
</html>
