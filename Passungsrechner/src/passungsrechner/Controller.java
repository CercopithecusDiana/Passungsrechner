package passungsrechner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Controller implements ActionListener {

	private Model model = new Model();
	private View3 view3 = new View3(this);

	public Controller(){
		view3.setVisible(true);
		model.addObserver(view3);
	}

	public void actionPerformed(ActionEvent arg0) {

		view3.lblDtxt.setText((String) view3.CBDurchm.getSelectedItem());

		int newIndexB = view3.CBBohrung.getSelectedIndex();
		int newIndexD = view3.CBDurchm.getSelectedIndex();
		int newIndexW = view3.CBWelle.getSelectedIndex();

		double oaB1 = model.TolArray[newIndexB][newIndexD][0]; 
		double uaB1 = model.TolArray[newIndexB][newIndexD][1];

		view3.lblBOA.setText(Double.toString((oaB1/1000)) );
		view3.lblBUA.setText(Double.toString((uaB1/1000) ));

		double oaW1 = model.TolArrayW[newIndexW][newIndexD][0]; 
		double uaW1 = model.TolArrayW[newIndexW][newIndexD][1];

		view3.lblWOA.setText(Double.toString((oaW1/1000)) );
		view3.lblWUA.setText(Double.toString((uaW1/1000)) );

		view3.lblHs.setText(Double.toString((	(	((1+oaB1)-(1+uaW1))/1000)	)));
		view3.lblMs.setText(Double.toString((	(	((1+uaB1)-(1+oaW1))/1000)	)));

		double Hoechsmass = ((1+(oaB1/1000))-(1+(uaW1/1000)));
		double mindestmasz = ((1+(uaB1/1000))-(1+(oaW1/1000)));

		if((Hoechsmass >= 0) && (mindestmasz >= 0) ) {
			view3.lblPassungsart.setText("Spielpassung");

			view3.txtPane.setText("Das Kleinstmaß der Bohrung ist immer größer als, im Grenzfall auch gleich groß wie, das Größtmaß der Welle."
					/*
					 * + "Beispiele: " + "H8/d9 für Großes Spiel zb Distanzbuchsen auf Wellen" +
					 * "H8/e8 fürTeile leicht verschiebbar. Zb Stellringe auf Wellen" + "" +
					 * "Ausgewählte Spielpassungen nach Passungssystem „Einheitsbohrung" +
					 * "d9/H7 : Teile mit sehr reichlichem Spiel: Transmissionsteile, Lager für Baumaschinen"
					 * +
					 * "e8/H8 : Teile mit reichlich Spiel: Hauptlager für Kurbelwellen, Kolben in Zylinder"
					 * +
					 * "f7/H8 : Teile mit merklichem Spiel beweglich: Mehrfach gelagerte Welle, Kolben in Zylinder"
					 * +
					 * "h9/H8 : Teile haben kaum Spiel und können mit Handkraft verschoben werden: Verschiebbare Zahnräder und Kupplungen"
					 * + "g6 H7: Teile ohne merkliches Spiel beweglich: Zahnräder und Kupplungen" +
					 * "h6 H7: Teile von Hand gerade noch verschiebbar: Führungen an Werkzeugmaschinen, Stellringe"
					 */
					);

			try {
				BufferedImage image2 = ImageIO.read( new File("/home/kata/eclipse-workspace/bildtest/src/bildtestbildtest/SpielPassung.jpg"));
				view3.icon.setImage(image2);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if((Hoechsmass < 0) && (mindestmasz < 0) ) {
			view3.lblPassungsart.setText("Übermaßpassung");

			view3.txtPane.setText("Das Größtmaß der Bohrung ist in jedem Fall kleiner als das Kleinstmaß der Welle.");

			try {
				BufferedImage image1 = ImageIO.read( new File("/home/kata/eclipse-workspace/bildtest/src/bildtestbildtest/presspassung.jpg"));
				view3.icon.setImage(image1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if( (Hoechsmass >= 0) ^ (mindestmasz >= 0) ) {
			view3.lblPassungsart.setText("Übergangspassung");

			view3.txtPane.setText("Bei einer Übergangspassung entsteht je nach Istmaßen von Bohrung und Welle beim Fügen entweder ein Spiel oder ein Übermaß. "
					+ "Das Größtmaß der Bohrung ist größer, im Grenzfall auch gleich groß wie das Kleinstmaß der Welle." );
			try {
				BufferedImage image3 = ImageIO.read( new File("/home/kata/eclipse-workspace/bildtest/src/bildtestbildtest/Übergangspassung.jpg"));
				view3.icon.setImage(image3);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(newIndexB);
		System.out.println(newIndexW);
	}
}