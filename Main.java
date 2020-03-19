import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException, ClassNotFoundException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "E:\\faculty\\JAVA\\lab5\\catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");

        Document doc2 = new Document("java2", "Java Own Refrence to calaog",
                "E:\\faculty\\JAVA\\lab5\\catalog.ser");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        catalog.add(doc2);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("E:\\faculty\\JAVA\\lab5\\catalog.ser");
        Document doc = catalog.findById("java1");
        Document doc2 = catalog.findById("java2");
        CatalogUtil.view(doc);
        CatalogUtil.view(doc2);
    }
}