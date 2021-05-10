public class ejecucion {
    public static void ejecutar(int centinela){

        //Llamado de las demas funciones de "Programa.java"
        Programa programa = new Programa();

        AnsiConsole.systemInstall();
		
		Audio audio = new Audio();
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
		int seleccion = 0;
		String [] canciones;
		String [][] info_canciones;
		StringBuilder letra_cancion;


		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		info_canciones = ConsoleData.dataList(canciones);

        if(centinela == 1){

            

			programa.imprimir("                      Ingrese un numero del 1 al 15 para buscar una cancion, el numero de canciones actuales son: "+(info_canciones.length-1));
			indice_cancion = ConsoleInput.getInt();
		
			inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
			fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
		
			System.out.println();
			programa.imprimir("                                                           Nombre: "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION]);
			programa.imprimir("                                                              Autor: "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION]);
			programa.imprimir(" ");
		}
        if(centinela == 2){
            audio.seleccionarCancion(info_canciones[1][ConsoleData.RUTA_CANCION]);
            audio.reproducir();
        }
        if(centinela == 3){
            //TODO: Ojo, falta validar el valor ingresado
            //TODO: Falta darle formato amigable de lectura al usuario 
            programa.imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
            indice_cancion = ConsoleInput.getInt();

            inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
            fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
            
            letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);

            programa.imprimir(letra_cancion.toString());
        }
        if(centinela == 4){
			audio.detener();
		}
        if(centinela==5){
            /* La informacion de las canciones esta
            en la matriz info_canciones, acá un ejemplo de como imprimir
            el nombre de la primer canción y su autor */
            
            //TODO: Ojo, falta validar el valor ingresado
            programa.imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
            indice_cancion = ConsoleInput.getInt();

            inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
            fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);

            System.out.println();
            programa.imprimir("Inicio letra "+inicio_letra);
            programa.imprimir("Fin letra "+fin_letra);
            programa.imprimir("Nombre "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION]);
            programa.imprimir("Autor "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION]);
            programa.imprimir("Archivo "+info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);

            programa.imprimir("Primera estrofa: "+canciones[inicio_letra]);
            programa.imprimir("Última estrofa: "+canciones[fin_letra]);
            
            //TODO:Explicar como funciona el archivo y como se analiza cada línea
            //TODO:Imprimir la lista completa
        }
        if(centinela == 6){
            programa.imprimir("Finalizando...");
            socket.close();
        }
    }
}
