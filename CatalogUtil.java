import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Catalog) objectInputStream.readObject();
    }

    public static void view(Document doc) throws IOException, URISyntaxException {
        String docPath = doc.getLocation();
        if(isValidUrl(docPath)) {
            URI url = new URI(docPath);
            Desktop dt = Desktop.getDesktop();
            dt.browse(url);
        } else {
            File file = new File(docPath);
            if(!Desktop.isDesktopSupported()){
                System.out.println("Desktop is not supported");
                return;
            }

            Desktop desktop = Desktop.getDesktop();
            if(file.exists()) desktop.open(file);
        }
        //… browse or open, depending of the location type
    }

    public static boolean isValidUrl(String url)
    {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }

        catch (Exception e) {
            return false;
        }
    }
}