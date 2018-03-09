package io.github.swimmingsand.lucene;

import org.apache.lucene.util.automaton.Automata;
import org.apache.lucene.util.automaton.Automaton;
import org.apache.lucene.util.automaton.CharacterRunAutomaton;
import org.apache.lucene.util.automaton.CompiledAutomaton;
import org.apache.lucene.util.automaton.RegExp;
import org.junit.Test;

import java.util.Set;

/**
 * Created by zlq on 5/8/15.
 */
public class AutomatonTest {

    @Test
    public void testAutomata() {
        Automaton automaton = Automata.makeEmpty();
    }

    @Test
    public void testAutomata2() {
        Automaton automaton = Automata.makeEmptyString();
        int numStates = automaton.getNumStates();

        CharacterRunAutomaton runAutomaton = new CharacterRunAutomaton(automaton);

        boolean isAccepted = runAutomaton.run("abc");

        System.out.println("abc is accepted? " + isAccepted);

        isAccepted = runAutomaton.run("");

        System.out.println("\"\" is accepted? " + isAccepted);

        System.out.println(numStates);
    }

    @Test
    public void testAutomata3() {
        Automaton automaton = Automata.makeAnyString();
        int numStates = automaton.getNumStates();

        CharacterRunAutomaton runAutomaton = new CharacterRunAutomaton(automaton);

        boolean isAccepted = runAutomaton.run("abc");

        System.out.println("abc is accepted? " + isAccepted);

        isAccepted = runAutomaton.run("");

        System.out.println("\"\" is accepted? " + isAccepted);

        System.out.println(numStates);
    }

    @Test
    public void testAutomata4() {
        Automaton automaton = new Automaton(9, 13);
        int numStates = automaton.getNumStates();
        for (int i=0;i<9;i++) {
            automaton.createState();
        }

        automaton.addTransition(0,1,'c');
        automaton.addTransition(0,5,'s');
        automaton.addTransition(0,8,'f');

        automaton.addTransition(1,2,'a');
        automaton.addTransition(1,4,'h');

        automaton.addTransition(2,3,'t');

        automaton.addTransition(4,2,'a');

        automaton.addTransition(5,6,'e');
        automaton.addTransition(5,8,'w');

        automaton.addTransition(6,7,'a');

        automaton.addTransition(7,3,'t');

        automaton.addTransition(8,2,'a');
        automaton.addTransition(8,4,'e');

        automaton.setAccept(3,true);
        automaton.setAccept(7,true);


        CharacterRunAutomaton runAutomaton = new CharacterRunAutomaton(automaton);

        boolean isAccepted = runAutomaton.run("cat");

        System.out.println("cat is accepted? " + isAccepted);

        isAccepted = runAutomaton.run("");

        System.out.println("\"\" is accepted? " + isAccepted);

        System.out.println(numStates);
    }



    @Test
    public void testRegex() {
        RegExp regExp = new RegExp("ab.*");

        String treeString = regExp.toStringTree();

        System.out.println(treeString);
    }

    @Test
    public void testRegex2() {
        RegExp regExp = new RegExp("ab.*");

        Automaton automaton = regExp.toAutomaton();

        CompiledAutomaton automaton1 = new CompiledAutomaton(automaton, null, true, 1000, true);

        boolean success = automaton1.runAutomaton.run("a".getBytes(), 0, 1);

        // . ? + * | { } [ ] ( ) " \
        // # @ & < >  ~

        System.out.println(success);

        String pattern = "john\\\"@smith.com\\\"";

        regExp = new RegExp(pattern);

        String treeString = regExp.toStringTree();

        System.out.println(treeString);

        automaton = regExp.toAutomaton();

        automaton1 = new CompiledAutomaton(automaton, null, true, 1000, false);

        success = automaton1.runAutomaton.run("john\"@smith.com\"".getBytes(), 0 , "john\"@smith.com\"".length());

        System.out.println(success);


        pattern = "john@smith.com";

        regExp = new RegExp(pattern);

        treeString = regExp.toStringTree();

        System.out.println(treeString);

        automaton = regExp.toAutomaton();

        automaton1 = new CompiledAutomaton(automaton, null, true, 1000, false);

        success = automaton1.runAutomaton.run("john@absmith.com".getBytes(), 0 , "john@absmith.com".length());

        System.out.println(success);


    }

    @Test
    public void testRegex3() {
        String pattern = "~a[^a][a-b].+&.+bbb|c";

        RegExp regExp = new RegExp(pattern);

        String treeString = regExp.toStringTree();

        System.out.println(treeString);

        Set<String> identifiers = regExp.getIdentifiers();

        System.out.println("identifiers:");
        for (String identifier: identifiers) {
            System.out.println(identifier);
        }

        System.out.println("OriginalString:");

        System.out.println(regExp.getOriginalString());

        System.out.println("toString:");

        System.out.println(regExp.toString());

        Automaton automaton = regExp.toAutomaton();

        CompiledAutomaton automaton1 = new CompiledAutomaton(automaton, null, true, 1000, false);

        boolean success = automaton1.runAutomaton.run("bbabbb".getBytes(), 0 , "bbabbb".length());

        System.out.println(success);
    }
}
