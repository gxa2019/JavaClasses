
package com.genexus.internet;

import com.genexus.IGXFTPSafe;
import com.genexus.platform.INativeFunctions;
import com.genexus.platform.NativeFunctions;

public class GXFTPSafe implements IGXFTPSafe
{
	public IFTPClient client;

	public GXFTPSafe()
	{
		client = new NetComponentsFTPClient();
	}

	protected int lastError;

	public void lastError(int[] lastError)
	{
		lastError[0] = this.lastError == 1?0:1;
	}

	public int getLastError()
	{
		return this.lastError;
	}

	public synchronized void connect(final String host, final String user, final String password)
	{	
		NativeFunctions.getInstance().executeWithPermissions(
					new Runnable() {
						public void run()
						{
							lastError = client.connect(host, user, password);
						}
					}, INativeFunctions.ALL);
	}
	
	public void disconnect()
	{	
		NativeFunctions.getInstance().executeWithPermissions(
					new Runnable() {
						public void run()
						{
							lastError = client.disconnect();
						}
					}, INativeFunctions.ALL);
	}

	public void status(String[] status)
	{	
		status[0] = client.status();
	}

	public String getStatus()
	{	
		return client.status();
	}


	public void get(final String source, final String target, final String mode)
	{
		NativeFunctions.getInstance().executeWithPermissions(
					new Runnable() {
						public void run()
						{
							lastError = client.get(source, target, mode);
						}
					}, INativeFunctions.ALL);
	}

	public void put(final String source, final String target, final String mode)
	{
		NativeFunctions.getInstance().executeWithPermissions(
					new Runnable() {
						public void run()
						{
							lastError = client.put(source, target, mode);
						}
					}, INativeFunctions.ALL);
	}

	public void delete(final String source)
	{
		NativeFunctions.getInstance().executeWithPermissions(
					new Runnable() {
						public void run()
						{
							lastError = client.delete(source);
						}
					}, INativeFunctions.ALL);
	}


	public void mkdir(final String mkpath)
	{
		NativeFunctions.getInstance().executeWithPermissions(
					new Runnable() {
						public void run()
						{
							lastError = client.mkdir(mkpath);
						}
					}, INativeFunctions.ALL);
	}


	public void command(final String cmd)
	{
		NativeFunctions.getInstance().executeWithPermissions(
					new Runnable() {
						public void run()
						{
							lastError = client.command(cmd);
						}
					}, INativeFunctions.ALL);
	}
	
	public void setPassive(boolean passive)
	{
		client.setPassive(passive);
	}
}