package net.ftb.workers;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import net.ftb.data.Settings;
import net.ftb.log.Logger;
import net.ftb.util.Benchmark;

public class UnreadNewsWorker
  extends SwingWorker<Integer, Void>
{
  protected Integer doInBackground()
  {
    Benchmark.start("UnreadNews");
    int i = 0;
    try
    {
      BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://feedthenuketerrorist.fr.nf/newsupdate.txt").openStream()));
      ArrayList<Long> timeStamps = Lists.newArrayList();
      String s = reader.readLine();
      s = s.trim();
      String[] str = s.split(",");
      for (String aStr : str) {
        if (!timeStamps.contains(Long.valueOf(Long.parseLong(aStr)))) {
          timeStamps.add(Long.valueOf(Long.parseLong(aStr)));
        }
      }
      long l;
      if (Long.parseLong(Settings.getSettings().getNewsDate()) == 0L) {
        l = Long.parseLong(Settings.getSettings().getNewsDate());
      } else {
        l = Long.parseLong(Settings.getSettings().getNewsDate().substring(0, 10));
      }
      for (Long timeStamp : timeStamps)
      {
        long time = timeStamp.longValue();
        if (time > l) {
          i++;
        }
      }
      Benchmark.logBenchAs("UnreadNews", "UnreadNews Init");
    }
    catch (UnknownHostException e)
    {
      Logger.logWarn("Error while checking news: " + e.getMessage());
    }
    catch (Exception e)
    {
      Logger.logError("Error while checking news", e);
    }
    return Integer.valueOf(i);
  }
}
