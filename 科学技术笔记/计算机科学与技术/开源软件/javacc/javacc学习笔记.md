
cd /Users/zlq/Servers/javacc-6.0/bin

java -cp lib/javacc.jar javacc ../examples/SimpleExamples/Simple1.jj




扩展的巴科斯范式（EBNF）

GRAMMER_ELEMENT := list of grammer elements
                    | alternative list of grammer elements

expr :=  number
       | expr '+' expr
       | expr '-' expr
       | expr '*' expr
       | expr '/' expr
       | '(' + expr + ')'
       | - expr

number := digit + ('.' digit+)?

digit := '0' '1' '2' '3' '4' '5' '6' '7' '8' '9'

