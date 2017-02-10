<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta charset="gb2312">
<title>个人博客模板（寻梦）</title>
<meta name="keywords" content="个人博客模板,博客模板" />
<meta name="description" content="寻梦主题的个人博客模板，优雅、稳重、大气,低调。" />
<link href="/css/base.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
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
    <%--<a href="/rest/page/share"><span>模板分享</span><span class="en">Share</span></a>--%>
    <%--<a href="/rest/page/knowledge"><span>学无止境</span><span class="en">Learn</span></a>--%>
    <%--<a href="/rest/page/book"><span>留言版</span><span class="en">Gustbook</span></a>--%>
  </nav>
</header>
<div class="banner">
  <section class="box">
    <ul class="texts">
      <p>打了死结的青春，捆死一颗苍白绝望的灵魂。</p>
      <p>为自己掘一个坟墓来葬心，红尘一梦，不再追寻。</p>
      <p>加了锁的青春，不会再因谁而推开心门。</p>
    </ul>
    <div class="avatar"><a href="#"><span>刘森贤</span></a> </div>
  </section>
</div>
<article>
  <h2 class="title_tj">
    <p>文章<span>推荐</span></p>
  </h2>
  <div class="bloglist left">

    <c:forEach items="${articleList}" var="item">
      <h3>${item.title}</h3>
      <figure><img src="${item.image}"></figure>
      <ul>
        <p>${item.sellPoint}</p>
        <a title="/" href="/rest/new/${item.id}" target="_blank" class="readmore">阅读全文>></a>
      </ul>
      <p class="dateview"><span>${item.created}</span><span>作者：${item.author}</span><span>个人博客：[<a href="/news/life/">程序人生</a>]</span></p>
    </c:forEach>
  </div>

  <aside class="right">
    <div class="weather"><iframe width="250" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe></div>
    <div class="news">
    <h3>
      <p>最新<span>文章</span></p>
    </h3>
    <ul class="rank">
    <c:forEach items="${newList}" var="item">
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
    <a href="/" class="weixin"> </a></aside>
</article>
<footer>
  <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank">蜀ICP备11002373号-1</a> <a href="/">网站统计</a></p>
</footer>
<script src="/js/silder.js"></script>
</body>
</html>
