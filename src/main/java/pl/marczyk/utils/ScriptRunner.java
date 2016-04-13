package pl.marczyk.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.http.protocol.HTTP.USER_AGENT;

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
			runAsHttp(script);
		return "";
	}

	private static void runAsHttp(String script) {
		HttpClient client;
		try {
			client = HttpClients.createDefault();
			HttpGet request = new HttpGet(script);
//			request.addHeader("User-Agent", USER_AGENT);
			HttpResponse response = client.execute(request);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
