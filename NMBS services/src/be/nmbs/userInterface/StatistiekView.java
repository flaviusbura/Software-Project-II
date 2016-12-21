package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.StatistiekController;
import be.nmbs.database.AbonnementDAO;
import be.nmbs.database.AbonnementTypeDAO;
import be.nmbs.logic.Abonnement;
public class StatistiekView {
	private static JButton goBackToHome;
	private static JPanel panel;
	private static StatistiekController statistiekController;
	private static AbonnementDAO abonnementDAO;
	private static AbonnementTypeDAO abonnementTypeDao;
	private static JLabel statistiekresultaat;
	private static JButton getToday;
	private static JButton getThisWeek;
	private static JButton getThisMonth;
	private static JButton getThisYear;
	private static JButton getBetweenDates;
	private static JLabel uitleg;
	private static JLabel datum1;
	private static JLabel datum2;
	private static JTextField date1;
	private static JTextField date2;
	
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(goBackToHome, c);
		
		getToday=new JButton("Vandaag");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=2;
		c.gridy=2;
		panel.add(getToday);
		getThisWeek = new JButton("Deze week");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=2;
		panel.add(getThisWeek);
		getThisMonth = new JButton("Deze maand");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		panel.add(getThisMonth);
		getThisYear = new JButton ("Dit jaar");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=3;
		panel.add(getThisYear);
		getBetweenDates = new JButton ("Tussen deze datums");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=6;
		c.gridy=4;
		panel.add(getBetweenDates);
		uitleg=new JLabel("Verkrijg de statistieken van:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		panel.add(uitleg);
		date1 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=3;
		c.gridy=4;
		panel.add(date1);
		date2 = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=5;
		c.gridy=4;
		panel.add(date2);
		datum1 = new JLabel("startdatum");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=2;
		c.gridy=4;
		panel.add(datum1);
		datum2 = new JLabel("einddatum");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=4;
		c.gridy=4;
		panel.add(datum2);
		statistiekresultaat = new JLabel("");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(statistiekresultaat, c);
		
		statistiekController =new StatistiekController(view);
		return panel;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static int setStatistiekresultaat(ArrayList<Abonnement> list){
		ArrayList<Abonnement> typen=new ArrayList();
		ArrayList<Double> totalen=new ArrayList();
		for(int i=0;i<list.size();i++){
			//check if type in typen
			boolean found=false;
			int foundPlace=0;
			for(int y=0;y<typen.size();y++){
				if(abonnementTypeDao.getTypeVanAbonnement(typen.get(y).getAbonnementId()) == abonnementTypeDao.getTypeVanAbonnement(list.get(i).getAbonnementId())){
					found=true;
					foundPlace=y;
				}
			}
			if(found){
				double newTotal = totalen.get(foundPlace)+1;
				Abonnement abo = typen.get(foundPlace);
				totalen.remove(foundPlace);
				typen.remove(foundPlace);
				totalen.add(newTotal);
				typen.add(abo);
			}
			else{
				totalen.add(1.0);
				typen.add(list.get(i));
			}
		}
		String result="";
		for (int i=0;i<totalen.size();i++){
			result = result + abonnementTypeDao.getTypeVanAbonnement(typen.get(i).getAbonnementId()) + ": "+totalen.get(i) + "/n";
		}
		statistiekresultaat = new JLabel(result);
		return 0;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		StatistiekView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		StatistiekView.panel = panel;
	}
	
	public static JLabel getStatistiekresultaat() {
		return statistiekresultaat;
	}
	public static void setStatistiekresultaat(JLabel statistiekresultaat) {
		StatistiekView.statistiekresultaat = statistiekresultaat;
	}
	public static JButton getGetToday() {
		return getToday;
	}
	public static void setGetToday(JButton getToday) {
		StatistiekView.getToday = getToday;
	}
	public static JButton getGetThisWeek() {
		return getThisWeek;
	}
	public static void setGetThisWeek(JButton getThisWeek) {
		StatistiekView.getThisWeek = getThisWeek;
	}
	public static JButton getGetThisMonth() {
		return getThisMonth;
	}
	public static void setGetThisMonth(JButton getThisMonth) {
		StatistiekView.getThisMonth = getThisMonth;
	}
	public static JButton getGetThisYear() {
		return getThisYear;
	}
	public static void setGetThisYear(JButton getThisYear) {
		StatistiekView.getThisYear = getThisYear;
	}
	public static JButton getGetBetweenDates() {
		return getBetweenDates;
	}
	public static void setGetBetweenDates(JButton getBetweenDates) {
		StatistiekView.getBetweenDates = getBetweenDates;
	}
	public static JLabel getUitleg() {
		return uitleg;
	}
	public static void setUitleg(JLabel uitleg) {
		StatistiekView.uitleg = uitleg;
	}
	public static JLabel getDatum1() {
		return datum1;
	}
	public static void setDatum1(JLabel datum1) {
		StatistiekView.datum1 = datum1;
	}
	public static JLabel getDatum2() {
		return datum2;
	}
	public static void setDatum2(JLabel datum2) {
		StatistiekView.datum2 = datum2;
	}
	public static JTextField getDate1() {
		return date1;
	}
	public static void setDate1(JTextField date1) {
		StatistiekView.date1 = date1;
	}
	public static JTextField getDate2() {
		return date2;
	}
	public static void setDate2(JTextField date2) {
		StatistiekView.date2 = date2;
	}
	public static StatistiekController getStatistiekController() {
		return statistiekController;
	}

	public static void setStatistiekController(StatistiekController statistiekController) {
		StatistiekView.statistiekController = statistiekController;
	}
	public static void setStatistiekControllerToNull() {
		statistiekController = null;
	
	}
}
