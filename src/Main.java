import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        DatabaseConnectionService dcs = new DatabaseConnectionService("golem.csse.rose-hulman.edu","SteamManager19");
        dcs.connect("huangz2","LHQ909202033lhq");
        GameService gs = new GameService(dcs);

        JFrame window = new JFrame("Steam Manager");

        JMenuBar mb;
        JMenu edit;
        JMenuItem cut,copy,paste,selectAll;
        cut=new JMenuItem("SearchByCategory");
        copy=new JMenuItem("SearchByTitle");
        paste=new JMenuItem("SearchLowestAndHighestPrice");
        selectAll=new JMenuItem("SearchByUsetag");
        cut.addActionListener(new MenuBarListener("SearchByCategory",gs));
        copy.addActionListener(new MenuBarListener("SearchByTitle",gs));
        paste.addActionListener(new MenuBarListener("SearchHighestAndLowestValue",gs));
        selectAll.addActionListener(new MenuBarListener("SearchByUsetag",gs));
        mb=new JMenuBar();
        edit=new JMenu("Tool");
        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);
        mb.add(edit);
        window.setJMenuBar(mb);


        window.setSize(600,300);
        window.setLayout(null);
        window.setVisible(true);
    }

}
