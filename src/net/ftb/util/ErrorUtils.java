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
package net.ftb.util;

import javax.swing.JOptionPane;

import net.ftb.gui.LaunchFrame;
import net.ftb.log.Logger;

public class ErrorUtils {
	public static void tossError(String output) {
		Logger.logError(output);
		JOptionPane.showMessageDialog(LaunchFrame.getInstance(), output, "ERROR!", JOptionPane.ERROR_MESSAGE);
	}
}
