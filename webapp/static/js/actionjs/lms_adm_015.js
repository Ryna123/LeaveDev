/**
 * 
 */
var lms_adm_015 ={};
var _orgid = '';
var _managerId = '';

$(document).ready(function() {
	lms_adm_015.loadData ();
	
	// Search Department
	var to = false;
	  $('#btn_search').click(function () {
	    if(to) { 
	    	clearTimeout(to); 
	    }
	    to = setTimeout(function () {
	      var value = $('#txtInput').val();
	      $('#treeData').jstree(true).search(value);
	    }, 250);
	  });
});
lms_adm_015.loadData = function(){
	$.ajax({
		url : "../action/service/lms_adm_r015",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(dat) {
			var data =[]
			 console.log(dat.RESP_DATA['ORG_REC']);      
			$.each(dat.RESP_DATA['ORG_REC'], function(i, v) {
				if(dat.RESP_DATA['ORG_REC'][i].parent_id == "-1"){
					v['parent'] = "#";
				}else{
					v['parent'] = dat.RESP_DATA['ORG_REC'][i].parent_id;
				};
				v['id'] = dat.RESP_DATA['ORG_REC'][i].id;
				v['supervisor'] = dat.RESP_DATA['ORG_REC'][i].supervisor;
				v['text'] = dat.RESP_DATA['ORG_REC'][i].name;
//				v[i] = data;
				console.log(v);
				data.push(v);
				
			});
			$('#treeData').jstree({
				'checkbox': {
				 'keep_selected_style': true,
			     'tie_selection': false,
			     'whole_node': false // click on checkBox
				},
				"plugins": ["type","checkbox", "json_data","search"],
				'core' : {
			    'data' : data,
			    "themes":{
		         "icons":true,
			    }			           
			}})		
			.bind("select_node.jstree", function (event, data) {
			_orgid = data.node.id;
			_managerId = data.node.original.supervisor;
			var input = {orgId:_orgid,managerId:_managerId};
			lms_adm_015.LoadUserInDepartment(input);
		})
		}
	});
}
lms_adm_015.LoadUserInDepartment = function(input){
	loading(true);
	//var a ={orgId:"2",managerId:"1"};
	$.ajax({
		url : "../action/service/lms_adm_016",
		dataType : "JSON",
		type : "POST",
		data :input,
		success : function(dat) {
			$("tbody#userArea").empty();
			console.log(dat.RESP_DATA);
			var res = dat.RESP_DATA['USR_REC'];
			$.each(res,function(i,v){
				
				var data = {};
				data['ID']  = res[i].id;
				data['IDENTIFIER']  = res[i].identifier;
				data['FIRSTNM']  = res[i].firstName;
				data['LASTNM']  = res[i].lastName;
				data['PHONE'] = res[i].phone;
				data['EMAIL'] = res[i].email;
				$("#userTamplate").tmpl(data).appendTo("tbody#userArea").html();
			});
		}
	
	});
	loading(false);
}