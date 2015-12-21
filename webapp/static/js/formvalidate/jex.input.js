/**
 * INPUT BOX Handler
 * 
 * 현재는 Jquery를 사용하는데 Jquery를 사용하지 않는 곳도 있을수 있으니 그것을 염두에 두어야 한다.
 * 일단 Jquery로 코딩
 *
 * 사용예) <input type="text" data-input="lower2Upper antiWhiteSpace"/>
 *        ->두개 이상 적용할경우 띄어쓰기로 구분함.
 * 
 * @author 김학길
 */
{
var plugin_inputBox = JexPlugin.extend({
	init : function()
	{
		this._super();
		this.checker = "[data-input]";
		this.attrNm = "data-input";
		_this = this;
		this.commonKeyCode = [4,6,8,9,13,46,37,39];
	},
	/**
	 * 공통으로 처리할 keycode
	 **/
	isCommonKeyCode : function(code) {
		for (var i=0; i<this.commonKeyCode.length; i++) {
			if (this.commonKeyCode[i] == code) return true;
		}
		return false;
		
	},
	isCommonKeyEvent : function(event) {
		//ctrl + c, ctrl + v 허용
		if( (event.ctrlKey && (event.keyCode == 67 || event.keyCode == 86 || event.keyCode == 88))) {
			return true;
		}
		return false;
		
	},
	lower2Upper : function($e)
	{
		$e.blur(function(event){
			$(this).val( ($(this).val()).toUpperCase() );
		});
	},
	/**
	 * 인풋에 값 입력후 blur시 대문자를 소문자로 변환해준다. 
	 * 
	 * 사용법: data-input="upper2lower"
	 */
	upper2lower : function($e)
	{
		$e.blur(function(event){
			$(this).val( ($(this).val()).toLowerCase() );
		});
	},
	
	/**
	 * 숫자외에는 입력급지
	 * 
	 * 사용법: data-input="onlyNumber"
	 */
	onlyNumber : function($e)
	{
		
		
		/*var _this = this;
		$e.keydown(function(event){
			var code = _this.getKeyCode(event);
			if (_this.isCommonKeyCode(code)) return true;
			if( code>=48 && code<=57) {
				return true; 
			} else {
				return false;
			}
		});*/
		// read only number
		var _this = this;
		$e.keydown(function(event){
			var code = _this.getKeyCode(event);
			//var code = (event.which) ? event.which: event.keyCode;
			if (_this.isCommonKeyEvent(event)) return true;
			if (_this.isCommonKeyCode(code)) return true;
			if((code < 96 || code > 105) &&  ( code < 48 || code > 57)) {
				return false; 
			} else {
				return true;
			}
		});
		
		$(this).css("ime-mode","inactive");
		
//		$e.keypress(function(event){
//			if(isNaN(String.fromCharCode(event.keyCode))) {
//				event.preventDefault();
//			}
//		});

		$e.blur(function(event){
			var Re = /[^0-9]/g;
			$(this).val($(this).val().replace(Re,''));
		});	
	},
	/**
	 * 숫자외에는 입력급지
	 * 
	 * 사용법: data-input="onlyNumberWithDot"
	 */
	onlyNumberWithDot : function($e)
	{
		// read only number
		var _this = this;
		$e.keypress(function(evt){
//			var charCode = _this.getKeyCode(event);
	        var charCode = (evt.which) ? evt.which : event.keyCode;
	        var a = evt.target.value.indexOf(".")+1;
	        var b = evt.target.value.length;
	        if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57)) {
	            return false;
	        } else {
	            // If the number field already has . then don't allow to enter . again.

	            if (evt.target.value.search(/\./) > -1 && charCode == 46) {
	                return false;
	            }
	            if (evt.target.value.search(/\./) > -1){  	// check have dot or not 
	            	if(evt.target.value.substr(a, b).length >= 2){ // check lenght after dot 2 byte
	            		return false;
	            	}
	            }
	            return true;
	        }

		});
	},
	/**
	 * 숫자외에는 입력급지
	 * 
	 * 사용법: data-input="onlyAlphaNumberic"
	 */
	onlyAlphaNumberic : function($e)
	{
		$e.keypress(function(e){
		    if (window.event)
		        code = e.keyCode;
		    else
		        code = e.which;
		    if((code >=48 && code <58)||(code>=97 && code<=122)|| (code>=65 && code<=90))
		        return true;
		    else
		        
		        return false;
		});
		
	},
	
	
	/**
	 * 숫자외에는 입력급지, 입력후 금액 comma표현
	 * 
	 * 사용법: data-input="commaFormat"
	 */
	commaFormat : function($e)
	{
		this.onlyNumber($e);
		$e.blur(function(event){
			$(this).val( _this.commify($(this).val()));
		});
	},
	/**
	 * 영문만 입력
	 * 
	 * 사용법: data-input="onlyEng"
	 */
	onlyEng : function($e)
	{
		$e.keydown(function(event){
			var code = _this.getKeyCode(event);
			if( code>=90/*number 9*/ || code<=65/*number 0*/ )
			{
				return false; 
			}
		});
	},
	/**
	 * 한글만 입력
	 * 
	 * 사용법: data-input="onlyKor"
	 */
	onlyKor : function($e)
	{
		$e.keydown(function(event){
			var code = _this.getKeyCode(event);
			if(!(code < 47 && code > 58)) return false;
		});
	},
	/**
	 * DateFormat
	 * 
	 * 사용법: data-input="dateFormat"
	 */
	dateFormat : function($e)
	{
		$e.blur(function(event){
			var result = $(this).val();
			if (result.length == 8) { 
				result = result.substring(0,4)+"-"+result.substring(4,2)+"-"+result.substring(6,2);
				$(this).val( result );
			}
		});
	},
	/**
	 * 좌측정렬
	 * leftFormat
	 * 
	 * 사용법: data-input="leftFormat"
	 */	
	leftFormat : function($e)
	{
	},	
	/**
	 * 우측정렬
	 * rightFormat
	 * 
	 * 사용법: data-input="rightFormat"
	 */	
	rightFormat : function($e)
	{
	},
	/**
	 * 중앙정렬
	 * centerFormat
	 * 
	 * 사용법: data-input="centerFormat"
	 */	
	centerFormat : function($e)
	{
	},
	/**
	 * 소수점 포함 금액
	 * commaPointFormat
	 * 
	 * 사용법: data-input="commaPointFormat"
	 */	
	commaPointFormat : function($e)
	{
	},
	/**
	 * 주민등록번호
	 * ssnFormat
	 * 
	 * 사용법: data-input="ssnFormat"
	 */	
	ssnFormat : function($e)
	{
	},
	/**
	 * 사업자번호
	 * bizFormat
	 * 
	 * 사용법: data-input="bizFormat"
	 */		
	bizFormat : function($e)
	{
	},
	/**
	 * 계좌번호
	 * accFormat
	 * 
	 * 사용법: data-input="accFormat"
	 */		
	accFormat : function($e)
	{
	},
	/**
	 * 신용카드
	 * cardFormat
	 * 
	 * 사용법: data-input="cardFormat"
	 */		
	cardFormat : function($e)
	{
	},
	/**
	 * 해당 인풋에 공백(space)를 입력하지 못하도록한다.
	 * 붙여넣기 등으로 공백이 존재할경우에도 blur시 공백을 제거함
	 * 
	 * 사용법: data-input="antiWhiteSpace"
	 */
	antiWhiteSpace : function($e)
	{
		$e.keydown(function(event){
			var code = _this.getKeyCode(event);
			if( code==32 )
			{
				return false; 
			}
		});
		$e.blur(function(event){
			if(/ /g.test($(this).val()))
			{
				$(this).val( ($(this).val()).replace(/ /g, ""));
			}
		});
	},
	/**
	 * 해당 인풋에 설정된 최소값 이하로 입력 제한을 한다.
	 * 
	 * 사용법: data-input="minValue" allowable_data="5"
	 */
	minValue : function($e)
	{

	},	
	/**
	 * 해당 인풋에 설정된 최대값 이상으로 입력 제한을 한다.
	 * 
	 * 사용법: data-input="maxValue" allowable_data="10"
	 */
	maxValue : function($e)
	{

	},	
	/**
	 * 해당 인풋에 설정된 길이 이하로 입력시 제한을 한다.(Byte단위)
	 * 
	 * 사용법: data-input="minLang" allowable_data="5"
	 */
	minLang : function($e)
	{

	},	
	/**
	 * 해당 인풋에 설정된 길이 이상으로 입력시 제한을 한다.(Byte단위)
	 * 
	 * 사용법: data-input="maxLang" allowable_data="5"
	 */
	maxLang : function($e)
	{

	},		
	/**
	 * 해당 인풋에 설정된 특수문자만 입력 허용한다.
	 * 
	 * 사용법: data-input="specialChar" allowable_data="%,$,@"
	 */
	specialChar : function($e)
	{

	},	
	/**
	 * 해당 인풋에 이메일 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="emailValid"
	 */	
	emailValid : function($e)
	{
		
	},
	/**
	 * 해당 인풋에 주민등록번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="ssnValid"
	 */	
	ssnValid : function($e)
	{
		
	},	
	/**
	 * 해당 인풋에 사업자등록번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="bizValid"
	 */	
	bizValid : function($e)
	{
		
	},		
	/**
	 * 해당 인풋에 핸드폰번호 앞자리 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="mibileNumValid"
	 */	
	mobileNumValid : function($e)
	{
		
	},			
	/**
	 * 해당 인풋에 지역번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="telNumValid"
	 */	
	telNumValid : function($e)
	{
		
	},	
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="accNumValid"
	 */		
	accNumValid : function($e)
	{
		
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="corpNoValid"
	 */		
	corpNoValid : function($e)
	{
		$e.focus(function(event){
			$e.mask("999-99-99999");
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber20digits"
	 */		
	onlyNumber20digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
	            event.keyCode == 8  || //backspace
	            event.keyCode == 37 || //left arrow key
	            event.keyCode == 39 || //right arrow key
	            event.keyCode == 9) || //allow tab
	            digit.length < 20 && //maximum 20 digits
	            ((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
	            (event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
	            // Stop the event
	            event.preventDefault();
	            return false;
	        }
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber10digits"
	 */		
	onlyNumber10digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
					event.keyCode == 8  || //backspace
					event.keyCode == 37 || //left arrow key
					event.keyCode == 39 || //right arrow key
					event.keyCode == 9) || //allow tab
					digit.length < 10 && //maximum 20 digits
					((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
							(event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
				// Stop the event
				event.preventDefault();
				return false;
			}
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber6digits"
	 */		
	onlyNumber6digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
	            event.keyCode == 8  || //backspace
	            event.keyCode == 37 || //left arrow key
	            event.keyCode == 39 || //right arrow key
	            event.keyCode == 9) || //allow tab
	            digit.length < 6 && //maximum 5 digits
	            ((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
	            (event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
	            // Stop the event
	            event.preventDefault();
	            return false;
	        }
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber7digits"
	 */		
	onlyNumber7digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
	            event.keyCode == 8  || //backspace
	            event.keyCode == 37 || //left arrow key
	            event.keyCode == 39 || //right arrow key
	            event.keyCode == 9) || //allow tab
	            digit.length < 7 && //maximum 5 digits
	            ((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
	            (event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
	            // Stop the event
	            event.preventDefault();
	            return false;
	        }
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber5digits"
	 */		
	onlyNumber5digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
	            event.keyCode == 8  || //backspace
	            event.keyCode == 37 || //left arrow key
	            event.keyCode == 39 || //right arrow key
	            event.keyCode == 9) || //allow tab
	            digit.length < 5 && //maximum 5 digits
	            ((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
	            (event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
	            // Stop the event
	            event.preventDefault();
	            return false;
	        }
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber4digits"
	 */		
	onlyNumber4digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
	            event.keyCode == 8  || //backspace
	            event.keyCode == 37 || //left arrow key
	            event.keyCode == 39 || //right arrow key
	            event.keyCode == 9) || //allow tab
	            digit.length < 4 && //maximum 4 digits
	            ((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
	            (event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
	            // Stop the event
	            event.preventDefault();
	            return false;
	        }
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber3digits"
	 */		
	onlyNumber3digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
	            event.keyCode == 8  || //backspace
	            event.keyCode == 37 || //left arrow key
	            event.keyCode == 39 || //right arrow key
	            event.keyCode == 9) || //allow tab
	            digit.length < 3 && //maximum 3 digits
	            ((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
	            (event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
	            // Stop the event
	            event.preventDefault();
	            return false;
	        }
		});
	},
	/**
	 * 해당 인풋에 계좌번호 입력 후 blur시 유효성 검사를 한다.
	 * 
	 * 사용법: data-input="onlyNumber2digits"
	 */		
	onlyNumber2digits : function($e)
	{
		$e.keydown(function(event){
			var digit = $e.attr("value");
			if (!((event.keyCode == 46 ||//delete key
	            event.keyCode == 8  || //backspace
	            event.keyCode == 37 || //left arrow key
	            event.keyCode == 39 || //right arrow key
	            event.keyCode == 9) || //allow tab
	            digit.length < 2 && //maximum 2 digits
	            ((event.keyCode >= 48 && event.keyCode <= 57) || // allow 0-9
	            (event.keyCode >= 96 && event.keyCode <= 105)))) {//Numpad keyboard
	            // Stop the event
	            event.preventDefault();
	            return false;
	        }
		});
	},
	
	
	
	getKeyCode : function(e) {
		var code;
		if (!e) e = window.event;

		if (!!e.keyCode) code = e.keyCode;
		else if(e.which) code = e.which;
		
		return code;
	}, commify : function(n) {
		  var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
		  n += '';                          // 숫자를 문자열로 변환

		  while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');

		  return n;
	}
});

jex.plugin.add("INPUT_BOX", new plugin_inputBox());

}

$(document).ready(function(){
	
	var plugin = jex.plugin.get("INPUT_BOX");
	
	var $inList = $(document).find("[data-input]");
	
	$.each($inList, function(i,v){
		var execList = $(v).attr("data-input").split(/ /g);

		for(var k=0 ; k<execList.length ; k++)
		{
			var key = execList[k];
			if(!!key && typeof plugin[key] == "function")
			{
				plugin[key]( $(v) );
			}
		}
	});
});