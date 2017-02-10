<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>刘海滨个人博客网站―一个站在web前段设计之路的女技术员个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
<meta name="description" content="杨青个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
<link href="/css/base.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">
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
<h1 class="t_nav"><span>“慢生活”不是懒惰，放慢速度不是拖延时间，而是让我们在生活中寻找到平衡。</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">慢生活</a></h1>
<div class="newblog left">
    <c:forEach items="${articleList}" var="item">
        <h2>${item.title}</h2>
        <p class="dateview"><span>发布时间：${item.created}</span><span>作者：${item.author}</span><span>分类：[<a href="/news/life/">程序人生</a>]</span></p>
        <figure><img src="${item.image}"></figure>
        <ul class="nlist">
            <p>${item.sellPoint}</p>
            <a title="/" href="/" target="_blank" class="readmore">阅读全文>></a>
        </ul>
        <div class="line"></div>
    </c:forEach>
    <div class="blank"></div>
</div>
<aside class="right">
   <div class="rnav">
      <ul>
       <li class="rnav1"><a href="/download/" target="_blank">日记</a></li>
       <li class="rnav2"><a href="/newsfree/" target="_blank">程序人生</a></li>
       <li class="rnav3"><a href="/web/" target="_blank">欣赏</a></li>
       <li class="rnav4"><a href="/newshtml5/" target="_blank">短信祝福</a></li>
     </ul>      
    </div>
<div class="news">
<h3>
      <p>最新<span>文章</span></p>
    </h3>
    <ul class="rank">
        <c:forEach items="${newArticleList}" var="item">
            <li><a href="/" title=${item.title} target="_blank">${item.title}</a></li>
        </c:forEach>
    </ul>
    </div>

     <!-- Baidu Button BEGIN -->
    <div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare"><a class="bds_tsina"></a><a class="bds_qzone"></a><a class="bds_tqq"></a><a class="bds_renren"></a><span class="bds_more"></span><a class="shareCount"></a></div>
    <script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6574585" ></script>
    <script type="text/javascript" id="bdshell_js"></script>
    <script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
</script> 
    <!-- Baidu Button END -->   
</aside>
</article>
<footer>
  <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank">蜀ICP备11002373号-1</a> <a href="/">网站统计</a></p>
</footer>
<script src="/js/silder.js"></script>
</body>
</html>