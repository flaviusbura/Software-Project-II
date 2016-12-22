package be.nmbs.controllers;

import java.sql.SQLException;

import be.nmbs.database.PushDAO;

public class HomeController {
	private final PushDAO pushDAO = new PushDAO();
	
	public boolean pushAllToRemote() {
		try {
			pushDAO.Push();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}
