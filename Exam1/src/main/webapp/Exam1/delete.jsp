<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.jikexueyuan.service.CheckUserService,com.jikexueyuan.entity.Film,com.jikexueyuan.servlet.DeleteServlet,java.util.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示界面</title>
<style type="text/css">
body {
	color: #000;
	font-size: 30px;
	margin: 20px auto;
}
</style>
</head>
<body>
	<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
		align="center">
		<tr>
			<td colspan="5" align="center" bgcolor="#E8E8E8">电影表</td>
		</tr>
		<tr>
			<td>电影序号</td>
			<td>电影名字</td>
			<td>电影描述</td>
			<td>电影语言</td>
			<td>删除操作</td>
			<td>编辑操作</td>
		</tr>
		<%
			CheckUserService ccs = new CheckUserService();
			List<Film> list = ccs.readResult();
			for (Film film : list) {
		%>
		<tr>
			<td><%=film.getFilm_id()%></td>
			<td><%=film.getTitle()%></td>
			<td><%=film.getDescription()%></td>
			<td><%=film.getName()%></td>
			<td><a href="<%=request.getContextPath()%>/Exam1/delete.jsp%>">删除</a></td>
			<td><a href="<%=request.getContextPath()%>/Exam1/bianji.jsp%>">编辑</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>