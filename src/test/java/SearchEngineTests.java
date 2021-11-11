import com.findwise.SearchEngineImpl;
import org.junit.Assert;
import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;

public class SearchEngineTests {

    SearchEngineImpl searchEngine = new SearchEngineImpl();
    @Test
    public void testWordOccurance(){
        String content = "This is a test string used for this test";
        HashMap<String, Integer> map = (HashMap<String, Integer>) searchEngine.getWordFrequency(searchEngine.getTokens(content));
        int numberofTest = map.get("this");

        assertEquals(2, numberofTest);
    }

    @Test
    public void testTokenization(){

        String[] tokens = searchEngine.getTokens("This is an example");
        assertEquals(4, tokens.length);

    }
    @Test
    public void testDocumentMap(){
        searchEngine.indexDocument("document 1", "Quick brown fox jumped over the fence");
        searchEngine.indexDocument("document 2", "This is an example sentence");
        searchEngine.indexDocument("document 3", "The red fox bit the lazy dog");
        assertNotNull(searchEngine.getDocs());
    }
    @Test
    public void testDocumentNumber(){
        searchEngine.indexDocument("document 1", "Quick brown fox jumped over the fence");
        searchEngine.indexDocument("document 2", "This is an example sentence");
        searchEngine.indexDocument("document 3", "The red fox bit the lazy dog");
        assertEquals(3, searchEngine.getDocs().size());
    }

    @Test
    public void testWordOccuranceInAllDocuments(){

        searchEngine.indexDocument("document 1", "Quick brown fox jumped over the fence");
        searchEngine.indexDocument("document 2", "This is an example sentence");
        searchEngine.indexDocument("document 3", "The red fox bit the lazy dog");
        String term = "fox";

        int documentTermCount = searchEngine.getIndexEntriesMap().getOrDefault(term, Collections.emptyList()).size();
        assertEquals(2, documentTermCount);

    }
    @Test
    public void testIDF(){


        searchEngine.indexDocument("document 1", "Quick brown fox jumped over the fence");
        searchEngine.indexDocument("document 2", "This is an example sentence");
        searchEngine.indexDocument("document 3", "The red fox bit the lazy dog");
        String term = "fox";
        // log(3/2+1) should return 0.9162907318741551


        double idf = searchEngine.getIDF(term);
       assertEquals(0.9162907318741551, idf, 0.1);



    }
    @Test
    public void testIdfDivisionByZero(){
        searchEngine.indexDocument("document 1", "Quick brown fox jumped over the fence");
        searchEngine.indexDocument("document 2", "This is an example sentence");
        searchEngine.indexDocument("document 3", "The red fox bit the lazy dog");
        double idf = searchEngine.getIDF("hello");
        assertTrue("Divide by zero gives infinity as result", Double.isInfinite(idf));
    }
}
