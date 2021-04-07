package es.uned.lsi.eped.pract2020_2021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import es.uned.lsi.eped.DataStructures.IteratorIF;

public class Main {
	
	/*Devuelve una cadena de caracteres con la secuencia de
	 * elementos de una cola con prioridad
	 * @param PQ: cola con prioridad
	*/
	public static <E> String toString(PriorityQueueIF<E> PQ){
		String result = "";
		IteratorIF<E> iter = PQ.iterator();
		while(iter.hasNext()){
			result = result+iter.getNext().toString();
			if(iter.hasNext()){
				result = result+" ";
			}
		}
		return result;
	}
	
	/*Comprueba si la ruta de un fichero existe (devuelve cadena de 
	 * caracteres vac�a) o en caso de que no (cadena de caracteres
	 * no vac�a)
	 * @param path: ruta de un fichero
	 * */
	public static String existsFolder(String path){
		String separator = System.getProperty("file.separator");
		if(path.contains(separator)){
			String folder = path.substring(0,path.lastIndexOf(separator));
			File F = new File(folder);
			if(!F.exists()){
				return folder;
			}
		}
		return new String();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		//Tipo de cola con prioridad. Posibles valores: 
		//   - BQ (Bucket Queue) o 
		//   - BST (Cola con prioridad mediante �rbol de b�squeda binario)
		String typeQueue = args[0]; 
		PriorityQueueIF<String> PQ;
		if(typeQueue.equals("BQ")){
			PQ = new BucketQueue<String>();
		}
		else{
			if(typeQueue.equals("BST")){
				PQ = new BSTPriorityQueue<String>();
			}
			else{
				System.out.println("ERROR: el primer argumento es BQ o BST.");
				return;
			}
		}
		//Fichero de entrada
		String input = args[1]; 
		//se comprueba que existe la ruta mediante la funci�n auxiliar existsFolder
		String existsPath = existsFolder(input);
		if(!existsPath.isEmpty()){
			//si no existe, se lanza mensaje de error
			System.out.println("ERROR: no existe carpeta de fichero de entrada "+existsPath+".");
			return;
		}
		//Fichero de salida
		String output = args[2];
		//se comprueba que existe la ruta mediante la funci�n auxiliar existsFolder
		String existsOut = existsFolder(output);
		if(!existsOut.isEmpty()){
			//si no existe, se lanza mensaje de error
			System.out.println("ERROR: no existe carpeta de fichero de salida "+existsOut+".");
			return;
		}
		//salto de linea
		String lineFeed = System.getProperty("line.separator");
		//lectura del fichero de entrada
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input), "utf-8"));		
		//escritura en el fichero de salida
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "utf-8"));
		String line;
		long t0 = System.currentTimeMillis();
		while ((line = br.readLine())!=null) {
			/*cada l�nea del fichero de entrada es una operaci�n
			 * de la cola con prioridad.
			*/
			//Obtiene cadenas separadas por espacios en blancos de la l�nea
			StringTokenizer st = new StringTokenizer(line, " ");
			//La primera cadena consiste en la operaci�n
			String op = st.nextToken();
			//resultado de la operaci�n
			String result = new String();
			//distinci�n seg�n sea la operaci�n
			switch(op){
				//operaci�n enqueue
				case "enqueue":
					/*va acompa�ada de 2 par�metros
					el primero es el elemento */
					String elem = st.nextToken();
					/*el segundo es una prioridad (n�mero entero)
					 *la cadena se pasa a entero
					*/
					int prior = Integer.parseInt(st.nextToken());
					//se aplica la operaci�n enqueue sobre la cola con prioridad
					PQ.enqueue(elem, prior);
					break;
				//}
				//operaci�n dequeue
				case "dequeue":
					//se aplica la operaci�n dequeue sobre la cola con prioridad
					PQ.dequeue();
					break;
				//operacion size
				case "size":
					//se aplica la operaci�n size sobre la cola con prioridad
					result = Integer.toString(PQ.size());
					break;
				//operaci�n iterator
				case "iterator":
					/*se obtiene la secuencia de elementos de la cola con 
					 * prioridad mediante la funci�n auxiliar toString
					*/
					result = toString(PQ);
					break;
				
			}
			//solo se escriben cadenas no vac�as en el fichero de salida 
			if(!result.isEmpty()){
				bw.write(result+lineFeed);
			}
		} 
		long t1 = System.currentTimeMillis() - t0;
		//muestra por consola el tiempo de ejecuci�n en milisegundos
		System.out.println(t1+" ms");
		//se cierra el buffer de lectura
		br.close();
		//se cierra el buffer de escritura
		bw.close();
	}
	
	
	

}