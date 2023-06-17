package Lexico;
import static Lexico.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ]
saltos=[\t]
linea = [\n]
%{
    public String lexeme;
%}
%%
ENTERO {lexeme=yytext(); return ENTERO;}
TEXTO {lexeme=yytext(); return TEXTO;}
FLOTANTE {lexeme=yytext(); return FLOTANTE;}
SI {lexeme=yytext(); return SI;}
SINO {lexeme=yytext(); return SINO;}
PARA {lexeme=yytext(); return PARA;}
MIENTRAS {lexeme=yytext(); return MIENTRAS;}
ESCRIBIR {lexeme=yytext(); return ESCRIBIR;}
LEER {lexeme=yytext(); return LEER;}
DONDE {lexeme=yytext(); return DONDE;}
ENTONCES {lexeme=yytext(); return ENTONCES;}
FIN {lexeme=yytext(); return FIN;}
CASO {lexeme=yytext(); return CASO;}
INTERRUPTOR {lexeme=yytext(); return INTERRUPTOR;}
DEFECTO {lexeme=yytext(); return DEFECTO;}
A {lexeme=yytext(); return A;}
{saltos} {lexeme=yytext(); return Saltos;}
{linea} {lexeme=yytext(); return Linea;}
{espacio} {lexeme=yytext(); return Espacio;}
"//".* {/*Ignore*/}
"=" {lexeme=yytext(); return Asignacion;}
"==" {lexeme=yytext(); return Comparacion;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
";" {lexeme=yytext(); return Cierre;}
"," {lexeme=yytext(); return Coma;}
"." {lexeme=yytext(); return Punto;}
"(" {lexeme=yytext(); return A_Parentesis;}
")" {lexeme=yytext(); return C_Parentesis;}
"<=" {lexeme=yytext(); return MenorIgual;}
">=" {lexeme=yytext(); return MayorIgual;}
"<" {lexeme=yytext(); return Menor;}
">" {lexeme=yytext(); return Mayor;}
"\"" {lexeme=yytext(); return Comillas;}
":" {lexeme=yytext(); return DosPuntos;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {lexeme=yytext(); return ERROR;}
