<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>杨青个人博客网站―一个站在web前段设计之路的女技术员个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
<meta name="description" content="杨青个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
<link href="/css/base.css" rel="stylesheet">
<link href="/css/new.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="/js/modernizr.js"></script>
    <![endif]-->
</head>
<body>
<header>
  <div id="logo"><a href="/"></a></div>
  <nav class="topnav" id="topnav">
    <a href="/rest/index"><span>首页</span><span class="en">Protal</span></a>
    <a href="/rest/about"><span>关于我</span><span class="en">About</span></a>
    <a href="/rest/newlist"><span>慢生活</span><span class="en">Life</span></a>
    <%--<a href="/rest/moodlist"><span>碎言碎语</span><span class="en">Doing</span></a>--%>
    <%--<a href="/rest/book"><span>留言版</span><span class="en">Gustbook</span></a>--%>
  </nav>
</header>
<article class="blogs">
  <h1 class="t_nav"><span>您当前的位置：<a href="/index.html">首页</a>&nbsp;&gt;&nbsp;<a href="/news/s/">慢生活</a>&nbsp;&gt;&nbsp;<a href="/news/s/">日记</a></span><a href="/" class="n1">网站首页</a><a href="/" class="n2">日记</a></h1>
  <div class="index_about">
    <h2 class="c_titile">${article.title}</h2>
    <p class="box_c"><span class="d_time">发布时间：${article.created}</span><span>编辑：${article.author}</span></p>
    <ul class="infos">
        ${articleDesc.articleDesc}
    </ul>
    <div class="keybq">
    <p><span>关键字词</span>：爱情,犯错,原谅,分手</p>
    
    </div>
    <%--<div class="nextinfo">--%>
      <%--<p>上一篇：<a href="/news/s/2013-09-04/606.html">程序员应该如何高效的工作学习</a></p>--%>
      <%--<p>下一篇：<a href="/news/s/2013-10-21/616.html">柴米油盐的生活才是真实</a></p>--%>
    <%--</div>--%>

  </div>
  <aside class="right">
    <!-- Baidu Button BEGIN -->
    <div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare"><a class="bds_tsina"></a><a class="bds_qzone"></a><a class="bds_tqq"></a><a class="bds_renren"></a><span class="bds_more"></span><a class="shareCount"></a></div>
    <script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6574585" ></script> 
    <script type="text/javascript" id="bdshell_js"></script> 
    <script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
</script> 
    <!-- Baidu Button END -->
    <div class="blank"></div>
  </aside>
</article>
<footer>
  <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank">蜀ICP备11002373号-1</a> <a href="/">网站统计</a></p>
</footer>
<script src="/js/silder.js"></script>
</body>
</html>