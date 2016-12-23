package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.StatistiekController;
import be.nmbs.logic.Abonnement;

public class StatistiekView {
	private JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel uitlegLabel = new JLabel("Verkrijg de statistieken van");
	private final JLabel startDateLabel = new JLabel("Startdatum");
	private final JLabel endDateLabel = new JLabel("Einddatum");
	private final JLabel resultLabel = new JLabel("");
	
	private final JTextField startDateTextField = new JTextField();
	private final JTextField endDateTextField = new JTextField();
	
	private final JButton getTodayButton = new JButton("Vandaag");
	private final JButton getThisWeekButton = new JButton("Deze week");
	private final JButton getThisMonthButton = new JButton("Deze maand");
	private final JButton getThisYearButton = new JButton ("Dit jaar");
	private final JButton getBetweenDatesButton = new JButton ("Tussen deze datums");
	private final JButton backButton = new JButton("Terug");
	
	private final StatistiekController statistiekController = new StatistiekController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Uitleg Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(uitlegLabel, c);
		
		// Add Result Label
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 8;
		panel.add(resultLabel, c);
		
		c.gridheight = 1;

		// Add Get Today Button
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 0;
		panel.add(getTodayButton, c);
		
		getTodayButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
				ArrayList<Abonnement> abos = new ArrayList<Abonnement>();
				abos = statistiekController.getAbonnementenOnDate(ts);
				setStatistiekresultaat(abos);
			}
		});
		
		// Add Get This Week Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 1;
		panel.add(getThisWeekButton, c);
		
		getThisWeekButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar startCal = Calendar.getInstance();
				Calendar endCal = startCal;
				endCal.setTime(new Date(startCal.getTimeInMillis() - 604800000L));
				
				Timestamp startStamp = new Timestamp(startCal.getTimeInMillis());
				Timestamp endStamp = new Timestamp(endCal.getTimeInMillis());
				ArrayList<Abonnement> abos = new ArrayList<Abonnement>();
				abos = statistiekController.getAbonnementen(startStamp, endStamp);
				setStatistiekresultaat(abos);
			}
		});
		
		// Add Get This Month Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 2;
		panel.add(getThisMonthButton, c);
		
		getThisMonthButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar startCal = Calendar.getInstance();
				Calendar endCal = startCal;
				endCal.setTime(new Date(startCal.getTimeInMillis() - 2629746000L));
				
				Timestamp startStamp = new Timestamp(startCal.getTimeInMillis());
				Timestamp endStamp = new Timestamp(endCal.getTimeInMillis());
				ArrayList<Abonnement> abos = new ArrayList<Abonnement>();
				abos = statistiekController.getAbonnementen(startStamp, endStamp);
				setStatistiekresultaat(abos);
			}
		});
		
		// Add Get This Year Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 3;
		panel.add(getThisYearButton, c);
		
		getThisYearButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Calendar startCal = Calendar.getInstance();
				Calendar endCal = startCal;
				endCal.setTime(new Date(startCal.getTimeInMillis() - 31556952000L));
				
				Timestamp startStamp = new Timestamp(startCal.getTimeInMillis());
				Timestamp endStamp = new Timestamp(endCal.getTimeInMillis());
				ArrayList<Abonnement> abos = new ArrayList<Abonnement>();
				abos = statistiekController.getAbonnementen(startStamp, endStamp);
				setStatistiekresultaat(abos);
			}
		});
		
		// Add Get Between Dates Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 4;
		panel.add(getBetweenDatesButton, c);
		
		getBetweenDatesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					Timestamp startStamp = new Timestamp(format.parse(startDateTextField.getText()).getTime());
					Timestamp endStamp = new Timestamp(format.parse(endDateTextField.getText()).getTime());
					
					ArrayList<Abonnement> abos = new ArrayList<Abonnement>();
					
					abos = statistiekController.getAbonnementen(startStamp, endStamp);
					setStatistiekresultaat(abos);
				}
				catch(ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		// Add Start Date Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 5;
		panel.add(startDateLabel, c);
		
		// Add Start Date Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 6;
		panel.add(startDateTextField, c);
		
		// Add End Date Label
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 7;
		panel.add(endDateLabel, c);
		
		// Add End Date Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 8;
		panel.add(endDateTextField, c);
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 9;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
	
	private void setStatistiekresultaat(ArrayList<Abonnement> list) {
		ArrayList<Abonnement> typen = new ArrayList<Abonnement>();
		ArrayList<Double> totalen = new ArrayList<Double>();
		for(int i=0;i<list.size();i++){
			//check if type in typen
			boolean found=false;
			int foundPlace=0;
			for(int y=0;y<typen.size();y++){
				if(statistiekController.getAbonnementType(typen.get(y).getAbonnementId()) == statistiekController.getAbonnementType(list.get(i).getAbonnementId())){
					found=true;
					foundPlace=y;
					break;
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
			result = result + statistiekController.getAbonnementType(typen.get(i).getAbonnementId()) + ": "+totalen.get(i) + "/n";
		}
		
		resultLabel.setText(result);
	}
}
