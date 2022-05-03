package manager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

import dao.Reader;
import dao.Writer;
import graphics.MainFrame;
import graphics.ui.PreferencesPanel;
import graphics.ui.WrongLogin;
import graphics.util.GameModel;
import graphics.util.Preferences;
import graphics.ui.Console;
import graphics.ui.Menu;
import graphics.ui.Login;

public class WindowManager {
	private static WindowManager instance;
	private static MainFrame frame;
	private static PreferencesPanel chess;
    private static PreferencesPanel preferencesFrame;
    private static boolean inGame;
    private static GameModel gameModel;
    private static Preferences preferences;
    private static Login login;
    private static Reader reader;
    private static Writer writer;
    private static Menu menu;
    private static String logs;
    private static WrongLogin wrongLogin;
    private static Console console;
    private String username;
	
	public static WindowManager getInstance() {
		if (instance == null) {
			instance = new WindowManager();
		}
		return instance;
	}
	
	private WindowManager () {
		frame = new MainFrame();
		frame.setVisible(true);
		login=new Login();
	}

	//M�todo necesario para el ajedrez
    public static void startGame() {
        inGame = true;
        gameModel = new GameModel();
    }
	
	//M�todo necesario para el ajedrez
    public static Preferences getPreferences() {
        return preferences;
    }

    //M�todo necesario para el ajedrez
    public static PreferencesPanel getPreferencesFrame() {
        return preferencesFrame;
    }
    
    //M�todo necesario para el ajedrez
    public static boolean isInGame() {
        return inGame;
    }
    
    public void inicialPanel() { 
    	login= new Login();
		frame.setLogin(login);
		login.getLogin().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				authentication();
			}
		});
		login.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
    
    private void authentication() {
		reader=new Reader("files/loggin.txt");
		username=login.getUsernameField().getText();
		String password=String.valueOf(login.getPasswordField().getPassword());
		String line;
		String[] credentials;
		
		while((line = reader.getLine())!=null) {
			credentials=line.split(" ");
			if(credentials[0].equals(username) && credentials[1].equals(password)) {
				logs="";
				showMenu();
				return;
			}
		}
		reader.close();
		
		wrongLogin = new WrongLogin(new JFrame(), "ERROR", "Wrong user or password");
		wrongLogin.setSize(300, 150);
	}
    
	private void showMenu() {
		console=new graphics.ui.Console();
		menu=new Menu();
		console.getContent().setText("");
		console.getContent().append("Usuario correcto\n");
		console.getContent().append("PANEL: "+username+"\n");
		menu.createTable(getMenuData());
		frame.setMenu(menu);
		frame.setConsole(console);
		
		menu.getPlayButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				console.getContent().append("---> NUEVA PARTIDA <---\n");
				menu.hideStartButton();
				writeStartGame("GAME_STARTED");
				menu.createTable(getMenuData());
				launchChess();
			}
		});
		menu.getExitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menu.getCloseButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				console.getContent().append("---> FIN PARTIDA <---\n");
				console.getContent().append("PANEL: "+username+"\n");
				menu.showStartButton();
				writeStartGame("GAME_FINISHED");
				menu.createTable(getMenuData());
				finalizarPartidaButton();
			}
		});
		
		menu.getLogoutButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chess!=null)
					finalizarPartidaButton();
				inicialPanel();
			}
		});
	}
	
	private void writeStartGame(String responseCode) {
		writer=new Writer("files/sesiones.txt", true);
		String today=new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		writer.writeOnFile("\n"+username+" "+responseCode+" "+today);
		writer.close();
	}
	
	private String[][] getMenuData() {
		reader=new Reader("files/sesiones.txt");
		ArrayList<String[]> records = new ArrayList<String[]>();
		String line;
		
		while((line = reader.getLine())!=null) {
			records.add(line.split(" "));
		}
		reader.close();
		
		String[][] data=new String[records.size()][3];
		
		for(int x=0; x<data.length; x++) {
			data[x][0]=records.get(x)[0];
			data[x][1]=records.get(x)[1];
			data[x][2]=records.get(x)[2];
		}
		
		return data; 
	}
    
    //TODO: este m�todo cierra el JDialog del ajedrez
	private void finalizarPartidaButton() {
		chess.endChess();
		gameModel.getGameFrame().setVisible(false);
	}
	
	//TODO: este m�todo inicializa el JDialog del chess
	public void launchChess() {
        inGame = false;
        preferences = new Preferences();
        chess = new PreferencesPanel();
    }
}
