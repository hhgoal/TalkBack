/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package voice.recognizer;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 *
 * @author PeterTsongalis
 */
public class SearchCommand {

    public List<String> otherWordsList;

    public SearchCommand(List<String> otherWordsList) {

        this.otherWordsList = otherWordsList;

    }

    public String run() throws IOException, URISyntaxException {
        String searchWords = "";
        for (int x = 0; x < otherWordsList.size(); x++) {

            searchWords += otherWordsList.get(x) + "_";

        }

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("http://www.google.com/search?q=" + searchWords));

        }

        searchWords = searchWords.replaceAll("_", " ");


        return searchWords;
    }
}
