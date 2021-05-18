import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import java.util.*;

import java.util.StringTokenizer;

public class Ejecucion {
    

        public static void displayVacio(int n,int m){
            for (int i=0;i<n;i++) 
            {
                for (int j=0;j<m;j++)
                {
                    System.out.print("  ");
                }
                System.out.println();
            }
        }

        public static void imprimirDisplay(int n,int m){
            String simbolo = Math.random()>5?"*":" ";
            for (int i=0;i<n;i++) 
            {
                if(i+1==n)
                {
                    simbolo = "#";
    
                }
                for (int j=0;j<m;j++)
                {
                    System.out.print(i+simbolo);
                }
                System.out.println();
            }
        }

        public static void borrarDisplay(int n){
            //Se le suma 1 si se ejecuta con el bat, ya que la ultima linea es el pause
            //for (int i=0;i<=n;i++){
                //System.out.println(ansi().cursorUpLine(i));
            //}
            System.out.println(ansi().cursor(2,1));
            displayVacio(5,6);
            System.out.println(ansi().cursor(1,1));
            System.out.println(ansi().reset());
        }

        public static void animar() throws InterruptedException{
		

            Thread.sleep(1000);
            
            /*
            for(int i=0;i<10;i++){
                System.out.print("\r");
                //System.out.print("\r");
                texto = texto+nuevo.charAt(i);
                System.out.print(texto);
                Thread.sleep(1000);
            }*/
        }

        public static String convertirUnicode(String letra,String cadena){
		
            StringBuilder str = new StringBuilder(cadena);
            int indice = -1;
            char caracter = 0;
            indice = str.lastIndexOf(letra);
            
            if(indice>=0 )
            {
                switch(letra){
                    case "á": caracter = '\u00E1';
                              break;
                    case "é": caracter = '\u00E9';
                              break;
                    case "í": caracter = '\u00ED';
                              break;
                    case "ó": caracter = '\u00F3';
                              break;
                    case "ú": caracter = '\u00FA';
                              break;
                    case "ñ": caracter = '\u00F1';
                              break;
                    case "Á": caracter = '\u00C1';
                              break;
                    case "É": caracter = '\u00C9';
                              break;
                    case "Í": caracter = '\u00CD';
                              break;
                    case "Ó": caracter = '\u00D3';
                              break;
                    case "Ú": caracter = '\u00DA';
                              break;
                    case "Ñ": caracter = '\u00D1';
                              break;
                }
                // System.out.println("\\u" + Integer.toHexString('÷' | 0x10000).substring(1));
                str.replace(indice,indice+1,""+caracter);
            }
    
            return str.toString();
        }

        public static void imprimir(String cadena)
	{
		String str; 
		str = convertirUnicode("á",cadena);
		str = convertirUnicode("Á",cadena);
		str = convertirUnicode("á",str);
		str = convertirUnicode("é",str);
		str = convertirUnicode("í",str);
		str = convertirUnicode("ó",str);
		str = convertirUnicode("ú",str);
		str = convertirUnicode("ñ",str);
		str = convertirUnicode("É",str);
		str = convertirUnicode("Í",str);
		str = convertirUnicode("Ó",str);
		str = convertirUnicode("Ú",str);
		str = convertirUnicode("Ñ",str);

		System.out.println(str);
	}

    public static StringBuilder obtenerLetraCancion(int inicio,int fin, String[]data)
	{
    
        StringBuilder str = new StringBuilder();
        StringTokenizer temp;

        try {
            

            for(int i = inicio; i<=fin; i++)
		{
            //System.out.println("@" + data[i]);

            String caracterNuevaLinea = new String("--");
            String caracterEspacio = new String(";");

            if(data[i].contains(caracterNuevaLinea)){

                temp = new StringTokenizer(data[i], caracterNuevaLinea);

                while(temp.hasMoreTokens()){
                    System.out.print(temp.nextToken()+" ");
                }
                System.out.println();
                Thread.sleep(500);
                
            }else if(data[i].contains(caracterEspacio)){

                temp = new StringTokenizer(data[i], caracterEspacio);

                while(temp.hasMoreTokens()){
                    System.out.print(temp.nextToken()+" ");
                }
                System.out.println();
                Thread.sleep(500);
			    //str.append(data[i]+"\n");
            }


            		
		}
    
        } catch (Exception e) {
            System.out.println(e);
        }

        return str;

	}

    public static void ejecutar(int centinela, int subOpcion, Audio audio){

        //Llamado de las demas funciones de "java"
        Programa programa = new Programa();
        
        AnsiConsole.systemInstall();

		
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
		int seleccion = 0;
		String [] canciones;
		String [][] info_canciones;
		StringBuilder letra_cancion;


		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		info_canciones = ConsoleData.dataList(canciones);

        if(centinela == 1){

            

			imprimir("                      Ingrese un numero del 1 al 15 para buscar una cancion, el numero de canciones actuales son: "+(info_canciones.length-1));
			indice_cancion = subOpcion;
		
			inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
			fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
		
			System.out.println();
			imprimir("                                                           Nombre: "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION]);
			imprimir("                                                              Autor: "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION]);
			imprimir(" ");
		}
        if(centinela == 2){
            imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
            indice_cancion = subOpcion;
            audio.seleccionarCancion(info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);
			audio.reproducir();
        }
        if(centinela == 3){
            //TODO: Ojo, falta validar el valor ingresado
            //TODO: Falta darle formato amigable de lectura al usuario 
            imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
            indice_cancion = subOpcion;

            inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
            fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
            
            letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);

            //imprimir(letra_cancion.toString());
        }
        if(centinela == 4){
           	
			audio.detener();			
		}
        if(centinela==5){
            /* La informacion de las canciones esta
            en la matriz info_canciones, acá un ejemplo de como imprimir
            el nombre de la primer canción y su autor */
            
            //TODO: Ojo, falta validar el valor ingresado
            imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
            indice_cancion = subOpcion;

            inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
            fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);

            System.out.println();
            imprimir("Inicio letra "+inicio_letra);
            imprimir("Fin letra "+fin_letra);
            imprimir("Nombre "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION]);
            imprimir("Autor "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION]);
            imprimir("Archivo "+info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);

            imprimir("Primera estrofa: "+canciones[inicio_letra]);
            imprimir("Última estrofa: "+canciones[fin_letra]);
            
            //TODO:Explicar como funciona el archivo y como se analiza cada línea
            //TODO:Imprimir la lista completa
        }
        if(centinela == 6){
            imprimir("Finalizando...");
        }
    }
}
