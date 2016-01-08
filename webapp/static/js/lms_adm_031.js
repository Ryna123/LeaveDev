			$(window).load(function () {

                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();
                var started;
                var categoryClass;

                var calendar = $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,agendaWeek,agendaDay'
                    },
              //      eventLimit: true,
                    views:{
                    	agenda:{
                    		eventLimit:4
                    	}
                    },
                    
                    selectable: true,
                    selectHelper: true,
                    select: function (start, end, allDay) {
                        $('#fc_create').click();

                        started = start;
                        ended = end

                        $(".antosubmit").on("click", function () {
                            var title = $("#title").val();
                            if (end) {
                                ended = end
                            }
                            categoryClass = $("#event_type").val();

                            if (title) {
                                calendar.fullCalendar('renderEvent', {
                                        title: title,
                                        start: started,
                                        end: end,
                                        allDay: false                                        
                                    },
                                    true // make the event "stick"
                                );
                            }
                            $('#title').val('');
                            calendar.fullCalendar('unselect');

                            $('.antoclose').click();

                            return false;
                        });
                    },
                    eventClick: function (calEvent, jsEvent, view) {
                        // alert(calEvent.title, jsEvent, view);

                        $('#fc_edit').click();
                        $('#title2').val(calEvent.title);
                        categoryClass = $("#event_type").val();

                        $(".antosubmit2").on("click", function () {
                            calEvent.title = $("#title2").val();

                            calendar.fullCalendar('updateEvent', calEvent);
                            $('.antoclose2').click();
                        });
                        calendar.fullCalendar('unselect');
                    },
                    timezone :  'Local'
                	
         //           editable: true,
//                    events: [
//                        {
//                            title: 'Special Leave',
//                            start: new Date(y, m, d - 5),
//                            end: new Date(y, m, d - 2),
//                        	color: '#337ab7',
//                        },
//                        {
//                        	title: 'Sick hay',
//                        	start: new Date(y, m, d),
//                    		start: new Date(y, m, d+4),
//                    		color: '#337ab7',
//                        },
//                        {
//                        	title: 'Annual leave',
//                        	start: new Date(y, m, d - 4),
//                            color: '#f0ad4e'
//                        },
//                        {
//                        	title: 'Annual leave',
//                        	start: new Date(y, m, d - 4),
//                            color: '#f0ad4e'
//                        },
//                        {
//                        	title: 'Annual leave',
//                        	start: new Date(y, m, d - 4),
//                            color: '#f0ad4e'
//                        },
//                        {
//                        	title: 'Annual leave',
//                        	start: new Date(y, m, d - 9),
//                            color: '#d9534f'
//                        }
//                       
//                    ]
                });
                loading(true);
            	var a = {empId :2};
            	$.ajax({
            		url : "../action/service/lms_adm_002",
            		dataType : "JSON",
            		type : "POST",
            		data :a,
            		success : function(data) {
            			console.log(data.RESP_DATA);
            				var res = data.RESP_DATA['LEAVES_REC'];
            				$.each(data.RESP_DATA['LEAVES_REC'],function(i){
            					var thisStatus = data.RESP_DATA['LEAVES_REC'][i];
            					if(thisStatus.leavesStatus=='Approved'){
            						var events=[{
            							title:thisStatus.leavesStatus,
	            						start:thisStatus.leavesStartdate,
	            						end:  thisStatus.leavesEnddate,
	            						color:'#26B99A'
	            						
            						}];	
        						}else if(thisStatus.leavesStatus=='Planned'){
        							var events=[{
            							title: thisStatus.leavesStatus,
	            						start: thisStatus.leavesStartdate,
	            						end:  thisStatus.leavesEnddate,
	            						color:'#5bc0de'
        							}];	
        						}else if(thisStatus.leavesStatus=='Requested'){
        							var events=[{
            							title: thisStatus.leavesStatus,
	            						start:thisStatus.leavesStartdate,
	            						end:  thisStatus.leavesEnddate,
	            						color:'#f0ad4e'
	            						
        							}];	
        						}else if(thisStatus.leavesStatus=='Rejected'){
        							var events=[{
            							title: thisStatus.leavesStatus,
	            						start: thisStatus.leavesStartdate,
	            						end:  thisStatus.leavesEnddate,
	            						color:'#d9534f'
        							}];	
        						}
            					
            					 $('#calendar').fullCalendar('addEventSource', events);
            					
            				});
            				
            				loading(false);
            			},
            			
            		});
                
                
                
            });