/**
 * 
 */
package org.promasi.client_swing.playmode.multiplayer;

import java.util.List;
import java.util.Map;

import org.promasi.client_swing.gui.GuiException;
import org.promasi.game.IGame;
import org.promasi.game.AGamesServer;
import org.promasi.game.company.ICompanyListener;
import org.promasi.game.company.EmployeeTaskMemento;
import org.promasi.game.company.IDepartmentListener;
import org.promasi.game.company.IMarketPlaceListener;
import org.promasi.game.singleplayer.IClientGameListener;
import org.promasi.protocol.client.ProMaSiClient;

/**
 * @author alekstheod
 *
 */
public class MultiPlayerGame implements IGame {
	
	/**
	 * 
	 */
	private String _gameId;
	
	/**
	 * 
	 */
	private String _description;
	
	/**
	 * 
	 */
	private ProMaSiClient _client;
	
	/**
	 * 
	 */
	private AGamesServer _gamesServer;
	
	/**
	 * 
	 * @param game
	 */
	public MultiPlayerGame(AGamesServer gamesServer, ProMaSiClient client, String gameId, String description )throws GuiException{
		if( gameId == null ){
			throw new GuiException("Wrong argument gameId == null");
		}
		
		if( description == null ){
			throw new GuiException("Wrong argument description == null");
		}
		
		if( client == null ){
			throw new GuiException("Wrong argument client == null");
		}
		
		if( gamesServer == null ){
			throw new GuiException("Wrong argument gamesServer == null");
		}
		
		_gameId = gameId;
		_description = description;
		_client = client;
		_gamesServer = gamesServer;
	}
	
	@Override
	public String getGameDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hireEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dischargeEmployee(String employeeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean assignTasks(Map<String , List<EmployeeTaskMemento> > employeeTasks) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addListener(IClientGameListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeListener(IClientGameListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stopGame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setGameSpeed(int newSpeed) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AGamesServer getGamesServer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCompanyListener(ICompanyListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCompanyListener(ICompanyListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListeners() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addDepartmentListener(IDepartmentListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeDepartmentListener(IDepartmentListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMarketPlaceListener(IMarketPlaceListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeMarketPlaceListener(IMarketPlaceListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString(){
		return _description;
	}
}
