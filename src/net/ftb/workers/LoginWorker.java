/*
 * This file is part of FTB Launcher.
 *
 * Copyright © 2012-2013, FTB Launcher Contributors <https://github.com/fares76/TNT-Launcher/>
 * FTB Launcher is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ftb.workers;

import java.io.IOException;
import java.net.URLEncoder;

import javax.swing.SwingWorker;

import net.ftb.util.ErrorUtils;

/**
 * SwingWorker that logs into minecraft.net. Returns a string containing the response received from the server.
 */
public class LoginWorker extends SwingWorker<String, Void> {
	private String username;

	public LoginWorker(String username, String password) {
		super();
		this.username = username;
	}

	@Override
	protected String doInBackground() {
		try {
			return "0:deprecated:" + URLEncoder.encode(username, "UTF-8") + ":0:0";
		} catch(IOException e) {
			ErrorUtils.tossError("IOException, minecraft servers might be down. Check @ help.mojang.com");
			return "";
		}
	}
}