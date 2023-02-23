import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
//    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
//    private HashMap<Voter, Integer> voterCounts = new HashMap<>();

    private int limit = 5_000_000;
    private int number = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("voter") && number < limit) {
            String name = attributes.getValue("name");
            String birthDate = attributes.getValue("birthDay");
            try {
                DBConnection.countVoter(name, birthDate);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            number++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter")) {
            voter = null;
        }
    }
}
