import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Audio extends Thread{
	
	//https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Sequencer.html
	private String sonido;	
	private Sequencer sequencer;
	private boolean esta_reproduciendose;
	
	public void seleccionarCancion(String ruta_cancion){
		sonido = ruta_cancion;
	}

	ejecucion ejecucion = new ejecucion();//Necesario para la impresion de caracteres especiales

	public void empezar(){
		if(!esta_reproduciendose)
		{
			try {
	        	sequencer = MidiSystem.getSequencer(); // Get the default Sequencer

	            if (sequencer==null) {
					System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
                    System.out.println("         |     .       .   .      .     .      .       Sequencer device not supported.         .         .   ..          .         .  |.");
                    System.out.println("         |               .                     .            .                  .         .                          .             .   |.");
	                return;
	            } 
	            sequencer.open(); // Open device
	            // Create sequence, the File must contain MIDI file data.
	            Sequence sequence = MidiSystem.getSequence(new File(sonido));
	            sequencer.setSequence(sequence); // load it into sequencer
	            sequencer.start();  // start the playback
	            esta_reproduciendose = true;

	        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
	            //ex.printStackTrace();
				System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
                System.out.println("         |     . .   .       .    .       Error al reproducir el archivo, revise la ruta y vuelva a intentarlo.       . .          .  |.");
                System.out.println("         |               .                     .            .                  .         .                          .             .   |.");
	            System.out.println("");
	            esta_reproduciendose = true;
	        }
		}
		else{

			System.out.println("         |               .        .             .              .                .         .                    .                   .   |.");
            ejecucion.imprimir("         |     . .         .     .       .    .       Hay un archivo actualmente en reproducción            .      .     .          .  |.");
			ejecucion.imprimir("         |     . .         .     .       .    .       Detenga la canción y seleccione una nueva            .       .     .          .  |.");
			System.out.println("         |               .                     .            .                   .         .                          .             .   |.");
		}
	}

	public void detener(){
		if(sequencer!=null)
    	{
        	if(sequencer.isOpen())
        	{
        		sequencer.stop();
        		sequencer.close();
        	}
    	}
    	esta_reproduciendose = false;
	}

	public void reproducir(){
		empezar();
		if(!esta_reproduciendose)
		{
			this.start();
		}
	}

	public void run(){

		while(esta_reproduciendose){
			if(sequencer != null)
			{
				if(!sequencer.isRunning())
				{
					System.out.println("         |               .        .             .              .                .         .                   .                   .   |.");
                	ejecucion.imprimir("         |     .          .      .   .       .    .       Se detuvo la canción       . .        .            .          ..         .  |.");
                	System.out.println("         |               .                     .            .                  .         .                          .             .   |.");
					detener();
				}
			}
		}
	}
}