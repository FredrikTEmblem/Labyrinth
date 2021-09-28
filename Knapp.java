import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Knapp extends JButton {
  Labyrint labyrint;
  Rute rute;
  Knapp(Labyrint labyrint, Rute rute) {
    this.labyrint = labyrint;
    this.rute = rute;
  }
  class RuteKnapp implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
      labyrint.finnUtveiFra(rute.hentRad(), rute.hentKolonne());
    }
  }
  public void initGui() {
    addActionListener(new RuteKnapp());
  }
}
