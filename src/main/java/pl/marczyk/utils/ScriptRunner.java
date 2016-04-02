package pl.marczyk.utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by marcin.marczyk on 2016-04-01.
 */
public class ScriptRunner {

	private static final Logger LOG = Logger.getLogger(ScriptRunner.class);

	public static String run(String script) {
		LOG.info("Running script: " + script);
		String[] split = script.split(":");
		if (split[0].equals("command"))
			return runAsCommand(script);
		if (split[0].equals("http"))
			return runAsHttp(script);
		return "";
	}

	private static String runAsHttp(String script) {
		StringBuilder returnMessage = new StringBuilder();
		HttpURLConnection connection = null;
		try {
			URL url = new URL(script);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			connection.setUseCaches(false);
			connection.setDoOutput(true);

			//Send request
			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.close();

			//Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder(); // or StringBuffer if not Java 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			return response.toString();
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return returnMessage.toString();
	}

	private static String runAsCommand(String script) {
		StringBuilder returnMessage = new StringBuilder();
		try {
			String command = script.replaceFirst("command://", "");
			Process exec;
			exec = Runtime.getRuntime().exec(command);
			exec.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				returnMessage.append(line);
			}
			LOG.info(returnMessage.toString());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		return returnMessage.toString();
	}
}
