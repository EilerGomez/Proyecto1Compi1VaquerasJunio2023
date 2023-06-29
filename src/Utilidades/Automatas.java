/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Lexico.Tokens;

/**
 *
 * @author HP
 */
public class Automatas {

    int[][] tabla;

    public Automatas() {
        this.tabla = new int[200][100];
        //ASIGNACION PARA ENTEROS
        tabla[0][0] = 0;
        tabla[0][1] = 1;//[ESTADO INICIAL][ENTERO] -> ESTADO1
        tabla[1][26] = 4;//[ESTADO1][ID] -> ESTADO4
        tabla[4][12] = 5;//[ESTADO1][ASIGNACION] -> ESTADO 5
        tabla[5][27] = 6;//[ESTADO 5] [NUMERO] -> ESTADO 6
        tabla[6][18] = 7;//[ESTADO 6] [CIERRE] -> ESTADO 7 -> ESTADO INICIAL
        tabla[4][18] = 7;//[ESTADO4] [CIERRE] -> ESTADO 7 -> ESTADO INICIAL
        //PARA ENTEROS CON OPERACIONES:
        tabla[5][26] = 61;//[ESTADO 5] [ID] -> ESTADO 61
        tabla[61][14] = 57;//[ESTADO 5] [SUMA] -> ESTADO 57
        tabla[61][15] = 57;//[ESTADO 5] [RESTA] -> ESTADO 57
        tabla[61][16] = 57;//[ESTADO 5] [MULTIPLICACION] -> ESTADO 57
        tabla[61][17] = 57;//[ESTADO 5] [DIVISION] -> ESTADO 57
        tabla[61][18] = 7;//[ESTADO 61] [CIERRE] -> ESTADO 7 --> ESTADO INICIAL
        tabla[6][14] = 57;//[ESTADO 6] [SUMA] -> ESTADO 57
        tabla[6][15] = 57;//[ESTADO 6] [RESTA] -> ESTADO 57
        tabla[6][16] = 57;//[ESTADO 6] [MULTIPLICACION] -> ESTADO 57
        tabla[6][17] = 57;//[ESTADO 6] [DIVISION] -> ESTADO 57
        tabla[57][26] = 60;//[ESTADO 57] [ID] -> ESTADO 60
        tabla[60][18] = 59;//[ESTADO 60] [CIERRE] -> ESTADO 59 --> ESTADO INICIAL
        tabla[57][27] = 58;//[ESTADO 57] [NUMRO] -> ESTADO 58
        tabla[58][18] = 59;//[ESTADO 58] [CIERRE] -> ESTADO 59 --> ESTADO INICIAL

        //ASIGNACION PARA TEXTOS:        
        tabla[0][2] = 2; //[ESTADO INICIAL] [TEXTO] -> ESTADO 2
        tabla[2][26] = 8; //[ESTADO 2] [ID] -> ESTADO 8
        tabla[8][12] = 9;////[ESTADO 8][ASIGNACION] -> ESTADO 9
        tabla[9][21] = 10; //[ESTADO9] [COMILLAS] -> ESTADO 10
        tabla[10][21] = 11;//[ESTADO10] [COMILLAS] -> ESTADO 11
        tabla[11][18] = 12;//[ESTADO 11] [CIERRE] -> ESTADO 12 -> ESTADO INICIAL
        tabla[8][18] = 12;//[ESTADO 11] [CIERRE] -> ESTADO 12 -> ESTADO INICIAL

        //ASIGNACION DE FLOTANTES:
        tabla[0][3] = 3; //[ESTADO INICIAL] [FLOTANTE] -> ESTADO 3
        tabla[3][26] = 13; //[ESTADO 3] [ID] -> ESTADO 13
        tabla[13][12] = 14; //[ESTADO 13] [ASIGNACION] -> ESTADO 14
        tabla[14][27] = 15; //[ESTADO 14] [NUMERO] -> ESTADO 15
        tabla[15][20] = 16; //[ESTADO 15] [PUNTO] -> ESTADO 16
        tabla[16][27] = 17; //[ESTADO 16] [NUMERO] -> ESTADO 17
        tabla[17][18] = 18; //[ESTADO 17] [CIERRE] -> ESTADO 18
        tabla[13][18] = 18; //[ESTADO 13] [CIERRE] -> ESTADO 18
        tabla[15][18] = 18; //[ESTADO 15] [CIERRE] -> ESTADO 18

        //ASIGNACION DE VARIABLES QUE YA PUEDEN ESTAR DEFINIDAS
        tabla[0][26] = 19; //[ESTADO INICIAL] [ID] -> ESTADO 19
        //ENTEROS
        tabla[20][12] = 23; //[ESTADO 20] [ASIGNACION] -> ESTADO 23 ESTADO 20 REPRESENTA QUE YA HA SIDO COMPROBADA QUE ES UN ENTERO
        tabla[23][27] = 24; //[ESTADO 23] [NUMERO] -> ESTADO 24
        tabla[24][18] = 25; //[ESTADO 24] [CIERRE] -> ESTADO 25 -> ESTADO INICIAL
        //CON OPERACIONES
        tabla[24][14] = 63; //[ESTADO 24] [SUMA] -> ESTADO 63
        tabla[24][15] = 63; //[ESTADO 24] [RESTA] -> ESTADO 63
        tabla[24][16] = 63; //[ESTADO 24] [MULT] -> ESTADO 63
        tabla[24][17] = 63; //[ESTADO 24] [DIVISION] -> ESTADO 63
        tabla[23][26] = 62; //[ESTADO 23] [ID] -> ESTADO 62
        tabla[62][18] = 25; //[ESTADO 62] [CIERRE] -> ESTADO 25 --> ESTADO INICIAL
        tabla[62][14] = 63; //[ESTADO 62] [SUMA] -> ESTADO 63
        tabla[62][15] = 63; //[ESTADO 62] [RESTA] -> ESTADO 63
        tabla[62][16] = 63; //[ESTADO 62] [MULT] -> ESTADO 63
        tabla[62][17] = 63; //[ESTADO 62] [DIV] -> ESTADO 63
        tabla[63][26] = 66; //[ESTADO 63] [ID] -> ESTADO 66
        tabla[66][18] = 65; //[ESTADO 66] [CIERRE] -> ESTADO 65 --> ESTADO INICIAL
        tabla[63][27] = 64; //[ESTADO 63] [NUMERO] -> ESTADO 64
        tabla[64][18] = 65; //[ESTADO 64] [CIERRE] -> ESTADO 65 --> ESTADO INICIAL
        //TEXTO
        tabla[21][12] = 26; //[ESTADO 21] [ASIGNACION] -> ESTADO 26 ESTADO 21 REPRESENTA QUE YA HA SIDO COMPROBADA QUE ES TEXTO
        tabla[26][21] = 27; //[ESTADO 26] [COMILLAS] -> ESTADO 27
        tabla[27][21] = 28; //[ESTADO 27] [COMILLAS] -> ESTADO 28
        tabla[28][18] = 29; //[ESTADO 28] [CIERRE] -> ESTADO 29 -> ESTADO INICIAL
        //FLOTANTE
        tabla[22][12] = 30; //[ESTADO 22] [ASIGNACION] -> ESTADO 30
        tabla[30][27] = 31; //[ESTADO 30] [NUMERO] -> ESTADO 31
        tabla[31][20] = 32; //[ESTADO 31] [PUNTO] -> ESTADO 32
        tabla[32][27] = 33; //[ESTADO 32] [NUMERO] -> ESTADO 33
        tabla[33][18] = 34; //[ESTADO 33] [CIERRE] -> ESTADO 34 -> ESTADO INICIAL
        tabla[31][18] = 34; //[ESTADO 30] [CIERRE] -> ESTADO 34 ESTADO INICIAL

        //PARA ESCRIBIR
        tabla[0][31] = 35;//[ESTADO 0] [ESCRIBIR] -> ESTADO 35
        tabla[35][22] = 36;//[ESTADO 35] [A_paretnesis] -> ESTADO 36
        tabla[36][21] = 37;//[ESTADO 36] [COMILLAS] -> ESTADO 37
        tabla[37][21] = 38;//[ESTADO 37] [COMILLAS] -> ESTADO 38
        tabla[38][23] = 39;//[ESTADO 38] [C_Parentesis] -> ESTADO 39
        tabla[39][18] = 41;//[ESTADO 39] [Cierre] -> ESTADO 41 --> estado inicial
        tabla[36][26] = 40;//[ESTADO 36] [ID] -> ESTADO 40
        tabla[40][23] = 39;//[ESTADO 40] [C_Parentesis] -> ESTADO 39

        //PARA EL CICLO FOR
        tabla[0][6] = 42;//[ESTADO 0] [PARA] -> ESTADO 42
        tabla[42][22] = 43;//[ESTADO 42] [A_Parentesis] -> ESTADO 43
        tabla[43][27] = 44;//[ESTADO 43] [NUMERO] -> ESTADO 44
        tabla[44][35] = 45;//[ESTADO 44] [A] -> ESTADO 45
        tabla[45][27] = 46;//[ESTADO 45] [NUMERO] -> ESTADO 46
        tabla[46][23] = 47;//[ESTADO 46] [CIERRE_PARENTESIS] -> ESTADO 47
        tabla[43][26] = 67;//[ESTADO 43] [ID] -> ESTADO 67
        tabla[67][35] = 45;//[ESTADO 67] [A] -> ESTADO 45
        tabla[45][26] = 68;//[ESTADO 45] [ID] -> ESTADO 68
        tabla[68][23] = 47;//[ESTADO 68] [CIERRE_PARENTESIS] -> ESTADO 47
        tabla[47][40] = 48;//[ESTADO 47] [A_Llaves] -> ESTADO 48

        //ESCRIBIR EN FOR
        tabla[47][31] = 48;//[ESTADO 47] [ESCRIBIR] -> ESTADO 48
        tabla[48][22] = 49;//[ESTADO 48] [A_paretnesis] -> ESTADO 49
        tabla[49][21] = 50;//[ESTADO 49] [COMILLAS] -> ESTADO 50
        tabla[50][21] = 51;//[ESTADO 50] [COMILLAS] -> ESTADO 51
        tabla[51][23] = 52;//[ESTADO 51] [C_Parentesis] -> ESTADO 52
        tabla[52][18] = 53;//[ESTADO 52] [Cierre] -> ESTADO 53 
        tabla[53][10] = 55;//[ESTADO 53] [FIN] -> ESTADO 55 --> ESTADO 56 --> ESTADO INICIAL
        tabla[53][31] = 48;//[ESTADO 53] [ESCRIBIR] -> ESTADO 48
        tabla[49][26] = 54;//[ESTADO 49] [ID] -> ESTADO 54
        tabla[54][23] = 53;//[ESTADO 54] [C_Parentesis] -> ESTADO 53

        //ASIGNAR EN FOR
        tabla[47][26] = 69;//[ESTADO 47] [ID] -> ESTADO 59
        tabla[69][12] = 70;//[ESTADO 59] [ASIGNACION] -> ESTADO 70
        tabla[70][27] = 71;//[ESTADO 70] [NUMERO] -> ESTADO 71
        tabla[71][18] = 72;//[ESTADO 71] [Cierre] -> ESTADO 72
        tabla[72][10] = 73;//[ESTADO 72] [FIN] -> ESTADO 73 --> ESTADO INICIAL
        tabla[71][14] = 75;//[ESTADO 71] [SUMA] -> ESTADO 75
        tabla[71][15] = 75;//[ESTADO 71] [RESTA] -> ESTADO 75
        tabla[71][16] = 75;//[ESTADO 71] [MULT] -> ESTADO 75
        tabla[71][17] = 75;//[ESTADO 71] [DIVISION] -> ESTADO 75
        tabla[70][26] = 74;//[ESTADO 70] [ID] -> ESTADO 74
        tabla[74][18] = 72;//[ESTADO 74] [Cierre] -> ESTADO 72
        tabla[74][14] = 75;//[ESTADO 74] [SUMA] -> ESTADO 75
        tabla[74][15] = 75;//[ESTADO 74] [RESTA] -> ESTADO 75
        tabla[74][16] = 75;//[ESTADO 74] [MULT] -> ESTADO 75
        tabla[74][17] = 75;//[ESTADO 74] [DIV] -> ESTADO 75
        tabla[75][27] = 76;//[ESTADO 75] [NUMERO] -> ESTADO 76
        tabla[76][18] = 78;//[ESTADO 76] [Cierre] -> ESTADO 78
        tabla[78][10] = 79;//[ESTADO 78] [FIN] -> ESTADO 79 --> ESTADO INICIAL
        tabla[75][26] = 77;//[ESTADO 75] [ID] -> ESTADO 77
        tabla[77][18] = 78;//[ESTADO 77] [Cierre] -> ESTADO 78

        //IF Y IF-ELSE
        tabla[0][4] = 80;//[ESTADO INICIAL] [SI] -> ESTADO 80
        tabla[80][22] = 81;//[ESTADO 80] [A_Parentesis] -> ESTADO 81
        tabla[81][27] = 82;//[ESTADO 81] [NUMERO] -> ESTADO 82
        tabla[82][13] = 84;//[ESTADO 82] [COMPARACION] -> ESTADO 84
        tabla[82][24] = 84;//[ESTADO 82] [MAYORIGUAL] -> ESTADO 84
        tabla[82][25] = 84;//[ESTADO 82] [MENORIGUAL] -> ESTADO 84
        tabla[82][33] = 84;//[ESTADO 82] [MAYOR] -> ESTADO 84
        tabla[82][34] = 84;//[ESTADO 82] [MENOR] -> ESTADO 84
        tabla[81][26] = 83;//[ESTADO 81] [ID] -> ESTADO 83
        tabla[83][13] = 84;//[ESTADO 83] [COMPARACION] -> ESTADO 84
        tabla[83][24] = 84;//[ESTADO 83] [MAYORIGUAL] -> ESTADO 84
        tabla[83][25] = 84;//[ESTADO 83] [MENORIGUAL] -> ESTADO 84
        tabla[83][33] = 84;//[ESTADO 83] [MAYOR] -> ESTADO 84
        tabla[83][34] = 84;//[ESTADO 83] [MENOR] -> ESTADO 84
        tabla[84][27] = 85;//[ESTADO 84] [NUMERO] -> ESTADO 85
        tabla[85][23] = 87;//[ESTADO 85] [C_Parentesis] -> ESTADO 87
        tabla[84][26] = 86;//[ESTADO 84] [ID] -> ESTADO 86
        tabla[86][23] = 87;//[ESTADO 86] [C_Parentesis] -> ESTADO 77
        tabla[87][40] = 88;//[ESTADO 87] [C_Llaves] -> ESTADO 88 EN EL ESTADO 88 GUARDAR EL TEXTO HASTA QUE VENGA OTRO CIERRE DE LLAVES
        //EN EL ESTADO 87 EVALUAR SI CUMPLE LA CONDICION O NO, DE MODO QUE SI SI MANDARLO AL ESTADO 88 SINO MANDARLO AL ESTADO 89
        //tabla[88][10] = 90;//[ESTADO 88] [FIN] -> ESTADO 90 --> ESTADO INICIAL
        tabla[0][5] = 89;//[ESTADO 0] [SINO] -> ESTADO 89
        tabla[89][40] = 90;//[ESTADO 89] [A_Llaves] -> ESTADO 90 EN ESTE ESTADO GUARDA EL TEXTO HASTA QEU ENCUENTRE CIERRE DE LLAVES

        tabla[92][22] = 93;//[ESTADO 92] [A_Parentesis] -> ESTADO 93
        tabla[93][26] = 99;//[ESTADO 93] [ID] -> ESTADO 99
        tabla[99][23] = 96;//[ESTADO 99] [C_Parentesis] -> ESTADO 96
        tabla[93][21] = 94;//[ESTADO 93] [COMILLAS] -> ESTADO 94
        tabla[94][21] = 95;//[ESTADO 94] [COMILLAS] -> ESTADO 95
        tabla[95][23] = 96;//[ESTADO 95] [C_Parentesis] -> ESTADO 96
        tabla[96][18] = 97;//[ESTADO 96] [Cierre] -> ESTADO 97
        tabla[97][10] = 98;//[ESTADO 97] [FIN] -> ESTADO 98 --> ESTADO INICIAL
        tabla[97][5] = 100;//[ESTADO 97] [SINO] -> ESTADO 100
        tabla[100][5] = 100;//[ESTADO 99] [SINO] -> ESTADO 100
        tabla[100][10] = 98;//[ESTADO 99] [FIN] -> ESTADO 98
        tabla[97][31] = 92;//[ESTADO 97] [ESCRIBIR] -> ESTADO 92

        tabla[89][31] = 92;//[ESTADO 89] [ESCRIBIR] -> ESTADO 92

        //IF ELSE PARA ASIGNACION DE VARIABLES
        tabla[89][26] = 101;//[ESTADO 89] [ID] -> ESTADO 101
        tabla[91][26] = 101;//[ESTADO 91] [ID] -> ESTADO 101
        tabla[101][12] = 102;//[ESTADO 101] [ASIGNACION] -> ESTADO 102
        tabla[102][26] = 104;//[ESTADO 102] [ID] -> ESTADO 104
        tabla[104][18] = 105;//[ESTADO 104] [CIERRE] -> ESTADO 105
        tabla[105][10] = 106;//[ESTADO 105] [FIN] -> ESTADO 106 --> ESTADO INICIAL
        tabla[105][5] = 107;//[ESTADO 105] [SINO] -> ESTADO 107
        tabla[107][10] = 106;//[ESTADO 107] [FIN] -> ESTADO 106 --> ESTADO INICIAL
        tabla[102][27] = 103;//[ESTADO 102] [NUMERO] -> ESTADO 103
        tabla[103][18] = 105;//[ESTADO 103] [CIERRE] -> ESTADO 105
        tabla[104][14] = 113;//[ESTADO 104] [SUMA] -> ESTADO 113
        tabla[104][15] = 113;//[ESTADO 104] [RESTA] -> ESTADO 113
        tabla[104][16] = 113;//[ESTADO 104] [MULT] -> ESTADO 113
        tabla[104][17] = 113;//[ESTADO 104] [DIVISION] -> ESTADO 113
        tabla[103][14] = 113;//[ESTADO 103] [SUMA] -> ESTADO 113
        tabla[103][15] = 113;//[ESTADO 103] [RESTA] -> ESTADO 113
        tabla[103][16] = 113;//[ESTADO 103] [MULT] -> ESTADO 113
        tabla[103][17] = 113;//[ESTADO 103] [DIVISION] -> ESTADO 113
        tabla[113][26] = 109;//[ESTADO 113] [ID] -> ESTADO 109
        tabla[109][18] = 110;//[ESTADO 109] [CIERRE] -> ESTADO 110
        tabla[110][5] = 112;//[ESTADO 110] [SINO] -> ESTADO 112
        tabla[110][10] = 111;//[ESTADO 110] [FIN] -> ESTADO 111 --> ESTADO INICIAL
        tabla[112][10] = 111;//[ESTADO 112] [FIN] -> ESTADO 111 --> ESTADO INICIAL
        tabla[113][27] = 108;//[ESTADO 113] [NUMERO] -> ESTADO 108
        tabla[108][18] = 110;//[ESTADO 108] [CIERRE] -> ESTADO 110
        tabla[105][26] = 101;//[ESTADO 105] [ID] -> ESTADO 101
        tabla[110][26] = 101;//[ESTADO 110] [ID] -> ESTADO 101

        //PARA LEER:
        tabla[0][32] = 114;//[ESTADO 0] [LEER] -> ESTADO 114
        tabla[114][22] = 115;//[ESTADO 114] [A_Parentesis] -> ESTADO 115
        tabla[115][26] = 116;//[ESTADO 115] [ID] -> ESTADO 116
        tabla[116][23] = 117;//[ESTADO 116] [C_Parentesis] -> ESTADO 117
        tabla[117][18] = 118;//[ESTADO 117] [CIERRE] -> ESTADO 118

        //PARA EL CICLO WHILE:
        tabla[0][7] = 119;//[ESTADO 0] [mientras] -> ESTADO 119
        tabla[119][22] = 120;//[ESTADO 119] [A_Parentesis] -> ESTADO 120
        tabla[120][26] = 121;//[ESTADO 120] [Identificador] -> ESTADO 121
        tabla[121][13] = 122;//[ESTADO 121] [COMPARACION] -> ESTADO 122
        tabla[121][24] = 122;//[ESTADO 121] [MENORiGUAL] -> ESTADO 122
        tabla[121][25] = 122;//[ESTADO 121] [MAYORIGUAL] -> ESTADO 122
        tabla[121][33] = 122;//[ESTADO 121] [MAYOR] -> ESTADO 122
        tabla[121][34] = 122;//[ESTADO 121] [MENOR] -> ESTADO 122
        tabla[120][27] = 156;//[ESTADO 120] [NUMERO] -> ESTADO 156
        tabla[156][13] = 122;//[ESTADO 156] [COMPARACION] -> ESTADO 122
        tabla[156][24] = 122;//[ESTADO 156] [MENORiGUAL] -> ESTADO 122
        tabla[156][25] = 122;//[ESTADO 156] [MAYORIGUAL] -> ESTADO 122
        tabla[156][33] = 122;//[ESTADO 156] [MAYOR] -> ESTADO 122
        tabla[156][34] = 122;//[ESTADO 156] [MENOR] -> ESTADO 122
        tabla[122][26] = 123;//[ESTADO 122] [ID] -> ESTADO 123
        tabla[122][27] = 124;//[ESTADO 122] [NUMERO] -> ESTADO 124
        tabla[124][23] = 125;//[ESTADO 124] [cIERRE PARENTESIS] -> ESTADO 125
        tabla[123][23] = 125;//[ESTADO 123] [cIERRE PARENTESIS] -> ESTADO 125
        tabla[125][40] = 134;//[ESTADO 125] [A_Llaves] -> ESTADO 134

        //PARA LA SENTENCIA SWITCH
        tabla[0][37] = 144;//[ESTADO 0] [INTERRUPTOR] -> ESTADO 144
        tabla[144][22] = 145;//[ESTADO 144] [A_PARENTESIS] -> ESTADO 145
        tabla[145][26] = 146;//[ESTADO 145] [IDENTIFICADOR] -> ESTADO 146
        tabla[146][23] = 147;//[ESTADO 146] [C_PARENTESIS] -> ESTADO 147
        tabla[155][38] = 148;//[ESTADO 155] [CASO] -> ESTADO 148
        tabla[148][27] = 149;//[ESTADO 148] [NUMERO] -> ESTADO 149
        tabla[149][36] = 152;//[ESTADO 149] [DOS_PUNTOS] -> ESTADO 152 // REVISAR SI CUMPLE CON LA FUNCION O NO
        tabla[148][21] = 150;//[ESTADO 148] [COMILLAS] -> ESTADO 150
        tabla[150][21] = 151;//[ESTADO 150] [COMILLAS] -> ESTADO 151
        tabla[151][36] = 152;//[ESTADO 151] [DOS_PUNTOS] -> ESTADO 152
        tabla[157][38] = 148;//[ESTADO 157] [caso] -> ESTADO 148
        tabla[157][39] = 153;//[ESTADO 157] [DEFECTO] -> ESTADO 153
        tabla[153][41] = 0;//[ESTADO 153] [fin] -> ESTADO 0 ESTADO INICIAL
        tabla[153][38] = 154;//[ESTADO 153] [caso] -> ESTADO 0 ESTADO INICIAL
        tabla[153][39] = 154;//[ESTADO 153] [DEFECTO] -> ESTADO 0 ESTADO INICIAL
        tabla[147][40] = 155;//[ESTADO 147] [A_Llaves] -> ESTADO 155

        //PARA GUARDAR EL CUERPO DE UN METODO:
        tabla[0][42] = 158;//[ESTADO 0] [METODO] -> ESTADO 158
        tabla[158][26] = 159;//[ESTADO 158] [Identificador] -> ESTADO 159
        tabla[159][22] = 160;//[ESTADO 159] [A_Parentesis] -> ESTADO 160
        tabla[160][23] = 161;//[ESTADO 160] [C_Parentesis] -> ESTADO 161
        tabla[161][40] = 162;//[ESTADO 161] [A_Llaves] -> ESTADO 162 GUARDAR TODOS LOS TOKENS Y LEXEMAS HASTA ENCONTRAR UN CIERRE DE LLAVE Y QUE EL BLOQUE =0
        //PARAMETROS DEL METODO
        tabla[160][1] = 163;//[ESTADO 160] [ENTERO] -> ESTADO 163
        tabla[160][2] = 163;//[ESTADO 160] [TEXTO] -> ESTADO 163
        tabla[160][3] = 163;//[ESTADO 160] [FLOTANTE] -> ESTADO 163
        tabla[163][26] = 164;//[ESTADO 163] [Identificador] -> ESTADO 164
        tabla[164][18] = 165;//[ESTADO 164] [Cierre] -> ESTADO 165
        tabla[165][1] = 163;//[ESTADO 165] [ENTERO] -> ESTADO 163
        tabla[165][2] = 163;//[ESTADO 165] [TEXTO] -> ESTADO 163
        tabla[165][3] = 163;//[ESTADO 165] [FLOTANTE] -> ESTADO 163
        tabla[164][23] = 161;//[ESTADO 164] [C_Parentesis] -> ESTADO 161

        //PARA LLAMAR A UN METODO
        tabla[19][22] = 166;//[ESTADO 19] [A_Parentesis] -> ESTADO 166
        tabla[166][27] = 167;//[ESTADO 166] [Numero] -> ESTADO 167
        tabla[167][18] = 166;//[ESTADO 167] [Cierre] -> ESTADO 166
        tabla[166][21] = 169;//[ESTADO 166] [Comillas] -> ESTADO 169
        tabla[169][21] = 167;//[ESTADO 169] [Comillas] -> ESTADO 167
        tabla[166][23] = 168;//[ESTADO 166] [C_Parentesis] -> ESTADO 168
        tabla[167][23] = 168;//[ESTADO 167] [C_Parentesis] -> ESTADO 168
        tabla[168][18] = 170;//[ESTADO 168] [Cierre] -> ESTADO 170 --> ESTADO INICIAL EJECUTAR EL CODIGO QUE CONTIENE EL METODO

        //PARA GUARDAR EL CUERPO DE UNA FUNCION
        tabla[0][43] = 171;//[ESTADO 0] [FUNCION] -> ESTADO 171
        tabla[171][1] = 172;//[ESTADO 171] [ENTERO] -> ESTADO 172
        tabla[171][2] = 172;//[ESTADO 171] [TEXTO] -> ESTADO 172
        tabla[171][3] = 172;//[ESTADO 171] [FLOTANTE] -> ESTADO 172
        tabla[172][26] = 173;//[ESTADO 172] [Identificador] -> ESTADO 173
        tabla[173][22] = 174;//[ESTADO 173] [A_PArentesis] -> ESTADO 174
        tabla[174][23] = 175;//[ESTADO 174] [c_pARENTESIS] -> ESTADO 175
        tabla[174][1] = 176;//[ESTADO 174] [ENTERO] -> ESTADO 176
        tabla[174][2] = 176;//[ESTADO 174] [TEXTO] -> ESTADO 176
        tabla[174][3] = 176;//[ESTADO 174] [FLOTANTE] -> ESTADO 176
        tabla[176][26] = 177;//[ESTADO 176] [Id] -> ESTADO 177
        tabla[177][18] = 178;//[ESTADO 177] [cierre] -> ESTADO 178
        tabla[178][1] = 176;//[ESTADO 178] [ENTERO] -> ESTADO 176
        tabla[178][2] = 176;//[ESTADO 178] [TEXTO] -> ESTADO 176
        tabla[178][3] = 176;//[ESTADO 178] [FLOTANTE] -> ESTADO 176
        tabla[177][23] = 175;//[ESTADO 177] [C_Parentesis] -> ESTADO 175
        tabla[175][40] = 179;//[ESTADO 175] [A_Llaves] -> ESTADO 179

        //reconociendo el valor del retorno
        tabla[0][44] = 180;//[ESTADO 0] [RETORNO] -> ESTADO 180
        tabla[180][26] = 181;//[ESTADO 180] [ID] -> ESTADO 181
        tabla[181][18] = 182;//[ESTADO 181] [CIERRE] -> ESTADO 182-----> VUELVCE AL ESTADO INICIAL
        
        //PARA CUANDO ESTEN ASIGNANDO PERO VIENE UNA FUNCION DECLARANDO
        tabla[62][22] = 183;//[ESTADO 62] [A_PARENTESIS] -> ESTADO 183
        tabla[61][22] = 183;//[ESTADO 61] [A_PARENTESIS] -> ESTADO 183
        tabla[183][27] = 184;//[ESTADO 183] [NUMERO] -> ESTADO 184
        tabla[183][21] = 185;//[ESTADO 183] [COMILLAS] -> ESTADO 185
        tabla[185][21] = 184;//[ESTADO 185] [COMILLAS] -> ESTADO 184
        tabla[184][18] = 183;//[ESTADO 184] [CIERRE] -> ESTADO 183
        tabla[183][23] = 186;//[ESTADO 183] [C_PARENTESIS] -> ESTADO 186
        tabla[184][23] = 186;//[ESTADO 184] [C_PARENTESIS] -> ESTADO 186
        tabla[186][14] = 57;//[ESTADO 186] [suma] -> ESTADO 57
        tabla[186][15] = 57;//[ESTADO 186] [resta] -> ESTADO 57
        tabla[186][16] = 57;//[ESTADO 186] [mult] -> ESTADO 57
        tabla[186][17] = 57;//[ESTADO 186] [division] -> ESTADO 57
        tabla[186][18] = 7;//[ESTADO 61] [A_PARENTESIS] -> ESTADO 183
        
        
        tabla[66][22] = 187;//[ESTADO 66] [A_PARENTESIS] -> ESTADO 187
        tabla[60][22] = 187;//[ESTADO 60] [A_PARENTESIS] -> ESTADO 187
        tabla[187][27] = 188;//[ESTADO 187] [NUMERO] -> ESTADO 188
        tabla[187][21] = 189;//[ESTADO 187] [COMILLAS] -> ESTADO 189
        tabla[189][21] = 188;//[ESTADO 189] [COMILLAS] -> ESTADO 188
        tabla[188][18] = 187;//[ESTADO 188] [CIERRE] -> ESTADO 187
        tabla[187][23] = 190;//[ESTADO 187] [C_PARENTESIS] -> ESTADO 189
        tabla[188][23] = 190;//[ESTADO 188] [C_PARENTESIS] -> ESTADO 189
        tabla[190][18] = 59;//[ESTADO 189] [CIERRE] -> ESTADO 59
    }

