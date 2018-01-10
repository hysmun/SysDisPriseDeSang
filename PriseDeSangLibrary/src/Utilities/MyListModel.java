/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import PriseDeSangLibrary.PriseDeSangToString;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author 'Toine
 */
public class MyListModel implements ListModel{
    public List lp;
    public LinkedList<ListDataListener> lldl;
    
    public MyListModel(List l){
        lp = l;
        lldl = new LinkedList<ListDataListener>();
    }
    
    @Override
    public int getSize() {
        return lp.size();
    }

    @Override
    public Object getElementAt(int index) {
        return PriseDeSangToString.toString(lp.get(index));
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        lldl.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        lldl.remove(l);
    }
}
