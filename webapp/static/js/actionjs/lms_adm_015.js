/**
 * 
 */
var lms_adm_015 ={};


$(document).ready(function() {
	lms_adm_015. loadData ();
});
lms_adm_015. loadData = function(){
	$.ajax({
		url : "../action/service/lms_adm_015",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(dat) {
			console.log(dat.RESP_DATA);
			var data =[]
			          
			$.each(dat.RESP_DATA['ORG_REC'], function(i, v) {
				if(dat.RESP_DATA['ORG_REC'][i].parent_id == "-1"){
				   console.log("-1");
					v['parent'] = "#";
				}else{
					v['parent'] = dat.RESP_DATA['ORG_REC'][i].parent_id;
				};
				v['id'] = dat.RESP_DATA['ORG_REC'][i].id;
				v['text'] = dat.RESP_DATA['ORG_REC'][i].name;
//				v[i] = data;
				data.push(v);
				
			});
			console.log(data);
			$('#treeData').jstree({
				'checkbox': {
				 'keep_selected_style': true,
			     'tie_selection': false,
			     'whole_node': false // click on checkBox
				},
				"plugins": ["type","checkbox"],
				'core' : {
			    'data' : data,
			    "themes":{
		         "icons":true
		            
	          
		        }
			           
			}})		
		}
	});
}