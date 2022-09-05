package Tateti.tateti;

public class Tateti {
	
	java.util.Scanner lector = new java.util.Scanner(System.in);
	
	private static char[][] tablero;
	boolean jugadaCorrecta = false;
	boolean hayGanador = false;
	int jugadasCompletas = 0;
	
	void crearYLlenarTablero() {
		tablero = new char[3][3];
		for (int i=0; i < tablero.length; i++) {
			for (int j=0; j < tablero[i].length; j++) {
				tablero[i][j] = '-';
			}
		}
	}
	
	void mostrarTablero() {
		for (int i=0; i < tablero.length; i++) {
			for (int j=0; j < tablero[i].length; j++) {
				System.out.printf("|%c", tablero[i][j]);
			}
			System.out.println("|");
			System.out.println();
		}
	}
	
	void movimientoJugador() {
		System.out.println("Por favor ingrese su jugada");
		while (!jugadaCorrecta) {
			System.out.println("Ingrese la fila elegida:");
			int filaJugador = Integer.parseInt(lector.nextLine());
			System.out.println("Ingrese la columna elegida:");
			int columnaJugador = Integer.parseInt(lector.nextLine());
			if (tablero[filaJugador][columnaJugador] == '-') {		
				tablero[filaJugador][columnaJugador] = 'X';
				jugadaCorrecta = true;
				jugadasCompletas++;
				mostrarTablero();
			}
		}		
	}
	
	void movimientoComputadora() {
		boolean completo = false;
		
		System.out.println("Jugada del adversario:");
		
		while (!completo) {
			int fila = (int)(Math.random() * (2-0+1));
			int columna = (int)(Math.random() * (2-0+1));
			if (tablero[fila][columna] == '-') {
				tablero[fila][columna] = 'O';
				completo = true;
				jugadasCompletas++;
				mostrarTablero();
			} 
		}		
		
 	}
	
	void comprobarGanador(char ficha) {
		for (int i =0; i<3; i++) {
			//comprobando columnas
			if (tablero[0][i] == ficha && tablero[1][i] == ficha && tablero[2][i] == ficha) {
				hayGanador = true;
				//comprobando filas
			} else if (tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) {
				hayGanador = true;
				//comprobando las diagonales por separado
			} else if (tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) {
				hayGanador = true;
			} else if (tablero[2][0] == ficha && tablero[1][1] == ficha && tablero[0][2] == ficha) {
				hayGanador = true;			
			}
		}
	}
	
}
