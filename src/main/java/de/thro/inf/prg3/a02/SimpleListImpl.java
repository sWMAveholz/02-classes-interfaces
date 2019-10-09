package de.thro.inf.prg3.a02;

import java.util.Iterator;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable {

    private static Element head;

    @Override
    public Iterator iterator() {
        return new SimpleListIterator();
    }

    private class SimpleListIterator implements Iterator{

        Element e1;

        @Override
        public boolean hasNext() {
            return e1 != null;
        }

        @Override
        public Object next() {
            Object ob = e1.getItem();
            e1 = e1.next;
            return ob;
        }

        public SimpleListIterator(){
            e1 = head;
        }

    }


    private static class Element {
        Object item;
        Element next;

        public Element()
        {
            item = null;
            next = null;
        }

        public Element(Object item, Element next)
        {
            this.item = item;
            this.next = next;
        }

        public Object getItem(){
            return item;
        }

    }


    // Konstruktor, Startwert festlegen
    public SimpleListImpl(){
        head = null;
    }

    @Override
    public void add(Object o) {
        if (head == null){
            head = new Element( o, null);
        }
        else {
            Element it = head;
            while (it.next != null){
                it = it.next;
            }
            Element add = new Element(o,null);
            it.next = add;
        }

    }

    @Override
    public int size() {
        int count = 0;
        if (head == null){
            return 0;
        }
        else{
            int i = 1;
            Element it = head;
            while (it.next != null){
                i = i+1;
                it = it.next;
            }
            return i;
        }

        /*int count = 0;
        Iterator it = this.iterator();
        while (it.hasNext())
        System.out.println(it.next());
        for(Object o:this){
        System.out.println(o);}


        return count;
         */

    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList simplelist = new SimpleListImpl();
        for(Object o : this){
            boolean b = filter.include(o);
            if(b == true){
                simplelist.add(o);
            }

        }

        return simplelist;
    }

    // TODO: Implement the required methods.

}
