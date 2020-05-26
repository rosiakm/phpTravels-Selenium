package Phptravels.helpers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class taskManagerProcessHelper
{
    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /F /IM";

    public static boolean isProcessRunning(String serviceName) throws IOException
    {
        Process p = Runtime.getRuntime().exec(TASKLIST);
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null)
        {
            System.out.println(line);
            if (line.contains(serviceName))
            {
                return true;
            }
        }

        return false;
    }

    public static void killProcess(String serviceName) throws IOException
    {
        Runtime.getRuntime().exec(KILL + serviceName);
    }
}
