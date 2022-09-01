package Tateti.tateti;

public class pruebaTateti {

	public static void main(String[] args) {
		Tateti jugar = new Tateti();
		System.out.println("Bienvenido al Tateti :)");
		int jugador = 1;
		jugar.crearYLlenarTablero();
		jugar.mostrarTablero();
		while (!jugar.hayGanador && jugar.jugadasCompletas < 9) {
			if (jugador == 1) {
				jugar.movimientoJugador();
				jugar.comprobarGanador('X');
				jugar.jugadaCorrecta = false;
				jugador = 2;
			} else {
				jugar.movimientoComputadora();
				jugar.comprobarGanador('O');
				jugar.jugadaCorrecta = false;
				jugador = 1;
			}
		}

		if (jugar.hayGanador && jugador == 2) {
			System.out.println("¡Felicitaciones! Usted es el ganador.");
		} else if (jugar.hayGanador && jugador == 1) {
			System.out.println("Su adversario ganó. Intente nuevamente.");
		} else if (jugar.jugadasCompletas == 9 && !jugar.hayGanador) {
			System.out.println("Fin del juego. Hubo un empate. \nLo invitamos a intentar de nuevo");
		}
		

	}

}
