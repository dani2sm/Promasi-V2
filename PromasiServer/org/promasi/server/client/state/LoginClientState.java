/**
 *
 */
package org.promasi.server.client.state;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.net.ProtocolException;
import java.util.NoSuchElementException;

import org.apache.commons.lang.NullArgumentException;
import org.promasi.protocol.request.LoginRequest;
import org.promasi.protocol.response.LoginResponse;
import org.promasi.protocol.response.WrongProtocolResponse;
import org.promasi.server.core.AbstractClientState;
import org.promasi.server.core.ProMaSi;
import org.promasi.server.core.ProMaSiClient;
import org.xml.sax.SAXParseException;


/**
 * @author m1cRo
 *
 */
public class LoginClientState extends AbstractClientState
{
	/**
	 *
	 */
	private ProMaSi _promasi;

	/**
	 *
	 * @param promasi
	 */
	public LoginClientState(ProMaSi promasi)
	{
		if(promasi==null)
		{
			throw new NullArgumentException("Wrong argument promasi");
		}
		_promasi=promasi;
	}

	/**
	 *
	 */
	public void onReceive(ProMaSiClient client, String recData)throws ProtocolException,NullArgumentException
	{
		if(client==null)
		{
			throw new NullArgumentException("Wrong argument client==null");
		}

		if(recData==null)
		{
			throw new NullArgumentException("Wrong argument client==null");
		}
		XMLDecoder decoder=new XMLDecoder(new ByteArrayInputStream(recData.getBytes()));
		try
		{
			Object object=decoder.readObject();
			decoder.close();
			if(object instanceof LoginRequest)
			{
				LoginRequest loginRequest=(LoginRequest)object;
				client.setClientId(loginRequest.getUserName());
				_promasi.addUser(client);
				client.sendMessage(new LoginResponse().toXML());
				changeClientState(client,new SelectGameClientState(_promasi));
			}
			else
			{
				client.sendMessage(new WrongProtocolResponse().toXML());
				throw new ProtocolException("Wrong protocol");
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			client.sendMessage(new LoginResponse(false,e.getMessage()).toXML());
			throw new ProtocolException("Wrong protocol" );
		}
		catch(NullArgumentException e)
		{
			client.sendMessage(new LoginResponse(false,e.getMessage()).toXML());
			throw new ProtocolException("Wrong protocol");
		}
		catch(IllegalArgumentException e)
		{
			client.sendMessage(new LoginResponse().toXML());
			throw new ProtocolException("Wrong protocol");
		}
		catch(NoSuchElementException e)
		{
			client.sendMessage(new WrongProtocolResponse().toXML());
			throw new ProtocolException("Wrong protocol");
		}
	}
}