//Librerias generales
import javax.swing.JOptionPane;

public class reproductor{
    public static void main(String[] args){
        String[] opciones = {"Cliente", "Director"};

        int ventana = JOptionPane.showOptionDialog(null, "Como desea ingresar?", "Seleccion de tipo de usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if(ventana==0){
            System.out.println("Usuario = Cliente");
        }else if(ventana==1){
            System.out.println("Usuario = Director");
        }


    }
}