    public int verificarSiguienteEstado(int estadoActual, Tokens token) {

        if (valorToken(token) == 11) {
            return estadoActual;
        } else {
            String var = "#" + tabla[49][49];
            //System.out.println(var);
            return tabla[estadoActual][valorToken(token)];

        }

    }

    public int valorToken(Tokens tokens) {
        int num = 0;
        switch (tokens) {

            case ENTERO:
                num = 1;
                break;
            case TEXTO:
                num = 2;
                break;//2
            case FLOTANTE:
                num = 3;
                break;//3
            case SI:
                num = 4;
                break;//4
            case SINO:
                num = 5;
                break;//5
            case PARA:
                num = 6;
                break;//6
            case MIENTRAS:
                num = 7;
                break;//7
            case DONDE:
                num = 8;
                break;//8
            case ENTONCES:
                num = 9;
                break;//9
            case FIN:
                num = 10;
                break;//10
            case Espacio:
                num = 11;
                break;//11
            case Asignacion:
                num = 12;
                break;//12
            case Comparacion:
                num = 13;
                break;//13
            case Suma:
                num = 14;
                break;//14
            case Resta:
                num = 15;
                break;//15
            case Multiplicacion:
                num = 16;
                break;//16
            case Division:
                num = 17;
                break;//17
            case Cierre:
                num = 18;
                break;//18
            case Coma:
                num = 19;
                break;//19
            case Punto:
                num = 20;
                break;//20
            case Comillas:
                num = 21;
                break;//21
            case A_Parentesis:
                num = 22;
                break;//22
            case C_Parentesis:
                num = 23;
                break;//23
            case MenorIgual:
                num = 24;
                break;//24
            case MayorIgual:
                num = 25;
                break;//25
            case Identificador:
                num = 26;
                break;//26
            case Numero:
                num = 27;
                break;//27
            case ERROR:
                num = 28;
                break;//28
            case Linea:
                num = 29;
                break;//29
            case Saltos:
                num = 30;
                break;//30
            case ESCRIBIR://31
                num = 31;
                break;
            case LEER://32
                num = 32;
                break;
            case Mayor://33
                num = 33;
                break;
            case Menor://34
                num = 34;
                break;
            case A://35
                num = 35;
                break;
            case DosPuntos: //36
                num = 36;
                break;
            case INTERRUPTOR: //37
                num = 37;
                break;
            case CASO: //38
                num = 38;
                break;
            case DEFECTO://39
                num = 39;
                break;
            case A_Llaves://40
                num = 40;
                break;
            case C_Llaves://41
                num = 41;
                break;
            case METODO:
                num = 42;
                break;
            case FUNCION:
                num = 43;
                break;
            case RETORNO:
                num = 44;
                break;
        }
        return num;
    }
}
