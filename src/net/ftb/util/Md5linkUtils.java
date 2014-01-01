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

import net.ftb.util.AppUtils;
import java.io.IOException;
import java.net.URL;

public class Md5linkUtils {
	public static String TNTMd5() {
		try {
			return AppUtils.downloadString(new URL("http://ftnt.rd-h.fr/TNT.md5"));
		} catch(IOException e) {
			ErrorUtils.tossError("Unable to find Md5 at URL:" + TNTMd5());
			return "";
		}
	}
}
