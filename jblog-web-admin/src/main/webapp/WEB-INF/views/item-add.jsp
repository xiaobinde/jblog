<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>文章分类:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择分类</a>
	            	<input type="hidden" name="cid" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>文章标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>文章描述:</td>
	            <td><input class="easyui-textbox" name="sellPoint" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
			<tr>
				<td>简介图片:</td>
				<td>
					<a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
					<input type="hidden" name="image"/>
				</td>
			</tr>
	        <tr>
	            <td>文章详情:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>

	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor ;
	$(function(){
		itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		var _data = {fun:function(node){
			TAOTAO.changeItemParam(node, "itemAddForm");
		}};
		TAOTAO.init(_data);
	});
	
	function submitForm(){
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}

		//将编辑器中的内容同步到隐藏多行文本中
		itemAddEditor.sync();
		
		//输入的规格参数数据保存为json
		var paramJson = [];
		$("#itemAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		paramJson = JSON.stringify(paramJson);
		
		$("#itemAddForm [name=itemParams]").val(paramJson);
		
		//提交到后台的RESTful
		$.ajax({
		   type: "POST",
		   url: "/rest/admin/article",
		   data: $("#itemAddForm").serialize(),
		   statusCode :{
			   201 : function(){
				   $.messager.alert('提示','新增商品成功!');
			   },
			   400 : function(){
				   $.messager.alert('提示','提交的参数不合法!');
			   },
			   500 : function(){
				   $.messager.alert('提示','新增商品失败!');
			   }
		   }
		});
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
