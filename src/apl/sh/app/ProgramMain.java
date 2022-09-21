package apl.sh.app;

import java.util.Locale;

import apl.sh.view.ClienteArea;

public class ProgramMain {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		ClienteArea clienteArea = new ClienteArea();
		
		clienteArea.menuPrincipal();
		return;
	}
}
