
package Lexico;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ]
saltos=[\t,\n]
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
ENTERO {return new Symbol(sym.ENTERO, yychar, yyline,yytext());}
TEXTO {return new Symbol(sym.TEXTO, yychar, yyline,yytext());}
FLOTANTE {return new Symbol(sym.FLOTANTE, yychar, yyline,yytext());}
SI {return new Symbol(sym.SI, yychar, yyline,yytext());}
SINO {return new Symbol(sym.SINO, yychar, yyline,yytext());}
PARA {return new Symbol(sym.PARA, yychar, yyline,yytext());}
MIENTRAS {return new Symbol(sym.MIENTRAS, yychar, yyline,yytext());}
ESCRIBIR {return new Symbol(sym.ESCRIBIR, yychar, yyline,yytext());}
LEER {return new Symbol(sym.LEER, yychar, yyline,yytext());}
DONDE {return new Symbol(sym.DONDE, yychar, yyline,yytext());}
ENTONCES {return new Symbol(sym.ENTONCES, yychar, yyline,yytext());}
FIN {return new Symbol(sym.FIN, yychar, yyline,yytext());}
A {return new Symbol(sym.A, yychar, yyline,yytext());}
INTERRUPTOR {return new Symbol(sym.INTERRUPTOR, yychar, yyline,yytext());}
CASO {return new Symbol(sym.CASO, yychar, yyline,yytext());}
DEFECTO {return new Symbol(sym.DEFECTO, yychar, yyline,yytext());}
{saltos} {/*Ignore*/}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {return new Symbol(sym.Asignacion, yychar, yyline,yytext());}
"==" {return new Symbol(sym.Comparacion, yychar, yyline,yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline,yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline,yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline,yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline,yytext());}
";" {return new Symbol(sym.Cierre, yychar, yyline,yytext());}
"," {return new Symbol(sym.Coma, yychar, yyline,yytext());}
"." {return new Symbol(sym.Punto, yychar, yyline,yytext());}
"(" {return new Symbol(sym.A_Parentesis, yychar, yyline,yytext());}
")" {return new Symbol(sym.C_Parentesis, yychar, yyline,yytext());}
"<=" {return new Symbol(sym.MenorIgual, yychar, yyline,yytext());}
">=" {return new Symbol(sym.MayorIgual, yychar, yyline,yytext());}
"<" {return new Symbol(sym.Menor, yychar, yyline,yytext());}
">" {return new Symbol(sym.Mayor, yychar, yyline,yytext());}
"\"" {return new Symbol(sym.Comillas, yychar, yyline,yytext());}
":" {return new Symbol(sym.DosPuntos, yychar, yyline,yytext());}
"{" {return new Symbol(sym.A_Llaves, yychar, yyline,yytext());}
"}" {return new Symbol(sym.C_Llaves, yychar, yyline,yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline,yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline,yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline,yytext());}
