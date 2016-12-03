package be.nmbs.userInterface;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;

public class NMBSServices {
	public static void main(String[] args) throws ParseException {
		/*View view = new View();
		Application application = new Application(view);
		application.run();*/
		String startDatum = "24-12-2016 00:00";
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	    Date date = format.parse(startDatum);
		Long tijd = date.getTime();
		Timestamp ts = new Timestamp(tijd);
		
		Abonnement abonnement = new Abonnement(1, 4, 22, "Burssel-Zuid-Gent", ts,
				ts, 1, 1, true);
		AbonnementDAO abonnementDAO = new AbonnementDAO();
		//abonnementDAO.insertDrieMaandAbonnement(abonnement, ts);
		//abonnementDAO.insertZesMaandAbonnement(abonnement, ts);
		//abonnementDAO.insertNegenMaandAbonnement(abonnement, ts);
		//abonnementDAO.insertEenJaarAbonnement(abonnement, ts);
		
		abonnement.setAbonnementId(36);
		Timestamp eindDatum = abonnementDAO.getEindDatum(abonnement);
		abonnement.setEindDatum(eindDatum);
		abonnementDAO.verlengAbonnementMetEenJaar(abonnement);
	}
}
