#<arguments>
	ruleName		//first argument
	ruleValue		//second argument
#<end>

A#<$ruleName>: '#<$ruleValue>';

//arguments
/*
#<arguments>
	version		//first argument
	count		//second argument
	123what		//third argument
#<end>

#<if (count > "0")>
	//Test#<$version>:		#<$123what>;
	#<import("grammar\\input3.g4", count)>
	#<if (count > "7")>
		//Test#<$version>:		#<$123what>;
		#<import("grammar\\input3.g4", 123what)>
	#<end>
	#<import("grammar\\input3.g4", count)>
#<end>
#<if (count > "1")>
	Test#<$version>:		#<$123what>
	Test#<$version>:		#<$123what>
	Test#<$version>:		#<$123what>
	Test#<$version>:		#<$123what>
	Test#<$version>:		#<$123what>
	Test#<$version>:		#<$123what>
	#<import("grammar\\input3.g4", 123what)>
	#<import("grammar\\input3.g4", 123what)>
#<end>

#<import("grammar\\input3.g4", 123what)>
*/