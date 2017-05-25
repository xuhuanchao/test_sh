
$(function() {
	
	var service = {
			queryStudent : basepath + "/student/queryStudent",
			addStudent : basepath + "/student/addStudent"
	}
	//获取表单数据
	function getFormData(formid) {
		var result = {};
		var array =$(formid).serializeArray();
	    $.each(array, function(i, field){
	    	result[field.name] = field.value;
	    });
	    return result;
	}
	
	/*
	 * 点击查询应用按钮
	 */
	$("#addStudentBtn").click(function() {
		$.ajax({
			url : service.addStudent,
			data : {params:getFormData("studentInfoForm")},
			type : 'post',
			headers : {
				"If-Modified-Since" : 0
			},
			success : function(ret) {
				alert("success");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
			}
		});
	});
	
	$("#queryStudentBtn").click(function(){
		queryStudent(getFormData("studentInfoForm"));
	});
	
	function queryStudent(params){
		$.ajax({
			url : service.queryStudent,
			data : {'params' : params},
			contentType: "application/json",
			dataType : 'json',
			type : 'post',
			headers : {
				"If-Modified-Since" : 0
			},
			success : function(ret) {
				$("#studentList tr:not(:first)").remove();
				var students = ret.data;
				for (var index in students){
					$("#studentList").append("<tr><td>"+students[index].name+"</td><td>"+students[index].age+"</td><td>"+students[index].address+"</td><td>"+students[index].hobby+"</td><td>"+students[index].classname+"</td></tr>");
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("查询失败");
			}
		});
	}

});
