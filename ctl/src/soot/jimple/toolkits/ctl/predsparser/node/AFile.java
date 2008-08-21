/* This file was generated by SableCC (http://www.sablecc.org/). */

package soot.jimple.toolkits.ctl.predsparser.node;

import java.util.*;
import soot.jimple.toolkits.ctl.predsparser.analysis.*;

@SuppressWarnings("nls")
public final class AFile extends PFile
{
    private final LinkedList<PPred> _pred_ = new LinkedList<PPred>();

    public AFile()
    {
        // Constructor
    }

    public AFile(
        @SuppressWarnings("hiding") List<PPred> _pred_)
    {
        // Constructor
        setPred(_pred_);

    }

    @Override
    public Object clone()
    {
        return new AFile(
            cloneList(this._pred_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFile(this);
    }

    public LinkedList<PPred> getPred()
    {
        return this._pred_;
    }

    public void setPred(List<PPred> list)
    {
        this._pred_.clear();
        this._pred_.addAll(list);
        for(PPred e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._pred_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._pred_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PPred> i = this._pred_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PPred) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
