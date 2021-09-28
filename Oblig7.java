import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class Oblig7 {

  // Oppretter en Arraylist av ArrayList med rute-objekter inne i, endrer resten av labyrint til
  // at ArrayListene har Rute-objekter istedenfor Tuppel. Da blir det enklere å hente ut kordinater.
  public static void main(String[] args) {
    class Knapp extends JButton {
      Rute rute;
      Knapp(Rute rute) {
        this.rute = rute;
      }
      // Hvis bruker trykker på knappen en gang, vises en utvei.
      // Trykker brukeren på knappen to ganger vil alle utveiene vises.
      class Utvei implements ActionListener {
        private JButton sistTrykket;
        ArrayList<ArrayList<Rute>> visUtvei;
        @Override
        public void actionPerformed(ActionEvent event) {
          JButton trykketPaa = (JButton) event.getSource();
          if (sistTrykket == trykketPaa) {
            rute.visAlleUtveier(visUtvei);
          } else {
            visUtvei = rute.hentLabyrintFraRute().finnUtveiFra(rute.hentRad(), rute.hentKolonne());
            rute.hentLabyrintFraRute().visUtveListe(visUtvei);
          }
          sistTrykket = trykketPaa;
        }
      }
      void initGUI() {
        this.addActionListener(new Utvei());
        // Gjør knappen transparent slik at det vises tydeligere hva som er utveien.
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(50,50));
      }
    }
    // Lar bruker velge fil med JFileChooser
    JFileChooser filValg = new JFileChooser();
    int resultat = filValg.showOpenDialog(null);
    if (resultat != JFileChooser.APPROVE_OPTION) {
      System.exit(1);
    }
    // Henter den bestemte filen og prøver å lese den inn
    File fil = filValg.getSelectedFile();
    Labyrint labyrint = null;
    try {
      labyrint = new Labyrint(fil);
    } catch(FileNotFoundException e) {
      System.out.println("Feil i lesing av fil: " + e.getMessage());
    }
    // Oppretter en JFrame (beholder) som leverer et vindu på skjermen
    JFrame vindu = new JFrame("Labyrint");
    vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    GridLayout grid = new GridLayout(labyrint.hentAntRader(), labyrint.hentAntKolonner());
    vindu.setLayout(grid);

    for (int rad1 = 0; rad1 < labyrint.hentAntRader(); rad1++) {
      for (int kol1 = 0; kol1 < labyrint.hentAntKolonner(); kol1++) {
        Rute rute = labyrint.hentLabyrint()[rad1][kol1];
        char rutePeker = labyrint.hentLabyrint()[rad1][kol1].tilTegn();
        if (rutePeker == '.') {
          if (rad1 == 0 || rad1 == labyrint.hentAntRader() - 1 || kol1 == 0 || kol1 == labyrint.hentAntKolonner() - 1) {
            Knapp knapp = new Knapp(rute);
            knapp.initGUI();
            rute.add(knapp);
          }
          else {
            Knapp knapp = new Knapp(rute);
            knapp.initGUI();
            rute.add(knapp);
          }
        }
        vindu.add(rute);
      }
    }

    vindu.pack();
    vindu.setVisible(true);
  }
}
