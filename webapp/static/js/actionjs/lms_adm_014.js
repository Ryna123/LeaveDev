var _employeeManagement = {};
var _table;
var lms_adm_009p ={};
var _orgid = '';
var _managerId = '';

$(document).ready(function(){
	loading(true);
	_employeeManagement.loadEmpData();
	
	loading(false);
	$('#txtSearch').keyup(function(){
	      _table.search($(this).val()).draw() ;
	});
	$('#btnSelect').click(function(){
		lms_adm_009p.loadData();
	});
	$('#btnOk').click(function(){
		var orgid = $('#txtOrgId').val();
		_orgid=orgid;
		if(orgid==0 || orgid==null){
			_employeeManagement.loadEmpData();
		}else{
			lms_adm_009p.selectDataTree(orgid);
		}
		_orgid=orgid;
	});
	
	$('#btnExport').click(function(){
		/*var data=new Array();
		_table.rows().eq(0).each( function ( index ) {
		    var row = _table.row( index );
		    data.push(row.data());
		});*/
		if(_orgid==0 ||_orgid=='' || _orgid == null){
			alert("0");
			_orgid=0;
		}else{
			alert(_orgid);
		}
		$('#btnExport').attr("href", "../action/service/hrListExport?orgid="+_orgid);
		
		/*$.ajax({
			url:"../action/service/hrListExport?orgid="+_orgid,
			dataType:"JSON",
			type:"GET",
			success:function(data){
				alert("dfafa");
				console.log(data);
			},
			error: function(jqXHR, textStatus, errorThrown) {
                console.log('submit click failed');
                console.log('status is ' + textStatus);
                console.log('error is ' + errorThrown);
            }
		});*/
	});
	
});

_employeeManagement.loadEmpData=function(){
	$.ajax({
		url:"../action/service/lms_adm_r014",
		dataType: "JSON",
		type:"GET",
		success:function(data){
			if(_table!=null){
				_table.clear().draw();
				_table.rows.add(data.List);
				_table.columns.adjust().draw();
			}else{
				//alert(JSON.stringify(data.List));
				var listData=data.List;
				//var count = Object.keys(listData).length;
				console.log(data.List);
				var values={"data":listData};
				//Covert json to String 
				//var dataSet=JSON.stringify(values);
				//covert String to json
				//var dd=JSON.parse(dataSet);
				//console.log(values);
				//$('#hrTable tbody tr').remove();
				_table = $('#hrTable').DataTable({
					"pagingType": "full_numbers",
					data:values["data"],
					 "dom": '<"top"i>rt<"bottom"lp>',
					 "scrollY":"400px",
					"scrollCollapse":true,
					columns:[
					        {"data":"id","bSearchable": false},
					        {"data":"status",className:"btnStatus","bSearchable": false,
					        	 "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
					        		 if(oData.status.toLowerCase()=='active'){
					        			 $(nTd).html("<span class='glyphicon glyphicon-ok' data-toggle='tooltip' " +
					                 		"data-placement='top' title='' data-original-title='Active' value='1'></span>");
					        		 }else{
					        			 $(nTd).html("<span class='glyphicon glyphicon-remove' data-toggle='tooltip' " +
					                 		"data-placement='top' title='' data-original-title='Active' value='0'></span>");
					        		 }
					             }
					        },
					        {"data":"firstName"},
					        {"data":"lastName"},
					        {"data":"phone","bSearchable": false},
					        {"data":"email","bSearchable": false},
					        {"data":"department"},
					        {"data":"contract","bSearchable": false},
					        {"data":"manager","bSearchable": false}
					],
					//"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
				});
			}
		}
	});
}

lms_adm_009p.loadData = function(){
	
	$.ajax({
		url : "../action/service/lms_adm_r015",
		dataType : "JSON",
		type : "POST",
		//data :a,
		success : function(dat) {
			var data =[]
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
				data.push(v);
				
			});
			$('#treeData').jstree({
				'checkbox': {
				 'keep_selected_style': true,
			     'tie_selection': false,
			     'whole_node': false // click on checkBox
				},
				"plugins": ["types","radio", "json_data","search","wholerow"],
				"animation":1,
				'core' : {
			    'data' : data,
			    "themes":{
		         "icons":true
			    }			           
			}})	
			.bind("select_node.jstree", function (event, data) {
				$('#txtOrgId').val(data.node.id);
			})
			
		}
	});
}

lms_adm_009p.selectDataTree=function(orgid){
	$.ajax({
		data:{"orgId":orgid},
		url:"../action/service/lms_adm_r009p",
		dataType: "JSON",
		type:"GET",
		success:function(data){
			_table.clear().draw();
			_table.rows.add(data.List);
			_table.columns.adjust().draw();
		}
	});
}
	
	