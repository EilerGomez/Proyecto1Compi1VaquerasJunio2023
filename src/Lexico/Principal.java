/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lexico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author HP
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/src/Lexico/Lexer.flex";
        String ruta2 = "C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/src/Lexico/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/src/Lexico/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);

        //generando la parte sintactica
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/src/Lexico/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Path rutaSim = Paths.get("C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/src/Lexico/Sintax.java");
        if(Files.exists(rutaSim)){
            Files.delete(rutaSim);
        }
        
        Files.move(
                Paths.get("C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/sym.java"),
                Paths.get("C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/src/Lexico/sym.java")
        );
        Files.move(
                Paths.get("C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/Sintax.java"),
                Paths.get("C:/Users/HP/Documents/NetBeansProjects/Proyect1Compi1Vaq2023/src/Lexico/Sintax.java")
        );
    }
}
