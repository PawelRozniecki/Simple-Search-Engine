
import com.findwise.IndexEntryImpl;
import org.junit.*;
import static org.junit.Assert.*;

public class IndexEntryTests {


    @Test
    public void testIndexEntryID(){
        IndexEntryImpl indexEntry = new IndexEntryImpl("doc1", 0.199);

        assertEquals("doc1", indexEntry.getId());

    }
    @Test
    public void testIndexEntryScore(){
        IndexEntryImpl indexEntry = new IndexEntryImpl("doc1", 0.199);
        assertEquals(0.299, indexEntry.getScore(),0.1);

    }
}
