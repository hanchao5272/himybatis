<%--
  Created by IntelliJ IDEA.
  User: hanchao
  Date: 2018/1/28
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>话题首页</title>
    <style type="text/css">
        div{margin: 5px 5px; }
        .div-left {float: left;margin: 5px 5px;}
        .div-text-center {text-align:center; border:1px solid #96c2f1; background:#eff7ff;}
        textarea{border:1px solid #9bdf70;background:#f0fbeb}
        .in-text{width: 30px;}
    </style>
</head>
<body>
<div class="div-left">
    <textarea id="message" cols="50" rows="50"></textarea>
</div>
<div class="div-left">
    <div class="div-text-center">
        <input type="button" value="查询所有(GET)" onclick="topics('GET')"/>
    </div>
    <div class="div-text-center">
        <label>话题id：</label><input class="in-text" type="text" id="id" value="1"/><input type="button" value="查询一个(GET)" onclick="topic('GET')"/><input type="button" value="删除一个(DELETE)" onclick="topic('DELETE')">
    </div>
    <div class="div-text-center">
        <table style="text-align: right;width: 325px;">
            <tr>
                <td><label>id</label></td>
                <td><input id="new_id" type="text" value="1"/> </td>
            </tr>
            <tr>
                <td><label>题目</label></td>
                <td><input id="new_title" type="text" value="新话题"/> </td>
            </tr>
            <tr>
                <td><label>分数</label></td>
                <td><input id="new_score" type="text" value="100"/> </td>
            </tr>
            <tr>
                <td><label>答案</label></td>
                <td><input id="new_answer" type="text" value="新答案"/> </td>
            </tr>
            <tr>
                <td><input type="button" value="新增(POST)" onclick="topic1('POST')"> </td>
                <td><input type="button" value="修改(PUT)" onclick="topic1('PUT')"> </td>
            </tr>
        </table>
    </div>
</div>
</body>
<script type="text/javascript" src="../static/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    /**
     * 获取一个话题：[GET]/ssm/topic/{id}
     */
    /**
     * 删除一个话题：[DELETE]/ssm/topic/{id}
     */
    function topic(type) {
        $.ajax({
            type:type,
            url:"/ssm/topic/" + $("#id").val(),
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                console.log(data);
                var html = "url[" + type + "]:/ssm/topic/" + $("#id").val() + "\n\nresult:\n" + JSON.stringify(data, null, 4);
                $("#message").html(html);
            }
        });
    }

    /**
     * 获取全部话题：[GET]/ssm/topic/
     */
    /**
     * 删除全部话题：[DELETE]/ssm/topic/
     */
    function topics(type) {
        $.ajax({
            type:type,
            url:"/ssm/topic/",
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                console.log(data);
                var html = "url[" + type + "]:/ssm/topic/\n\nresult:\n" + JSON.stringify(data, null, 4);
                $("#message").html(html);
            }
        });
    }

    /**
     * 新增一个话题：[POST]/ssm/topic/
     */
    /**
     * 替换一个话题：[PUT]/ssm/topic/
     */
    /**
     * 修改一个话题：[PATCH]/ssm/topic/
     */
    function topic1(type) {
        $.ajax({
            type:type,
            url:"/ssm/topic/",
            data:JSON.stringify({
                id:$("#new_id").val(),
                title:$("#new_title").val(),
                score:$("#new_score").val(),
                answer:$("#new_answer").val()
            }),
            contentType:"application/json;charset:utf-8",
            success:function (data) {
                console.log(data);
                var html = "url[" + type + "]:/ssm/topic/\n\nresult:\n" + JSON.stringify(data,null,4);
                $("#message").html(html);
            }
        });
    }
</script>
</html>
