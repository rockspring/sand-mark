package io.github.swimmingsand.lucene;

import org.apache.lucene.search.DocIdSetIterator;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zlq on 5/21/15.
 */
public class UtilTest {

    @Test
    public void testDocIdSetIterator() {
        DocIdSetIterator empty = DocIdSetIterator.empty();

        while (true) {
            try {
                int docId = empty.docID();
                if (docId == -1) {
                    break;
                } else {
                    System.out.println(docId);
                    int nextDoc = empty.nextDoc();
                    System.out.println(nextDoc);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        DocIdSetIterator all = DocIdSetIterator.all(10);

        while (true) {
            try {
                int nextDoc = all.nextDoc();

                if (nextDoc == DocIdSetIterator.NO_MORE_DOCS) {
                    break;
                }
                System.out.println(nextDoc);
                System.out.println(all.docID());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
