<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>File Uploading</title>
</head>
<body>
	<h2>ファイルアップロード</h2>
	<form method="post" enctype="multipart/form-data">
		<input type="file" name="file" /><br />
		<button type="submit" name="upload">アップロード</button>
		<button type="submit" name="download">ダウンロード</button>
	</form>
</body>
</html>