lexer grammar input;

#<evaluate(rawr = 5)>

#<if (rawr == 5)>
R: 'a';
#<end>
#<if (false)>
B: 'c';
#<end>



//#<if (expr)> line line line #<end>
//#<arguments> arg arg arg #<end>
//#<import(file, args...)>
//#<$var>

#<import ("grammar/input2.g4" "name1" "value2")>

/*
#<arguments>
	hello		//first argument
	boo			//second argument
	what		//third argument
#<end>

R: 'a';

#<if ("4" == "4")>
	R[[a]];
	#<if ("4" == "4")>
		R[[c]];
	#<end>
	#<if ("4" == "4")>
		R[[b]];
	#<end>
#<end>

#<if ("4" == "4")>
	R[[a]];
	#<if ("4" == "4")>
		R[[c]];
	#<end>
	#<if ("4" == "4")>
		R[[b]];
	#<end>
#<end>

#<import("grammar\\input2.g4", "v5", "3", "what?")>

#<if ("4" == "4")>
	R[[a]];
#<end>

R: 'b';
*/



