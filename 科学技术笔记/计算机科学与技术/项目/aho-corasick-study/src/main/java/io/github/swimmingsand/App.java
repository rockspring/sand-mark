package io.github.swimmingsand;

import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App {
    public static void test1() {
        Trie trie = new Trie();
        trie.addKeyword("hers");
        trie.addKeyword("his");
        trie.addKeyword("she");
        trie.addKeyword("he");
        //trie.addKeyword("爱家亚洲花园二期");
        trie.addKeyword("爱家亚洲");
        trie.addKeyword("亚洲花园");
        trie.addKeyword("爱家亚洲花园");
        trie.addKeyword("莲园路");
        trie.addKeyword("莲园路488弄");
        //trie.addKeyword("花园二期");
        Collection<Emit> emits = trie.parseText("ushers");
        System.out.println(emits);
        emits = trie.parseText("我爱我家爱家亚洲花园二期");
        System.out.println(emits);
        emits = trie.removeOverlaps().parseText("莲园路488弄");
        System.out.println(emits);
    }

    public static void test2() {
        Trie trie = new Trie();
        trie.addKeyword("莲园路");
        trie.addKeyword("莲园路488弄");
        //trie.addKeyword("花园二期");
        Collection<Emit> emits = trie.parseText("莲园路488弄");
        System.out.println(emits);
        emits = trie.removeOverlaps().parseText("莲园路488弄");
        System.out.println(emits);
    }
    public static void main( String[] args ) {
        test2();
    }
}
