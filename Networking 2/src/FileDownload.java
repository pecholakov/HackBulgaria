
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


public class FileDownload {
    
    public static void URLRead(String url) throws IOException {
        String pathName = "/home/petyo/Downloads/temp.jpg";
        URL netSource = new URL(url);
//        BufferedReader in = new BufferedReader(new InputStreamReader(netSource.openStream()));
//        
//        String inputLine;
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine);
//        in.close();  
        
        byte[] URLcontent = IOUtils.toByteArray(netSource.openStream());
        FileUtils.writeByteArrayToFile(new File(pathName), URLcontent);       
    }
}